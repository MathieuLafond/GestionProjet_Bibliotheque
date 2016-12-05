package prj.backend.dao;

import java.util.List;

import prj.backend.dto.DTO;
import prj.backend.exception.DAOException;

public class DAO<T extends DTO> {
	
	private List<T> dtos;
	
	protected DAO(List<T> db){
		dtos=db;
	}
	
	public void create(T dto) throws DAOException{
		for(T unDto : dtos){
			if(unDto.getId().equals(dto.getId())){
				throw new DAOException("Duplication de l'ID");
			}
		}
		System.out.println("");
		dtos.add(dto);
	}
	
	public T read(String id) throws DAOException{
		T retour=null;
		for(T dto : dtos){
			if(id.equals(dto.getId())){
				retour= dto;
				break;
			}
		}
		if(retour==null){
			throw new DAOException("Aucune entrée trouvée");
		}
		return retour;
	}

	public void update(T objDto) throws DAOException{
		int index = -1;
		for(T dto : dtos){
			if(objDto.getId().equals(dto.getId())){
				index= dtos.indexOf(dto);
				break;
			}
		}
		if(index==-1){
			throw new DAOException("L'entrée à modifier n'existe pas");
		}
			dtos.remove(index);
			dtos.add(index, objDto);
	}
	
	public void delete(T objDto) throws DAOException{
		boolean supprime = false;
		for(T unDto : dtos){
			if(unDto.getId().equals(objDto.getId())){
				supprime = true;
			}
		}
		if(!supprime){
			throw new DAOException("L'entrée à supprimer n'existe pas");
		}
		dtos.remove(objDto);
	}
	
	public List<T> getAll(){
		return dtos;
	}
	
	protected void replace(List<T> newList){
		dtos=newList;
	}
	
}
