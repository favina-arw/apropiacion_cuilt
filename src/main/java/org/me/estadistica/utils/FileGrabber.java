package org.me.estadistica.utils;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileGrabber {

    String pathToFiles;

    public Map<Integer,String> traerArchvos(){
        Map<Integer,String> mapa = new HashMap<Integer,String>();
        File carpeta = new File(this.pathToFiles);
        File[] listaArchivos = carpeta.listFiles();

        if(listaArchivos == null || listaArchivos.length == 0){
            System.err.println("Lista vacía. Corrija o agregue la dirección de los archivos.");
            return null;
        }

        int posicion = 1;

        for (File archivo : listaArchivos){
            if(archivo.isFile()){
                mapa.put(posicion, archivo.getAbsolutePath());
                posicion++;
            }
        }
        return mapa;
    }

    public void seleccionarArchivos(){
        boolean enSeleccion = true;
        Scanner entradaTeclado = new Scanner(System.in);


        while (enSeleccion){
            System.out.println("Elija un archivo para agregar a la lista del procesador.");
            System.out.println("Use el número 0 para terminar.");
            for (Map.Entry<Integer, String> entrada : this.traerArchvos().entrySet()){
                System.out.println(entrada.getKey() + " - " + entrada.getValue());
            }
            int seleccion = entradaTeclado.nextInt();

            if (seleccion == 0){
                enSeleccion = false;
            }else{

            }

        }
    }

}
