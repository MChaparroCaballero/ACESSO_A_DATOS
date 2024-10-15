package proyectoXML1;

import javax.xml.parsers.*;

import org.w3c.dom.Document;

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
		
		 } catch (Exception e) {
		 e.printStackTrace();
		
		 }

	}
	
}
