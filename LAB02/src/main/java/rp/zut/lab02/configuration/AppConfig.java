package rp.zut.lab02.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rp.zut.lab02.components.Car;
import rp.zut.lab02.components.Engine;
import rp.zut.lab02.components.Transmission;

@Configuration
public class AppConfig {
    @Autowired
    Engine engine;

    // utworzenie beana za pomocą konstruktora domyślnego
    @Bean
    public Transmission transmission() {
        return new Transmission();
    }
    // utworzenie beana car za pomocą zdefinowanego konstruktora
    @Bean
    public Car car(Engine engine, Transmission transmission) {
        return new Car(engine, transmission);
    }
}
