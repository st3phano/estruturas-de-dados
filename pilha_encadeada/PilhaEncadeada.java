public class PilhaEncadeada {
  private ListaEncadeada lista;

  public PilhaEncadeada() {
    lista = new ListaEncadeada();
  }

  public void empilhar(int dado) {
    lista.inserir_primeiro(dado);
  }

  public int desempilhar() {
    Node topo = lista.remover_primeiro();

    if (topo == null) {
      return Integer.MAX_VALUE;
    }
    return topo.get_info();
  }

  public int get_topo() {
    Node topo = lista.get_primeiro();

    if (topo == null) {
      return Integer.MAX_VALUE;
    }
    return topo.get_info();
  }

  public void imprimir_da_base_pro_topo() {
    System.out.print("Base pro topo: ");
    lista.imprimir_ao_contrario();
  }

  public void imprimir_do_topo_pra_base() {
    System.out.print("Topo pra base: ");
    lista.imprimir();
  }
}
