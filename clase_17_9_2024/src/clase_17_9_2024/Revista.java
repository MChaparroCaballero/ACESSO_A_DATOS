package clase_17_9_2024;

public class Revista extends Material {
	private int numero;

	public Revista(String titulo, int año_publicacion, int numero)
			throws AñoInvalidoException, NumeroInvalidoException {
		super(titulo, año_publicacion);
		if (numero < 0) {
			throw new NumeroInvalidoException("Numero de revista invalido");
		} else {
			this.numero = numero;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;

	}

	@Override
	public String mostrarInfo() {
		String info = "La revista se llama " + this.getTitulo() + " se publico en el año " + this.getAño_publicacion()
				+ " su numero de revista es " + this.getNumero();
		return info;

	}

}
