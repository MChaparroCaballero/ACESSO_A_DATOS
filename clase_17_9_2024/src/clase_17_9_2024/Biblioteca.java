package clase_17_9_2024;

import java.util.ArrayList;

public class Biblioteca {
	private ArrayList<Material> almacenaje;

	public Biblioteca() {
		this.almacenaje = new ArrayList<Material>();
	}

	public ArrayList<Material> getAlmacenaje() {
		return almacenaje;
	}

	public void setAlmacenaje(ArrayList<Material> almacenaje) {
		this.almacenaje = almacenaje;
	}

	public void agregarMaterial(Material e) {
		almacenaje.add(e);
		System.out.println("Material agregado con exito");
	}

	public void listarMaterial() {
		for (Material i : getAlmacenaje()) {
			System.out.println(i.mostrarInfo());
		}

	}

	public void BuscarMaterial(String titulo) throws MaterialNoEncontradoException {

		Boolean continuar = true;
		
		for(int i = 0; i < almacenaje.size() && continuar ; i++) {
			Material material = almacenaje.get(i);
			if (material.getTitulo().equalsIgnoreCase(titulo)) {
				System.out.println(material.mostrarInfo());
				continuar  = false;
			}
			
		} 
		
		if(continuar ){
			throw new MaterialNoEncontradoException("No se ha encontrado");
		}
		}
	}

