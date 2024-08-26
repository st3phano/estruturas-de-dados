public class Pilha<T> {
  public final int MAX;
  private int topo;
  private T[] dados;

  @SuppressWarnings("unchecked")
  public Pilha(int tamanho) {
    MAX = tamanho;

    dados = (T[]) new Object[MAX];
    topo = -1;
  }

  public boolean esta_vazia() {
    return (topo == -1);
  }

  public boolean esta_cheia() {
    return (topo == MAX - 1);
  }

  public T consultar() {
    if (esta_vazia()) {
      return null;
    } else {
      return dados[topo];
    }
  }

  public void empilhar(T elemento) {
    if (esta_cheia()) {
      System.out.println("Pilha cheia!");
    } else {
      ++topo;
      dados[topo] = elemento;
    }
  }

  public T desempilhar() {
    if (esta_vazia()) {
      return null;
    } else {
      --topo;
      return dados[topo + 1];
    }
  }
}
