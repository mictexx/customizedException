package model.exceptions;

//public class DomainException extends Exception{
public class DomainExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DomainExceptions(String msg) {
		super(msg);
	}

}
