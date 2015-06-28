package dev.yn.poke.mon.service.domain;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by devyn on 6/28/15.
 */
@Entity
public class PokemonMetadata {

    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    private List<PokemonType> types;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypes(List<PokemonType> types) {
        this.types = types;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PokemonType> getTypes() {
        return types;
    }
}
