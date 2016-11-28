package prj.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import prj.dao.interfaces.ICategorieDAO;
import prj.dto.CategorieDTO;
import prj.dto.LivreDTO;

public class CategorieDAO extends DAO implements ICategorieDAO{


	@Override
	public void create(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public CategorieDTO read(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<CategorieDTO> getAll(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByNom(Connection connection, String nom) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
