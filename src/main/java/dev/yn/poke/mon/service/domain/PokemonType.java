package dev.yn.poke.mon.service.domain;

/**
 * Created by devyn on 6/28/15.
 */
public enum PokemonType {
    NORMAL("normal"),
    FIRE("fire"),
    WATER("water"),
    ELECTRIC("electric"),
    GRASS("grass"),
    ICE("ice"),
    FIGHTING("fighting"),
    POISON("poison"),
    GROUND("ground"),
    FLYING("flying"),
    PSYCHIC("psychic"),
    BUG("bug"),
    ROCK("rock"),
    GHOST("ghost"),
    DRAGON("dragon"),
    DARK("dark"),
    STEEL("steel"),
    FAIRY("fairy");

    private String type;

    private PokemonType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
