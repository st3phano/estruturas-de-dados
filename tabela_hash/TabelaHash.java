public class TabelaHash {
  private ListaEncadeada[] tabela;

  public TabelaHash(int tamanho) {
    tabela = new ListaEncadeada[tamanho];
  }

  public void inserir(int chave) {
    int indice = gerar_indice(chave);

    if (tabela[indice] == null) {
      tabela[indice] = new ListaEncadeada();
    }

    tabela[indice].inserir_ordenado(chave);
  }

  public boolean buscar(int chave) {
    int indice = gerar_indice(chave);

    ListaEncadeada lista = tabela[indice];
    return (lista != null && lista.get_node(chave) != null);
  }

  private int gerar_indice(int chave) {
    return chave % tabela.length;
  }
}
