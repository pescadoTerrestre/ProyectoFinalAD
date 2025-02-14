package ad.models.DTOs;

import java.time.LocalDate;

public class PrestamoNombresDTO {
    private int id;
    private String instrumento_nombre;
    private String usuario_nombre;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_devolucion;
    private String estado;

    public PrestamoNombresDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public String getInstrumento_nombre() {
        return instrumento_nombre;
    }

    public void setInstrumento_nombre(String instrumento_nombre) {
        this.instrumento_nombre = instrumento_nombre;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
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
        if (estado.equals("Pendiente") || estado.equals("Devuuuelto")){
            this.estado = estado;
        }else {
            this.estado = "Pendiente";
        }
    }
}
