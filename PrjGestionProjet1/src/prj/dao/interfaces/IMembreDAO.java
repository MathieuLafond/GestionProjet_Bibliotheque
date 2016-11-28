package prj.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import prj.dto.MembreDTO;

public interface IMembreDAO extends IDAO {

	void create(Connection connection,MembreDTO livreDTO) throws SQLException;
	MembreDTO read(Connection connection,MembreDTO livreDTO) throws SQLException;
	void update(Connection connection,MembreDTO livreDTO) throws SQLException;
	void delete(Connection connection,MembreDTO livreDTO) throws SQLException;
	List<MembreDTO> getAll(Connection connection) throws SQLException;
	
	List<MembreDTO> findByRetard(Connection connection) throws SQLException;
	
}
