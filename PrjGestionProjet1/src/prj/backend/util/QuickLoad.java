package prj.backend.util;

import java.util.List;

import prj.backend.dto.DTO;
import prj.backend.exception.DAOException;

public class QuickLoad {
	
	static public <T extends DTO> T read(String id,List<T> db) throws DAOException{
		T retour=null;
		for(T dto : db){
			if(dto.getId().equals(id)){
				retour= dto;
				break;
			}
		}
		if(retour==null){
			throw new DAOException("Aucune entrée trouvée");
		}
		return retour;
	}
	
	
}
