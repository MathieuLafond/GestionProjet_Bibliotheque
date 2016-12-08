package prj.backend.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;
import prj.backend.exception.DAOException;
import prj.backend.util.QuickLoad;

public class Database {
	
	private static ArrayList<LivreDTO> livres = new ArrayList<>();
	private static ArrayList<MembreDTO> membres = new ArrayList<>();
	private static ArrayList<PretDTO> prets = new ArrayList<>();
	private static ArrayList<CategorieDTO> categories = new ArrayList<>();
	
	private static int seq_livre=1;
	private static int seq_membre=1;
	private static int seq_pret=1;
	private static int seq_categorie=1;
	
	final private static String fichierLivres = "livres.txt";
	final private static String fichierMembres= "membres.txt";
	final private static String fichierPrets = "prets.txt";
	final private static String fichierCategories = "categories.txt";
	
	final private static String fichierSeq = "seq.txt";
	
	public static void load() throws DAOException{
		String[] fichiers={fichierCategories,fichierLivres,fichierMembres,fichierPrets,fichierSeq};
		for(String nomFichier : fichiers){
			try {
				FileReader fr = new FileReader(nomFichier);
				BufferedReader fichier = new BufferedReader(fr);
				String ligne = fichier.readLine();
				while(ligne!=null){
					StringTokenizer st = new StringTokenizer(ligne,";");
					
					switch(nomFichier){
					case fichierLivres:
						LivreDTO livre = new LivreDTO();
						livre.setIdLivre(st.nextToken());
						livre.setCategorieDTO(QuickLoad.read(st.nextToken(), Database.categories));
						livre.setTitre(st.nextToken());
						livre.setAuteur(st.nextToken());
						livre.setEditeur(st.nextToken());
						livre.setLangue(st.nextToken());
						livre.setDateParution(new Timestamp(Long.parseLong(st.nextToken())));
						livre.setEmplacement(st.nextToken());
						Database.livres.add(livre);
						break;
					case fichierMembres:
						MembreDTO membre = new MembreDTO();
						membre.setIdMembre(st.nextToken());
						membre.setPrenom(st.nextToken());
						membre.setNom(st.nextToken());
						membre.setAdresse(st.nextToken());
						membre.setCodePostal(st.nextToken());
						membre.setTelephone(st.nextToken());
						membre.setCourriel(st.nextToken());
						membre.setLimitePret(st.nextToken());
						Database.membres.add(membre);
						break;
					case fichierPrets:
						PretDTO pret = new PretDTO();
						pret.setIdPret(st.nextToken());
						pret.setMembreDTO(QuickLoad.read(st.nextToken(), Database.membres));
						pret.setLivreDTO(QuickLoad.read(st.nextToken(), Database.livres));
						pret.setDatePret(new Timestamp(Long.parseLong(st.nextToken())));
						String dateRetour = st.nextToken();
						if(!dateRetour.equals("0")){
							pret.setDateRetour(new Timestamp(Long.parseLong(dateRetour)));
						}
						pret.setDateLimite(new Timestamp(Long.parseLong(st.nextToken())));
						break;
					case fichierCategories:
						CategorieDTO categorie = new CategorieDTO();
						categorie.setIdCategorie(st.nextToken());
						categorie.setNomCategorie(st.nextToken());
						Database.categories.add(categorie);
						break;
					case fichierSeq:
						seq_livre=Integer.parseInt(st.nextToken());
						seq_membre=Integer.parseInt(st.nextToken());
						seq_pret=Integer.parseInt(st.nextToken());
						seq_categorie=Integer.parseInt(st.nextToken());
						break;
					}
					
					ligne = fichier.readLine();
				}
				fichier.close();
				
			} catch (IOException | DAOException e) {
				throw new DAOException("Impossible de lire les données");
			}
		}
		
	}
	
	public static void save() throws DAOException{
		String[] fichiers={fichierCategories,fichierLivres,fichierMembres,fichierPrets,fichierSeq};
		for(String nomFichier : fichiers){
			try {
				FileWriter fw= new FileWriter(nomFichier);
				BufferedWriter bw= new BufferedWriter(fw);
				switch(nomFichier){
				case fichierLivres:
					for(LivreDTO livre : Database.livres){
						bw.write(livre.stock());
						bw.newLine();
					}
					break;
				case fichierMembres:
					for(MembreDTO membre : Database.membres){
						bw.write(membre.stock());
						bw.newLine();
					}
					break;
				case fichierPrets:
					for(PretDTO prets : Database.prets){
						bw.write(prets.stock());
						bw.newLine();
					}
					break;
				case fichierCategories:
					for(CategorieDTO categorie : Database.categories){
						bw.write(categorie.stock());
						bw.newLine();
					}
					break;
				case fichierSeq:
					bw.write(seq_livre+";"+seq_membre+";"+seq_pret+";"+seq_categorie);
					bw.newLine();
					break;
				}
				bw.close();
			} catch (IOException e) {
				throw new DAOException("Impossible de sauvegarder les données");
			}
		}
	}

	public static List<LivreDTO> getLivres(){
		return livres;
	}
	public static List<MembreDTO> getMembres(){
		return membres;
	}
	public static List<PretDTO> getPrets(){
		return prets;
	}
	public static List<CategorieDTO> getCategories(){
		return categories;
	}
	
	public static int getSeqLivreVal(){
		return seq_livre++;
		
	}
	public static int getSeqMembreVal(){
		return seq_membre++;
		
	}
	public static int getSeqPretVal(){
		return seq_pret++;
		
	}
	public static int getSeqCategorieVal(){
		return seq_categorie++;
		
	}
	
}
