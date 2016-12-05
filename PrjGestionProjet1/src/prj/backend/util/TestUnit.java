package prj.backend.util;

import java.sql.Timestamp;

import prj.backend.db.Database;
import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.DAOException;
import prj.backend.exception.FacadeException;

class TestUnit {

	public static void main(String[] args) {
		testBackEndNoError();
	}

	private static void testBackEndNoError() {
		try {
			AppFunction app = new AppFunction();
			
			//Insertions
			LivreDTO livre= new LivreDTO();
			MembreDTO membre= new MembreDTO();
			PretDTO pret= new PretDTO();
			CategorieDTO categorie= new CategorieDTO();
			
			for(int i = 0;i<20;i++){
				livre= new LivreDTO();
				membre = new MembreDTO();
				pret = new PretDTO();
				categorie = new CategorieDTO();
				
				livre.setIdLivre(""+(i+1));
				membre.setIdMembre(""+(i+1));
				pret.setIdPret(""+(i+1));
				categorie.setIdCategorie(""+(i+1));
				
				livre.setDateParution(new Timestamp(System.currentTimeMillis()));
				livre.setCategorieDTO(categorie);
				
				pret.setLivreDTO(livre);
				pret.setMembreDTO(membre);
				if(i%2==0){
					livre.setAuteur("Jean");
					livre.setEditeur("Beauchamps");
					livre.setEmplacement("A-1");
					livre.setLangue("Anglais");
					livre.setTitre("Les patins spaciaux de Gaston");
					
					membre.setAdresse("1234 rue desAvions");
					membre.setCodePostal("H1K7B6");
					membre.setCourriel("tulib.roger@gmail.com");
					membre.setLimitePret("25");
					membre.setNom("Tulib");
					membre.setPrenom("Roger");
					membre.setTelephone("5147893845");
					
					categorie.setNomCategorie("Fantastique");
					
					pret.setDateLimite(new Timestamp(System.currentTimeMillis()+20000));
				}
				else{
					livre.setAuteur("Paul");
					livre.setEditeur("Desjardins");
					livre.setEmplacement("B-14");
					livre.setLangue("Français");
					livre.setTitre("Les voitures de l'espace");
					
					membre.setAdresse("8234 avenue desChars");
					membre.setCodePostal("G1A7B6");
					membre.setCourriel("gsawl.bertrand@hotmail.com");
					membre.setLimitePret("11");
					membre.setNom("Gsawl");
					membre.setPrenom("Bertand");
					membre.setTelephone("5143456097");
					
					categorie.setNomCategorie("Science-Fiction");
					
					pret.setDateLimite(new Timestamp(System.currentTimeMillis()+60000));
				}
				app.getCategorieFacade().ajouter(categorie);
				app.getMembreFacade().inscrire(membre);
				app.getLivreFacade().acquerir(livre);
				app.getPretFacade().creer(pret);
			}
			
			//Cas sans erreurs (OK)
			
			//Aperçu Insert (OK)
			System.out.println("Categories\n");
			for(CategorieDTO categorieDTO : app.getCategorieFacade().getAll()){
				System.out.println(affichageCategorie(categorieDTO));
			}
			System.out.println("Membres\n");
			for(MembreDTO membreDTO : app.getMembreFacade().getAll()){
				System.out.println(affichageMembre(membreDTO));
			}
			System.out.println("Livres\n");
			for(LivreDTO livreDTO : app.getLivreFacade().getAll()){
				System.out.println(affichageLivre(livreDTO));
			}
			System.out.println("Prets\n");
			for(PretDTO pretDTO : app.getPretFacade().getAll()){
				System.out.println(affichagePret(pretDTO));
			}
			
			
			//Update 
			
			membre = QuickLoad.read("18", Database.getMembres());
			membre.setCourriel("ladlido.denis@hotmail.com");
			membre.setNom("Denis");
			membre.setPrenom("Ladlido");
			membre.setTelephone("1234567890");
			membre.setCodePostal("G9P2H3");
			membre.setAdresse("4998 rue desMarmottes");
			app.getMembreFacade().modifier(membre);
			//Aperçu Update (OK)
			membre = QuickLoad.read("18", Database.getMembres());
			System.out.println("Membre 18 modifié :\n");
			System.out.println(affichageMembre(membre));
			
			
			//Delete
			livre = new LivreDTO();
			membre = new MembreDTO();
			categorie = new CategorieDTO();
			pret = new PretDTO();
			
			for(int i=0;i<16;i++){
				livre.setIdLivre(""+(i+1));
				membre.setIdMembre(""+(i+1));
				pret.setIdPret(""+(i+1));
				categorie.setIdCategorie(""+(i+1));
				app.getPretFacade().payer(pret);
				app.getMembreFacade().desinscrire(membre);
				app.getLivreFacade().vendre(livre);
				app.getCategorieFacade().supprimer(categorie);
			}
			
			//Aperçu Delete (OK)
			System.out.println("Categories\n");
			for(CategorieDTO categorieDTO : app.getCategorieFacade().getAll()){
				System.out.println(affichageCategorie(categorieDTO));
			}
			System.out.println("Membres\n");
			for(MembreDTO membreDTO : app.getMembreFacade().getAll()){
				System.out.println(affichageMembre(membreDTO));
			}
			System.out.println("Livres\n");
			for(LivreDTO livreDTO : app.getLivreFacade().getAll()){
				System.out.println(affichageLivre(livreDTO));
			}
			System.out.println("Prets\n");
			for(PretDTO pretDTO : app.getPretFacade().getAll()){
				System.out.println(affichagePret(pretDTO));
			}
			
			
			//Read (OK)
			
			livre = new LivreDTO();
			membre = new MembreDTO();
			categorie = new CategorieDTO();
			categorie.setIdCategorie("20");
			membre.setIdMembre("18");
			livre.setIdLivre("19");
			livre.setAuteur("e");
			livre.setEditeur("Beau");
			livre.setEmplacement("A");
			livre.setLangue("Anglais");
			livre.setTitre("patins");
			livre.setCategorieDTO(categorie);
			
			System.out.println("Livres\n");
			for(LivreDTO livreDTO : app.getLivreFacade().findByForm(livre)){
				System.out.println(affichageLivre(livreDTO));
			}
			for(LivreDTO livreDTO : app.getLivreFacade().findByCategorie(categorie)){
				System.out.println(affichageLivre(livreDTO));
			}
			System.out.println("Prets\n");
			for(PretDTO pretDTO : app.getPretFacade().findByMembre(membre)){
				System.out.println(affichagePret(pretDTO));
			}
			for(PretDTO pretDTO : app.getPretFacade().findByLivre(livre)){
				System.out.println(affichagePret(pretDTO));
			}
			
			
			
			//Delete all in categorie
			
			pret = new PretDTO();
			categorie = new CategorieDTO();
			pret.setIdPret("19");
			categorie.setIdCategorie("19");
			app.getPretFacade().payer(pret);
			app.getLivreFacade().deleteAllInCategorie(categorie);
			
			//Aperçu Delete all in categorie (OK)
			System.out.println("Livres\n");
			for(LivreDTO livreDTO : app.getLivreFacade().getAll()){
				System.out.println(affichageLivre(livreDTO));
			}
			
			//TODO findByRetard / 
			
			
			
		} catch (FacadeException | DAOException e) {
			//System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	//Affichages
	
	private static String affichageLivre(LivreDTO livreDTO){
		return ""
				+livreDTO.getIdLivre()+"\n"
				+livreDTO.getAuteur()+"\n"
				+livreDTO.getEditeur()+"\n"
				+livreDTO.getEmplacement()+"\n"
				+livreDTO.getLangue()+"\n"
				+livreDTO.getTitre()+"\n"
				+livreDTO.getCategorieDTO().getIdCategorie()+"\n"
				+livreDTO.getDateParution()+"\n";
	}
	
	private static String affichageMembre(MembreDTO membreDTO){
		return ""
				+membreDTO.getIdMembre()+"\n"
				+membreDTO.getPrenom()+"\n"
				+membreDTO.getNom()+"\n"
				+membreDTO.getCourriel()+"\n"
				+membreDTO.getTelephone()+"\n"
				+membreDTO.getCodePostal()+"\n"
				+membreDTO.getAdresse()+"\n"
				+membreDTO.getLimitePret()+"\n";
	}
	
	private static String affichagePret(PretDTO pretDTO){
		return ""
				+pretDTO.getIdPret()+"\n"
				+pretDTO.getDatePret()+"\n"
				+pretDTO.getDateRetour()+"\n"
				+pretDTO.getDateLimite()+"\n"
				+pretDTO.getLivreDTO().getIdLivre()+"\n"
				+pretDTO.getMembreDTO().getIdMembre()+"\n";
	}
	
	private static String affichageCategorie(CategorieDTO categorieDTO){
		return ""
				+categorieDTO.getIdCategorie()+"\n"
				+categorieDTO.getNomCategorie()+"\n";
	}

}
