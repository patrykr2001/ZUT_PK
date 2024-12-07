package rp.zut.lab05.components;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Slf4j
public class Oil {
    private int id;

    private String name;
    // konstruktor domyślny
    public Oil() {
        log.info("Tworzenie beana oil za pomocą konstruktora domyślnego");
    }
    // TODO można uzupełnić deklarację dodając właściwości
}
