package proyectoXML1;

import java.io.*;
import java.util.*;

import javax.xml.parsers.*;

import org.w3c.dom.*;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fichero="C:\\Users\\MariaChaparroCaballe\\eclipse-workspace\\EsquemaXml\\NewXMLSchema.xml";
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
		
		 leerXML(doc);
		 } catch (Exception e) {
		 e.printStackTrace();
		
		 }

	}
	
	
	public static void leerXML(Document doc) {
		//metodo para recorer el doc y MOSTRAR LOS DATOS DE CADA VIDEOJUEGO//
		
		String[] datos_nodo = null;//UN ARRAY DE ALMACENAJE POR VIDEOJUEGO//
		
		 String salida = "";//VARIABLE DONDE METEREMOS LOS DATOS DE TEXTO PARA IMPRESION//
		 
		 Node node;//variable temporal//
		 
		// Obtener el primer nodo (raíz) del DOM aka coleccion
		 Node raiz = doc.getFirstChild();
		// Obtener todos los nodos hijo del nodo raíz 
		 NodeList nodelist = raiz.getChildNodes();

		 /*Recorremos la lista de nodos hijos*/
		 for (int i = 0; i < nodelist.getLength(); i++) {
			 node = nodelist.item(i);//almacenamos el nodo individual en posicion i//
			 
			 if (node.getNodeType() == Node.ELEMENT_NODE) {//si el nodo es un elemento llama al metodo procesar_videojuego que es en ese metodo que accedemos al nodo texto de cada elemento//
				 datos_nodo = procesar_videojuego(node);
				 
				 //actualizamos salida para que nos escriba lo que hay en los nodos hijos aka elementos dentro de videojeugo//
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
		 //imprimimos//
		 System.out.println(salida);
		
	}


	private static String [] procesar_videojuego(Node n) {/*METODO PARA SACAR LOS DATOS DE CADA NODO TEXTO DENTRO DE CADA VIDEOJUEGO*/
		
	String[] datos =new String[7];//variable de almacenaje final//
		Node ntemp = null;//varaible temporal par almacenar nodos individuales//
		int contador=1;//contador de array//
		datos[0] =n.getAttributes().item(0).getNodeValue();//metemos el atributo al array//
		// Obtener los hijos del nodo <videojuego> (titulo,desarollador,plataforma,genero,clasificacion,año) 
		 NodeList nodos = n.getChildNodes();
		 for (int i = 0; i < nodos.getLength(); i++) {
			 ntemp = nodos.item(i);//obtenemos el nodo en posicion i dentro de la lista de nodos//
			 if (ntemp.getNodeType() == Node.ELEMENT_NODE) {
				 // Obtener el valor del nodo de tipo #text, lo almacenamos en datos y sumamos una a contador para que el siguiete elemento nos lo guardo en otra posicion//
				 datos[contador] =ntemp.getChildNodes().item(0).getNodeValue();
				 contador++;
			 }
		 }

		 //devolvemos el array//
		return datos;
	}
		
	public static void añadirVideojuego(Document doc, String titulo, String
			desarrollador, String plataforma, String genero, String anno, String
			clasificacion, String numCopias, String fichero) {
		
		try {
			
			 // Crear nodo <desarollador> 
			 Node nDesarrollador = doc.createElement("Desarrollador");
			 // Crear nodo de texto con el desarollador
			 Node nDesarrollador_text = doc.createTextNode(desarrollador);
			 // Añadir el texto como hijo del elemento <Desarrollador> 
			 nDesarrollador.appendChild(nDesarrollador_text);
			 /********************************************/
			 
			 //creacion nodo elemento//
			 Node nPlataforma = doc.createElement("Plataforma");
			//creacion nodo texto//
			 Node nPlataforma_text = doc.createTextNode(plataforma);
			 // Añadir el texto como hijo del elemento//
			 nPlataforma.appendChild(nPlataforma_text);
			 
			 
			 /************************/
			//creacion nodo elemento//
			 Node nGenero=doc.createElement("Género");
			//creacion nodo texto//
			 Node nGenero_text=doc.createTextNode(genero);
			 // Añadir el texto como hijo del elemento//
			 nGenero.appendChild(nGenero_text);
			 
			 /***********************************/
			//creacion nodo elemento//
			 Node nanno=doc.createElement("AñodeLanzamiento");
			//creacion nodo texto//
			 Node nanno_text=doc.createTextNode(anno);
			 // Añadir el texto como hijo del elemento//
			 nanno.appendChild(nanno_text);
			 
			 
			 /************************************/
			//creacion nodo elemento//
			 Node nclasificacion=doc.createElement("ClasificaciónPorEdades");
			//creacion nodo texto//
			 Node nclasificacion_text=doc.createTextNode(clasificacion);
			 // Añadir el texto como hijo del elemento//
			 nclasificacion.appendChild(nclasificacion_text);
			 
			 /***********************************/
			//creacion nodo elemento//
			 Node nnumCopias=doc.createElement("NumeroDeCopiasDisponibles");
			//creacion nodo texto//
			 Node nnumCopias_text=doc.createTextNode(numCopias);
			 // Añadir el texto como hijo del elemento//
			 nnumCopias.appendChild(nnumCopias_text);
			 /**************************************/
			 
			 // Crear nodo <videojuego> 
			 Node nVideojuego = doc.createElement("videojuego");
			 // Añadir el atributo titulo
			 ((Element) nVideojuego).setAttribute("El titulo es", titulo);
			 
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
			 
			 //llamamos al metodo que guarda la nueva rama del arbol dom en el archivo xml//
			 guardarXML(doc,fichero);
			 } catch (Exception e) {
			 e.printStackTrace();
			 
			 }
			}

		
		
	
	
	public static void guardarXML(Document doc, String archivo) {
		try {
		
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
	

