package Ex16ptb3;

import java.util.Objects;

public class Producto implements Comparable<Producto> {
  private String codigo;
  private String nombre;
  private double precioDeCompra;
  private double precioDeVenta;
  private int stock;
  
  public Producto(String codigo) {
    this.codigo = codigo;
  }
  
  public Producto(String codigo, String nombre, double precioDeCompra, double precioDeVenta, int stock) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precioDeCompra = precioDeCompra;
    this.precioDeVenta = precioDeVenta;
    this.stock = stock;
  }
  
  // Getters y Setters
//Codigo
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
//Nombre
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
//PrecioDeCompra
  public double getPrecioDeCompra() {
    return precioDeCompra;
  }
  public void setPrecioDeCompra(double precioDeCompra) {
    this.precioDeCompra = precioDeCompra;
  }
//Precio de Venta
  public double getPrecioDeVenta() {
    return precioDeVenta;
  }
  public void setPrecioDeVenta(double precioDeVenta) {
    this.precioDeVenta = precioDeVenta;
  }
//Stock
  public int getStock() {
    return stock;
  }
  public void setStock(int stock) {
    this.stock = stock;
  }

  // Salida formateada de datos
  public String toString() {
    String cadena = "------------------------------------------";
    cadena += "\nCódigo: " + this.codigo;
    cadena += "\nNombre: " + this.nombre;
    cadena += "\nPrecio de compra: " + this.precioDeCompra;
    cadena += "\nPrecio de venta: " + this.precioDeVenta;
    cadena += "\nCantidad: " + this.stock + " unidades";
    cadena += "\n------------------------------------------";
    return cadena;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 73 * hash + Objects.hashCode(this.codigo);
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
    final Producto other = (Producto) obj;
    if (!Objects.equals(this.codigo, other.codigo)) {
      return false;
    }
    return true;
  }

  @Override
  public int compareTo(Producto t) {
    return (this.codigo).compareTo(t.codigo);
  }
}