/*@author Pedro Torres Barba*/
package Ex16ptb4b;

import java.util.Scanner;
import java.io.PrintStream;

public class Ex16ptb4b {
  public Ex16ptb4b(Scanner s, PrintStream salida) {
    this.s = s;
    this.salida = salida;
  }
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    //Lanzamos la función que empieza el programa
		Ex16ptb4b menu = new Ex16ptb4b(s, System.out);
		menu.empezar();
  }
  //Atributos privados
  private ListadoComerciales listaComercial = new ListadoComerciales();
  private ListadoClientes listaCliente = new ListadoClientes();
  private Scanner s;
  private PrintStream salida;

  // Guarda datos de ejemplo
  private void precarga() {
    listaCliente.put(new Usuario("Pepe", "pepe@gmail.com", "700-600-600"));
    listaCliente.put(new Usuario("Pedro", "pedro@gmail.com", "600-600-600"));
    listaComercial.put(new Comercial("Paco", "paco@outlook.com", "Comercial de cristales"));
    listaComercial.put(new Comercial("Juan", "juan@outlook.com", "Comercial de gasolineras"));
    listaComercial.put(new Comercial("Fran", "fran@hotmail.es", "Comertial de telefonía"));
  }

  // Menú principal del programa
  public void ordenes() {
    System.out.println("Bienvenido a JavApp");
    System.out.println("═════════════════");
    System.out.println("📓 Lista");
    System.out.println("➕ Nuevo");
    System.out.println("➖ Eliminar");
    System.out.println("✏ Editar");
    System.out.println("💲 Comprar");
    System.out.println("🏃 Salir");
  }

  // scanLine separa los comandos, similar a Linux
  private String[] scan(String prompt) {
    return scanLine(prompt).split(" ");
  }

  // Lee la línea completa y la convierte a minúsculas
  private String scanLine(String prompt) {
    System.out.print(prompt);
    return s.nextLine();
  }

  // Comprueba que las órdenes tengan los comandos necesarios
  private boolean comprobarOrdenes(String[] orden) {
    if (orden.length < 2) {
      return false;
    }
    return orden[1].toLowerCase().equals("cm") || orden[1].toLowerCase().equals("cl");
  }

  // Alta
  private void alta(String[] orden) {
    if (!comprobarOrdenes(orden)) {
      System.out.println("Tienes que especificar comercial[cm] o cliente[cl]");
      return;
    }
    if (orden[1].equals("cm")) {
      altaComercial(orden);
    } else {
      altaCliente(orden);
    }
  }

  // Procede con el alta del cliente
  private void altaCliente(String[] orden) {
    if (orden.length == 2) {
      // Modo interactivo
      String nombreCliente = scanLine("Nombre del cliente: ");
      String correoCliente = scanLine("Correo del cliente: ");
      String tlfCliente = scanLine("Teléfono del cliente: ");
      listaCliente.put(new Usuario(nombreCliente, correoCliente, tlfCliente));
      System.out.println("\nCliente grabado con éxito");
    }
  }

  // Procede con el alta del comercial
  private void altaComercial(String[] orden) {
    if (orden.length == 2) {
      // Modo interactivo
      String nombreComercial = scanLine("Nombre del comercial: ");
      String correoComercial = scanLine("Correo del comercial: ");
      String puestoComercial = scanLine("Puesto del comercial: ");
      listaComercial.put(new Comercial(nombreComercial, correoComercial, puestoComercial));
      System.out.println("\nComercial grabado con éxito");
    }
  }

  // Comprueba la orden de listar
  private void listar(String[] orden) {
    if (!comprobarOrdenes(orden)) {
      System.out.println("Tienes que especificar comercial[cm] o cliente[cl]");
      return;
    }
    if (orden[1].equals("cm")) {
      listarComercial(orden);
    } else {
      listarCliente(orden);
    }
  }

  // Lista a los clientes
  private void listarCliente(String[] orden) {
    for (String correo : listaCliente.correos()) {
      System.out.println(listaCliente.get(correo));
    }

  }

  // Lista a los comerciales
  private void listarComercial(String[] orden) {
    for (String correo : listaComercial.correos()) {
      System.out.println(listaComercial.get(correo));
    }
  }

  // Comprueba la orden de borrar
  private void borrar(String[] orden) {
    if (!comprobarOrdenes(orden)) {
      System.out.println("Tienes que especificar comercial[cm] o cliente[cl]");
      return;
    }
    if (orden[1].equals("cm")) {
      borrarComercial(orden);
    } else {
      borrarCliente(orden);
    }
  }

  // Borra el cliente
  private void borrarCliente(String[] orden) {
    if (orden.length == 2) {

      String correoCliente = scanLine("Correo del cliente: ");
      listaCliente.del(correoCliente);
      System.out.println("Cliente eliminado correctamente");
    }
  }

  // Borra el comercial
  private void borrarComercial(String[] orden) {
    if (orden.length == 2) {

      String correoComercial = scanLine("Correo del comercial: ");
      listaComercial.del(correoComercial);
      System.out.println("Comercial eliminado correctamente");
    }
  }

  // Comprueba la orden de Editar
  private void editar(String[] orden) {
    if (!comprobarOrdenes(orden)) {
      System.out.println("Tienes que especificar comercial[cm] o cliente[cl]");
      return;
    }
    if (orden[1].equals("cm")) {
      editarComercial(orden);
    } else {
      editarCliente(orden);
    }
  }

  // Edita un cliente
  private void editarCliente(String[] orden) {
    //Comprueba que exista el cliente
    if (orden.length == 2) {
      String correoCliente = scanLine("Correo del cliente: ");
      Usuario usuario = listaCliente.get(correoCliente);
      if (usuario == null) {
        System.out.println("No existe ese cliente");
        return;
      }
      String nombreCampo = scanLine("¿Qué editar?[nombre, telefono, correo]: ");
      String valorCampo = scanLine("Nuevo valor del campo: ");
 
      switch (nombreCampo.toLowerCase()) {
        case "nombre":
          usuario.setNombre(valorCampo);
          break;
        case "telefono":
          usuario.setTelf(valorCampo);
          break;
        case "correo":
          usuario.setCorreo(valorCampo);
          listaCliente.del(correoCliente);
          listaCliente.put(usuario);
          break;
        default:
          break;
      }
    }

  }

  // Edita un comercial
  private void editarComercial(String[] orden) {
    //Comprueba que exista el comercial
    if (orden.length == 2) {
      String correoComercial = scanLine("Correo del comercial: ");
      Comercial comercial = listaComercial.get(correoComercial);
      if (comercial == null) {
        System.out.println("No existe ese comercial");
        return;
      }
      String nombreCampo = scanLine("Nombre del campo a editar: ");
      String valorCampo = scanLine("Nuevo valor del campo: ");
      
      switch (nombreCampo.toLowerCase()) {
        case "nombre":
          comercial.setNombre(valorCampo);
          break;
        case "cargo":
          comercial.setPuesto(valorCampo);
          break;
        case "correo":
          comercial.setCorreo(valorCampo);
          listaComercial.del(correoComercial);
          listaComercial.put(comercial);
          break;
        default:
          break;
      }
    }
  }

  // Esta función se encarga del apartado de compras
  private void compra(String[] orden) {
    if (orden.length < 1) {
      return;
    }
    if (orden.length == 1) {
      String correoComercial = scanLine("Introduce el correo del comercial: ");
      if (listaComercial.get(correoComercial) == null) {
        System.out.println("No existe ese comercial");
        return;
      }
      String nombreProducto = scanLine("Introduce el nombre del producto: ");
      String cantidad = scanLine("Introduce la cantidad a comprar: ");
      int cantidadProducto = Integer.parseInt(cantidad);
      Articulo art = new Articulo(nombreProducto, cantidadProducto);
      Comercial comercial = listaComercial.get(correoComercial);
      comercial.addSale(art);
      System.out.println("Compra realizada con éxito");
      // Se puede realizar la compra con una sola línea
    } else if (orden.length == 4) {
      int cantidad = Integer.parseInt(orden[3]);
      Articulo art = new Articulo(orden[2].replaceAll("_", " "), cantidad);
      Comercial comercial = listaComercial.get(orden[1]);
      comercial.addSale(art);
      System.out.println("Compra realizada con éxito");
    }

  }

  // Programa principal
  public void empezar() {
    // Ejecuta la función de datos y la de comandos
    precarga();
    ordenes();
    while (true) {
      System.out.println("Escribe cm o cl después de una orden excepto comprar");
      String[] orden = scan("Orden: ");
      switch (orden[0].toLowerCase()) {
        case "lista":
          listar(orden);
          break;
        case "nuevo":
          alta(orden);
          break;
        case "eliminar":
          borrar(orden);
          break;
        case "editar":
          editar(orden);
          break;
        case "comprar":
          compra(orden);
          break;
        case "ordenes":
          ordenes();
          break;
        case "salir":
          return;

        default:
          System.out.println("Error al escribir la orden\n");
          ordenes();
      }
    }
  }

}
