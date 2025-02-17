package ad.controllers;

import ad.models.Usuario;
import ad.repositories.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Operation(summary = "Devuelve una lista de usuarios", description = "Devulve una Lista con todos los usuarios registrados")
    @ApiResponse(responseCode = "200", description = "Lista obtenida con exito")
    @GetMapping
    public List<Usuario> obtenerTodos(){
        return  usuarioRepository.findAll();
    }

    @Operation(summary = "Devuelve un usuario", description = "Devuelve un usuario seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Usuario obtenido con exito")
    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    @Operation(summary = "Guarda un usuario", description = "Añade un nuevo usuario al sistema")
    @ApiResponse(responseCode = "200", description = "Usuario guardado con exito")
    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Operation(summary = "Actualiza un usuario", description = "Actualiza un usuario seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado con exito")
    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable int id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    @Operation(summary = "Elimina un usuario", description = "Elimina un usuario seleccionado por Id")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado con exito")
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id){
        usuarioRepository.deleteById(id);
    }
}
