package prj.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prj.dao.interfaces.ILivreDAO;
import prj.dto.LivreDTO;

public class LivreDAO extends DAO implements ILivreDAO{
	//CRUD
	private static final String CREATE_LIVRE_REQUEST = ""
			+ " INSERT INTO livre(titre, auteur, editeur, langue, categorie, emplacement, dateParution) "
			+ " VALUES('?','?','?','?','?','?',?)";
	private static final String READ_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE idLivre = ?";
	private static final String UPDATE_LIVRE_REQUEST = ""
			+ " UPDATE livre "
			+ " SET titre = '?', auteur = '?', editeur = '?', langue = '?', categorie = '?', emplacement = '?', dateParution = ? "
			+ " WHERE idLivre = ?";
	private static final String DELETE_LIVRE_REQUEST = ""
			+ " DELETE FROM livre "
			+ " WHERE idLivre = ?";
	private static final String GET_ALL_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre";
	private static final String DELETE_ALL_IN_CATEGORIE_LIVRE_REQUEST = ""
			+ " DELETE FROM livre "
			+ " WHERE categorie = '?'";
	//Finds
	private static final String FIND_BY_TITRE_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE titre = '?'";
	private static final String FIND_BY_AUTEUR_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE auteur = '?'";
	private static final String FIND_BY_EDITEUR_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE editeur = '?'";	
	private static final String FIND_BY_LANGUE_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE langue = '?'";
	private static final String FIND_BY_CATEGORIE_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE categorie = '?'";	
	private static final String FIND_BY_EMPLACEMENT_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE emplacement = '?'";
	private static final String FIND_BY_PARUTION_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE dateParution = ?";
	private static final String FIND_BY_FORM_LIVRE_REQUEST = ""
			+ " SELECT idLivre, titre, auteur, editeur, langue, categorie, emplacement, dateParution "
			+ " FROM livre "
			+ " WHERE titre = '?' "
			+ " AND auteur = '?' "
			+ " AND editeur = '?' "
			+ " AND langue = ? "
			+ " AND categorie = '?' "
			+ " AND emplacement = '?' "
			+ " AND dateParution = ? ";
	
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
                    unLivreDTO.setIdLivre(resultSet.getString(1));
                    unLivreDTO.setTitre(resultSet.getString(2));
                    unLivreDTO.setAuteur(resultSet.getString(3));
                    unLivreDTO.setEditeur(resultSet.getString(4));
                    unLivreDTO.setLangue(resultSet.getString(5));
                    unLivreDTO.setIdCategorie(resultSet.getString(6));
                    unLivreDTO.setEmplacement(resultSet.getString(7));
                    unLivreDTO.setDateParution(resultSet.getTimestamp(8));
                }
            }
        }
        return unLivreDTO;
	}
	@Override
	public void update(Connection connection, LivreDTO livreDTO) throws SQLException {
		try(PreparedStatement updatePreparedStatement = connection.prepareStatement(LivreDAO.UPDATE_LIVRE_REQUEST)) {
	            updatePreparedStatement.setString(1,livreDTO.getTitre());
	            updatePreparedStatement.setString(2,livreDTO.getAuteur());
	            updatePreparedStatement.setString(3,livreDTO.getEditeur());
	            updatePreparedStatement.setString(4,livreDTO.getLangue());
	            updatePreparedStatement.setString(5,livreDTO.getIdCategorie());
	            updatePreparedStatement.setString(6,livreDTO.getEmplacement());
	            updatePreparedStatement.setTimestamp(7,livreDTO.getDateParution());
	            updatePreparedStatement.setString(8,livreDTO.getIdLivre());
	            updatePreparedStatement.executeUpdate();
	        }
	}
	@Override
	public void delete(Connection connection, LivreDTO livreDTO) throws SQLException {
		try(PreparedStatement deletePreparedStatement = connection.prepareStatement(LivreDAO.DELETE_LIVRE_REQUEST)) {
            deletePreparedStatement.setString(1,livreDTO.getIdLivre());
            deletePreparedStatement.executeUpdate();
        }
	}
	@Override
	public List<LivreDTO> getAll(Connection connection) throws SQLException {
        List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement getAllPreparedStatement = connection.prepareStatement(LivreDAO.GET_ALL_LIVRE_REQUEST)) {
            try(ResultSet resultSet = getAllPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public void deleteAllInCategorie(Connection connection, String categorie) throws SQLException {
		try(PreparedStatement deletePreparedStatement = connection.prepareStatement(LivreDAO.DELETE_ALL_IN_CATEGORIE_LIVRE_REQUEST)) {
            deletePreparedStatement.setString(1,categorie);
            deletePreparedStatement.executeUpdate();
        }
	}
	@Override
	public List<LivreDTO> findByTitre(Connection connection, String titre) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_TITRE_LIVRE_REQUEST)) {
            findPreparedStatement.setString(1, titre);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByAuteur(Connection connection, String auteur) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_AUTEUR_LIVRE_REQUEST)) {
            findPreparedStatement.setString(1, auteur);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByEditeur(Connection connection, String editeur) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_EDITEUR_LIVRE_REQUEST)) {
            findPreparedStatement.setString(1, editeur);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByLangue(Connection connection, String langue) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_LANGUE_LIVRE_REQUEST)) {
            findPreparedStatement.setString(1, langue);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByCategorie(Connection connection, String categorie) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_CATEGORIE_LIVRE_REQUEST)) {
            findPreparedStatement.setString(1, categorie);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByEmplacement(Connection connection, String emplacement) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_EMPLACEMENT_LIVRE_REQUEST)) {
            findPreparedStatement.setString(1, emplacement);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByDateParution(Connection connection, Timestamp dateParution) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_PARUTION_LIVRE_REQUEST)) {
            findPreparedStatement.setTimestamp(1, dateParution);
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO livreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        livreDTO = new LivreDTO();
                        livreDTO.setIdLivre(resultSet.getString(1));
                        livreDTO.setTitre(resultSet.getString(2));
                        livreDTO.setAuteur(resultSet.getString(3));
                        livreDTO.setEditeur(resultSet.getString(4));
                        livreDTO.setLangue(resultSet.getString(5));
                        livreDTO.setIdCategorie(resultSet.getString(6));
                        livreDTO.setEmplacement(resultSet.getString(7));
                        livreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(livreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}
	@Override
	public List<LivreDTO> findByForm(Connection connection, LivreDTO livreDTO) throws SQLException {
		List<LivreDTO> livres = Collections.emptyList();
        try(PreparedStatement findPreparedStatement = connection.prepareStatement(LivreDAO.FIND_BY_FORM_LIVRE_REQUEST)) {
        	findPreparedStatement.setString(1, livreDTO.getTitre());
            findPreparedStatement.setString(2, livreDTO.getAuteur());
            findPreparedStatement.setString(3, livreDTO.getEditeur());
            findPreparedStatement.setString(4, livreDTO.getLangue());
            findPreparedStatement.setString(5, livreDTO.getIdCategorie());
            findPreparedStatement.setString(6, livreDTO.getEmplacement());
            findPreparedStatement.setTimestamp(7, livreDTO.getDateParution());
        	try(ResultSet resultSet = findPreparedStatement.executeQuery()) {
                LivreDTO unLivreDTO = null;
                if(resultSet.next()) {
                    livres = new ArrayList<>();
                    do {
                        unLivreDTO = new LivreDTO();
                        unLivreDTO.setIdLivre(resultSet.getString(1));
                        unLivreDTO.setTitre(resultSet.getString(2));
                        unLivreDTO.setAuteur(resultSet.getString(3));
                        unLivreDTO.setEditeur(resultSet.getString(4));
                        unLivreDTO.setLangue(resultSet.getString(5));
                        unLivreDTO.setIdCategorie(resultSet.getString(6));
                        unLivreDTO.setEmplacement(resultSet.getString(7));
                        unLivreDTO.setDateParution(resultSet.getTimestamp(8));
                        livres.add(unLivreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return livres;
	}

	
	
	
}
