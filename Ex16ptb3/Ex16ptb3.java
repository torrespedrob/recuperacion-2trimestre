package Ex16ptb3;

//Incluimos los imports necesarios para el programa
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex16ptb3 {
  public static void main(String[] args) throws InterruptedException {
    Scanner s = new Scanner(System.in);

    //Creamos variables necesarias para el programa
    int seleccion;
    int indice;
    String inputCodigo;
    String inputNombre;
    double inputCompraPrecio;
    String inputCompraPrecioString;
    double inputVentaPrecio;
    String inputVentaPrecioString;
    int inputStock;
    String inputStockString;
    boolean checkCodigo;

    //Crea el array con productos de ejemplo
    ArrayList<Producto> producto = new ArrayList<>();
    producto.add(new Producto("A", "Álbum de fotos", 3, 10, 25));
    producto.add(new Producto("T1", "Tablet Samsung Galaxy", 190, 280, 30));
    producto.add(new Producto("T2", "Tablet Sony Xperia", 160, 250, 20));
    producto.add(new Producto("SD", "Tarjeta de memoria SD 128GB", 10, 20, 60));
    
    // Menú principal del programa
    do {
      System.out.println("\n\nBienvenido a GESTISIMAL");
      System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━");
      System.out.println("1. Listar productos");
      System.out.println("2. Alta");
      System.out.println("3. Baja");
      System.out.println("4. Modificación");
      System.out.println("5. Llegada de existencias");
      System.out.println("6. Venta de existencias");
      System.out.println("7. Listado de productos bajos de stock");
      System.out.println("8. Salir");
      System.out.print("Seleccione una opción: ");
      seleccion = Integer.parseInt(s.nextLine());

      // Programa
      switch (seleccion) {
        // Listado
        case 1:
          System.out.println("\nListado de productos");
          System.out.println("====================");
          
          // Creamos variables necesarias
          int numeroProductos = 0;
          double precioDeCompraTotal = 0;
          double precioDeVentaTotal = 0;
          Collections.sort(producto);
          
          // Calculamos los precios de los productos del mismo tipo
          for (Producto producto1 : producto) {
            System.out.println(producto1);
            numeroProductos++;
            precioDeCompraTotal += producto1.getPrecioDeCompra();
            precioDeVentaTotal += producto1.getPrecioDeVenta();
          }
          
          // Calculamos la media de los precios y el margen de beneficio
          double precioDeCompraMedio = precioDeCompraTotal / numeroProductos;
          double precioDeVentaMedio = precioDeVentaTotal / numeroProductos;
          double margenBeneficioMedio = precioDeVentaMedio - precioDeCompraMedio;
          
          // Mostramos por pantalla las medias y el margen al final
          System.out.println("\nArtículos totales: " + numeroProductos);
          System.out.println("Precio de compra medio: " + String.format("%.2f", precioDeCompraMedio));
          System.out.println("Precio de venta medio: " + String.format("%.2f", precioDeVentaMedio));
          System.out.println("Margen de beneficio medio: " + String.format("%.2f", margenBeneficioMedio));
          break;

        // Alta
        case 2:
          System.out.println("\nNuevo Producto");
          System.out.println("═════════════");

          // Introduce un código
          System.out.println("Introduce los datos del producto.");
          System.out.print("Código: ");
          inputCodigo = s.nextLine();
          // Comprueba que el código introducido no se repita
          while (producto.contains(new Producto(inputCodigo))) {
            System.out.println("Error, ese código ya está registrado.");
            System.out.print("Introduzca otro código: ");
            inputCodigo = s.nextLine();
          }

          // Introduce los datos
          System.out.print("Nombre: ");
          inputNombre = s.nextLine();
          System.out.print("Precio de compra: ");
          inputCompraPrecio = Double.parseDouble(s.nextLine());
          System.out.print("Precio de venta: ");
          inputVentaPrecio = Double.parseDouble(s.nextLine());
          System.out.print("Cantidad: ");
          inputStock = Integer.parseInt(s.nextLine());

          // Graba el producto en el ArrayList
          producto.add(new Producto(inputCodigo, inputNombre, inputCompraPrecio, inputVentaPrecio, inputStock));
          System.out.println("Producto agregado con éxito");
          break;

        // Baja
        case 3:
          System.out.println("\nEliminar un producto");
          System.out.println("══════════════════");

          //Introduce un código
          System.out.print("Introduce el código del producto que desea dar de baja: ");
          inputCodigo = s.nextLine();
          //Comprueba si existe realmente
          if (!producto.contains(new Producto(inputCodigo))) {
            System.out.println("Error, ese código no existe");
          } else { // Si existe, procede a eliminarlo
            producto.remove(new Producto(inputCodigo));
            System.out.println("Producto eliminado con éxito");
          }
          break;

        // Modificación
        case 4:
          System.out.println("\nModifica un producto");
          System.out.println("═════════════════");

          // Introduce un código
          System.out.print("Introduce el código del producto a editar: ");
          inputCodigo = s.nextLine();
          // Comprueba si existe
          if (!producto.contains(new Producto(inputCodigo))) {
            System.out.println("Error, el código introducido no existe.");
          } else {
            // Localiza el producto
            indice = producto.indexOf(new Producto(inputCodigo));
            System.out.println("Escribe nuevos datos o pulsa Intro para dejarlos tal cual");
            
            System.out.println("Código: " + producto.get(indice).getCodigo());
            System.out.print("Nuevo código: ");
            inputCodigo = s.nextLine();
            if (!inputCodigo.equals("")) {
              producto.get(indice).setCodigo(inputCodigo);
            }

            System.out.println("Nombre: " + producto.get(indice).getNombre());
            System.out.print("Nuevo Nombre: ");
            inputNombre = s.nextLine();
            if (!inputNombre.equals("")) {
              producto.get(indice).setNombre(inputNombre);
            }

            System.out.println("Precio de compra: " + producto.get(indice).getPrecioDeCompra());
            System.out.print("Nuevo precio de compra: ");
            inputCompraPrecioString = s.nextLine();
            if (!inputCompraPrecioString.equals("")) {
              producto.get(indice).setPrecioDeCompra(Double.parseDouble(inputCompraPrecioString));
            }
            
            System.out.println("Precio de venta: " + producto.get(indice).getPrecioDeVenta());
            System.out.print("Nuevo precio de venta: ");
            inputVentaPrecioString = s.nextLine();
            if (!inputVentaPrecioString.equals("")) {
              producto.get(indice).setPrecioDeVenta(Double.parseDouble(inputVentaPrecioString));
            }
            
            System.out.println("Cantidad: " + producto.get(indice).getStock());
            System.out.print("Nueva cantidad: ");
            inputStockString = s.nextLine();
            if (!inputStockString.equals("")) {
              producto.get(indice).setStock(Integer.parseInt(inputStockString));
            }
            System.out.println("Producto modificado con éxito");
          }
          break;

        // Llegada de existencias
        case 5:
          System.out.println("\nLlegada de Existencias");
          System.out.println("======================");

          // Selecciona y localiza el producto
          System.out.print("Introduce el código del producto: ");
          inputCodigo = s.nextLine();
          indice = producto.indexOf(new Producto(inputCodigo));

          // Comprueba el código
          if (!producto.contains(new Producto(inputCodigo))) {
            System.out.println("Error, el código introducido no existe.");
          } else { // Procede
            System.out.println("Entrada de mercancía del siguiente producto: ");
            System.out.println(producto.get(indice));
            System.out.print("¿Cuántas unidades entran?: ");
            inputStockString = s.nextLine();
            producto.get(indice).setStock(Integer.parseInt(inputStockString) + producto.get(indice).getStock());
            System.out.println("Las existencias se han incluido con éxito.");
          }
          break;

        // Venta de mercancía
        case 6:
          System.out.println("\nVenta de Existencias");
          System.out.println("====================");

          //Introduce el código del producto
          System.out.print("Introduce el código del producto: ");
          inputCodigo = s.nextLine();
          indice = producto.indexOf(new Producto(inputCodigo));

          //Comprueba que el producto existe
          if (!producto.contains(new Producto(inputCodigo))) {
            System.out.println("Error, el código introducido no existe.");
          } else { //Procede
            System.out.println("Vender el producto: ");
            System.out.println(producto.get(indice));
            System.out.print("Introduce el número de unidades que deseas vender: ");
            inputStock = Integer.parseInt(s.nextLine());
            //Se asegura de que haya stock suficiente para vender
            if (producto.get(indice).getStock() - inputStock > 0) {
              producto.get(indice).setStock(producto.get(indice).getStock() - inputStock);
              System.out.println("La venta se ha realizado.");
              System.out.print("Generando factura");
              //Genera la factura de la venta, con efecto de retardo
              Thread.sleep(520); System.out.print(".");Thread.sleep(520); System.out.print(".");Thread.sleep(520); System.out.print(".");Thread.sleep(520); System.out.print(".");
              double precioSinIva = (producto.get(indice).getPrecioDeVenta()) * inputStock;
              double iva = ((producto.get(indice).getPrecioDeVenta()) * (inputStock)) * 0.21;
              System.out.println("\n\nFactura de Venta");
              System.out.println("================");
              System.out.println("Código del Producto: " + inputCodigo);
              System.out.println("Precio: " + String.format("%.2f", producto.get(indice).getPrecioDeVenta()) + "€");
              System.out.println("Cantidad: " + inputStock);
              System.out.println("Precio sin IVA: " + String.format("%.2f", precioSinIva) + "€");
              System.out.println("IVA: " + String.format("%.2f", iva) + "€");
              System.out.println("----------------------");
              System.out.println("Precio Final: " + String.format("%.2f", (precioSinIva + iva)) + "€");
              System.out.println("Gracias por su confianza");
            } else {
              System.out.println("Error, no se pueden vender tantas unidades.");
            }
          }
          break;
        
        // Listar productos según stock
        case 7:
          // Filtra por stock
          //Si introduce 20, aparecen los productos con stock <= a 20
          System.out.print("Introduce el stock máximo: ");
          int stockMaximo = Integer.parseInt(s.nextLine());
          System.out.println("Listado por stock");
          System.out.println("=================");
          
          //Comprueba cada producto y si cumple la condición de stock lo muestra
          for (Producto producto1 : producto) {
            if (producto1.getStock() <= stockMaximo) {
              System.out.println(producto1);
            }
          }
          break;
          
      }
    } while (seleccion != 8); // Termina el programa
  }
}
