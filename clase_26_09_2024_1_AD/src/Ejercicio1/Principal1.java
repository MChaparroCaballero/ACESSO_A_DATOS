package Ejercicio1;

import java.io.*;

public class Principal1 {

	public static void main(String[] args) {
		
		// escribimos en un string la ruta del fichero donde escribiremos//
		
		String destino = "C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\numNaturales.txt";
		
		// con un try catch instanciamos un nuevo bufferedWriter para que nos pase linea
		// a linea lo escrito en el filewriter y el filewrite escribe caracteres en el
		// destino//
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
			
			// hacemos un for para escribir de 1 a 100//
			
			for (int i = 1; i <= 100; i++) {
				
				// llamamos al buffer que tiene como destino el archivo y escribimos el caracter
				// y salto de linea//
				
				bw.write(i + "\n");
			}

			// mensaje fuera del for para que nos envie un mensaje de exite una vez de
			// terminanr de escribir todos los numeros y garantizarnos que ha ido bien//
			
			System.out.println("Se ha escrito con exito");
		} catch (IOException e) {

			// en caso de que salte una excepcion que nos muestre todo el stack de
			// excepciones
			
			e.printStackTrace();
		}
	}

}
