public class ListaDuplamenteEncadeadaCircular {
  private Node lista;

  public ListaDuplamenteEncadeadaCircular() {
    lista = null;
  }

  public boolean is_vazia() {
    return (lista == null);
  }

  public Node get_node(int info) {
    if (is_vazia()) {
      return null;
    }

    Node atual = lista;
    do {
      if (info == atual.get_info()) {
        return atual;
      }
      atual = atual.get_proximo();
    } while (atual != lista);

    return null;
  }

  public void imprimir() {
    System.out.print("{ ");

    if (lista != null) {
      Node atual = lista;
      do {
        System.out.print(atual.get_info() + " ");
        atual = atual.get_proximo();
      } while (atual != lista);
    }

    System.out.println("}");
  }

  public void inserir_primeiro(int info) {
    var novo_node = new Node(info);

    if (is_vazia()) {
      novo_node.set_anterior(novo_node);
    } else {
      novo_node.set_anterior(lista.get_anterior());
      novo_node.set_proximo(lista);
    }

    lista = novo_node;
  }

  public void inserir_ultimo(int info) {
    if (is_vazia()) {
      inserir_primeiro(info);
    } else {
      var novo_node = new Node(info);
      novo_node.set_anterior(lista.get_anterior());
      novo_node.set_proximo(lista);
    }
  }

  public void inserir_antes(Node node, int info) {
    if (node == null) {
      return;
    }

    if (node == lista) {
      inserir_primeiro(info);
    } else {
      var novo_node = new Node(info);
      novo_node.set_anterior(node.get_anterior());
      novo_node.set_proximo(node);
    }
  }

  public void inserir_depois(Node node, int info) {
    if (node == null) {
      return;
    }

    var novo_node = new Node(info);
    novo_node.set_proximo(node.get_proximo());
    novo_node.set_anterior(node);
  }

  public void inserir_ordenado(int info) {
    if (is_vazia()) {
      inserir_primeiro(info);
    } else {
      Node atual = lista;
      do {
        if (info < atual.get_info()) {
          inserir_antes(atual, info);
          return;
        }
        atual = atual.get_proximo();
      } while (atual != lista);

      inserir_ultimo(info);
    }
  }

  public Node remover_primeiro() {
    if (is_vazia()) {
      return null;
    }

    Node primeiro = lista;
    if (primeiro == lista.get_proximo()) {
      lista = null;
    } else {
      lista = primeiro.get_proximo();
      lista.set_anterior(primeiro.get_anterior());
    }

    primeiro.set_anterior(primeiro);
    return primeiro;
  }

  public Node remover_ultimo() {
    if (is_vazia()) {
      return null;
    }

    Node ultimo = lista.get_anterior();
    if (ultimo == lista) {
      lista = null;
    } else {
      lista.set_anterior(ultimo.get_anterior());
    }

    ultimo.set_anterior(ultimo);
    return ultimo;
  }

  public Node remover(Node node) {
    if (is_vazia()) {
      return null;
    } else if (node == lista) {
      return remover_primeiro();
    }

    Node atual = lista.get_proximo();
    do {
      if (atual == node) {
        Node anterior = atual.get_anterior();
        anterior.set_proximo(atual.get_proximo());

        atual.set_anterior(atual);
        return atual;
      }
      atual = atual.get_proximo();
    } while (atual != lista);

    return null;
  }
}

class Node {
  private int info;
  private Node anterior;
  private Node proximo;

  public Node(int info) {
    this.info = info;
    this.anterior = null;
    this.proximo = null;
  }

  public Node(int info, Node anterior, Node proximo) {
    this.info = info;
    this.anterior = anterior;
    this.proximo = proximo;
  }

  public int get_info() {
    return info;
  }

  public Node get_anterior() {
    return anterior;
  }

  public Node get_proximo() {
    return proximo;
  }

  public void set_anterior(Node anterior) {
    this.anterior = anterior;

    if (anterior != null) {
      anterior.proximo = this;
    }
  }

  public void set_proximo(Node proximo) {
    this.proximo = proximo;

    if (proximo != null) {
      proximo.anterior = this;
    }
  }
}
