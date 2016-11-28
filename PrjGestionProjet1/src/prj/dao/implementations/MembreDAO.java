package prj.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prj.dao.interfaces.IMembreDAO;
import prj.dto.MembreDTO;

public class MembreDAO extends DAO implements IMembreDAO{

	private static final String CREATE_MEMBRE_REQUEST = ""
			+ " INSERT INTO membre(prenom, nom, adresse, code_postal, telephone, courriel, limite_pret) "
			+ " VALUES('?','?','?','?','?','?',?)";
	private static final String READ_MEMBRE_REQUEST = ""
			+ " SELECT idMembre, prenom, nom, adresse, code_postal, telephone, courriel, limite_pret "
			+ " FROM membre "
			+ " WHERE idMembre = ?";
	private static final String UPDATE_MEMBRE_REQUEST = ""
			+ " UPDATE membre "
			+ " SET prenom = '?', nom = '?', adresse = '?', code_postal = '?', telephone = '?', courriel = '?', limite_pret = ? "
			+ " WHERE idMembre = ?";
	private static final String DELETE_MEMBRE_REQUEST = ""
			+ " DELETE FROM membre "
			+ " WHERE idMembre = ?";
	private static final String GET_ALL_MEMBRE_REQUEST = ""
			+ " SELECT idMembre, prenom, nom, adresse, code_postal, telephone, courriel, limite_pret "
			+ " FROM membre";
	
	
	
	@Override
	public void create(Connection connection, MembreDTO membreDTO) throws SQLException {
		try(PreparedStatement createPreparedStatement = connection.prepareStatement(MembreDAO.CREATE_MEMBRE_REQUEST)){
			createPreparedStatement.setString(1, membreDTO.getPrenom());
			createPreparedStatement.setString(2, membreDTO.getNom());
			createPreparedStatement.setString(3, membreDTO.getAdresse());
			createPreparedStatement.setString(4, membreDTO.getCodePostal());
			createPreparedStatement.setString(5, membreDTO.getTelephone());
			createPreparedStatement.setString(6, membreDTO.getCourriel());
			createPreparedStatement.setString(7, membreDTO.getLimitePret());
			createPreparedStatement.executeUpdate();
		}
	}

	@Override
	public MembreDTO read(Connection connection, MembreDTO membreDTO) throws SQLException {
		MembreDTO unMembreDTO = null;
        try(PreparedStatement readPreparedStatement = connection.prepareStatement(MembreDAO.READ_MEMBRE_REQUEST)) {
            readPreparedStatement.setString(1,membreDTO.getIdMembre());
            try(ResultSet resultSet = readPreparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    unMembreDTO = new MembreDTO();
                    unMembreDTO.setIdMembre(resultSet.getString(1));
                    unMembreDTO.setPrenom(resultSet.getString(2));
                    unMembreDTO.setNom(resultSet.getString(3));
                    unMembreDTO.setAdresse(resultSet.getString(4));
                    unMembreDTO.setCodePostal(resultSet.getString(5));
                    unMembreDTO.setTelephone(resultSet.getString(6));
                    unMembreDTO.setCourriel(resultSet.getString(7));
                    unMembreDTO.setLimitePret(resultSet.getString(8));
                }
            }
        }
        return unMembreDTO;
	}

	@Override
	public void update(Connection connection, MembreDTO membreDTO) throws SQLException {
		try(PreparedStatement updatePreparedStatement = connection.prepareStatement(MembreDAO.UPDATE_MEMBRE_REQUEST)) {
            updatePreparedStatement.setString(1,membreDTO.getPrenom());
            updatePreparedStatement.setString(2,membreDTO.getNom());
            updatePreparedStatement.setString(3,membreDTO.getAdresse());
            updatePreparedStatement.setString(4,membreDTO.getCodePostal());
            updatePreparedStatement.setString(5,membreDTO.getTelephone());
            updatePreparedStatement.setString(6,membreDTO.getCourriel());
            updatePreparedStatement.setString(7,membreDTO.getLimitePret());
            updatePreparedStatement.setString(8,membreDTO.getIdMembre());
            updatePreparedStatement.executeUpdate();
        }
	}

	@Override
	public void delete(Connection connection, MembreDTO membreDTO) throws SQLException {
		try(PreparedStatement deletePreparedStatement = connection.prepareStatement(MembreDAO.DELETE_MEMBRE_REQUEST)) {
            deletePreparedStatement.setString(1,membreDTO.getIdMembre());
            deletePreparedStatement.executeUpdate();
        }
	}

	@Override
	public List<MembreDTO> getAll(Connection connection) throws SQLException {
		List<MembreDTO> membres = Collections.emptyList();
        try(PreparedStatement getAllPreparedStatement = connection.prepareStatement(MembreDAO.GET_ALL_MEMBRE_REQUEST)) {
            try(ResultSet resultSet = getAllPreparedStatement.executeQuery()) {
                MembreDTO membreDTO = null;
                if(resultSet.next()) {
                    membres = new ArrayList<>();
                    do {
                        membreDTO = new MembreDTO();
                        membreDTO.setIdMembre(resultSet.getString(1));
                        membreDTO.setPrenom(resultSet.getString(2));
                        membreDTO.setNom(resultSet.getString(3));
                        membreDTO.setAdresse(resultSet.getString(4));
                        membreDTO.setCodePostal(resultSet.getString(5));
                        membreDTO.setTelephone(resultSet.getString(6));
                        membreDTO.setCourriel(resultSet.getString(7));
                        membreDTO.setLimitePret(resultSet.getString(8));
                        membres.add(membreDTO);
                    } while(resultSet.next());
                }
            }
        }
        return membres;
	}

	@Override
	public List<MembreDTO> findByRetard(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
