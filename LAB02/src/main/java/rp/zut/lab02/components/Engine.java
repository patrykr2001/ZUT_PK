package rp.zut.lab02.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Engine {
    private Oil oil;

    // wstrzyknięcie przez właściwość
    @Autowired
    public void setOil(Oil oil) {
        log.info("Wstrzykuję oil przez właściowść");
        this.oil = oil;
    }

    public void start() {
        // TODO dodać logowanie informacji o starcie silnika
    }
}