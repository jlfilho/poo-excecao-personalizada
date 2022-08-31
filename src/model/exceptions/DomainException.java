package model.exceptions;

public class DomainException extends Exception  { //RuntimeException
	
	public DomainException(String msg) {
		super(msg);
	}
}
