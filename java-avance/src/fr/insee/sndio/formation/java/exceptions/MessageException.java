package fr.insee.sndio.formation.java.exceptions;

public class MessageException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageException(String message, Throwable cause) {
		super("Message pas sensé être null." + message, cause);
	}
}
