package org.me.estadistica.utils;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Getter @Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileGrabber {

    String pathToFiles;

    public Map<String,String> traerArchvos(){
        Map<String,String> mapa = new HashMap<String,String>();
        File carpeta = new File(this.pathToFiles);
        File[] listaArchivos = carpeta.listFiles();

        for (File archivo : listaArchivos){
            if(archivo.isFile())
                mapa.put(archivo.getName(), archivo.getAbsolutePath());
        }

        return mapa;
    }

}
