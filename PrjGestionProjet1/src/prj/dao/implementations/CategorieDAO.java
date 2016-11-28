package prj.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prj.dao.interfaces.ICategorieDAO;
import prj.dto.CategorieDTO;

public class CategorieDAO extends DAO implements ICategorieDAO{


	private static final String CREATE_CATEGORIE_REQUEST = ""
			+ " INSERT INTO categorie(nom) "
			+ " VALUES('?')";
	private static final String READ_CATEGORIE_REQUEST = ""
			+ " SELECT idCategorie, nom "
			+ " FROM categorie "
			+ " WHERE idLivre = ?";
	private static final String UPDATE_CATEGORIE_REQUEST = ""
			+ " UPDATE categorie "
			+ " SET nom = '?' "
			+ " WHERE idCategorie = ?";
	private static final String DELETE_CATEGORIE_REQUEST = ""
			+ " DELETE FROM categorie "
			+ " WHERE idCategorie = ?";
	private static final String GET_ALL_CATEGORIE_REQUEST = ""
			+ " SELECT idCategorie, nom "
			+ " FROM categorie";
	
	@Override
	public void create(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		try(PreparedStatement createPreparedStatement = connection.prepareStatement(CategorieDAO.CREATE_CATEGORIE_REQUEST)){
			createPreparedStatement.setString(1, categorieDTO.getNomCategorie());
			createPreparedStatement.executeUpdate();
		}
	}
	@Override
	public CategorieDTO read(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		CategorieDTO uneCategorieDTO = null;
        try(PreparedStatement readPreparedStatement = connection.prepareStatement(CategorieDAO.READ_CATEGORIE_REQUEST)) {
            readPreparedStatement.setString(1,categorieDTO.getIdCategorie());
            try(ResultSet resultSet = readPreparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    uneCategorieDTO = new CategorieDTO();
                    uneCategorieDTO.setIdCategorie(resultSet.getString(1));
                    uneCategorieDTO.setNomCategorie(resultSet.getString(2));
                }
            }
        }
        return uneCategorieDTO;
	}
	@Override
	public void update(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		try(PreparedStatement updatePreparedStatement = connection.prepareStatement(CategorieDAO.UPDATE_CATEGORIE_REQUEST)) {
            updatePreparedStatement.setString(1,categorieDTO.getNomCategorie());
            updatePreparedStatement.setString(2,categorieDTO.getIdCategorie());
            updatePreparedStatement.executeUpdate();
        }
	}
	@Override
	public void delete(Connection connection, CategorieDTO categorieDTO) throws SQLException {
		try(PreparedStatement deletePreparedStatement = connection.prepareStatement(CategorieDAO.DELETE_CATEGORIE_REQUEST)) {
            deletePreparedStatement.setString(1,categorieDTO.getIdCategorie());
            deletePreparedStatement.executeUpdate();
        }
	}
	@Override
	public List<CategorieDTO> getAll(Connection connection) throws SQLException {
		List<CategorieDTO> categories = Collections.emptyList();
        try(PreparedStatement getAllPreparedStatement = connection.prepareStatement(CategorieDAO.GET_ALL_CATEGORIE_REQUEST)) {
            try(ResultSet resultSet = getAllPreparedStatement.executeQuery()) {
                CategorieDTO categorieDTO = null;
                if(resultSet.next()) {
                    categories = new ArrayList<>();
                    do {
                        categorieDTO = new CategorieDTO();
                        categorieDTO.setIdCategorie(resultSet.getString(1));
                        categorieDTO.setNomCategorie(resultSet.getString(2));
                    } while(resultSet.next());
                }
            }
        }
        return categories;
	}
	
}
