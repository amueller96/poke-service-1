package dev.yn.poke.mon.service;

import dev.yn.poke.mon.service.domain.PokemonMetadata;
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokeServiceImpl implements PokeService {


    @Autowired
    private PokemonMetadataRepository metadataRepository;

    @Override public List<PokemonMetadata> getAllPokemon() {
        return metadataRepository.findAll();
    }
}
