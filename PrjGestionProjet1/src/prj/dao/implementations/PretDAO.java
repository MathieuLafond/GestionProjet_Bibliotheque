package prj.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import prj.dao.interfaces.IPretDAO;
import prj.dto.LivreDTO;
import prj.dto.MembreDTO;
import prj.dto.PretDTO;

public class PretDAO extends DAO implements IPretDAO{

	
	private static final String CREATE_PRET_REQUEST = ""
			+ " INSERT INTO pret(idMembre, idLivre, datePret, dateRetour, dateLimite) "
			+ " VALUES(?,?,?,?,?)";
	private static final String READ_PRET_REQUEST = ""
			+ " SELECT idPret, idMembre, idLivre, datePret, dateRetour, dateLimite "
			+ " FROM pret "
			+ " WHERE idPret = ?";
	private static final String UPDATE_PRET_REQUEST = ""
			+ " UPDATE pret "
			+ " SET datePret = ?, dateRetour = ?, dateLimite = ? "
			+ " WHERE idLivre = ?";
	private static final String DELETE_PRET_REQUEST = ""
			+ " DELETE FROM pret "
			+ " WHERE idPret = ?";
	private static final String GET_ALL_PRET_REQUEST = ""
			+ " SELECT idPret, idMembre, idLivre, datePret, dateRetour, dateLimite "
			+ " FROM pret";
	
	@Override
	public void create(Connection connection, PretDTO pretDTO) throws SQLException {
		try(PreparedStatement createPreparedStatement = connection.prepareStatement(PretDAO.CREATE_PRET_REQUEST)){
			createPreparedStatement.setString(1, pretDTO.getMembreDTO().getIdMembre());
			createPreparedStatement.setString(2, pretDTO.getLivreDTO().getIdLivre());
			createPreparedStatement.setTimestamp(3, pretDTO.getDatePret());
			createPreparedStatement.setTimestamp(4, pretDTO.getDateRetour());
			createPreparedStatement.setTimestamp(5, pretDTO.getDateLimite());
			createPreparedStatement.executeUpdate();
		}
	}

	@Override
	public PretDTO read(Connection connection, PretDTO pretDTO) throws SQLException {
		PretDTO unPretDTO = null;
        try(PreparedStatement readPreparedStatement = connection.prepareStatement(PretDAO.READ_PRET_REQUEST)) {
            readPreparedStatement.setString(1,pretDTO.getIdPret());
            try(ResultSet resultSet = readPreparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    unPretDTO = new PretDTO();
                    MembreDTO unMembreDTO = new MembreDTO();
                    LivreDTO unLivreDTO = new LivreDTO();
                    unPretDTO.setIdPret(resultSet.getString(1));
                    unMembreDTO.setIdMembre(resultSet.getString(2));
                    unPretDTO.setMembreDTO(unMembreDTO);
                    unLivreDTO.setIdLivre(resultSet.getString(3));
                    unPretDTO.setLivreDTO(unLivreDTO);
                    unPretDTO.setDatePret(resultSet.getTimestamp(4));
                    unPretDTO.setDateRetour(resultSet.getTimestamp(5));
                    unPretDTO.setDateLimite(resultSet.getTimestamp(6));
                }
            }
        }
        return unPretDTO;
	}

	@Override
	public void update(Connection connection, PretDTO pretDTO) throws SQLException {
		try(PreparedStatement updatePreparedStatement = connection.prepareStatement(PretDAO.UPDATE_PRET_REQUEST)) {
            updatePreparedStatement.setTimestamp(1,pretDTO.getDatePret());
            updatePreparedStatement.setTimestamp(2,pretDTO.getDateRetour());
            updatePreparedStatement.setTimestamp(3,pretDTO.getDateLimite());
            updatePreparedStatement.setString(4,pretDTO.getIdPret());
            updatePreparedStatement.executeUpdate();
        }
	}

	@Override
	public void delete(Connection connection, PretDTO pretDTO) throws SQLException {
		try(PreparedStatement deletePreparedStatement = connection.prepareStatement(PretDAO.DELETE_PRET_REQUEST)) {
            deletePreparedStatement.setString(1,pretDTO.getIdPret());
            deletePreparedStatement.executeUpdate();
        }
	}

	@Override
	public List<PretDTO> getAll(Connection connection) throws SQLException {
		List<PretDTO> prets = Collections.emptyList();
        try(PreparedStatement getAllPreparedStatement = connection.prepareStatement(PretDAO.GET_ALL_PRET_REQUEST)) {
            try(ResultSet resultSet = getAllPreparedStatement.executeQuery()) {
                PretDTO pretDTO = null;
                if(resultSet.next()) {
                    prets = new ArrayList<>();
                    do {
                        pretDTO = new PretDTO();
                        MembreDTO unMembreDTO = new MembreDTO();
                        LivreDTO unLivreDTO = new LivreDTO();
                        pretDTO.setIdPret(resultSet.getString(1));
                        unMembreDTO.setIdMembre(resultSet.getString(2));
                        pretDTO.setMembreDTO(unMembreDTO);
                        unLivreDTO.setIdLivre(resultSet.getString(3));
                        pretDTO.setLivreDTO(unLivreDTO);
                        getAllPreparedStatement.setTimestamp(4,pretDTO.getDatePret());
                        getAllPreparedStatement.setTimestamp(5,pretDTO.getDateRetour());
                        getAllPreparedStatement.setTimestamp(6,pretDTO.getDateLimite());
                        getAllPreparedStatement.executeUpdate();
                        prets.add(pretDTO);
                    } while(resultSet.next());
                }
            }
        }
        return prets;
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
