package ad.services;

import ad.models.DTOs.PrestamoDTO;
import ad.models.Instrumento;
import ad.models.Usuario;
import ad.repositories.InstrumentoRepository;
import ad.repositories.PrestamoRepository;
import ad.models.Prestamo;
import ad.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private InstrumentoRepository instrumetoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Prestamo> obtenerTodos(){
        return prestamoRepository.findAll();
    }

    public List<Prestamo> obtenerPendientes(){
        return prestamoRepository.findPendientes();
    }

    public List<Prestamo> obtenerDevueltos(){
        return prestamoRepository.findDevueltos();
    }

    public Prestamo obtenerPorId(int id){
        return prestamoRepository.findById(id).orElseGet(null);
    }

    public Prestamo guardar(PrestamoDTO prestamoDTO) throws Exception {
        Prestamo prestamo = new Prestamo();
        Instrumento instrumento = instrumetoRepository.findById(prestamoDTO.getInstrumento_id()).orElse(null);
        Usuario usuario = usuarioRepository.findById(prestamoDTO.getInstrumento_id()).orElse(null);

        prestamo.setId(prestamoDTO.getId());
        prestamo.setInstrumento(instrumento);
        prestamo.setUsuario(usuario);
        prestamo.setFecha_prestamo(prestamoDTO.getFecha_prestamo());
        prestamo.setFecha_devolucion((prestamoDTO.getEstado().equals("Pendiente"))? null: prestamoDTO.getFecha_devolucion());
        prestamo.setEstado(prestamoDTO.getEstado());

        if (instrumento.getCantidad() < 1 && prestamo.getEstado().equals("Pendiente")){
            throw new Exception("No quedan unidades disponible");
        }else {
            return prestamoRepository.save(prestamo);
        }
    }

    public void borrar(int id){
        prestamoRepository.deleteById(id);
    }
}
