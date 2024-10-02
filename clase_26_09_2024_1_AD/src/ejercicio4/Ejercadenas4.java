package ejercicio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercadenas4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// creamos un nuevo scanner llamado lector (si yo todos mis scanners primerizos
		// siempre les llamo lector)
		Scanner lector = new Scanner(System.in);

		// le pedimos el nombre del archivo y lo almacenamos en un String con uso de
		// scanner//
		System.out.print("Introduzca el nombre del archivo");
		String nombre = lector.nextLine();

		// llamamos al metodo leer y le pasamos por parametro el nombre del archivo//
		leer(nombre);

		// cerramos el scanner//
		lector.close();
	}

	public static void leer(String nombre) throws IOException {
		String row;// creamos una nueva variable que es unicamente para el manejo de lineas del
					// archivo//

		// En un nuevo string llamado ruta ponemos la parte de la ruta que ya sabiamos y
		// la concatenamos con el nombre del archivo que hemos pasado por parametro y la
		// terminacion.txt//
		String ruta = "C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\" + nombre + ".txt";

		// abrimos try catch porque de por si nos lo pide para el manejo de archivos y
		// asi poder imprimir todo el historial de errores//
		
		try {
			
			/* creamos un nuevo bufferreader que accede a el archivo mediante un filereader de la ruta que habiamos concatenado antes*/
			BufferedReader BR = new BufferedReader(new FileReader(ruta));
			
			/*
			 * abrimos bucle y nos va a meter la linea del buffer osea la linea del archivo
			 * en row y si esta no esta vacia aka no es null nos imprime row osea la linea
			 * pero mediante el metodo replace remplazamos el asterisco por un espacio en
			 * blanco en la lectura de la consola para que no lo imprima
			 */
			
			while ((row = BR.readLine()) != null) {
				System.out.println(row.replace("*", " "));
			}
			
			//una vez que salga del bucle nos cerrara el bufferreader//
			BR.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
