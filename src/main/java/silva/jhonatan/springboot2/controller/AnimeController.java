package silva.jhonatan.springboot2.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.requests.AnimePostRequestBody;
import silva.jhonatan.springboot2.requests.AnimePutRequestBody;
import silva.jhonatan.springboot2.service.AnimeService;
import silva.jhonatan.springboot2.util.DateUtil;

/**
 * Onde estão só os end points
 */
@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
	/**
	 * Autowired para fazer injeção de dependência mas não é recomendado via campos
	 * e sim via constructor podemos isntanciar o constructor ou usar a anotação do
	 * lombok par isso ou usar RequiredArgsConstructor que irá criar um constructor
	 * com os campos que são finais mas o mais correto seria criar uma interface
	 */
	private final DateUtil dateUtil;
	private final AnimeService animeService;

	@GetMapping
	public ResponseEntity<Page<Anime>> list(Pageable pageable) {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		/**
		 * Posso retornar o status da requisição Usando return new
		 * ResponseEntity<>(animeService.listAll(), HttpStatus.OK); Ou usando
		 */
		return ResponseEntity.ok(animeService.listAll(pageable));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable Long id) {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		/**
		 * Posso retornar o status da requisição Usando return new
		 * ResponseEntity<>(animeService.listAll(), HttpStatus.OK); Ou usando
		 */
		return ResponseEntity.ok(animeService.findbyidOrThrowBadRequestException(id));
	}

	/**
	 * Para usar o param http://localhost:8080/animes/find?name=Boku no hero
	 * 
	 * @param name
	 * @return
	 */
	@GetMapping(path = "/find")
	public ResponseEntity<List<Anime>> findByName(@RequestParam String name) {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		/**
		 * Posso retornar o status da requisição Usando return new
		 * ResponseEntity<>(animeService.listAll(), HttpStatus.OK); Ou usando
		 */
		return ResponseEntity.ok(animeService.findByName(name));
	}

	@PostMapping
	public ResponseEntity<Anime> save(@RequestBody @Valid AnimePostRequestBody animePostRequestBody) {
		return new ResponseEntity<>(animeService.save(animePostRequestBody), HttpStatus.CREATED);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		animeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Atualizar anime, recebendo um anime inteiro com id e nome
	 *
	 * @param anime
	 * @return
	 */
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody AnimePutRequestBody animePutRequestBody) {
		log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
		animeService.replace(animePutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
