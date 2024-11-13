import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    var teclado = new Scanner(System.in);
    var random = new Random(1);
    var arvore_binaria = new ArvoreBinaria();

    System.out.print("\n1 - Ler inteiros do teclado\n2 - Inteiros aleatórios\n:");
    int opcao = teclado.nextInt();

    for (int i = 0; i < 10; ++i) {
      int inteiro;
      if (opcao == 1) {
        inteiro = teclado.nextInt();
      } else {
        inteiro = random.nextInt(0, 50);
      }

      if (i % 2 == 0) {
        arvore_binaria.inserir_iterativo(inteiro);
      } else {
        arvore_binaria.inserir_recursivo(inteiro);
      }
      arvore_binaria.imprimir_pre_ordem();
    }

    System.out.println("\nMaior: " + arvore_binaria.remover_maior_iterativo().get_info());
    arvore_binaria.imprimir_pre_ordem();
    System.out.println("\nMaior: " + arvore_binaria.remover_maior_recursivo().get_info());
    arvore_binaria.imprimir_pre_ordem();

    System.out.println("\nMenor: " + arvore_binaria.remover_menor_iterativo().get_info());
    arvore_binaria.imprimir_pre_ordem();
    System.out.println("\nMenor: " + arvore_binaria.remover_menor_recursivo().get_info());
    arvore_binaria.imprimir_pre_ordem();

    System.out.print("\n1 - Remover usando teclado\n2 - Remover aleatórios\n:");
    opcao = teclado.nextInt();

    for (int i = 0; i < 4; ++i) {
      int inteiro;
      if (opcao == 1) {
        inteiro = teclado.nextInt();
      } else {
        inteiro = random.nextInt(0, 50);
      }

      System.out.print(inteiro + ": ");
      if (i % 2 == 0) {
        System.out.println(arvore_binaria.remover_iterativo(inteiro));
      } else {
        System.out.println(arvore_binaria.remover_recursivo(inteiro));
      }
      arvore_binaria.imprimir_pre_ordem();
    }

    teclado.close();
  }
}
