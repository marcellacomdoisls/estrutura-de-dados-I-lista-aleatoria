import java.util.*;

public class ListaAleatoria {
  public static void main(String[] args) {
    int[] vetor = new int[1000];
    LinkedList<Integer> lista = new LinkedList<>();

    Random rand = new Random();
    for (int i = 0; i < vetor.length; i++) {
      vetor[i] = rand.nextInt(19999) - 9999;
    }

    for (int num : vetor) {
      if (lista.isEmpty()) {
        lista.add(num);
      } else {
        ListIterator<Integer> iterator = lista.listIterator();
        boolean inserted = false;
        while (iterator.hasNext()) {
          if (num < iterator.next()) {
            iterator.previous();
            iterator.add(num);
            inserted = true;
            break;
          }
        }
        if (!inserted) {
          iterator.add(num);
        }
      }
    }

    System.out.println("Lista em ordem crescente:");
    for (int num : lista) {
      System.out.print(num + " ");
    }
    System.out.println();

    System.out.println("Lista em ordem decrescente:");
    ListIterator<Integer> iterator = lista.listIterator(lista.size());
    while (iterator.hasPrevious()) {
      System.out.print(iterator.previous() + " ");
    }
    System.out.println();

    iterator = lista.listIterator();
    while (iterator.hasNext()) {
      int num = iterator.next();
      if (ehPrimo(num)) {
        iterator.remove();
      }
    }

    System.out.println("Lista sem números primos:");
    for (int num : lista) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  private static boolean ehPrimo(int num) {
    if (num <= 1) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
