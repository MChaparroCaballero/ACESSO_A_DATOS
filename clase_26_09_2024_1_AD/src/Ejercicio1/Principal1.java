package Ejercicio1;

import java.io.*;

public class Principal1 {

	public static void main(String[] args) {
		FileWriter wr = null;
		try {
			wr = new FileWriter("C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\numNaturales.txt");
			for(int i=1;i<=100;i++) {
				wr.write("'"+i+"'");
				
			}
			System.out.println("Se ha escrito con exito");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
