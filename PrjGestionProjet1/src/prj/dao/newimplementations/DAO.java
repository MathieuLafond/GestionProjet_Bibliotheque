package prj.dao.newimplementations;

import java.util.List;

import prj.dto.DTO;

public class DAO<T extends DTO> {
	
	private List<T> dtos;
	
	public DAO(List<T> db){
		dtos=db;
	}
	
	public void create(T dto){
		dtos.add(dto);
	}
	
	public T read(String id){
		T retour=null;
		for(T dto : dtos){
			if(id.equals(dto.getId())){
				retour= dto;
				break;
			}
		}
		return retour;
	}

	public void update(T objDto){
		int index = -1;
		for(T dto : dtos){
			if(objDto.getId().equals(dto.getId())){
				index= dtos.indexOf(dto);
				break;
			}
		}
		if(index!=-1){
			dtos.remove(index);
			dtos.add(index, objDto);
		}
	}
	
	public void delete(T objDto){
		dtos.remove(objDto);
	}
	
	public List<T> getAll(){
		return dtos;
	}
	
	protected void replace(List<T> newList){
		dtos=newList;
	}
	
}
