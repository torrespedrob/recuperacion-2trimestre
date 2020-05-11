package Ex16ptb4b;

public class Persona {
  //Atributos
	protected String nombre;
	protected String correo;
	
	public Persona(String nombre, String correo) {
		this.nombre = nombre;
		this.correo = correo;
	}

  //Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public String getCorreo() {
		return correo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
}