package ad.APIntrumentos.models;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

import java.util.Date;

@Entity(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "instrumento_id")
    private Instrumento instrumento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column
    private Date fecha_prestamo;

    @Column
    private Date fecha_devolucion;

    @Column
    private Estado estado;

    public enum Estado{
        Pendiente, Devuelto
    }
}
