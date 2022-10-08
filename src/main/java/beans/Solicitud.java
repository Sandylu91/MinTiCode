
package beans;

import java.sql.Date;

public class Solicitud {

private int id_usuario;
private int id_solicitud;
private int cod_servicio;
private Date fecha;
private int dias_ejecucion;
private int cod_estado;
private int id_proveedor;

    public Solicitud(int id_usuario, int id_solicitud, int cod_servicio, Date fecha, int dias_ejecucion, int cod_estado, int id_proveedor) {
        this.id_usuario = id_usuario;
        this.id_solicitud = id_solicitud;
        this.cod_servicio = cod_servicio;
        this.fecha = fecha;
        this.dias_ejecucion = dias_ejecucion;
        this.cod_estado = cod_estado;
        this.id_proveedor = id_proveedor;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public int getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(int cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDias_ejecucion() {
        return dias_ejecucion;
    }

    public void setDias_ejecucion(int dias_ejecucion) {
        this.dias_ejecucion = dias_ejecucion;
    }

    public int getCod_estado() {
        return cod_estado;
    }

    public void setCod_estado(int cod_estado) {
        this.cod_estado = cod_estado;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    @Override
    public String toString() {
        return "solicitud{" + "id_usuario=" + id_usuario + ", id_solicitud=" + id_solicitud + ", cod_servicio=" + cod_servicio + ", fecha=" + fecha + ", dias_ejecucion=" + dias_ejecucion + ", cod_estado=" + cod_estado + ", id_proveedor=" + id_proveedor + '}';
    }


}