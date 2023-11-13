package silva.jhonatan.springboot2.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("anime")
@Log4j2
@AllArgsConstructor
public class AnimeController {
    /**
     * Autowired para fazer injeção de dependência
     * mas não é recomendado via campos
     * e sim via constructor
     * podemos isntanciar o constructor ou usar a anotação do lombok par isso
     * ou usar RequiredArgsConstructor que irá criar um constructor com os campos que são finais
     * mas o mais correto seria criar uma interface
     */
    private DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Anime> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Anime("One punch man"), new Anime("One piece"));
    }

}
