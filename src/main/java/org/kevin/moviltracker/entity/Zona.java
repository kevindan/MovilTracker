package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Entity
@Table(name = "zona")
public class Zona implements Serializable {
    @Id
    private int zona_id;
    private String zona;
    private int activo;

    public Zona() {
    }

    public Zona(int zona_id, String zona, int activo) {
        this.zona_id = zona_id;
        this.zona = zona;
        this.activo = activo;
    }

    public int getZona_id() {
        return zona_id;
    }

    public void setZona_id(int zona_id) {
        this.zona_id = zona_id;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
