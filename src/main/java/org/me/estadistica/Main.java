package org.me.estadistica;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.me.estadistica.entity.Alumno;
import org.me.estadistica.enums.Provincia;
import org.me.estadistica.enums.TipoDni;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String rutaAlArchivo = "D:/Descargas/Reporte_Alumnos_20240819013629_795.xls";
        try {

            POIFSFileSystem fs = new POIFSFileSystem(new File(rutaAlArchivo));
            HSSFWorkbook libro = new HSSFWorkbook(fs.getRoot(),true);
            Sheet hoja = libro.getSheetAt(0);

            Row filaDatosEscuela = hoja.getRow(1);
            Row cabeceras = hoja.getRow(2);
            Row data = hoja.getRow(3);

            String datosEscuela = hoja.getRow(1).getCell(0).getStringCellValue();
            //String cabeceraUno = hoja.getRow(2).getCell(0).getStringCellValue();
            //String datoUno = hoja.getRow(3).getCell(0).getStringCellValue();

            Alumno alumno = new Alumno();

            for (int i = 3 ; i <= hoja.getLastRowNum() ;i++){
                Row fila = hoja.getRow(i);

                //Celda 0 -> nombre y apellido
                alumno.setApellidoNombre(fila.getCell(0).getStringCellValue().replace(",", ""));

                //Celda 1 -> DNI + numero
                if (StringUtils.left(fila.getCell(1).getStringCellValue(),3) == "DNI" ||
                        StringUtils.left(fila.getCell(1).getStringCellValue(),3).equals("DNI")){
                    alumno.setTipoDocumento(TipoDni.DOCUMENTO_UNICO.getCodigoString());
                }else if(fila.getCell(1).getStringCellValue() == "No posee" ||
                        fila.getCell(1).getStringCellValue().equals("No posee")){
                    alumno.setTipoDocumento("NO");
                }else{
                    alumno.setTipoDocumento(fila.getCell(1).getStringCellValue().substring(0,fila.getCell(1).getStringCellValue().length() - 8));
                }

                alumno.setNumeroDocumento(StringUtils.right(fila.getCell(1).getStringCellValue(), 8));

                //Celda 2 -> Fecha nacimiento
                alumno.setFechaNacimiento(fila.getCell(2).getStringCellValue());

                //Celda 3 -> Sexo
                alumno.setSexo(fila.getCell(3).getStringCellValue());

                //Celda 4 -> Año
                alumno.setAnio(fila.getCell(4).getStringCellValue());
                //Celda 5 -> Sección
                alumno.setSeccion(fila.getCell(5).getStringCellValue());

                //Celda 6 -> titulación
                alumno.setTitulacion(fila.getCell(6).getStringCellValue());

                //Celda 7 -> VACIO!
                //Celda 8 -> Estado
                alumno.setEstado(fila.getCell(8).getStringCellValue());

                //Se rellena el resto de datos del alumno
                alumno.setCodigoProvincia(Provincia.CHUBUT.getCodigoString());

                alumno.setCalle("");
                alumno.setNumero("");
                alumno.setPiso("");
                alumno.setDepto("");
                alumno.setCodigoPostal("");
                alumno.setLocalidad("");
                alumno.setEscuelaCueAnexo(StringUtils.left(datosEscuela,9));

                System.out.println(alumno.toString().length() +" - "+ alumno);


            }

            System.out.println(alumno.getEscuelaCueAnexo());

            /*---- CERRDADO DE ARCHIVO ----*/
            fs.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}