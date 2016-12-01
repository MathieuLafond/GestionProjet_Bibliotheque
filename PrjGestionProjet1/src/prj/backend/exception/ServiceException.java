package prj.backend.exception;

public class ServiceException extends Exception{
	
	
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception cause) {
		super(cause);
	}
	
	
	private static final long serialVersionUID = 1L;

}
