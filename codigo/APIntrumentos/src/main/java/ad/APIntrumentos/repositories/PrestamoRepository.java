package ad.APIntrumentos.repositories;

import ad.APIntrumentos.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    List<Prestamo> findByCliente(Long id);
    List<Prestamo> findByUsuario(Long id);

    @Query("select u from Prestamos u where u.estado = 'Pendiente'")
    List<Prestamo> findPendientes();

    @Query("select u from Prestamos u where u.estado = 'Devuelto'")
    List<Prestamo> findDevueltos();
}
