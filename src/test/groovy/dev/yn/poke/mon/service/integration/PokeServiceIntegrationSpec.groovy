package dev.yn.poke.mon.service.integration

import com.fasterxml.jackson.databind.ObjectMapper
import dev.yn.poke.mon.service.Application
import dev.yn.poke.mon.service.PokeService
import dev.yn.poke.mon.service.domain.PokemonMetadata
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository
import dev.yn.poke.mon.service.repository.jpa.JpaPokemonMetadataRepository
import dev.yn.poke.mon.service.web.PokeServiceController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification;


@ContextConfiguration(classes = [Application], loader = SpringApplicationContextLoader)
public class PokemonServiceIntegrationSpec extends Specification {

    @Autowired
    PokeServiceController pokeServiceController

    @Autowired
    JpaPokemonMetadataRepository jpaMetadataRepository

    @Autowired
    PokemonMetadataRepository metadataRepository

    @Autowired
    PokeService pokeService

    @Autowired
    ObjectMapper mapper

    void setup() {
        jpaMetadataRepository.deleteAll()
    }

    void "test jpa repository"() {
        given:
        PokemonMetadata ampharosMetadata = mapper.readValue("{\"id\":181,\"name\":\"ampharos\",\"types\":[\"ELECTRIC\"]}", PokemonMetadata)
        PokemonMetadata charmanderMetadata = mapper.readValue("{\"id\":1,\"name\":\"charmander\",\"types\":[\"FIRE\"]}", PokemonMetadata)
        metadataRepository.save(ampharosMetadata)
        metadataRepository.save(charmanderMetadata)
        List<PokemonMetadata> pokeMeatadata

        when:
        pokeMeatadata = metadataRepository.findAll()

        then:
        pokeMeatadata.size() == 2
        pokeMeatadata.get(0).name == "charmander"
        pokeMeatadata.get(1).name == "ampharos"

    }

    void "test service layer"() {
        given:
        PokemonMetadata ampharosMetadata = mapper.readValue("{\"id\":181,\"name\":\"ampharos\",\"types\":[\"ELECTRIC\"]}", PokemonMetadata)
        PokemonMetadata charmanderMetadata = mapper.readValue("{\"id\":1,\"name\":\"charmander\",\"types\":[\"FIRE\"]}", PokemonMetadata)
        metadataRepository.save(ampharosMetadata)
        metadataRepository.save(charmanderMetadata)
        List<PokemonMetadata> pokeMetadata

        when:
        pokeMetadata = pokeService.allPokemon

        then:
        pokeMetadata.size() == 2
        pokeMetadata.get(0).name == "charmander"
        pokeMetadata.get(1).name == "ampharos"
    }

    void "test call controller directly"() {
        given:
        PokemonMetadata ampharosMetadata = mapper.readValue("{\"id\":181,\"name\":\"ampharos\",\"types\":[\"ELECTRIC\"]}", PokemonMetadata)
        PokemonMetadata charmanderMetadata = mapper.readValue("{\"id\":1,\"name\":\"charmander\",\"types\":[\"FIRE\"]}", PokemonMetadata)
        metadataRepository.save(ampharosMetadata)
        metadataRepository.save(charmanderMetadata)
        List<PokemonMetadata> pokeMetadata

        when:
        pokeMetadata = pokeServiceController.allPokemon

        then:
        pokeMetadata.size() == 2
        pokeMetadata.get(0).name == "charmander"
        pokeMetadata.get(1).name == "ampharos"
    }
}
