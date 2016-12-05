package prj.backend.util;

import prj.backend.dao.CategorieDAO;
import prj.backend.dao.LivreDAO;
import prj.backend.dao.MembreDAO;
import prj.backend.dao.PretDAO;
import prj.backend.db.Database;
import prj.backend.facade.CategorieFacade;
import prj.backend.facade.LivreFacade;
import prj.backend.facade.MembreFacade;
import prj.backend.facade.PretFacade;
import prj.backend.service.CategorieService;
import prj.backend.service.LivreService;
import prj.backend.service.MembreService;
import prj.backend.service.PretService;

public class AppFunction {
	
	private LivreFacade livreFacade;
	private MembreFacade membreFacade;
	private PretFacade pretFacade;
	private CategorieFacade categorieFacade;
	
	public AppFunction(){
		LivreDAO livreDAO = new LivreDAO(Database.getLivres());
		MembreDAO membreDAO = new MembreDAO(Database.getMembres());
		PretDAO pretDAO = new PretDAO(Database.getPrets());
		CategorieDAO categorieDAO = new CategorieDAO(Database.getCategories());
		
		LivreService livreService = new LivreService(livreDAO);
		MembreService membreService = new MembreService(membreDAO);
		PretService pretService = new PretService(pretDAO);
		CategorieService categorieService = new CategorieService(categorieDAO);
		
		livreFacade = new LivreFacade(livreService);
		membreFacade = new MembreFacade(membreService);
		pretFacade = new PretFacade(pretService);
		categorieFacade = new CategorieFacade(categorieService);
		
	}

	public LivreFacade getLivreFacade() {
		return livreFacade;
	}

	public MembreFacade getMembreFacade() {
		return membreFacade;
	}

	public PretFacade getPretFacade() {
		return pretFacade;
	}

	public CategorieFacade getCategorieFacade() {
		return categorieFacade;
	}
	
	
}
