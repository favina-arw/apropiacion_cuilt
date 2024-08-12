package org.me.estadistica;


import org.me.estadistica.entity.Tupla;
import org.me.estadistica.enums.Provincia;
import org.me.estadistica.enums.TipoDni;
import org.me.estadistica.utils.FileGrabber;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        Tupla tupla = new Tupla(
                TipoDni.DOCUMENTO_UNICO.getCodigoString(),
                "38080929",
                "Viña Federico",
                "masculino",
                "17/06/1994",
                "Calle Falsa",
                "666",
                "11",
                "C",
                "9103",
                "Rawson",
                Provincia.CHUBUT.getCodigoString());

        logger.info(tupla.toString()+ "-fin");
        logger.info(String.valueOf(tupla.toString().length()));
        */

        /* Pruebas de FileGrabber */

        FileGrabber fileGrabber = new FileGrabber("C:/Users/Admin/Estadistica_2024/archivos para procesar");

        List<String> archivos = fileGrabber.seleccionarArchivos();

        for(String s : archivos){
            System.out.println(s);
        }

    }
}