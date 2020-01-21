/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obtenciondatosfichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author uNKoLL
 */
public class ObtencionDatosFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 1. Leer un fichero y obtener los datos para meterlos en un array/vector
        // 2. Se pide el numero "n" y este mostrará el contenido de este
        //INICIALIZAMOS EL FICHERO mifichero.txt , para ello, si no existe CREAMOS EL FICHERO.
        //NOS OBLIGA A UTILIZAR UNA SENTENCIA TRY CATCH POR SI ESTE FALLA
        File f = new File("mifichero.txt");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                //Logger.getLogger(EjercicioFicheroC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error creando fichero");
            }
        }
        Scanner leerFichero = null;
        String []vNombres = new String[5];
        try {
            leerFichero = new Scanner(f);
            while(leerFichero.hasNext()){
                vNombres = leerFichero.nextLine().split(",");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error lectura fichero");
            //Logger.getLogger(EjercicioFicheroC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < vNombres.length; i++) {
            System.out.println(i+". "+vNombres[i]);
        }
        System.out.println("=========================================");
        System.out.println("Dime que numero quieres (del 0 al 2)");
        System.out.println("=========================================");
        Scanner leer = new Scanner(System.in);
        int numero = leer.nextInt();
        System.out.println(vNombres[numero]);
    }
    
}
