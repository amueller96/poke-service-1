package dev.yn.poke.mon.service

import dev.yn.poke.mon.service.domain.PokemonMetadata
import dev.yn.poke.mon.service.domain.PokemonData
import dev.yn.poke.mon.service.PokeService
import dev.yn.poke.mon.service.PokeServiceImpl
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository
import spock.lang.Specification
import dev.yn.poke.mon.service.domain.PokemonType

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

    void "the service should calls metadataRepository.save and returns the result when addPokemon is called"() {
        given:
        List<PokemonMetadata> expected = new ArrayList<>();
        PokemonMetadata testData = new PokemonMetadata();
        testData.setId(30);
        testData.setName("Pikachu");
        List<PokemonType> types = new ArrayList<>();
        types.add(PokemonType.ELECTRIC);
        testData.setTypes(types);
        expected = metadataRepository.save(testData)
        List<PokemonMetadata> result = new ArrayList<>();

        when:
        result = service.addPokemon(testData)

        then:
        result == expected
    }

}
