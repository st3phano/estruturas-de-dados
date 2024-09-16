public class ListaEncadeada {
  private Node lista;

  public ListaEncadeada() {
    lista = null;
  }

  public boolean is_vazia() {
    return (lista == null);
  }

  public Node get_node(int info) {
    Node atual = lista;

    while (atual != null && atual.get_info() != info) {
      atual = atual.get_proximo();
    }

    return atual;
  }

  public Node get_primeiro() {
    return lista;
  }

  public Node get_ultimo() {
    if (is_vazia()) {
      return null;
    }

    Node ultimo = lista;
    while (ultimo.get_proximo() != null) {
      ultimo = ultimo.get_proximo();
    }

    return ultimo;
  }

  public void inserir_primeiro(int info) {
    var novo_node = new Node(info, lista);
    lista = novo_node;
  }

  public void inserir_depois(Node node, int info) {
    if (node == null) {
      return;
    }

    var novo_node = new Node(info, node.get_proximo());
    node.set_proximo(novo_node);
  }

  public void inserir_ultimo(int info) {
    if (is_vazia()) {
      inserir_primeiro(info);
    } else {
      Node ultimo = lista;
      while (ultimo.get_proximo() != null) {
        ultimo = ultimo.get_proximo();
      }

      inserir_depois(ultimo, info);
    }
  }

  public void inserir_ordenado(int info) {
    if (is_vazia() || (info < lista.get_info())) {
      inserir_primeiro(info);
    } else {
      Node anterior = lista;
      Node posterior = anterior.get_proximo();

      while (posterior != null && info > posterior.get_info()) {
        anterior = posterior;
        posterior = posterior.get_proximo();
      }

      inserir_depois(anterior, info);
    }
  }

  public Node remover_primeiro() {
    if (is_vazia()) {
      return null;
    }

    Node primeiro = lista;
    lista = primeiro.get_proximo();

    return primeiro;
  }

  public Node remover_ultimo() {
    if (is_vazia()) {
      return null;
    }
    if (lista.get_proximo() == null) {
      return remover_primeiro();
    }

    Node anterior = lista;
    Node atual = anterior.get_proximo();

    while (atual.get_proximo() != null) {
      anterior = atual;
      atual = atual.get_proximo();
    }

    anterior.set_proximo(null);
    return atual;
  }

  public Node remover(Node node) {
    if (is_vazia()) {
      return null;
    }
    if (lista == node) {
      return remover_primeiro();
    }

    Node anterior = lista;
    Node atual = anterior.get_proximo();
    while (atual != null && atual != node) {
      anterior = atual;
      atual = atual.get_proximo();
    }

    if (atual != null) {
      anterior.set_proximo(atual.get_proximo());
    }

    return atual;
  }

  public void imprimir() {
    System.out.print("{ ");

    Node atual = lista;
    while (atual != null) {
      System.out.print(atual.get_info() + " ");
      atual = atual.get_proximo();
    }

    System.out.println("}");
  }

  // MÉTODOS RECURSIVOS

  public void imprimir_ao_contrario() {
    System.out.print("{ ");
    imprimir_ao_contrario(lista);
    System.out.println("}");
  }

  private void imprimir_ao_contrario(Node inicio_lista) {
    if (inicio_lista != null) {
      imprimir_ao_contrario(inicio_lista.get_proximo());
      System.out.print(inicio_lista.get_info() + " ");
    }
  }

  public Node get_node_recursivo(int info) {
    return get_node_recursivo(info, lista);
  }

  private Node get_node_recursivo(int info, Node atual) {
    if (atual == null) {
      return null;
    }
    if (atual.get_info() == info) {
      return atual;
    }
    return get_node_recursivo(info, atual.get_proximo());
  }

  public Node get_ultimo_recursivo() {
    if (is_vazia()) {
      return null;
    }
    return get_ultimo_recursivo(lista);
  }

  private Node get_ultimo_recursivo(Node atual) {
    Node proximo = atual.get_proximo();
    if (proximo == null) {
      return atual;
    }
    return get_ultimo_recursivo(proximo);
  }
}

class Node {
  private int info;
  private Node proximo;

  public Node(int info) {
    this.info = info;
    this.proximo = null;
  }

  public Node(int info, Node proximo_node) {
    this.info = info;
    this.proximo = proximo_node;
  }

  public int get_info() {
    return info;
  }

  public Node get_proximo() {
    return proximo;
  }

  public void set_proximo(Node node) {
    this.proximo = node;
  }
}
