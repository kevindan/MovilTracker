package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {
    @Id
    private int vehiculo_id;
    private String nro_placa;
    private int marca_id;
    private String anio_fabricacion;
    private int activo;

    public Vehiculo() {
    }

    public Vehiculo(int vehiculo_id, String nro_placa, int marca_id, String anio_fabricacion, int activo) {
        this.vehiculo_id = vehiculo_id;
        this.nro_placa = nro_placa;
        this.marca_id = marca_id;
        this.anio_fabricacion = anio_fabricacion;
        this.activo = activo;
    }

    public int getVehiculo_id() {
        return vehiculo_id;
    }

    public void setVehiculo_id(int vehiculo_id) {
        this.vehiculo_id = vehiculo_id;
    }

    public String getNro_placa() {
        return nro_placa;
    }

    public void setNro_placa(String nro_placa) {
        this.nro_placa = nro_placa;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int marca_id) {
        this.marca_id = marca_id;
    }

    public String getAnio_fabricacion() {
        return anio_fabricacion;
    }

    public void setAnio_fabricacion(String anio_fabricacion) {
        this.anio_fabricacion = anio_fabricacion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
