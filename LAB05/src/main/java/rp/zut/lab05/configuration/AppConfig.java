package rp.zut.lab05.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import rp.zut.lab05.components.Car;
import rp.zut.lab05.components.Engine;
import rp.zut.lab05.components.Transmission;

@Configuration
public class AppConfig {
    @Autowired
    Engine engine;

    @Autowired
    Environment env;

    // utworzenie beana za pomocą konstruktora domyślnego
    @Bean
    public Transmission transmission() {
        return new Transmission();
    }
    // utworzenie beana car za pomocą zdefinowanego konstruktora
    @Bean
    public Car car(Engine engine, Transmission transmission) {
        return new Car(engine, transmission, env.getProperty("car.name"));
    }
}
