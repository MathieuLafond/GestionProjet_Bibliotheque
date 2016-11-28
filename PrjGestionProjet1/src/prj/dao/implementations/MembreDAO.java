package prj.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import prj.dao.interfaces.IMembreDAO;
import prj.dto.MembreDTO;

public class MembreDAO extends DAO implements IMembreDAO{

	@Override
	public void create(Connection connection, MembreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MembreDTO read(Connection connection, MembreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Connection connection, MembreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection connection, MembreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MembreDTO> getAll(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembreDTO> findByRetard(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
