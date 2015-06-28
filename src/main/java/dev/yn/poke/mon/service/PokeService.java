package dev.yn.poke.mon.service;

import dev.yn.poke.mon.service.domain.PokemonMetadata;

import java.util.List;

public interface PokeService {
    public List<PokemonMetadata> getAllPokemon();
}