package prj.dao.implementations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import prj.dao.interfaces.IPretDAO;
import prj.dto.PretDTO;

public class PretDAO extends DAO implements IPretDAO{

	@Override
	public void create(Connection connection, PretDTO pretDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PretDTO read(Connection connection, PretDTO pretDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Connection connection, PretDTO pretDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Connection connection, PretDTO pretDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PretDTO> getAll(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PretDTO> findByMembre(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PretDTO> findByLivre(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PretDTO> findByRetard(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
