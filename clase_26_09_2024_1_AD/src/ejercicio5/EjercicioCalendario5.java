package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioCalendario5 {

	public static void main(String[] args) {

		// creamos un scanner y le pedimos el numero del mes y la inicial del dia del
		// primer dia de ese mes y las almacenamos en dos variables//
		Scanner lector = new Scanner(System.in);
		System.out.println("Introduzca el numero del mes del que quiere el calendario");
		int mes = lector.nextInt();
		lector.nextLine();
		System.out
				.println("introduzca el dia de la semana que cae el primer dia de ese mes (La inicial L,M,X,J,V,S,D)");
		String dia = lector.nextLine();

		escribirCalendario(mes, dia);
		lector.close();
	}

	public static void escribirCalendario(int mes, String dia) {

		// creamos un array de String de meses, es de 12 por que directamente
		// compararemos el numero de mes que nos pasa el usuario con el indice y nos
		// saltaremos la posicion 0//
		String meses[] = new String[12];

		// Mirando el calendario establezco manualmente la inicial que deberia mostrar
		// cada mes por su primer dia, el contenido de este array sera con lo que
		// comparemos lo que nos pasa el usuario asique no pasa nada que lo haga yo
		// manualmente//
		
			//String meses[]= {"X","S","S", "M","J","D","M", "V","L","X","S","L",};
		meses[1] = "X";
		meses[2] = "S";
		meses[3] = "S";
		meses[4] = "M";
		meses[5] = "J";
		meses[6] = "D";
		meses[1] = "M";
		meses[1] = "V";
		meses[1] = "L";
		meses[1] = "X";
		meses[1] = "S";
		meses[1] = "L";

		for (int i = 1; i <= meses.length; i++) {
			if (meses[mes].equalsIgnoreCase(dia)) {
				String ruta = "C:\\Users\\MariaChaparroCaballe\\Desktop\\proyectos archivos\\" + "mes" + mes + ".txt";
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

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
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
