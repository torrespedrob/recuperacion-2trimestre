package Ex16ptb4;

public class Empresa implements Cliente {
  // Atributos
  private String CIF;
  private String nombre;
  private String tel;
  
  // Métodos
  public Empresa(String CIF, String nombre, String tel) {
    this.CIF = CIF;
    this.nombre = nombre;
    this.tel = tel;
  }
  
  //Calcula la compra
  @Override
  public void compra(Persona p1, Articulo a1) {
    if (p1.getVenta().contains(a1)) {
      int unidadesNuevas = a1.getUnidades();
      int posicion = p1.getVenta().indexOf(a1);
      int unidadesAntiguas = p1.getVenta().get(posicion).getUnidades();
      int unidadesActualizadas = unidadesAntiguas + unidadesNuevas;
      p1.getVenta().get(posicion).setUnidades(unidadesActualizadas);
    } else {
      p1.getVenta().add(a1);
    }
  }
  
  
  
}