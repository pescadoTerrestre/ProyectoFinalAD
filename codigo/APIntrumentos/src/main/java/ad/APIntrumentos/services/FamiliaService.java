package ad.APIntrumentos.services;

import ad.APIntrumentos.repositories.FamilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService {

    @Autowired
    private FamilaRepository familaRepository;
}
