package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Entity
@Table(name = "grado")
public class Grado implements Serializable {
    @Id
    private int grado_id;
    private String grado;
    private int activo;

    public Grado() {

    }

    public Grado(int grado_id, String grado, int activo) {
        this.grado_id = grado_id;
        this.grado = grado;
        this.activo = activo;
    }

    public int getGrado_id() {
        return grado_id;
    }

    public void setGrado_id(int grado_id) {
        this.grado_id = grado_id;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
