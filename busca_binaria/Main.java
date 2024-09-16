public class Main {
  public static void main(String[] args) {
    int[] dados = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    System.out.println("5: "
        + busca_binaria(dados, 5, 0, 9));
    System.out.println("1: "
        + busca_binaria(dados, 1, 0, 9));
    System.out.println("10: "
        + busca_binaria(dados, 10, 0, 9));
    System.out.println("2: "
        + busca_binaria(dados, 2, 0, 9));
    System.out.println("9: "
        + busca_binaria(dados, 9, 0, 9));
    System.out.println("11: "
        + busca_binaria(dados, 11, 0, 9));
  }

  public static int busca_binaria(int[] dados, int alvo, int i_inicio, int i_fim) {
    if (i_inicio > i_fim) {
      return -1;
    }

    int i_meio = (i_fim + i_inicio) / 2;
    int valor_meio = dados[i_meio];
    if (valor_meio == alvo) {
      return i_meio;
    }

    if (valor_meio < alvo) {
      return busca_binaria(dados, alvo, i_meio + 1, i_fim);
    } else {
      return busca_binaria(dados, alvo, i_inicio, i_meio - 1);
    }
  }
}
