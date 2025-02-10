package ad.APIntrumentos.repositories;

import ad.APIntrumentos.models.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilaRepository extends JpaRepository<Familia, Long> {
}
