package ad.models.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Entidad que simplifica al cliente enviar un prestamo")
public class PrestamoDTO {
    private int id;
    private int instrumento_id;
    private int usuario_id;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion ;
    private String estado;

    public PrestamoDTO() {
        this.estado = "Pendiente";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInstrumento_id() {
        return instrumento_id;
    }

    public void setInstrumento_id(int instrumento_id) {
        this.instrumento_id = instrumento_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
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
