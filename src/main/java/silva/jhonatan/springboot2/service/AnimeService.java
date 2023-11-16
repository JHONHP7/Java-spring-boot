package silva.jhonatan.springboot2.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.repository.AnimeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Onde fazemos as regras de negócio
 */
@Service
public class AnimeService {
    private static List<Anime> animes;

    static {
        animes = new ArrayList<>(List.of(new Anime(1L, "One punch man"), new Anime(2L, "One piece")));
    }

    /**
     * To do
     * private final AnimeRepository animeRepository
     *
     * @return
     */
    public List<Anime> listAll() {
        return animes;
    }

    /**
     * Buscar anime por id, e caso não retorne nada, usamos o bad request ao invés de 404 not found
     * e a message tbm par quando existir o exception na requisição aparaça a msm que possa ser usada pelo
     * front
     * Além disso, ainda vem um stack tracer muito extenso que vc pode reduzir ou ignorar na resposta
     * indo em resources/application.yml e adicionar server: error: include-stacktrace: on_param
     * para aparecer o param precisa colocar no caminho http ?trace=true
     *
     * @param id
     * @return
     */
    public Anime findById(Long id) {
        return animes.stream()
                .filter(animes -> animes.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not found"));
    }

    public Anime save(Anime anime) {
        anime.setId(ThreadLocalRandom.current().nextLong(3, 10000000));
        animes.add(anime);
        return anime;
    }

    public void delete(Long id){
        animes.remove(findById(id));
    }
}
