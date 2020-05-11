package recuperacion;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Ex16ptb1 {
  public static void main(String[] args) {
    //Creamos el Scanner y el HashMap que vamos a usar
    Scanner s = new Scanner(System.in);
    HashMap<String, String> diccionario = new HashMap<>();
    HashMap<String, String> errores = new HashMap<>();
    diccionario.put("frambuesa", "raspberry");
    diccionario.put("casa", "house");
    diccionario.put("coche", "car");
    diccionario.put("manzana", "apple");
    diccionario.put("verde", "green");
    diccionario.put("armario", "wardrobe");
    diccionario.put("agua", "water");
    diccionario.put("hola", "hello");
    
    //Separamos la clave y el valor del diccionario para trabajar con ellos
    ArrayList<String> palEsp = new ArrayList<>(diccionario.keySet());
    ArrayList<String> palIng = new ArrayList<>(diccionario.values());
    int puntos = 0; //Inicializamos la variable de la puntuación
    boolean falloPresente = false;
    
    //Inicializamos el bucle principal del programa
    for (int i = 0; i < 5; i++) {
      //Almacena una palabra en espanol y una en ingles y las relaciona
      String alePalEsp = palEsp.get((int) ((Math.random() * 7) + 1));
      String alePalIng = palIng.get((int) ((Math.random() * 7) + 1));
      
      //Parte con la que interactua el usuario
      System.out.print(alePalEsp + " es igual a " + alePalIng + "?(s/n): ");
      String seleccion = s.nextLine();
      
      if (seleccion.equals("s") && diccionario.get(alePalEsp).equals(alePalIng)) {
        puntos++;
      } else if (!seleccion.equals("s") && diccionario.get(alePalEsp).equals(alePalIng)) {
        falloPresente = true;
        errores.put(alePalEsp, diccionario.get(alePalEsp));
      }
      
      if (seleccion.equals("n") && (!diccionario.get(alePalEsp).equals(alePalIng))) {
        puntos++;
      } else if (!seleccion.equals("n") && !diccionario.get(alePalEsp).equals(alePalIng)) {
        falloPresente = true;
        errores.put(alePalEsp, diccionario.get(alePalEsp));
      }
      
    }
    
    System.out.println("Respuestas acertadas: " + puntos);
    if (falloPresente) {
      System.out.println("\nRepasa las siguientes palabras: ");
      System.out.println(errores.keySet() + " es " + (errores.values()));
    }
  }
}
