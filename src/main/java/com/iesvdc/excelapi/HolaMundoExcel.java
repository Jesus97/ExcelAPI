package com.iesvdc.excelapi;

import com.sun.rowset.internal.Row;
import java.io.FileOutputStream;
import java.io.IOException;
import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
public class HolaMundoExcel {

    /**
     * @param args the command line arguments
     */
    
    /**
     * Metodo
     * @param args 
     */
    
    public static void main(String[] args) {
        
        SXSSFWorkbook wb = new SXSSFWorkbook();
        
        Sheet sh = wb.createSheet("HOLA MUNDO");
        
        for (int i = 0; i < 10; i++) {
            Row row = sh.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue((char)('A'+j)+" "+(i+1));                
            }
        }
        
        try {
            FileOutputStream out = new FileOutputStream("this.nombreArchivo");
            wb.write(out);
            out.close();                        
        } catch (IOException ex) {
            // Logger.getLogger(HolaMundoExcel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR al crear el archivo: "+
                    ex.getLocalizedMessage());
        } finally {
            wb.dispose();
        }
         
    }
    
}