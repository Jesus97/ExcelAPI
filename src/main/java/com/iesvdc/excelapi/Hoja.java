package com.iesvdc.excelapi;

/**
 * Esta clase almacena información del texto de 
 * una hoja de cálculo.
 * 
 * @author Acceso a Datos
 */
public class Hoja {
    private String[][] datos;
    private String nombre;
    private int nFilas;
    private int nColumnas;

    /**
     * Crea una hoja de cálculo nueva
     */
    public Hoja() {
        this.datos = new String[5][5];
        this.nFilas=5;
        this.nColumnas=5;
        this.nombre = "";
        
    }
    
    /**
     * Crea una hoja nueva de tamaño nFilas por nColumnas
     * @param nFilas el número de filas
     * @param nColumnas el número de celdas que tiene cada fila
     */
    public Hoja(int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
        this.nombre="";
        this.nColumnas=nColumnas;
        this.nFilas=nFilas;
    } 
    
    public Hoja(String nombre, int nFilas, int nColumnas) {
        this.datos = new String[nFilas][nColumnas];
        this.nombre = nombre;
        this.nColumnas=nColumnas;
        this.nFilas=nFilas;
    }    


    public String getDato(int fila, int columna) {
        return datos[fila][columna];
    }

    public void setDato(String dato, int fila, int columna) {
        //excepcion si no accedemos a una posicion no valida
        this.datos[fila][columna] = dato;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        //excepcion si no accedemos a una posicion no valida
        this.nombre = nombre;
    }

    public int getnColumnas() {
        return nColumnas;
    }

    public void setnColumnas(int nColumnas) {
        this.nColumnas = nColumnas;
    }

    public int getnFilas() {
        return nFilas;
    }

    public void setnFilas(int nFilas) {
        this.nFilas = nFilas;
    }
    
    public boolean compare(Hoja hoja)  {
        boolean iguales = true;
       if (this.nColumnas==hoja.getnColumnas() 
               && this.nFilas==hoja.getnFilas() 
               && this.nombre.equals(hoja.getNombre())){
           for (int i = 0 ; i<this.nFilas ; i++){
               for (int j = 0 ; j<this.nColumnas ; j++){
                   if(!this.datos[i][j].equals(hoja.getDato(i, j))){
                       return false;
                   }
               }
           }
       }else{
           iguales= false;
       }
        return iguales;
        
    }
    
}
