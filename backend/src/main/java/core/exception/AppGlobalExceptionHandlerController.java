package core.exception;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppGlobalExceptionHandlerController {

	static final Logger log = Logger.getLogger(AppGlobalExceptionHandlerController.class.getName());

	@ExceptionHandler(AppException.class)
	public void handleCustomAppException(HttpServletResponse res, AppException ex) throws IOException {
		res.sendError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
	}

}
