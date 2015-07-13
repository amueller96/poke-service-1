package dev.yn.poke.mon.service;

import dev.yn.poke.mon.service.repository.PokemonMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dev.yn.poke.mon.service.domain.PokemonMetadata;

@Component
public class PokeServiceImpl implements PokeService {

    @Autowired
    private PokemonMetadataRepository metadataRepository;

    @Override public Object getAllPokemon() {
        return metadataRepository.findAll();
    }

    @Override public PokemonMetadata addPokemon(PokemonMetadata request) {
    	return metadataRepository.save(request);
    }
}
