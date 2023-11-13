package silva.jhonatan.springboot2.repository;

import silva.jhonatan.springboot2.domain.Anime;

import java.util.List;

/**
 * Relação direta com o banco de dados
 * todas as querys nessa interface
 */
public interface AnimeRepository {
    List<Anime> listAll();
}

