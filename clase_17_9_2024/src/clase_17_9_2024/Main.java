package clase_17_9_2024;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Scanner lector = new Scanner(System.in);// instanciamos el escanner global//
	private static Biblioteca nueva = new Biblioteca();// hacemos nuevo obejto global de la biblio para no tener que
														// pasarlo al menu como parametros//

	public static void main(String[] args)
			throws MaterialNoEncontradoException, ISBN_NO_ACEPTADO, AñoInvalidoException, NumeroInvalidoException {

		// añadimos unos cuantos objetos, como el arraylist es de materiales los hacemos
		// objetos de materiales pero usamos polimorfimos para que se les traten como
		// las diferentes hijas clase//

		Material uno = new Libro("Harry Potter", 1920, "J.K Rowling", "20PSCL");
		Material dos = new Revista("El corazón", 2024, 20);
		Material tres = new DVD("En busca del valle encantado", 1990, "steven spilver");
		Material cuatro = new Libro("Percy jackson", 2011, "manolo galan", "123CP6");

		// las añadimos a el araylist previamente creado que recuerda que ese arralist
		// es el valor del getter de biblioteca.//

		nueva.agregarMaterial(uno);
		nueva.agregarMaterial(dos);
		nueva.agregarMaterial(tres);
		nueva.agregarMaterial(cuatro);
		menuGeneral();
	}

	public static void menuGeneral() throws AñoInvalidoException, ISBN_NO_ACEPTADO, NumeroInvalidoException {
		int opcion;
		// una variable donde almacenamos la opcion del usuario//

		do {
			System.out.println("\n1.Agregar un titulo al almacen" + "\n2.Listar almacen"
					+ "\n3.Buscar un titulo del almacen" + "\n4.salir del menu");
			opcion = lector.nextInt();
			switch (opcion) {
			case 1:

				menuAgregar();

				break;

			case 2:
				nueva.listarMaterial();
				break;

			case 3:
				System.out.println("Teclé el titulo del material a buscar");
				lector.nextLine();
				String nombre = lector.nextLine();
				try {
					nueva.BuscarMaterial(nombre);
				} catch (MaterialNoEncontradoException me) {
					System.out.println(me.getMessage());
				}
				break;

			case 4:
				System.out.println("Adios gracias por usar nuestra app");
				break;
			}
		} while (opcion != 4);
		lector.close();
	}

	public static void menuAgregar() throws ISBN_NO_ACEPTADO, AñoInvalidoException, NumeroInvalidoException {
		System.out.println("\n1.Agregar un libro" + "\n2.Agregar una revista" + "\n3.Agregar un DVD");
		int optMaterial = lector.nextInt();
		switch (optMaterial) {
		case 1:

			System.out.println("Teclé el titulo del libro");
			lector.nextLine();// para que no nos junte un system.out con el otro sino que espere a que el
								// usuario responda y luego salte el siguiente//
			String t = lector.nextLine();
			System.out.println("Teclé el año de publicacion del libro");
			int f = lector.nextInt();
			lector.nextLine();
			System.out.println("Teclé el autor del libro");
			String a = lector.nextLine();
			System.out.println("Teclé el isbn del libro");
			String s = lector.nextLine();
			Material l = new Libro(t, f, a, s);
			nueva.agregarMaterial(l);
			break;

		case 2:
			System.out.println("Teclé el titulo de la revista");
			lector.nextLine();
			String ti = lector.nextLine();
			System.out.println("Teclé el año de publicacion de la revista");
			int fe = lector.nextInt();
			lector.nextLine();
			System.out.println("Teclé el numero de la revista");
			int n = lector.nextInt();
			Material p = new Revista(ti, fe, n);
			nueva.agregarMaterial(p);
			break;

		case 3:
			System.out.println("Teclé el titulo del DVD");
			lector.nextLine();
			String tiT = lector.nextLine();
			System.out.println("Teclé el año de publicacion del DVD");
			int feC = lector.nextInt();
			lector.nextLine();
			System.out.println("Teclé el director del DVD");
			String d = lector.nextLine();
			Material o = new DVD(tiT, feC, d);
			nueva.agregarMaterial(o);
			break;

		}

	}

}
