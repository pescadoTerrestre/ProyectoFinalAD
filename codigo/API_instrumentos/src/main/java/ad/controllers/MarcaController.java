package ad.controllers;

import ad.models.Marca;
import ad.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marcas")
public class MarcaController {
    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<Marca> obtenerTodos(){
        return  marcaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Marca obtenerPorId(@PathVariable int id){
        return marcaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Marca guardar(@RequestBody Marca marca){
        return marcaRepository.save(marca);
    }

    @PutMapping("/{id}")
    public Marca actualizar(@PathVariable int id, @RequestBody Marca marca){
        marca.setId(id);
        return marcaRepository.save(marca);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        marcaRepository.deleteById(id);
    }
}
