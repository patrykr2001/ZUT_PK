package rp.zut.lab09.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import rp.zut.lab09.domain.User;

@RestController
@RequestMapping(value = "/rest")
@Validated
public class UserRestController {

    @PostMapping("/adduser")
    public ResponseEntity<Result> addUser(@Valid @RequestBody User user) {
        try {
            // TODO zapis User do bazy
            model.addAttribute("user", user);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Result(){{
                        setStatus("OK");
                    }});
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new Result(){{
                        setStatus("ERROR");
                    }}); // TODO zainicjować pola obiektu Result
        }
    }

    @DeleteMapping("/deleteuser/{name}")
    public ResponseEntity<Result> deleteUser(@PathVariable String name) {
        try {
            repository.deleteByName(name);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new Result());
            // obiekt Result należy zainicjować
        }
        catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(new Result()); // obiekt Error mależy zainicjować
        }
    }
    // TODO dodać analogicznie usługi get, put.
    // TODO dodać obsługę wyjątków i zamienić w istniejących usługach (wykorzystać dowolną omówioną metodę)
}
