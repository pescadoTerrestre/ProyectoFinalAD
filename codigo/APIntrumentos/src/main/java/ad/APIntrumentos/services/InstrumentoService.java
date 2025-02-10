package ad.APIntrumentos.services;

import ad.APIntrumentos.repositories.InstrumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepository instrumentoRepository;
}
