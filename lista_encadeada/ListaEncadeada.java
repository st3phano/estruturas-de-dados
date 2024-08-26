public class ListaEncadeada {
  private Node lista;

  public ListaEncadeada() {
    lista = null;
  }

  public boolean is_vazia() {
    return (lista == null);
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
    if (is_vazia()) {
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

  public Node get_node(int info) {
    Node atual = lista;

    while (atual != null && atual.get_info() != info) {
      atual = atual.get_proximo();
    }

    return atual;
  }

  public void imprimir() {
    Node atual = lista;

    while (atual != null) {
      System.out.print(atual.get_info() + " ");
      atual = atual.get_proximo();
    }
    System.out.println();
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
