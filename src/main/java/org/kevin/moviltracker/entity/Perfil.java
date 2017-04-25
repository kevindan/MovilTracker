package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by kevin on 16/04/17.
 */
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {
@Id
    private int efectivo_id;
    private String nombres;
    private String apellidos;
    private String grado;
    private String comisaria;
    private String zona;
    private String marca;
    private String nro_placa;

    public Perfil() {
    }

    public Perfil(int efectivo_id, String nombres, String apellidos, String grado, String comisaria, String zona, String marca, String nro_placa) {
        this.efectivo_id = efectivo_id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.grado = grado;
        this.comisaria = comisaria;
        this.zona = zona;
        this.marca = marca;
        this.nro_placa = nro_placa;
    }

    public int getEfectivo_id() {
        return efectivo_id;
    }

    public void setEfectivo_id(int efectivo_id) {
        this.efectivo_id = efectivo_id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getComisaria() {
        return comisaria;
    }

    public void setComisaria(String comisaria) {
        this.comisaria = comisaria;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNro_placa() {
        return nro_placa;
    }

    public void setNro_placa(String nro_placa) {
        this.nro_placa = nro_placa;
    }
}
