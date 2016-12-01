package prj.backend.dao;

import java.util.List;

import prj.backend.dto.CategorieDTO;

public class CategorieDAO extends DAO<CategorieDTO>{
	
	public CategorieDAO(List<CategorieDTO> dtos){
		super(dtos);
	}
	
}
