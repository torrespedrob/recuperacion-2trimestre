package Ex16ptb4;

import java.util.Objects;

public class Articulo {
  // Atributos
  private String nombre;
  private int unidades;
  
  // Métodos
  public Articulo(String nombre, int unidades) {
    this.nombre = nombre;
    this.unidades = unidades;
  }

  //Getters y setters
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public int getUnidades() {
    return unidades;
  }
  public void setUnidades(int unidades) {
    this.unidades = unidades;
  }

  //Salida por pantalla
  @Override
  public String toString() {
    String resultado = this.nombre + ", " + this.unidades + " unid.\n";
    
    return resultado;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 43 * hash + Objects.hashCode(this.nombre);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Articulo other = (Articulo) obj;
    if (!Objects.equals(this.nombre, other.nombre)) {
      return false;
    }
    return true;
  }
  
}