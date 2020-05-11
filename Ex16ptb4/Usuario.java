package Ex16ptb4;

public class Usuario extends Persona implements Cliente {
  // Atributos
  private String tel;
  
  // Métodos
  public Usuario(String nombre, String email, String tel) {
    super(nombre, email);
    this.tel = tel;
  }
  
}