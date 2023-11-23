package silva.jhonatan.springboot2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception personalizada Chama a exception no service retorna um badrequest
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = -8266099206815818296L;

	public BadRequestException(String message) {
		super(message);
	}
}
