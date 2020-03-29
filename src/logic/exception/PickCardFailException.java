package logic.exception;

public class PickCardFailException extends Exception{

	private static final long serialVersionUID = -7108982069079662317L;
	public String message ;
	public PickCardFailException(String message) {
		this.message = message ;
		}
}