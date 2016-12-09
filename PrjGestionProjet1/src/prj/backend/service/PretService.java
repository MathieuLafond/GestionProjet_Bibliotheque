package prj.backend.service;

import java.sql.Timestamp;
import java.util.List;

import prj.backend.dao.PretDAO;
import prj.backend.db.Database;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.DAOException;
import prj.backend.exception.ServiceException;
import prj.backend.util.QuickLoad;
import prj.backend.util.Tarif;

public class PretService extends Service<PretDTO,PretDAO>{

	public PretService(PretDAO dao) {
		super(dao);
	}

	public void creer(PretDTO pretDTO) throws ServiceException{
		try {
			PretDTO unPret = pretDTO;
			MembreDTO membre = QuickLoad.read(pretDTO.getMembreDTO().getIdMembre(), Database.getMembres());
			LivreDTO livre = QuickLoad.read(pretDTO.getLivreDTO().getIdLivre(), Database.getLivres());
			if(!Database.getLivres().contains(livre)){
				throw new ServiceException("Erreur : le livre n'existe pas");
			}
			if(!Database.getMembres().contains(membre)){
				throw new ServiceException("Erreur : le membre n'existe pas");
			}
			List<PretDTO> prets = findByMembre(membre);
			if(prets.size()>=Integer.parseInt(membre.getLimitePret())){
				throw new ServiceException("Erreur : le membre a atteint sa limite de prêts");
			}
			prets = findByRetard();
			for(PretDTO pret : prets){
				if(pret.getMembreDTO().equals(pretDTO.getMembreDTO())){
					throw new ServiceException("Erreur : le membre a des prêts en retard non payés");
				}
			}
			unPret.setIdPret(""+Database.getSeqPretVal());
			long date = System.currentTimeMillis();
			unPret.setLivreDTO(livre);
			unPret.setMembreDTO(membre);
			unPret.setDatePret(new Timestamp(date));
			unPret.setDateLimite(new Timestamp(date+(1000*3600*24*7)));
			create(unPret);
		} catch (DAOException exception) {
			throw new ServiceException(exception);
		}
	}
	public void retourner(PretDTO pretDTO) throws ServiceException{
		PretDTO pret = read(pretDTO.getIdPret());
		Timestamp aujourdhui = new Timestamp(System.currentTimeMillis());
		pret.setDateRetour(aujourdhui);
		if(aujourdhui.before(pret.getDateLimite())){
			delete(pret);
		}
		else {
			update(pret);
		}
	}
	public void payer(PretDTO pretDTO) throws ServiceException{
		PretDTO pret = read(pretDTO.getIdPret());
		delete(pret);
	}
	
	public double calculerFraisRetard(PretDTO pretDTO) throws ServiceException{
		PretDTO pret = read(pretDTO.getIdPret());
		//TODO TEMP
		long ti = 24*3600*1000;
		pret.setDateRetour(new Timestamp(System.currentTimeMillis()+ti));
		//
		double montant = 0;
		Timestamp limite = pret.getDateLimite();
		Timestamp retour = new Timestamp(System.currentTimeMillis());
		if(pret.getDateRetour()!=null){
			retour = pret.getDateRetour();
		}
		if(limite.before(retour)){
			long dif = retour.getTime()-limite.getTime();
			dif /= 1000; //nb sec
			dif /= 3600; //nb heures
			int jours = (int) (dif /= 24); //nb jours
			montant = jours*Tarif.getTarif();
			if(montant>Tarif.getMaxPaiement()){
				montant = Tarif.getMaxPaiement();
			}
		}
		return montant;
	}
	
	public List<PretDTO> findByMembre(MembreDTO membreDTO){
		return getDAO().findByMembre(membreDTO);
	}
	public List<PretDTO> findByLivre(LivreDTO livreDTO){
		return getDAO().findByLivre(livreDTO);
	}
	public List<PretDTO> findByRetard(){
		return getDAO().findByRetard();
	}

}
