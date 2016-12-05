package prj.backend.service;

import java.util.List;

import prj.backend.dao.DAO;
import prj.backend.dto.DTO;
import prj.backend.exception.DAOException;
import prj.backend.exception.ServiceException;

public class Service<E extends DTO,T extends DAO<E>> {
	
	private T dao;
	
	protected Service(T dao){
		this.dao=dao;
	}
	
	public void create(E dto) throws ServiceException{
		try {
			dao.create(dto);
		} catch (DAOException exception) {
			throw new ServiceException(exception);
		}
	}
	
	public E read(String id) throws ServiceException{
		try {
			return dao.read(id);
		} catch (DAOException exception) {
			throw new ServiceException(exception);
		}
	}

	public void update(E objDto) throws ServiceException{
		try {
			dao.update(objDto);
		} catch (DAOException exception) {
			throw new ServiceException(exception);
		}
	}
	
	public void delete(E objDto) throws ServiceException{
		try {
			dao.delete(objDto);
		} catch (DAOException exception) {
			throw new ServiceException(exception);
		}
	}
	
	public List<E> getAll(){
		return dao.getAll();
	}
	
	protected T getDAO(){
		return dao;
	}
	
}
