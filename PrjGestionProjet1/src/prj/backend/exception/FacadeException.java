package prj.backend.exception;

public class FacadeException extends Exception{
	
	
	
	public FacadeException(String message) {
		super(message);
	}
	
	public FacadeException(Exception cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}
