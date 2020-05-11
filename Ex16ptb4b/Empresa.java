package Ex16ptb4b;

public class Empresa implements Cliente {
  //Atributos
	private String cif;
	private String nombre;
	private String telf;
  //Funcion de compra
	@Override
	public void compra(Comercial comerc, Articulo art) {
		comerc.addSale(art);
	}
}
