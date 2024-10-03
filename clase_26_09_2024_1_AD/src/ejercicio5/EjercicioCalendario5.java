package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class EjercicioCalendario5 {

	public static void main(String[] args) throws Exceptionmes {

		// creamos un scanner y le pedimos el numero del mes y la inicial del dia del
		// primer dia de ese mes y las almacenamos en dos variables//
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduzca el numero del mes del que quiere el calendario");
		int mes = lector.nextInt();
		lector.nextLine();
		System.out.println("introduzca el dia de la semana que cae el primer dia de ese mes (La inicial L,M,X,J,V,S,D)");
		String dia = lector.nextLine();

		/*llamamos al metodo escribirCalendario y le pasamos el mes alamcenado del usuario y el dia*/
		escribirCalendario(mes, dia);
		
		/*cerramos el scanner*/
		lector.close();
	}

	public static void escribirCalendario(int mes, String dia) throws Exceptionmes {

		/*
		 * creamos un array de String de meses, es de 13 por que directamente //
		 * compararemos el numero de mes que nos pasa el usuario con el indice y nos //
		 * saltaremos la posicion 0
		 */
		String meses[] = new String[13];

		/*
		 * Mirando el calendario establezco manualmente la inicial que deberia mostrar
		 * cada mes por su primer dia, el contenido de este array sera con lo que
		 * comparemos lo que nos pasa el usuario asique no pasa nada que lo haga yo
		 * manualmente
		 */

		meses[1] = "X";
		meses[2] = "S";
		meses[3] = "S";
		meses[4] = "M";
		meses[5] = "J";
		meses[6] = "D";
		meses[7] = "M";
		meses[8] = "V";
		meses[9] = "L";
		meses[10] = "X";
		meses[11] = "S";
		meses[12] = "L";

		/*
		 * Hacemos un if para comprobar si el més que ha metido es valido ose del 1 al
		 * 12, si no lo es salta la excepcion
		 */
		
		
		if (mes < 1 || mes > 12) {
			throw new Exceptionmes("Mes no aceptado tiene que ser entre 1 y 12");
		}

		// abrimos otro if, que solo pasa a este si el mes es valido//

		if (meses[mes].equalsIgnoreCase(dia)) {

			/*
			 * En un string concatenamos la ruta que ya sabiamos con la palabra mes, el mes
			 * numerico que nos ha pasado y la terminacion.txt
			 */
			String ruta = "C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\" + "mes" + mes + ".txt";

			/*
			 * abrimos un try catch donde creamos un bufferwriter con un filewriter, ya que
			 * vamos a escribir caracteres, y como destino le ponemos un filwriter con la
			 * ruta de su destino, para acceder al archivo creado
			 */
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

				/*
				 * Abrimos un switch y comparamos el parametro de mes valido introducido por el
				 * usuario y dependiendo de que mes es hace un calendario diferente
				 */
				
	
				switch (mes) {

				case 1:
					bw.write("1X2J3V4S5D6L7M8X9J10V11S12D13L14M15X16J17V18S19D20L21M22X23J24V25S26D27L28M29X30J31V");

					break;

				case 2:
					bw.write("1S2D3L4M5X6J7V8S9D10L11M12X13J14V15S16D17L18M19X20J21V22S23D24L25M26X27J28V");

					break;
				case 3:
					bw.write("1S2D3L4M5X6J7V8S9D10L11M12X13J14V15S16D17L18M19X20J21V22S23D24L25M26X27J28V29S30D31L");

					break;
				case 4:
					bw.write("1M2X3J4V5S6D7L8M9X10J11V12S13D14L15M16X17J18V19S20D21L22M23X24J25V26S27D28L29M30X");

					break;
				case 5:
					bw.write("1J2V3S4D5L6M7X8J9V10S11D12L13M14X15J16V17S18D19L20M21X22J23V24S25D26L27M28X29J30V31S");

					break;
				case 6:
					bw.write("1D2L3M4X5J6V7S8D9L10M11X12J13V14S15D16L17M18X19J20V21S22D23L24M25X26J27V28S29D30L");

					break;
				case 7:
					bw.write("1M2X3J4V5S6D7L8M9X10J11V12S13D14L15M16X17J18V19S20D21L22M23X24J25V26S27D28L29M30X31J");

					break;
				case 8:
					bw.write("1V2S3D4L5M6X7J8V9S10D11L12M13X14J15V16S17D18L19M20X21J22V23S24D25L26M27X28J29V30S31D");

					break;
				case 9:
					bw.write("1L2M3X4J5V6S7D8L9M10X11J12V13S14D15L16M17X18J19V20S21D22L23M24X25J26V27S28D29L30M");

					break;
				case 10:
					bw.write("1X2J3V4S5D6L7M8X9J10V11S12D13L14M15X16J17V18S19D20L21M22X23J24V25S26D27L28M29X30J31V");

					break;
				case 11:
					bw.write("1S2D3L4M5X6J7V8S9D10L11M12X13J14V15S16D17L18M19X20J21V22S23D24L25M26X27J28V29S30D");

					break;
				case 12:
					bw.write("1L2M3X4J5V6S7D8L9M10X11J12V13S14D15L16M17X18J19V20S21D22L23M24X25J26V27S28D29L30M31X");

					break;

				}
				/* cerramos el buffered writer y filewriter */
				bw.close();

			} catch (IOException e) {
				// imprimimos todo el historial de errores//
				e.printStackTrace();
			}

			/*
			 * cerramos el try catch y imprimimos un mensaje de exito para que el usuario
			 * sepa que se ha escrito el calendario
			 */
			System.out.println("Més escrito con exito");
			}else {
				
				/*En caso de que no empiece el mes por el dia que han puesto muestra este mensaje*/
			System.out.println("Ese més no empieza por ese día de la semana");
			
		}

	}
}
