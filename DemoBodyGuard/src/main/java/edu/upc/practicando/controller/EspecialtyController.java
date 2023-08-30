package edu.upc.practicando.controller;

import edu.upc.practicando.entities.Especialty;
import edu.upc.practicando.service.EspecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Especialty")
public class EspecialtyController {
    @Autowired
    private EspecialtyService es;

    @PostMapping
    public Especialty generate(@RequestBody Especialty especialty) {
        return es.generate(especialty);
    }

    @GetMapping
    List<Especialty> list() {
        return es.list();
    }

    @GetMapping("/{id}")
    public Especialty find(@PathVariable(value = "id") int id) {
        return es.find(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") int id) {
        es.delete(id);
    }

    @PutMapping
    public void update(@RequestBody Especialty especialty) {
        es.generate(especialty);
    }
}
