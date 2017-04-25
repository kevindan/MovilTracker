package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Entity
@Table(name = "marca")
public class Marca implements Serializable {
    @Id
    private int marca_id;
    private String marca;
    private int activo;

    public Marca() {
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int grado_id) {
        this.marca_id = marca_id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String grado) {
        this.marca = grado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
