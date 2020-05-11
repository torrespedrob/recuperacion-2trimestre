package Ex16ptb4b;

public class Articulo {
  //Atributos
	private String art;
	private int cant;
	
	public Articulo(String art, int cant) {
		this.art = art;
		this.cant = cant;
	}
	
	public void addCant(int cant) {
		this.cant += cant;
	}

  //Getters
	public String getArt() {
		return art;
	}
	public int getCant() {
		return cant;
	}
	
  //Salida por pantalla
	@Override
	public String toString() {
		return String.format("%s, %d unid.", art, cant);
	}
}