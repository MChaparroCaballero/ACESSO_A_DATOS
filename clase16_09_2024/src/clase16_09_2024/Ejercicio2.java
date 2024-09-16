package clase16_09_2024;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner lector=new Scanner(System.in);
		int cantidadNumeros,numActual;
		int max = Integer.MIN_VALUE,min=Integer.MAX_VALUE,contadorMax=0,contadorMin=0;
		
		System.out.println("¿Cuantos numeros quieres introducir");
		cantidadNumeros=lector.nextInt();
		
		
		//validar que la cantidad de numeros sea positiva//
		if(cantidadNumeros<=0) {
			System.out.println("la cantidad debe ser mayor que cero");
		
		}else {
			for(int i=1;i<=cantidadNumeros;i++) {
				System.out.println("introduce el numero "+i+" de "+cantidadNumeros+": ");
				numActual=lector.nextInt();
				
				//nuevo max//
				if(numActual>max) {
					max=numActual;
					contadorMax=1;
				}else if(numActual==max){
					contadorMax++;
				}
				
				//nuevo min//
				if(numActual<min) {
					min=numActual;
				}
			}
		}
	}

}
