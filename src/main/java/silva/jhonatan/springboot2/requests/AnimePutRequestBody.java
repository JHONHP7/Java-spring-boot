package silva.jhonatan.springboot2.requests;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Como o dto
 */
@Data
@Getter
@Setter
public class AnimePutRequestBody {
    private Long id;
    private String name;
}
