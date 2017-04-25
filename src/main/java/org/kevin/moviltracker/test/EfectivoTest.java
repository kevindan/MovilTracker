package org.kevin.moviltracker.test;

import org.kevin.moviltracker.entity.Efectivo;
import org.kevin.moviltracker.model.EfectivoService;

import java.util.List;

/**
 * Created by USUARIO on 6/04/2017.
 */
public class EfectivoTest {


    public static void Grabar() {

        Efectivo ef = new Efectivo();
        ef.setNombres("Pamfilo");
        ef.setApellidos("Tiburcio");
        ef.setEfectivo_cip("645365245");
        ef.setGrado_id(2);
        ef.setActivo(1);

        EfectivoService emodel = new EfectivoService();
        try {
            emodel.Grabar(ef);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    public static void actualizar() {

        Efectivo ef = new Efectivo();

        ef.setNombres("Pamfilomodif");
        ef.setApellidos("Tiburciomodif");
        ef.setEfectivo_cip("645365245modif");
        ef.setGrado_id(1);
        ef.setEfectivo_id(2);

        EfectivoService emodel = new EfectivoService();

        try {
            emodel.Modificar(ef);
        } catch (Throwable th) {
            th.printStackTrace();
        }

    }

    public static void Listar() {

        EfectivoService emodel = new EfectivoService();
        try {
            List<Efectivo> lista = emodel.Listar();
            for (Efectivo efe : lista) {
                System.out.println(efe.getNombres());
            }
        } catch (Throwable th) {
            th.printStackTrace();

        }

    }

    public static void Buscar() {
        Efectivo ef = new Efectivo();
        ef.setEfectivo_id(2);
        EfectivoService emodel = new EfectivoService();
        try {
            Efectivo efect = emodel.Buscar(ef);

            System.out.println(efect.getNombres() + " " + efect.getApellidos());


        } catch (Throwable th) {
            th.printStackTrace();

        }

    }

    public static void Eliminar() {
        Efectivo ef = new Efectivo();

        ef.setEfectivo_id(2);

        EfectivoService emodel = new EfectivoService();

        try {
            emodel.Eliminar(ef);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Buscar();

    }


}

