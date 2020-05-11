package Ex16ptb4b;

import java.util.ArrayList;

public class Comercial extends Persona{
  //Crea el ArrayList donde se almacenan las ventas
	ArrayList<Articulo> ventas = new ArrayList<>();
	private String puesto;
	
	public Comercial(String nombre, String correo, String puesto) {
		super(nombre, correo);
		this.puesto = puesto;
	}
	
  //Calcula la cantidad de ventas
	public void addSale(Articulo art) {
		for (Articulo articulo : ventas) {
			if (articulo.getArt().equals(art.getArt())) {
				articulo.addCant(art.getCant());
				return;
			}
		}
		ventas.add(art);
	}
  
  //Getter y Setter
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
  //Salida por pantalla formateada
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
    //Si no ha vendido nada, no muestra las ventas
		if (ventas.size() == 0) {
			sb.append(String.format("Nombre: %s\nCorreo: %s\nCargo: %s\nTodavía no hay ventas\n", nombre, correo, puesto));
			return sb.toString();
		}
		sb.append(String.format("Nombre: %s\nCorreo: %s\nCargo: %s\nVentas "
				+ "realizadas\n=================\n", nombre, correo, puesto));
		for (Articulo articulo : ventas) {
			sb.append(articulo.toString()+"\n");
		}
		return sb.toString();
	}
	
}