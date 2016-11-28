package prj.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import prj.dto.CategorieDTO;

public interface ICategorieDAO extends IDAO{

	void create(Connection connection,CategorieDTO categorieDTO) throws SQLException;
	CategorieDTO read(Connection connection,CategorieDTO categorieDTO) throws SQLException;
	void update(Connection connection,CategorieDTO categorieDTO) throws SQLException;
	void delete(Connection connection,CategorieDTO categorieDTO) throws SQLException;
	List<CategorieDTO> getAll(Connection connection) throws SQLException;
	
}
