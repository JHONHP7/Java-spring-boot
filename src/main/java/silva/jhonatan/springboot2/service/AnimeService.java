package silva.jhonatan.springboot2.service;

import org.springframework.stereotype.Service;
import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.repository.AnimeRepository;

import java.util.List;

/**
 * Onde fazemos as regras de negócio
 */
@Service
public class AnimeService {
    /**
     * To do
     * private final AnimeRepository animeRepository
     * @return
     */
    public List<Anime> listAll() {
        return List.of(new Anime(1L, "One punch man"), new Anime(2L, "One piece"));
    }
}
