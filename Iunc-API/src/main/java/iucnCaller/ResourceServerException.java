/**
 * 
 */
package iucnCaller;

import java.io.IOException;

/**
 *  general Server-Exception
 *
 */
public class ResourceServerException extends IOException {

	private static final long serialVersionUID = 1L;

	private Integer errorcode;

	/**
	 * Default Constructor
	 */
	public ResourceServerException() {
		super();
	}

	/**
	 * Constructor with message
	 * @param message a mssage
	 */
	public ResourceServerException(String message) {
		super(message);
	}

	/**
	 * Constructor, message and Http-Statuscode
	 * @param statuscode  Http-Status-Code
	 * @param message message
	 */
	public ResourceServerException(int statuscode, String message) {
		super(message);
		this.errorcode = statuscode;
	}

	/**
	 * Constructor mit Throwable
	 * @param cause ein Throwable
	 */
	public ResourceServerException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor with message and Throwable
	 * @param message eine Message
	 * @param cause ein Throwable
	 */
	public ResourceServerException(String message, Throwable cause) {
		super(message, cause);
	}


	/**
	 * return Http-Status-Code.
	 * @return  Code
	 */
	public Integer getErrorcode() {
		return errorcode;
	}
}
