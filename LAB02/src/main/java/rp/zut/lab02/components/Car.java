package rp.zut.lab02.components;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Car {
    private Engine engine;
    private Transmission transmission;

    // wstrzykiwanie zależności przez konstruktor
    public Car(Engine engine, Transmission transmission) {
    // TODO dodać log
        this.engine = engine;
        this.transmission = transmission;
    }

    public void run() {
    // TODO dodać logowanie informujące o starcie samochodu
    // TODO wywołać start silnika
    }
}
