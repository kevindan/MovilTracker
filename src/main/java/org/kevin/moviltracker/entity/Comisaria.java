package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Entity
@Table(name = "comisaria")
public class Comisaria implements Serializable {
    @Id
    private int comisaria_id;
    private String comisaria;
    private int activo;

    public Comisaria() {

    }

    public Comisaria(int comisaria_id, String comisaria, int activo) {
        this.comisaria_id = comisaria_id;
        this.comisaria = comisaria;
        this.activo = activo;
    }

    public int getComisaria_id() {
        return comisaria_id;
    }

    public void setComisaria_id(int comisaria_id) {
        this.comisaria_id = comisaria_id;
    }

    public String getComisaria() {
        return comisaria;
    }

    public void setComisaria(String comisaria) {
        this.comisaria = comisaria;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
