package ad.APIntrumentos.services;

import ad.APIntrumentos.models.Prestamo;
import ad.APIntrumentos.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> obtenerTodos(){
        return prestamoRepository.findAll();
    }

    public List<Prestamo> obtenerPendientes(){
        return prestamoRepository.findPendientes();
    }

    public List<Prestamo> obtenerDevueltos(){
        return prestamoRepository.findDevueltos();
    }

    public Prestamo obtenerPorId(Long id){
        return prestamoRepository.findById(id).orElseGet(null);
    }

    public Prestamo guardar(Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }

    public Prestamo borrar(Long id){
        prestamoRepository.deleteById(id);
    }
}
