package silva.jhonatan.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
public class Anime implements Serializable {
    private static final long serialVersionUID = -2890017292817658315L;
    @Id
    private Long id;
    @Column(name = "nome")
    private String name;

    public Anime() {
    }
}
