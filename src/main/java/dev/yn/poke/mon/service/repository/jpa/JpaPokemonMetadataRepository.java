package dev.yn.poke.mon.service.repository.jpa;

import dev.yn.poke.mon.service.domain.PokemonMetadata;
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPokemonMetadataRepository extends CrudRepository<PokemonMetadata,Integer>, PokemonMetadataRepository {
}
