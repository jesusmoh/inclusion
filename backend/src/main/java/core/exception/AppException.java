package core.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;
	private final boolean error;

	public AppException(String message, boolean error) {
		this.message = message;
		this.error = error;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public boolean isError() {
		return error;
	}

}
