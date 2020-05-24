package springbootdatajpa.springbootdatajpa.exception;

public class MscException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MscException(String message ,Long id) {
        super( message + id);
    }
	
	
	
}
