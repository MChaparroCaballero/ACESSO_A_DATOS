package ejercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NumPositivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//INICIAMOS EL SCANNER PARA PEDIR EL TITULO DEL ARCHIVO//
			Scanner lector= new Scanner(System.in);
			System.out.println("Introduzca el nombre del archivo");
			
			//Concatenamos la ruta donde esta el archivo con el nombre introducido//
			
			String ruta="C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\"+lector.nextLine();
			int sumar=0;//variable a la que sumamos//
			
			Integer num = 0;//variable donde almacenamos cada caracter pasado a numero//
			
			String linea;//variable contenedora de cada linea del archivo//;
			try {
				FileReader fr = new FileReader(ruta);//hacedemos al fichero con los numeros//
				
				BufferedReader br= new BufferedReader(fr);//un buffer que hacemos unicamente para utilizar el readline y que nos facilite la vida//
				
				while((linea=br.readLine())!=null) {
					//linea la igualamos a la linea del buffer y luego este bucle seguira hasta que el buffer no encuentre más lineas en el archivo//
					
					num=num.parseInt(linea);//num almacena la version numerica de lo contenido en linea (osea el caracter escrito)//
					
					sumar=sumar+num;//sumar se va actualizando sumando loo que tenia + el caracter pasado a numero//
				}
				
				//salimos del bucle y imprimimos el resultado total de suma
				
					System.out.println(sumar);
					 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
