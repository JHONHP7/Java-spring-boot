package silva.jhonatan.springboot2.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.service.AnimeService;
import silva.jhonatan.springboot2.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Onde estão só os end points
 */
@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {
    /**
     * Autowired para fazer injeção de dependência
     * mas não é recomendado via campos
     * e sim via constructor
     * podemos isntanciar o constructor ou usar a anotação do lombok par isso
     * ou usar RequiredArgsConstructor que irá criar um constructor com os campos que são finais
     * mas o mais correto seria criar uma interface
     */
    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        /**
         * Posso retornar o status da requisição
         * Usando return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
         * Ou usando
         */
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        /**
         * Posso retornar o status da requisição
         * Usando return new ResponseEntity<>(animeService.listAll(), HttpStatus.OK);
         * Ou usando
         */
        return ResponseEntity.ok(animeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime) {
        return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
