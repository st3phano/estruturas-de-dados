public class ArvoreBinaria {
  private Node raiz;

  public boolean is_vazia() {
    return (raiz == null);
  }

  public void inserir_iterativo(int info) {
    Node novo = new Node(info);
    if (is_vazia()) {
      raiz = novo;
      return;
    }

    Node atual = raiz;
    boolean inseriu = false;
    do {
      if (info < atual.get_info()) {
        if (atual.get_esquerda() == null) {
          atual.set_esquerda(novo);
          inseriu = true;
        } else {
          atual = atual.get_esquerda();
        }
      } else {
        if (atual.get_direita() == null) {
          atual.set_direita(novo);
          inseriu = true;
        } else {
          atual = atual.get_direita();
        }
      }
    } while (!inseriu);

    balancear();
  }

  public void inserir_recursivo(int info) {
    Node novo = new Node(info);
    if (is_vazia()) {
      raiz = novo;
      return;
    }

    inserir_recursivo(novo, raiz);
    balancear();
  }

  private void inserir_recursivo(Node novo, Node atual) {
    if (novo.get_info() < atual.get_info()) {
      if (atual.get_esquerda() == null) {
        atual.set_esquerda(novo);
      } else {
        inserir_recursivo(novo, atual.get_esquerda());
      }
    } else {
      if (atual.get_direita() == null) {
        atual.set_direita(novo);
      } else {
        inserir_recursivo(novo, atual.get_direita());
      }
    }
  }

  public void imprimir_pre_ordem() {
    System.out.print("Pré-ordem:\t");
    imprimir_pre_ordem(raiz);
    System.out.println();
  }

  private void imprimir_pre_ordem(Node node) {
    if (node == null) {
      return;
    }

    System.out.print(node.get_info() + "\t");
    imprimir_pre_ordem(node.get_esquerda());
    imprimir_pre_ordem(node.get_direita());
  }

  public void imprimir_in_ordem() {
    System.out.print("In-ordem:\t");
    imprimir_in_ordem(raiz);
    System.out.println();
  }

  private void imprimir_in_ordem(Node node) {
    if (node == null) {
      return;
    }

    imprimir_in_ordem(node.get_esquerda());
    System.out.print(node.get_info() + "\t");
    imprimir_in_ordem(node.get_direita());
  }

  public void imprimir_pos_ordem() {
    System.out.print("Pós-ordem:\t");
    imprimir_pos_ordem(raiz);
    System.out.println();
  }

  private void imprimir_pos_ordem(Node node) {
    if (node == null) {
      return;
    }

    imprimir_pos_ordem(node.get_esquerda());
    imprimir_pos_ordem(node.get_direita());
    System.out.print(node.get_info() + "\t");
  }

  public Node remover_maior_iterativo() {
    if (is_vazia()) {
      return null;
    }

    Node anterior = null;
    Node atual = raiz;
    Node proximo = atual.get_direita();
    while (proximo != null) {
      anterior = atual;
      atual = proximo;
      proximo = proximo.get_direita();
    }

    if (atual == raiz) {
      raiz = raiz.get_esquerda();
    } else {
      anterior.set_direita(atual.get_esquerda());
    }

    atual.set_esquerda(null);
    balancear();
    return atual;
  }

  public Node remover_maior_recursivo() {
    if (is_vazia()) {
      return null;
    }

    Node removido = remover_maior_recursivo(null, raiz);
    balancear();
    return removido;
  }

  private Node remover_maior_recursivo(Node anterior, Node atual) {
    Node proximo = atual.get_direita();
    if (proximo == null) {
      if (atual == raiz) {
        raiz = raiz.get_esquerda();
      } else {
        anterior.set_direita(atual.get_esquerda());
      }

      atual.set_esquerda(null);
      return atual;
    }

    return remover_maior_recursivo(atual, proximo);
  }

  public Node remover_menor_iterativo() {
    Node anterior = null;
    Node atual = null;
    Node proximo = raiz;
    while (proximo != null) {
      anterior = atual;
      atual = proximo;
      proximo = proximo.get_esquerda();
    }
    if (atual == null) {
      return null;
    }

    if (atual == raiz) {
      raiz = raiz.get_direita();
    } else {
      anterior.set_esquerda(atual.get_direita());
    }

    atual.set_direita(null);
    balancear();
    return atual;
  }

  public Node remover_menor_recursivo() {
    if (is_vazia()) {
      return null;
    }

    Node anterior = get_anterior_menor_recursivo(null, raiz);
    Node menor;
    if (anterior == null) {
      menor = raiz;
      raiz = raiz.get_direita();
    } else {
      menor = anterior.get_esquerda();
      anterior.set_esquerda(menor.get_direita());
    }

    menor.set_direita(null);
    balancear();
    return menor;
  }

  private Node get_anterior_menor_recursivo(Node anterior, Node atual) {
    Node proximo = atual.get_esquerda();
    if (proximo == null) {
      return anterior;
    }

    return get_anterior_menor_recursivo(atual, proximo);
  }

  public boolean esta_presente(int info) {
    Node atual = raiz;
    while (atual != null) {
      if (info < atual.get_info()) {
        atual = atual.get_esquerda();
      } else if (info > atual.get_info()) {
        atual = atual.get_direita();
      } else {
        return true;
      }
    }

    return false;
  }

  public Node remover_iterativo(int info) {
    Node anterior = null;
    Node atual = raiz;
    while (atual != null && atual.get_info() != info) {
      anterior = atual;
      if (info < atual.get_info()) {
        atual = atual.get_esquerda();
      } else {
        atual = atual.get_direita();
      }
    }
    if (atual == null) {
      return null;
    }

    Node substituto = null;
    if (atual.get_esquerda() == null) {
      substituto = atual.get_direita();
    } else if (atual.get_direita() == null) {
      substituto = atual.get_esquerda();
    } else {
      substituto = remover_menor_direita(atual);
      substituto.set_esquerda(atual.get_esquerda());
      substituto.set_direita(atual.get_direita());
    }

    if (atual == raiz) {
      raiz = substituto;
    } else if (info < anterior.get_info()) {
      anterior.set_esquerda(substituto);
    } else {
      anterior.set_direita(substituto);
    }

    atual.set_esquerda(null);
    atual.set_direita(null);
    balancear();
    return atual;
  }

  public Node remover_recursivo(int info) {
    Node removido = remover_recursivo(info, null, raiz);
    balancear();
    return removido;
  }

  private Node remover_recursivo(int info, Node anterior, Node atual) {
    if (atual == null) {
      return null;
    }

    if (info < atual.get_info()) {
      return remover_recursivo(info, atual, atual.get_esquerda());
    } else if (info > atual.get_info()) {
      return remover_recursivo(info, atual, atual.get_direita());
    } else {
      Node substituto = null;
      if (atual.get_esquerda() == null) {
        substituto = atual.get_direita();
      } else if (atual.get_direita() == null) {
        substituto = atual.get_esquerda();
      } else {
        substituto = remover_menor_direita(atual);
        substituto.set_esquerda(atual.get_esquerda());
        substituto.set_direita(atual.get_direita());
      }

      if (atual == raiz) {
        raiz = substituto;
      } else if (info < anterior.get_info()) {
        anterior.set_esquerda(substituto);
      } else {
        anterior.set_direita(substituto);
      }

      atual.set_esquerda(null);
      atual.set_direita(null);
      return atual;
    }
  }

  private Node remover_menor_direita(Node node) {
    Node anterior = get_anterior_menor_recursivo(node, node.get_direita());
    Node menor;
    if (anterior == node) {
      menor = node.get_direita();
      node.set_direita(menor.get_direita());
    } else {
      menor = anterior.get_esquerda();
      anterior.set_esquerda(menor.get_direita());
    }

    menor.set_direita(null);
    return menor;
  }

  private void balancear() {
    balancear_recursivo(raiz, null);
  }

  private void balancear_recursivo(Node atual, Node anterior) {
    if (atual == null) {
      return;
    }

    balancear_recursivo(atual.get_esquerda(), atual);
    balancear_recursivo(atual.get_direita(), atual);

    int fator_balanceamento = calcular_fator_balanceamento(atual);
    if (fator_balanceamento == 2) {
      Node esquerda_do_atual = atual.get_esquerda();
      if (calcular_fator_balanceamento(esquerda_do_atual) == -1) {
        atual.set_esquerda(rotacionar_esquerda(esquerda_do_atual));
      }

      Node novo_atual = rotacionar_direita(atual);
      if (anterior == null) {
        raiz = novo_atual;
      } else if (anterior.get_esquerda() == atual) {
        anterior.set_esquerda(novo_atual);
      } else {
        anterior.set_direita(novo_atual);
      }
    } else if (fator_balanceamento == -2) {
      Node direita_do_atual = atual.get_direita();
      if (calcular_fator_balanceamento(direita_do_atual) == 1) {
        atual.set_direita(rotacionar_direita(direita_do_atual));
      }

      Node novo_atual = rotacionar_esquerda(atual);
      if (anterior == null) {
        raiz = novo_atual;
      } else if (anterior.get_esquerda() == atual) {
        anterior.set_esquerda(novo_atual);
      } else {
        anterior.set_direita(novo_atual);
      }
    }
  }

  private int calcular_fator_balanceamento(Node node) {
    if (node == null) {
      return 0;
    }

    int altura_esquerda = calcular_altura_recursivo(node.get_esquerda());
    int altura_direita = calcular_altura_recursivo(node.get_direita());
    return (altura_esquerda - altura_direita);
  }

  private int calcular_altura_recursivo(Node node) {
    if (node == null) {
      return 0;
    }

    int altura_esquerda = calcular_altura_recursivo(node.get_esquerda());
    int altura_direita = calcular_altura_recursivo(node.get_direita());
    int altura = (altura_esquerda > altura_direita) ? altura_esquerda : altura_direita;
    return 1 + altura;
  }

  private Node rotacionar_esquerda(Node node) {
    if (node == null) {
      return null;
    }

    Node direita_do_node = node.get_direita();
    Node esquerda_da_direita_do_node = direita_do_node.get_esquerda();
    direita_do_node.set_esquerda(node);
    node.set_direita(esquerda_da_direita_do_node);

    return direita_do_node;
  }

  private Node rotacionar_direita(Node node) {
    if (node == null) {
      return null;
    }

    Node esquerda_do_node = node.get_esquerda();
    Node direita_da_esquerda_do_node = esquerda_do_node.get_direita();
    esquerda_do_node.set_direita(node);
    node.set_esquerda(direita_da_esquerda_do_node);

    return esquerda_do_node;
  }
}

class Node {
  private int info;
  private Node esquerda;
  private Node direita;

  public Node(int info) {
    this.info = info;
    esquerda = null;
    direita = null;
  }

  public int get_info() {
    return info;
  }

  public Node get_esquerda() {
    return esquerda;
  }

  public Node get_direita() {
    return direita;
  }

  public void set_esquerda(Node node) {
    esquerda = node;
  }

  public void set_direita(Node node) {
    direita = node;
  }
}
