package dev.yn.poke.mon.service.web

import dev.yn.poke.mon.service.PokeService
import spock.lang.Specification

/**
 * Created by devyn on 7/1/15.
 */
class PokeServiceControllerSpec extends Specification {
    PokeService service = Mock()
    PokeServiceController pokeServiceController

    void setup() {
        pokeServiceController = new PokeServiceController(service: service)
    }

    void "should call service.getAllPokemon() and return result on call to getAllPokemon"() {
        given:
        Object expected = [ "look", "at", "me"]
        Object result

        when:
        result = pokeServiceController.getAllPokemon()

        then:
        1 * service.getAllPokemon() >> expected
        result == expected
    }
}
