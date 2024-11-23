package rp.zut.lab02.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Oil {
    // konstruktor domyślny
    public Oil() {
        log.info("Tworzenie beana oil za pomocą konstruktora domyślnego");
    }
    // TODO można uzupełnić deklarację dodając właściwości
}
