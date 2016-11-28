package prj.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import prj.dto.LivreDTO;

public interface ILivreDAO extends IDAO {

	void create(Connection connection,LivreDTO livreDTO) throws SQLException;
	LivreDTO read(Connection connection,LivreDTO livreDTO) throws SQLException;
	void update(Connection connection,LivreDTO livreDTO) throws SQLException;
	void delete(Connection connection,LivreDTO livreDTO) throws SQLException;
	List<LivreDTO> getAll(Connection connection) throws SQLException;
	
	void deleteAllInCategorie(Connection connection,String categorie) throws SQLException;
	
	List<LivreDTO> findByTitre(Connection connection,String titre) throws SQLException;
	List<LivreDTO> findByAuteur(Connection connection,String auteur) throws SQLException;
	List<LivreDTO> findByEditeur(Connection connection,String editeur) throws SQLException;
	List<LivreDTO> findByLangue(Connection connection,String langue) throws SQLException;
	List<LivreDTO> findByCategorie(Connection connection,String categorie) throws SQLException;
	List<LivreDTO> findByEmplacement(Connection connection,String emplacement) throws SQLException;
	List<LivreDTO> findByDateParution(Connection connection,Timestamp dateParution) throws SQLException;
	List<LivreDTO> findByForm(Connection connection,LivreDTO livreDTO) throws SQLException;
	
}
