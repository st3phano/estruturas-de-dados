public class Main {
  public static void main(String[] args) {
    var lista_encadeada = new ListaEncadeada();

    System.out.println(lista_encadeada.is_vazia());
    lista_encadeada.imprimir();

    lista_encadeada.inserir_ordenado(10);
    lista_encadeada.inserir_primeiro(5);
    lista_encadeada.inserir_ultimo(30);
    lista_encadeada.inserir_depois(lista_encadeada.get_node(10), 15);
    lista_encadeada.inserir_ordenado(20);

    System.out.println(lista_encadeada.is_vazia());
    lista_encadeada.imprimir();

    Node removido = lista_encadeada.remover_primeiro();
    System.out.println(removido.get_info());

    removido = lista_encadeada.remover_ultimo();
    System.out.println(removido.get_info());

    removido = lista_encadeada.remover(removido);
    System.out.println(removido);

    lista_encadeada.imprimir();

    removido = lista_encadeada.remover(lista_encadeada.get_node(10));
    System.out.println(removido.get_info());

    System.out.println(lista_encadeada.is_vazia());
    lista_encadeada.imprimir();

    lista_encadeada.inserir_ultimo(30);
    removido = lista_encadeada.remover(lista_encadeada.get_node(20));
    System.out.println(removido.get_info());

    lista_encadeada.imprimir();
  }
}
