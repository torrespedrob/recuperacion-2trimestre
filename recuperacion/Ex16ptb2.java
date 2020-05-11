package recuperacion;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex16ptb2 {
  public static void main(String[] args) {
    ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(77, 88, 99));
    ArrayList<Integer> lista3 = new ArrayList<>();

    System.out.println(mezclaListas(lista1, lista2));
    System.out.println(mezclaListas(lista2, lista1));
    System.out.println(mezclaListas(lista1, lista3));
    System.out.println(mezclaListas(lista2, lista3));
  }
  
  public static ArrayList<Integer> mezclaListas(ArrayList<Integer> a1, ArrayList<Integer> a2) {
    //Crea el ArrayList final
    ArrayList<Integer> listado = new ArrayList<>();
    int contador = 0;
    int size1 = a1.size();
    int size2 = a2.size();
    
    //El programa acaba cuando contador supere a los size
    while ((contador < size1) || (contador < size2)) {
      if (contador < size1) {
         listado.add(a1.get(contador));
       }
       if (contador < size2) {
         listado.add(a2.get(contador));
       }
       contador++;
    }
    
    return listado;
  }
}