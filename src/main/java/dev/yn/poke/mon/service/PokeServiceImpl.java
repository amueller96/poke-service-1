package dev.yn.poke.mon.service;

import dev.yn.poke.mon.service.repository.PokemonMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokeServiceImpl implements PokeService {

    @Autowired
    private PokemonMetadataRepository metadataRepository;

    @Override public Object getAllPokemon() {
        return metadataRepository.findAll();
    }
}
