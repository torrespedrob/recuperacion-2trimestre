package Ex16ptb4;

public class Comercial extends Persona {
  // Atributos
  private String cargo;
  
  
  // Métodos
  public Comercial(String nombre, String email, String cargo) {
    super(nombre, email);
    this.cargo = cargo;
  }

  //Getter y Setter
  public String getCargo() {
    return cargo;
  }
  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  //Salida formateada por pantallas
  @Override
  public String toString() {
    String resultado = "\nNombre: " + super.getNombre() +
                       "\nCorreo electronico: " + super.getEmail() +
                       "\nCargo: " + this.cargo +
                       "\nVentas realizadas" +
                       "\n=================\n";
    
    for (Articulo articulo : super.getVenta()) {
      resultado += articulo;
    }
            
    
    return resultado;
  }
  
}
