package clase_17_9_2024;

public abstract class Material {
private String titulo;
private int año_publicacion;

public Material(String titulo, int año_publicacion) throws AñoInvalidoException {
	
	this.titulo = titulo;
	if(año_publicacion<0) {
		throw new AñoInvalidoException("año no valido");
		
	}else {
		this.año_publicacion = año_publicacion;
	}
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public int getAño_publicacion() {
	return año_publicacion;
}

public void setAño_publicacion(int año_publicacion) {
	
	this.año_publicacion=año_publicacion;
	
}

public abstract String mostrarInfo();
}
