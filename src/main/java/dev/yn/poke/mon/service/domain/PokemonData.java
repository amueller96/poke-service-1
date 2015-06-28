package dev.yn.poke.mon.service.domain;

import java.util.List;

public class PokemonData {
    private Integer id;
    private String name;
    private List<PokemonType> types;
    private PokemonStats stats;

    //TODO add descritions
    //TODO add egg information
    //TODO evolutionary data
    //TODO weight
    //TODO size

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonType> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    public PokemonStats getStats() {
        return stats;
    }

    public void setStats(PokemonStats stats) {
        this.stats = stats;
    }
}
