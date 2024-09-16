public class FilaEncadeada {
  private ListaEncadeada lista;

  public FilaEncadeada() {
    lista = new ListaEncadeada();
  }

  public void inserir(int dado) {
    lista.inserir_ultimo(dado);
  }

  public int remover() {
    Node primeiro = lista.remover_primeiro();

    if (primeiro == null) {
      return Integer.MAX_VALUE;
    }
    return primeiro.get_info();
  }

  public void imprimir() {
    lista.imprimir();
  }
}
