package prj.backend.db;

import java.util.Collections;
import java.util.List;

import prj.backend.dto.CategorieDTO;
import prj.backend.dto.LivreDTO;
import prj.backend.dto.MembreDTO;
import prj.backend.dto.PretDTO;

public class Database {
	
	private static List<LivreDTO> livres = Collections.emptyList();
	private static List<MembreDTO> membres = Collections.emptyList();
	private static List<PretDTO> prets = Collections.emptyList();
	private static List<CategorieDTO> categories = Collections.emptyList();
	
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
	
}
