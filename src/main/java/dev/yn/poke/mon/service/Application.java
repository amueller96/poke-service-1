package dev.yn.poke.mon.service;

import dev.yn.poke.mon.service.domain.PokemonMetadata;
import dev.yn.poke.mon.service.domain.PokemonType;
import dev.yn.poke.mon.service.repository.PokemonMetadataRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@ComponentScan(value = { "dev.yn.poke.mon.service" })
public class Application {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        seedDb(context);
    }

    private static void seedDb(ConfigurableApplicationContext context) {
        PokemonMetadataRepository repository = (PokemonMetadataRepository) context.getBeanFactory().getBean("jpaPokemonMetadataRepository");
        PokemonMetadata metadata = new PokemonMetadata();
        metadata.setId(181);
        metadata.setName("ampharos");
        List<PokemonType> types = new ArrayList<>();
        types.add(PokemonType.ELECTRIC);
        metadata.setTypes(types);
        repository.save(metadata);

        metadata= new PokemonMetadata();
        metadata.setId(1);
        metadata.setName("charmander");
        types = new ArrayList<>();
        types.add(PokemonType.FIRE);
        metadata.setTypes(types);
        repository.save(metadata);
    }
}
