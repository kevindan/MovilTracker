package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kevin on 16/04/17.
 */
@Entity
@Table(name = "asignacion")
public class Asignacion implements Serializable {
    @Id
    private int asignacion_id;
    private int efectivo_id;
    private int vehiculo_id;
    private int comisaria_id;
    private int zona_id;
    private String fecha_asignacion;
    private int activo;

    public Asignacion(){

    }

    public Asignacion(int asignacion_id, int efectivo_id, int vehiculo_id, int comisaria_id, int zona_id, String fecha_asignacion, int activo) {
        this.asignacion_id = asignacion_id;
        this.efectivo_id = efectivo_id;
        this.vehiculo_id = vehiculo_id;
        this.comisaria_id = comisaria_id;
        this.zona_id = zona_id;
        this.fecha_asignacion = fecha_asignacion;
        this.activo = activo;
    }

    public int getAsignacion_id() {
        return asignacion_id;
    }

    public void setAsignacion_id(int asignacion_id) {
        this.asignacion_id = asignacion_id;
    }

    public int getEfectivo_id() {
        return efectivo_id;
    }

    public void setEfectivo_id(int efectivo_id) {
        this.efectivo_id = efectivo_id;
    }

    public int getVehiculo_id() {
        return vehiculo_id;
    }

    public void setVehiculo_id(int vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public int getComisaria_id() {
        return comisaria_id;
    }

    public void setComisaria_id(int comisaria_id) {
        this.comisaria_id = comisaria_id;
    }

    public int getZona_id() {
        return zona_id;
    }

    public void setZona_id(int zona_id) {
        this.zona_id = zona_id;
    }

    public String getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(String fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
