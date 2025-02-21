package ad.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Schema(description = "Entidad que representa un Prestamo")
@Entity(name = "prestamos")
public class Prestamo {
    @Schema(description = "Identificador unico", example = "3")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description = "Identificador del instrumento prestado")
    @NotBlank(message = "El identificador del instrumento no puede estar en blanco")
    @ManyToOne
    @JoinColumn(name = "instrumento_id")
    private Instrumento instrumento;

    @Schema(description = "Identificador del usuario que hace el prestamo")
    @NotBlank(message = "El identificador del usuario nu puede estar en blanco")
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Schema(description = "fecha en la que se hace el prestamo", example = "2025-02-17")
    @NotBlank(message = "La fecha de prestamo no puede estar en blanco")
    @Column
    private LocalDate fecha_prestamo;

    @Schema(description = "fecha en la que se devolvio el prestamo", example = "2025-02-21")
    @Column
    private LocalDate fecha_devolucion;

    @Schema(description = "estado actual del prestamo", example = "Devuelto")
    @NotBlank(message = "El estado no puede estar en blanco")
    @Column
    private String estado;

    public Prestamo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if (estado.equals("Pendiente") || estado.equals("Devuelto")){
            this.estado = estado;
        }else {
            this.estado = "Pendiente";
        }
    }
}
