package org.kevin.moviltracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by USUARIO on 6/04/2017.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    private int usuario_id;
    private int efectivo_id;
    private String efectivo_cip;
    private String contrasena;
    private int activo;

    public Usuario() {
    }

    public Usuario(int usuario_id, int efectivo_id, String efectivo_cip, String contrasena, int activo) {
        this.usuario_id = usuario_id;
        this.efectivo_id = efectivo_id;
        this.efectivo_cip = efectivo_cip;
        this.contrasena = contrasena;
        this.activo = activo;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
