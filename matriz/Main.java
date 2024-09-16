import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int[][] matriz = gerar_matriz_quadrada(5);

    imprimir_matriz(matriz);
    System.out.println();

    imprimir_matriz_a(matriz);
    System.out.println();

    imprimir_matriz_b(matriz);
    System.out.println();

    imprimir_matriz_c(matriz);
    System.out.println();

    imprimir_matriz_d(matriz);
    System.out.println();
  }

  public static int[][] gerar_matriz_quadrada(int dimensao) {
    var random = new Random();
    int[][] matriz = new int[dimensao][dimensao];

    for (int l = 0; l < dimensao; ++l) {
      for (int c = 0; c < dimensao; ++c) {
        matriz[l][c] = random.nextInt(10, 100);
      }
    }

    return matriz;
  }

  public static void imprimir_matriz(int[][] matriz) {
    for (int l = 0; l < matriz.length; ++l) {
      for (int c = 0; c < matriz[l].length; ++c) {
        System.out.print(matriz[l][c] + " ");
      }
      System.out.println();
    }
  }

  public static void imprimir_matriz_a(int[][] matriz) {
    int linha_meio = matriz.length / 2;
    int coluna_meio = matriz[0].length / 2;

    for (int l = 0; l < matriz.length; ++l) {
      for (int c = 0; c < matriz[l].length; ++c) {
        if (l == linha_meio || c == coluna_meio) {
          System.out.print(matriz[l][c] + " ");
        } else {
          System.out.print("   ");
        }
      }
      System.out.println();
    }
  }

  public static void imprimir_matriz_b(int[][] matriz) {
    int ultima_linha = matriz.length - 1;
    int ultima_coluna = matriz[0].length - 1;

    for (int l = 0; l < matriz.length; ++l) {
      for (int c = 0; c < matriz[l].length; ++c) {
        if (l == 0 || l == ultima_linha || c == 0 || c == ultima_coluna) {
          System.out.print(matriz[l][c] + " ");
        } else {
          System.out.print("   ");
        }
      }
      System.out.println();
    }
  }

  public static void imprimir_matriz_c(int[][] matriz) {
    for (int l = 0; l < matriz.length; ++l) {
      for (int c = 0; c < matriz[l].length; ++c) {
        if (l == c - 1 || c == l - 1) {
          System.out.print(matriz[l][c] + " ");
        } else {
          System.out.print("   ");
        }
      }
      System.out.println();
    }
  }

  public static void imprimir_matriz_d(int[][] matriz) {
    for (int l = 0; l < matriz.length; ++l) {
      for (int c = 0; c < matriz[l].length; ++c) {
        if ((l % 2 == 1 && c % 2 == 0) || (c % 2 == 1 && l % 2 == 0)) {
          System.out.print(matriz[l][c] + " ");
        } else {
          System.out.print("   ");
        }
      }
      System.out.println();
    }
  }
}
