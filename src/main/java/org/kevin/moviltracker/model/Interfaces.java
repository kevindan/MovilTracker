package org.kevin.moviltracker.model;

import java.util.List;

/**
 * Created by USUARIO on 3/04/2017.
 */
public interface Interfaces<T> {

    public abstract void Grabar(T o) throws Exception;

    public abstract void Modificar(T o) throws Exception;

    public abstract void Eliminar(T o) throws Exception;

    public abstract List<T> Listar() throws Exception;

    public abstract List<T> Filtrar(T o) throws Exception;

    public abstract T Buscar(T o) throws Exception;
}
