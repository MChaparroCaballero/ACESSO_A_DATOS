package clase_17_9_2024;

public class DVD extends Material {
	private String director;

	public DVD(String titulo, int año_publicacion, String director) throws AñoInvalidoException {
		super(titulo, año_publicacion);
		this.director = director;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String mostrarInfo() {
		String info = "El DVD se llama " + this.getTitulo() + " se publico en el año " + this.getAño_publicacion()
				+ " su director es " + this.getDirector();
		return info;

	}

}
