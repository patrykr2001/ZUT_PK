package rp.zut.lab04.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class Transmission {
    @Value("#{${transmission.wheel.radius} * 2 * T(java.lang.Math).PI}")
    private double transmissionBeltLength;

    public double getTransmissionBeltLength() {
        return transmissionBeltLength;
    }

    public Transmission() {
        log.info("Tworzę beana transmission");
    }
}
