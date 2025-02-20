package ad.repositories;

import ad.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
    @NativeQuery(value = "SELECT * FROM prestamos WHERE estado like 'Pendiente'")
    List<Prestamo> findPendientes();

    @NativeQuery(value = "SELECT * FROM prestamos WHERE estado like 'Devuelto'")
    List<Prestamo> findDevueltos();
}
