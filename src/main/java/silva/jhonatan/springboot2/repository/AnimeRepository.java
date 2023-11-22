package silva.jhonatan.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import silva.jhonatan.springboot2.domain.Anime;

import java.util.List;

/**
 * Relação direta com o banco de dados todas as querys nessa interface
 */
@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
	List<Anime> findByName(String name);
}
