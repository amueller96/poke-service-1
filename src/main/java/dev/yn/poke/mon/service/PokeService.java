package dev.yn.poke.mon.service;

import dev.yn.poke.mon.service.domain.PokemonMetadata;
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository;

public interface PokeService {
    Object getAllPokemon();
    Object addPokemon(PokemonMetadata request);
}
