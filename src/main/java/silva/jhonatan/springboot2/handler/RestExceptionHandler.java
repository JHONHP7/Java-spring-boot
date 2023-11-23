package silva.jhonatan.springboot2.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 * Dizendo pros controles que eles teram que utilizar o que eu colocar dentro dessa classe
 * baseado na flag @ExceptionHandler
 */
import org.springframework.web.bind.annotation.ExceptionHandler;

import silva.jhonatan.springboot2.exception.BadRequestException;
import silva.jhonatan.springboot2.exception.BadRequestExceptionDetails;

@ControllerAdvice
public class RestExceptionHandler {
	/**
	 * Toda vez que ocorrer uma exception do tipo bad request 
	 * vc vai utilizar esse exception handler e retornar o valor definido aqui
	 * @param bre
	 * @return
	 */
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
		return new ResponseEntity<>(
				BadRequestExceptionDetails.builder().timetamp(LocalDateTime.now())
						.status(HttpStatus.BAD_REQUEST.value()).title("Bad Request Exception, Check the Documentation")
						.details(bre.getMessage()).developerMessage(bre.getClass().getName()).build(),
				HttpStatus.BAD_REQUEST);

	}

}
