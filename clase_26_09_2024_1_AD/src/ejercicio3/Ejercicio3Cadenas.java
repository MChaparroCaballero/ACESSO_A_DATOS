package ejercicio3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//abrimos scanner y les pedimos la longitud del array//
		Scanner lector = new Scanner(System.in);
		System.out.println("Cuantos caracteres vas a meter");
		
		//almacenamos la longitud en la variable num y la metemos como parametro de la longitud a la hora de crear el array de string cadena donde almacenaremos los caracteres del usuario//
		int num = lector.nextInt();
		String cadena[] = new String[num];
		
		//limpiamos el scanner ya que lo ultimo introducio fue un numero y tendremos que usarlo con caracteres después//
		lector.nextLine();

		//en un for vamos a pedirle un caracter con el uso del scanner lector y guardarlo 1 por posición del array, no saldra hasta que este totalmente comentado//
		for (int i = 0; i < cadena.length; i++) {
			System.out.println("escriba el siguiente caracter");
			cadena[i] = lector.nextLine();
		}

		//le pedimos el nombre del archivo y en un string concatenamos lo que sabiamos de la ruta + el nombre del archivo diretamente con el uso de scanner + el formato .txt// 
		System.out.println("Introduzca el nombre del archivo");
		String ruta = "C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\" + lector.nextLine() + ".txt";
		
		//llamamos al metodo escribir y le pasamos la ubicacion del archivo y el array de caracteres//
		escribir(ruta, cadena);
		
		//cerramos el scanner//
		lector.close();

	}

	public static void escribir(String rut, String[] caracteres) {
		try {
			
			//para acceder al archivo creamos un file writer con la ruta pasada y lo metemos en un bufferwriter para evitar errores, que antes no me escribia sin ello no se porque//
			BufferedWriter BW= new BufferedWriter(new FileWriter(rut));
			
			//con un for recorremos el array y por cada posicion llamamos al buffer y escribimos el caracter en esa posicion del array y concatenamos con un asterisco//
			for (int i = 0; i < caracteres.length; i++) {
				BW.write(caracteres[i]+"*");
				
			}
			
			//imprimimos un mensaje de exito para saber que ha podido escribir bien en el archivo y que ha llegado a hacer todas sus funciones y cerramos el buffer//
			System.out.println("Mensaje escrito con exito");
			BW.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
