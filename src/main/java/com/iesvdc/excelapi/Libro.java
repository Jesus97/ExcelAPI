/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.excelapi;

import com.sun.rowset.internal.Row;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author Jesus
 */
public class Libro {
    private List<Hoja> hojas;
    private String nombreArchivo;

    public Libro() {
        this.hojas=new ArrayList<>();
        this.nombreArchivo = "nuevo.xlsx";
    }

    public Libro(String nombreArchivo) {
        this.hojas=new ArrayList<>();
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public boolean addHoja(Hoja hoja){
        return this.hojas.add(hoja);
    }
            
    public Hoja removeHoja(int index) throws ExcelAPIException{
        if(index<0 || index>this.hojas.size()){
            throw new ExcelAPIException("Libro::removeHoja(): Posicion no valida.");
        }
            return this.hojas.remove(index);
    }
            
    public Hoja indexHoja(int index)throws ExcelAPIException{
        if(index<0 || index>this.hojas.size()){
            throw new ExcelAPIException("Libro::removeHoja(): Posicion no valida.");
        }
            return this.hojas.get(index);
    }
    
    public void load(){
        
    }
    
    public void load(String filename){
        this.nombreArchivo= filename;
        this.load();
    }
    
    public void save() throws ExcelAPIException{
          SXSSFWorkbook wb = new SXSSFWorkbook();
        
        
    
        for (Hoja hoja: this.hojas){
            Sheet sh = wb.createSheet(hoja.getNombre());
            for (int i = 0; i < hoja.getFilas(); i++){
            Row row = sh.createRow(i);
            for (int j = 0; j < hoja.getColumnas(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(hoja.getDato(i, j));                
            }
        }
        }
        try (FileOutputStream out = new FileOutputStream("this.nombreArchivo")){
            wb.write(out);
            //out.close();                        
        } catch (IOException ex) {
            throw  new ExcelAPIException("Error al guardar el archivo");
        } finally {
            wb.dispose();
        }
    }
    
    
    public void save(String filename) throws ExcelAPIException{
        this.nombreArchivo= filename;
        this.save();
      
}
    protected void testExtension(){
        //if (nombreArchivo.charAt(7)= ".xlsx"){
        //    return nombreArchivo;
        //}else{    
        //}
    }
    
    
    
    
}
    
