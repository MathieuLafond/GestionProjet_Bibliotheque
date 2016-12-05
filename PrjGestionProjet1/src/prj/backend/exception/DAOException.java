package prj.backend.exception;

public class DAOException extends Exception{
	
	
	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception cause) {
		super(cause);
	}
	
	
	private static final long serialVersionUID = 1L;

}
