package org.me.estadistica;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.me.estadistica.entity.Tupla;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        String rutaAlArchivo = "C:/Users/Admin/Downloads/Reporte_Alumnos_20240814104723_795.xls";
        try {

            POIFSFileSystem fs = new POIFSFileSystem(new File(rutaAlArchivo));
            HSSFWorkbook libro = new HSSFWorkbook(fs.getRoot(),true);
            Sheet hoja = libro.getSheetAt(0);

            Row filaDatosEscuela = hoja.getRow(1);
            Row cabeceras = hoja.getRow(2);
            Row data = hoja.getRow(3);

            String datosEscuela = hoja.getRow(1).getCell(0).getStringCellValue();
            String cabeceraUno = hoja.getRow(2).getCell(0).getStringCellValue();
            String datoUno = hoja.getRow(3).getCell(0).getStringCellValue();

            String[] usefulData = new String[]{};

            for (int i = 3 ; i <= hoja.getLastRowNum() ;i++){
                Row fila = hoja.getRow(i);
                for (int j = 0; j <= fila.getLastCellNum(); j++){
                    Cell celda = fila.getCell(j);

                    switch (celda.getColumnIndex()){
                        case 0:
                            usefulData[0] = celda.getStringCellValue().replace(",","");
                            break;
                        case 1:
                            usefulData[1] = celda.getStringCellValue();
                            break;
                    }
                }

            }



            /*---- CERRDADO DE ARCHIVO ----*/
            fs.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}