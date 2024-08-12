package org.me.estadistica;


import org.me.estadistica.entity.Tupla;
import org.me.estadistica.enums.Provincia;
import org.me.estadistica.enums.TipoDni;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(Main.class.getName());
        
        Tupla tupla = new Tupla(TipoDni.DOCUMENTO_UNICO.getCodigoString(),
                "38080929", "Viña Federico",
                "masculino", "17/06/1994", "Calle Falsa",
                "666", "11", "C", "9103",
                "Rawson", Provincia.CHUBUT.getCodigoString());

        logger.info(tupla.toString()+ "-fin");
        logger.info(String.valueOf(tupla.toString().length()));
    }
}