package dev.yn.poke.mon.service

import dev.yn.poke.mon.service.domain.PokemonMetadata
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository
import spock.lang.Specification

/**
 * Created by devyn on 7/1/15.
 */
class PokemonServiceImplSpec extends Specification {

    PokeServiceImpl service
    PokemonMetadataRepository metadataRepository = Mock()

    void setup() {
        service = new PokeServiceImpl(metadataRepository: metadataRepository)
    }

    void "the service should calls metadataRepository.findAll and returns the result when getAllPokemon is called"() {
        given:
        List<PokemonMetadata> expected = new ArrayList<>();
        expected.add(new PokemonMetadata())
        List<PokemonMetadata> result

        when:
        result = service.getAllPokemon()

        then:
        1 * metadataRepository.findAll() >> expected
        result == expected
    }

}
