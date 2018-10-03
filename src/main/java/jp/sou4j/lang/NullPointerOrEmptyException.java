package jp.sou4j.lang;

public class NullPointerOrEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NullPointerOrEmptyException() {
		super();
	}

	public NullPointerOrEmptyException(String message) {
		super(message);
	}

	public NullPointerOrEmptyException(String message, Throwable cause) {
		super(cause);
	}

	public NullPointerOrEmptyException(Throwable cause) {
		super(cause);
	}
}
