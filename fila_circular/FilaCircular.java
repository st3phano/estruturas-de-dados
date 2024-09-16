public class FilaCircular {
  public final int CAPACIDADE;

  private int primeiro, ultimo, tamanho;
  private int[] dados;

  public FilaCircular(int capacidade) {
    CAPACIDADE = capacidade;
    primeiro = 0;
    ultimo = -1;
    tamanho = 0;

    dados = new int[CAPACIDADE];
  }

  public boolean is_cheia() {
    return (tamanho == CAPACIDADE);
  }

  public boolean is_vazia() {
    return (tamanho == 0);
  }

  public void inserir(int inteiro) {
    if (is_cheia()) {
      return;
    }
    ++tamanho;

    if (ultimo == CAPACIDADE - 1) {
      ultimo = 0;
    } else {
      ++ultimo;
    }

    dados[ultimo] = inteiro;
  }

  public int remover() {
    if (is_vazia()) {
      return Integer.MAX_VALUE;
    }
    --tamanho;

    int i_remover = primeiro;
    if (primeiro == CAPACIDADE - 1) {
      primeiro = 0;
    } else {
      ++primeiro;
    }

    return dados[i_remover];
  }

  public void imprimir() {
    int i_imprimir = primeiro;
    for (int i = 0; i < tamanho; ++i) {
      System.out.print(dados[i_imprimir] + " ");

      if (i_imprimir == CAPACIDADE - 1) {
        i_imprimir = 0;
      } else {
        ++i_imprimir;
      }
    }
    System.out.println();
  }

  public static FilaCircular merge(FilaCircular fila_a, FilaCircular fila_b) {
    var fila_c = new FilaCircular(fila_a.CAPACIDADE + fila_b.CAPACIDADE);

    int int_fila_a = fila_a.remover();
    int int_fila_b = fila_b.remover();
    while (int_fila_a != Integer.MAX_VALUE || int_fila_b != Integer.MAX_VALUE) {
      if (int_fila_a < int_fila_b) {
        fila_c.inserir(int_fila_a);
        int_fila_a = fila_a.remover();
      } else {
        fila_c.inserir(int_fila_b);
        int_fila_b = fila_b.remover();
      }
    }

    return fila_c;
  }
}
