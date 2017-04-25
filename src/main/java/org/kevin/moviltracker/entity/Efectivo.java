package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "efectivo")
public class Efectivo implements Serializable {
    @Id
    private int efectivo_id;
    private String efectivo_cip;
    private String nombres;
    private String apellidos;
    private int grado_id;
    private int activo;

    public Efectivo() {

    }

    public Efectivo(int efectivo_id, String efectivo_cip, String nombres, String apellidos, int grado_id, int activo) {
        this.efectivo_id = efectivo_id;
        this.efectivo_cip = efectivo_cip;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.grado_id = grado_id;
        this.activo = activo;
    }

    public int getEfectivo_id() {
        return efectivo_id;
    }

    public void setEfectivo_id(int efectivo_id) {
        this.efectivo_id = efectivo_id;
    }

    public String getEfectivo_cip() {
        return efectivo_cip;
    }

    public void setEfectivo_cip(String efectivo_cip) {
        this.efectivo_cip = efectivo_cip;
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

    public int getGrado_id() {
        return grado_id;
    }

    public void setGrado_id(int grado_id) {
        this.grado_id = grado_id;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
