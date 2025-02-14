package ad.controllers;

import ad.models.Familia;
import ad.repositories.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/familias")
public class FamiliaController {
    @Autowired
    private FamiliaRepository familiaRepository;

    @GetMapping
    public List<Familia> obtenerTodos(){
        return  familiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Familia obtenerPorId(@PathVariable int id){
        return familiaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Familia guardar(@RequestBody Familia familia){
        return familiaRepository.save(familia);
    }

    @PutMapping("/{id}")
    public Familia actualizar(@PathVariable int id, @RequestBody Familia familia){
        familia.setId(id);
        return familiaRepository.save(familia);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        familiaRepository.deleteById(id);
    }
}