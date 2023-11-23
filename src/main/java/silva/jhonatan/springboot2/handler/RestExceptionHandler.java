package silva.jhonatan.springboot2.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 * Dizendo pros controles que eles teram que utilizar o que eu colocar dentro dessa classe
 * baseado na flag @ExceptionHandler
 */
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.log4j.Log4j2;
import silva.jhonatan.springboot2.exception.BadRequestException;
import silva.jhonatan.springboot2.exception.BadRequestExceptionDetails;
import silva.jhonatan.springboot2.exception.ValidationExceptionDetails;

/**
 * O Handler é uma forma que vc tem de interceptar e dizer pro controller para
 * ele pegar as exceptions e add oq eu definir dentro do método
 */
@ControllerAdvice
@Log4j2
public class RestExceptionHandler {
	/**
	 * Toda vez que ocorrer uma exception do tipo bad request vc vai utilizar esse
	 * exception handler e retornar o valor definido aqui
	 * 
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionDetails> handlerMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		String field = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
		String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage)
				.collect(Collectors.joining(", "));
		
		  return new ResponseEntity<>(
				  ValidationExceptionDetails.builder()
					  .timetamp(LocalDateTime.now())
					  .status(HttpStatus.BAD_REQUEST.value())
					  .title("Bad Request Exception, Invalid Fields")
					  .details("Check the fields error")
					  .developerMessage(exception.getClass().getName())
					  .fields(field)
					  .fieldsMessage(fieldsMessage)
					  .build(), HttpStatus.BAD_REQUEST);
		 

	}

}
