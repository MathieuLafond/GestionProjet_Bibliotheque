package prj.backend.db;

import java.util.ArrayList;
import java.util.List;

import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;

public class Database {
	
	private static ArrayList<LivreDTO> livres = new ArrayList<>();
	private static ArrayList<MembreDTO> membres = new ArrayList<>();
	private static ArrayList<PretDTO> prets = new ArrayList<>();
	private static ArrayList<CategorieDTO> categories = new ArrayList<>();
	
	private static int seq_livre=1;
	private static int seq_membre=1;
	private static int seq_pret=1;
	private static int seq_categorie=1;
	
	public static void load(){
		
	}
	
	public static void save(){
		
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
