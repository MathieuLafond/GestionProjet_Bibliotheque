package prj.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import prj.dao.interfaces.ILivreDAO;
import prj.dto.LivreDTO;

public class LivreDAO extends DAO implements ILivreDAO{
	//CRUD
	private static final String CREATE_LIVRE_REQUEST = ""
			+ " INSERT INTO livre(titre, auteur, editeur, langue, categorie, emplacement, dateParution) "
			+ " VALUES('?','?','?','?','?','?',?)";
	private static final String READ_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE idLivre = ?";
	private static final String UPDATE_LIVRE_REQUEST = ""
			+ " UPDATE livre "
			+ " SET titre = ?, auteur = ?, editeur = ?, langue = ?, categorie = ?, emplacement = ?, dateParution = ? "
			+ " WHERE idLivre = ?";
	private static final String DELETE_LIVRE_REQUEST = ""
			+ " DELETE FROM livre "
			+ " WHERE idLivre = ?";
	private static final String GET_ALL_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre";
	private static final String DELETE_ALL_IN_CATEGORIE_LIVRE_REQUEST = ""
			+ " DELETE FROM livre "
			+ " WHERE categorie = ?";
	//Finds
	private static final String FIND_BY_TITRE_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE titre = ?";
	private static final String FIND_BY_AUTEUR_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE auteur = ?";
	private static final String FIND_BY_EDITEUR_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE editeur = ?";	
	private static final String FIND_BY_LANGUE_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE langue = ?";
	private static final String FIND_BY_CATEGORIE_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE categorie = ?";	
	private static final String FIND_BY_EMPLACEMENT_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE emplacement = ?";
	private static final String FIND_BY_PARUTION_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE dateParution = ?";
	private static final String FIND_BY_FORM_LIVRE_REQUEST = ""
			+ " SELECT idLivre titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE titre = ? "
			+ " AND auteur = ?"
			+ " AND editeur = ? "
			+ " AND langue = ? "
			+ " AND categorie = ? "
			+ " AND emplacement = ? "
			+ " AND dateParution = ?  ";
	
	@Override
	public void create(Connection connection, LivreDTO livreDTO) throws SQLException {
		try(PreparedStatement createPreparedStatement = connection.prepareStatement(LivreDAO.CREATE_LIVRE_REQUEST)){
			createPreparedStatement.setString(1, livreDTO.getTitre());
			createPreparedStatement.setString(2, livreDTO.getAuteur());
			createPreparedStatement.setString(3, livreDTO.getEditeur());
			createPreparedStatement.setString(4, livreDTO.getLangue());
			createPreparedStatement.setString(5, livreDTO.getIdCategorie());
			createPreparedStatement.setString(6, livreDTO.getEmplacement());
			createPreparedStatement.setTimestamp(7, livreDTO.getDateParution());
			createPreparedStatement.executeUpdate();
		}
	}
	@Override
	public LivreDTO read(Connection connection, LivreDTO livreDTO) throws SQLException {
		LivreDTO unLivreDTO = null;
        try(PreparedStatement readPreparedStatement = connection.prepareStatement(LivreDAO.READ_LIVRE_REQUEST)) {
            readPreparedStatement.setString(1,livreDTO.getIdLivre());
            try(ResultSet resultSet = readPreparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    unLivreDTO = new LivreDTO();
                    
                }
            }
        }
        return unLivreDTO;
	}
	@Override
	public void update(Connection connection, LivreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Connection connection, LivreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<LivreDTO> getAll(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllInCategorie(Connection connection, String categorie) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<LivreDTO> findByTitre(Connection connection, String titre) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByAuteur(Connection connection, String auteur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByEditeur(Connection connection, String editeur) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByLangue(Connection connection, String langue) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByCategorie(Connection connection, String categorie) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByEmplacement(Connection connection, String emplacement) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByDateParution(Connection connection, Timestamp dateParution) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LivreDTO> findByForm(Connection connection, LivreDTO livreDTO) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
