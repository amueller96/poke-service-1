package dev.yn.poke.mon.service.repository;

import dev.yn.poke.mon.service.domain.PokemonMetadata;

import java.util.List;

/**
 * Created by devyn on 6/28/15.
 */
public interface PokemonMetadataRepository {
    List<PokemonMetadata> findAll();
    PokemonMetadata save(PokemonMetadata pokemonMetadata);
}
