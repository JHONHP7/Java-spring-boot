package silva.jhonatan.springboot2.requests;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * Como o dto
 */
@Data
public class AnimePostRequestBody {
	/**
	 * Cuida das validações de campos
	 */
	@NotEmpty(message = "The anime name cannot be empty")
	private String name;

}
