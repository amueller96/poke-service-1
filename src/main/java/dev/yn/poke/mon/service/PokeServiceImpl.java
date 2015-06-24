package dev.yn.poke.mon.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PokeServiceImpl implements PokeService {
    @Override public List<Object> getAllPokemon() {
        List<Object> pokemon = new ArrayList<>();
        pokemon.add("{name:ampharos}");
        return pokemon;
    }
}
