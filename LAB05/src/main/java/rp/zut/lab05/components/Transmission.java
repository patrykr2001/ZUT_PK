package rp.zut.lab05.components;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Setter
@Getter
@Slf4j
public class Transmission {
    private int id;
    @Value("#{${transmission.wheel.radius} * 2 * T(java.lang.Math).PI}")
    private double transmissionBeltLength;

    public Transmission() {
        log.info("Tworzę beana transmission");
    }
}
