package proyectoXML1;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fichero = "C:\\Users\\MariaChaparroCaballe\\eclipse-workspace\\EsquemaXml\\NewXMLSchema.xml";
		Document doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			// Ignorar los espacios en blanco
			factory.setIgnoringElementContentWhitespace(true);
			// Crear un objeto DocumentBuilder
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Interpretar (parsear) el XML y generar el DOM equivalente
			doc = builder.parse(fichero);
			// Ahora doc apunta al árbol DOM listo para ser recorrido

			
			/*Creamos el scanner para que el usuario meta su opcion*/
			Scanner sc = new Scanner(System.in);
			
			
			
			int i = 0;//variable de manejo de bucle//

			while (i != 4) {
				/*mostramos las opciones*/
				System.out.println("\n1.Ver Videojuegos." + "\n2.Añadir un videojuego a la colleción."
						+ "\n3.Buscar un videojuego." + "\n4.Salir.");
				/*guardamos la opcion del usuario*/
				int opcion = sc.nextInt();
				switch (opcion) {
				/*dependiendo de la opcion o leer el archivo, guarda un nuevo videojeugo, busca o sale del meno*/
				case 1:
					leerXML(doc);
					break;
				case 2:
					/*le pedimos los datos*/
					
					sc.nextLine();//paraa borrar datos residuos//
					
					/*pedimos los datos necesarios*/
					System.out.println("Introduzca el titulo del videojuego");
					String titulo = sc.nextLine();
					System.out.println("Introduzca el desarrollador del videojuego");
					String desarrollador = sc.nextLine();
					System.out.println("Introduzca la plataforma del videojuego");
					String plataforma = sc.nextLine();
					System.out.println("Introduzca el género del videojuego");
					String genero = sc.nextLine();
					System.out.println("Introduzca el año de lanzamiento del videojuego");
					String anno = sc.nextLine();
					System.out.println("Introduzca la clasificación por edades del videojuego");
					String clasificacion = sc.nextLine();
					System.out.println("Introduzca el numero de copias disponibles del videojuego");
					String numCopias = sc.nextLine();
					String archivo = "C:\\Users\\MariaChaparroCaballe\\eclipse-workspace\\EsquemaXml\\NewXMLSchema.xml";
					
					/*llamamos al metodo*/
					añadirVideojuego(doc, titulo, desarrollador, plataforma, genero, anno, clasificacion, numCopias,
							archivo);
					System.out.println("videojuego creado con exito");
					break;
				case 3:
					String consulta;
					System.out.println(" \nQue consulta quieres hacer?"+"\n1.Mostrar todos los titulos"+"\n2.Mostar videojuegos posteriores a un año especifico"+"\n3Mostrar todos los videojuegos creados por un desarrollador en especifico"+"\n4. Mostrar todos los videoejugos creados posterior a 2015");
					
					int opt2= sc.nextInt();
					switch(opt2) {
					case 1:
						consulta="/ColeccionVideojuegos/videojuego/@Titulo";
						realizarConsultaXPath(fichero, consulta);
						break;
					case 2:
						System.out.println("De que año de lanzamiento?");
						int year= sc.nextInt();
						consulta="/ColeccionVideojuegos/videojuego[AñodeLanzamiento>"+year+"]";
						realizarConsultaXPath(fichero, consulta);
					break;
					case 3://g//
						sc.nextLine();
						System.out.println(" De que desarrollador?");
						String name= sc.nextLine();
						consulta="/ColeccionVideojuegos/videojuego[Desarrollador='"+name+"']";
						realizarConsultaXPath(fichero, consulta);
						break;
					case 4:
						consulta="/ColeccionVideojuegos/videojuego[AñodeLanzamiento>2015]";
						realizarConsultaXPath(fichero, consulta);
						break;
					}
					
					break;

				case 4:
					
					System.out.println("Adios");//mensaje de salida//
					
					i = 4;//para cerrar el bucle//
					sc.close();//cerramos scanner//
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void leerXML(Document doc) {
		// metodo para recorer el doc y MOSTRAR LOS DATOS DE CADA VIDEOJUEGO//

		String[] datos_nodo = null;// UN ARRAY DE ALMACENAJE POR VIDEOJUEGO//

		String salida = "";// VARIABLE DONDE METEREMOS LOS DATOS DE TEXTO PARA IMPRESION//

		Node node;// variable temporal//

		// Obtener el primer nodo (raíz) del DOM aka coleccion
		Node raiz = doc.getFirstChild();
		// Obtener todos los nodos hijo del nodo raíz
		NodeList nodelist = raiz.getChildNodes();

		/* Recorremos la lista de nodos hijos */
		for (int i = 0; i < nodelist.getLength(); i++) {
			node = nodelist.item(i);// almacenamos el nodo individual en posicion i//

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				/* si el nodo es un elemento llama al metodo
				procesar_videojuego que es en ese metodo que accedemos al
				nodo texto de cada elemento*/
				datos_nodo = procesar_videojuego(node);

				// actualizamos salida para que nos escriba lo que hay en los nodos hijos aka
				// elementos dentro de videojeugo//
				
				salida += "\n El titulo es: " + datos_nodo[0];
				salida += "\n El desarrollador es: " + datos_nodo[1];
				salida += "\n La plataforma es: " + datos_nodo[2];
				salida += "\n El genero es: " + datos_nodo[3];
				salida += "\n El año de lanzamiento es: " + datos_nodo[4];
				salida += "\n La clasificacion por edades es: " + datos_nodo[5];
				salida += "\n El Numero de copias disponibles es: " + datos_nodo[6];
				salida += "\n --------------------";

			}

		}
		// imprimimos//
		System.out.println(salida);

	}

	private static String[] procesar_videojuego(
			Node n) {/* METODO PARA SACAR LOS DATOS DE CADA NODO TEXTO DENTRO DE CADA VIDEOJUEGO */

		String[] datos = new String[7];// variable de almacenaje final//
		
		Node ntemp = null;// varaible temporal par almacenar nodos individuales//
		
		int contador = 1;// contador de array//
		
		datos[0] = n.getAttributes().item(0).getNodeValue();// metemos el atributo al array//
		
		// Obtener los hijos del nodo <videojuego>
		// (titulo,desarollador,plataforma,genero,clasificacion,año)
		NodeList nodos = n.getChildNodes();
		
		for (int i = 0; i < nodos.getLength(); i++) {
			ntemp = nodos.item(i);// obtenemos el nodo en posicion i dentro de la lista de nodos//
			if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
				
				
				// Obtener el valor del nodo de tipo #text, lo almacenamos en datos y sumamos
				// una a contador para que el siguiete elemento nos lo guardo en otra posicion//
				datos[contador] = ntemp.getChildNodes().item(0).getNodeValue();
				contador++;
			}
		}

		// devolvemos el array//
		return datos;
	}

	public static void añadirVideojuego(Document doc, String titulo, String desarrollador, String plataforma,
			String genero, String anno, String clasificacion, String numCopias, String fichero) {

		try {

			// Crear nodo <desarollador>
			Node nDesarrollador = doc.createElement("Desarrollador");
			// Crear nodo de texto con el desarollador
			Node nDesarrollador_text = doc.createTextNode(desarrollador);
			// Añadir el texto como hijo del elemento <Desarrollador>
			nDesarrollador.appendChild(nDesarrollador_text);
			/********************************************/

			// creacion nodo elemento//
			Node nPlataforma = doc.createElement("Plataforma");
			// creacion nodo texto//
			Node nPlataforma_text = doc.createTextNode(plataforma);
			// Añadir el texto como hijo del elemento//
			nPlataforma.appendChild(nPlataforma_text);

			/************************/
			// creacion nodo elemento//
			Node nGenero = doc.createElement("Género");
			// creacion nodo texto//
			Node nGenero_text = doc.createTextNode(genero);
			// Añadir el texto como hijo del elemento//
			nGenero.appendChild(nGenero_text);

			/***********************************/
			// creacion nodo elemento//
			Node nanno = doc.createElement("AñodeLanzamiento");
			// creacion nodo texto//
			Node nanno_text = doc.createTextNode(anno);
			// Añadir el texto como hijo del elemento//
			nanno.appendChild(nanno_text);

			/************************************/
			// creacion nodo elemento//
			Node nclasificacion = doc.createElement("ClasificaciónPorEdades");
			// creacion nodo texto//
			Node nclasificacion_text = doc.createTextNode(clasificacion);
			// Añadir el texto como hijo del elemento//
			nclasificacion.appendChild(nclasificacion_text);

			/***********************************/
			// creacion nodo elemento//
			Node nnumCopias = doc.createElement("NumeroDeCopiasDisponibles");
			// creacion nodo texto//
			Node nnumCopias_text = doc.createTextNode(numCopias);
			// Añadir el texto como hijo del elemento//
			nnumCopias.appendChild(nnumCopias_text);
			/**************************************/

			// Crear nodo <videojuego>
			Node nVideojuego = doc.createElement("videojuego");
			// Añadir el atributo titulo
			((Element) nVideojuego).setAttribute("Titulo", titulo);

			// Añadir los nodos elementos al nodo <videojuego>
			nVideojuego.appendChild(nDesarrollador);
			nVideojuego.appendChild(nPlataforma);
			nVideojuego.appendChild(nGenero);
			nVideojuego.appendChild(nanno);
			nVideojuego.appendChild(nclasificacion);
			nVideojuego.appendChild(nnumCopias);

			// Añadir el nodo <videojuego> al nodo raíz del documento
			Node raiz = doc.getChildNodes().item(0);
			raiz.appendChild(nVideojuego);

			// llamamos al metodo que guarda la nueva rama del arbol dom en el archivo xml//
			guardarXML(doc, fichero);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void guardarXML(Document doc, String archivo) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();/*
			 * a instancia de TransformerFactory, que es la clase que se encarga de crear
			 * objetos transfer*/
			
			Transformer transformer = transformerFactory.newTransformer();/*
			* crea un objeto Transformer, que se encargará de transformar el contenido de
			* un DOMSource en un archivo*/
			
			DOMSource source = new DOMSource(doc);// fuente de datos del arbol dom//
			
			StreamResult result = new StreamResult(new File(archivo));/* ruta de en que archivo vamos a meter el guardado*/
			
			transformer.transform(source, result);// guardamos lo nuevo del arbol dom en el archivo de guardado xml//
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public static void realizarConsultaXPath(String doc1, String 
			consulta) throws ParserConfigurationException {
		try {
			// Crea una instancia de DocumentBuilderFactory
			 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 factory.setIgnoringComments(true);
			 factory.setIgnoringElementContentWhitespace(true);
			 // Crea un DocumentBuilder para analizar (parsear) el archivo XML
			 DocumentBuilder builder = factory.newDocumentBuilder();
			 // Carga el archivo XML en un objeto Document
			 Document doc2 = builder.parse(new File(doc1));
			 // Crea una instancia de XPathFactory
			 XPathFactory xpathFactory = XPathFactory.newInstance();
			 XPath xpath = xpathFactory.newXPath();
			 // Define la consulta XPath (en este caso, selecciona todos los elementos Autor)
			 String xpathExpression = consulta;
			 // Compila la consulta XPath
			 XPathExpression expr = xpath.compile(xpathExpression);
			 // Ejecuta la consulta XPath y obtiene el resultado como un NodeList
			 NodeList nodeList = (NodeList) expr.evaluate(doc2, XPathConstants.NODESET);
			 // Recorre el NodeList y muestra el resultado
			 for (int i = 0; i < nodeList.getLength(); i++) {
			 System.out.println(nodeList.item(i).getTextContent());
			 }
			 } catch (Exception e) {
			 e.printStackTrace();
			 }
			
		

	}
}
