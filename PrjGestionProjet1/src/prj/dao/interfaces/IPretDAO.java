package prj.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import prj.dto.PretDTO;

public interface IPretDAO extends IDAO {
	
	void create(Connection connection,PretDTO pretDTO) throws SQLException;
	PretDTO read(Connection connection,PretDTO pretDTO) throws SQLException;
	void update(Connection connection,PretDTO pretDTO) throws SQLException;
	void delete(Connection connection,PretDTO pretDTO) throws SQLException;
	List<PretDTO> getAll(Connection connection) throws SQLException;
	
	List<PretDTO> findByMembre(Connection connection) throws SQLException;
	List<PretDTO> findByLivre(Connection connection) throws SQLException;
	List<PretDTO> findByRetard(Connection connection) throws SQLException;
}
