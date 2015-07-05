package dev.yn.poke.mon.service.integration

import com.fasterxml.jackson.databind.ObjectMapper
import dev.yn.poke.mon.service.Application
import dev.yn.poke.mon.service.domain.PokemonMetadata
import dev.yn.poke.mon.service.repository.jpa.JpaPokemonMetadataRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpHeaders
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * Created by devyn on 7/5/15.
 */
@ContextConfiguration(classes = [Application], loader = SpringApplicationContextLoader)
@WebAppConfiguration
class WebAppIntegrationSpec extends Specification {
    @Autowired
    WebApplicationContext webApplicationContext

    @Autowired
    JpaPokemonMetadataRepository metadataRepository

    @Autowired
    ObjectMapper mapper

    MockMvc mockMvc

    void setup() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
        metadataRepository.deleteAll()
    }

    void "pokemon endpoint returns list of pokemon"() {
        given:
        PokemonMetadata ampharosMetadata = mapper.readValue("{\"id\":181,\"name\":\"ampharos\",\"types\":[\"ELECTRIC\"]}", PokemonMetadata)
        PokemonMetadata charmanderMetadata = mapper.readValue("{\"id\":1,\"name\":\"charmander\",\"types\":[\"FIRE\"]}", PokemonMetadata)
        metadataRepository.save(ampharosMetadata)
        metadataRepository.save(charmanderMetadata)
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json")

        when:
        ResultActions results = mockMvc.perform(get("/pokemon").headers(headers))

        then:
        results.andExpect(status().isOk())
        results.andReturn().getResponse().getContentAsString() == "[{\"id\":1,\"name\":\"charmander\",\"types\":[\"FIRE\"]},{\"id\":181,\"name\":\"ampharos\",\"types\":[\"ELECTRIC\"]}]"
    }
}
