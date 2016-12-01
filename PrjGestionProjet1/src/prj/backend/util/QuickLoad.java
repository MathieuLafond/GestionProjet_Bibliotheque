package prj.backend.util;

import java.util.List;

import prj.backend.dto.DTO;

public class QuickLoad {
	
	static public <T extends DTO> T read(String id,List<T> db){
		T retour=null;
		
		for(T dto : db){
			if(id.equals(dto.getId())){
				retour= dto;
				break;
			}
		}
		return retour;
	}
	
	
}
