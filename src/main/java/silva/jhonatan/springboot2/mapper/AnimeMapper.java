package silva.jhonatan.springboot2.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import silva.jhonatan.springboot2.domain.Anime;
import silva.jhonatan.springboot2.requests.AnimePostRequestBody;
import silva.jhonatan.springboot2.requests.AnimePutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
	/**
	 * Dois métodos que vão fazer a conversão automaticamente para anime Pegando uma
	 * instancia de AnimeMapper
	 */
	public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

	public abstract Anime toAnime(AnimePostRequestBody animePostRequestBody);

	public abstract Anime toAnime(AnimePutRequestBody animePostRequestBody);

}
