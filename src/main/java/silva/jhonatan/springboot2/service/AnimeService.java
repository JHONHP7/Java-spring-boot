package silva.jhonatan.springboot2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.exception.BadRequestException;
import silva.jhonatan.springboot2.mapper.AnimeMapper;
import silva.jhonatan.springboot2.repository.AnimeRepository;
import silva.jhonatan.springboot2.requests.AnimePostRequestBody;
import silva.jhonatan.springboot2.requests.AnimePutRequestBody;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Onde fazemos as regras de negócio
 */
@Service
@RequiredArgsConstructor
public class AnimeService {

	private final AnimeRepository animeRepository;

	/**
	 * To do private final AnimeRepository animeRepository
	 *
	 * @return
	 */
	public List<Anime> listAll() {
		return animeRepository.findAll();
	}

	public List<Anime> findByName(String name) {
		return animeRepository.findByName(name);
	}

	/**
	 * Buscar anime por id, e caso não retorne nada, usamos o bad request ao invés
	 * de 404 not found e a message tbm par quando existir o exception na requisição
	 * aparaça a msm que possa ser usada pelo front Além disso, ainda vem um stack
	 * tracer muito extenso que vc pode reduzir ou ignorar na resposta indo em
	 * resources/application.yml e adicionar server: error: include-stacktrace:
	 * on_param para aparecer o param precisa colocar no caminho http ?trace=true
	 *
	 * @param id
	 * @return
	 */
	public Anime findbyidOrThrowBadRequestException(Long id) {
		return animeRepository.findById(id)
				.orElseThrow(() -> new BadRequestException("Anime not found"));
	}
	
	@Transactional
	public Anime save(AnimePostRequestBody animePostRequestBody) {
		AnimeMapper.INSTANCE.toAnime(animePostRequestBody);
		return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animePostRequestBody));
	}

	public void delete(Long id) {
		animeRepository.delete(findbyidOrThrowBadRequestException(id));
	}

	public void replace(AnimePutRequestBody animePutRequestBody) {
		Anime savedAnime = findbyidOrThrowBadRequestException(animePutRequestBody.getId());
		Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
		anime.setId(savedAnime.getId());
		animeRepository.save(anime);
	}
}
