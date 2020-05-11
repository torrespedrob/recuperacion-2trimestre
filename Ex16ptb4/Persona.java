package Ex16ptb4;

import java.util.ArrayList;

public abstract class Persona {
  //Atributos
  private String nombre;
  private String email;
  private ArrayList<Articulo> venta = new ArrayList<>();
  
  // Métodos
  public Persona(String nombre, String email) {
    this.nombre = nombre;
    this.email = email;
  }

  //Getters y setters
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public ArrayList<Articulo> getVenta() {
    return venta;
  }
  
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

  @Override
  public String toString() {
    String resultado = "\nNombre: " + this.nombre +
                       "\nCorreo electronico: " + this.email +
                       "\nVentas realizadas" +
                       "\n=================\n";
    
    for (Articulo articulo : venta) {
      resultado += articulo;
    }
            
    
    return resultado;
  }
  
}