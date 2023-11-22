package silva.jhonatan.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import silva.jhonatan.springboot2.domain.Anime;

import java.util.List;

/**
 * Relação direta com o banco de dados
 * todas as querys nessa interface
 */
public interface AnimeRepository extends JpaRepository<Anime, Long> {
    List<Anime> findAll();
}

