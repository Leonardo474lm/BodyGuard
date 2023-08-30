package edu.upc.practicando.controller;

import edu.upc.practicando.entities.Bodyguard;
import edu.upc.practicando.service.BodyguardService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Bodyguard")
public class BodyguardController {
    @Autowired
    public BodyguardService bs;

    @PostMapping
    public Bodyguard register(@RequestBody Bodyguard bodyguard) {
        return bs.register(bodyguard);
    }

    @GetMapping
    List<Bodyguard> list() {
        return bs.list();
    }

    @GetMapping("/{id}")
    public Bodyguard find(@PathVariable(value = "id") int id) {
        return bs.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        bs.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Bodyguard bodyguard) {
        bs.register(bodyguard);
    }
//esto filtro muestra a todos los bodyguard que tengan la misma especialidad
    @GetMapping("/filtro/{id}")
    public List<Bodyguard> bodyguardList(@PathVariable(value = "id") int id){
      return  bs.getBodyguardsByEspecialty(id);
    }
}
