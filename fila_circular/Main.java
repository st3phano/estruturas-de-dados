public class Main {
  public static void main(String[] args) {
    var fila_a = new Fila(4);
    fila_a.inserir(1);
    fila_a.inserir(1);
    fila_a.remover();
    fila_a.remover();

    fila_a.inserir(12);
    fila_a.inserir(35);
    fila_a.inserir(52);
    fila_a.inserir(64);
    fila_a.imprimir();

    var fila_b = new Fila(5);
    fila_b.inserir(1);
    fila_b.remover();
    fila_b.inserir(1);
    fila_b.remover();
    fila_b.inserir(1);
    fila_b.remover();

    fila_b.inserir(5);
    fila_b.inserir(15);
    fila_b.inserir(23);
    fila_b.inserir(55);
    fila_b.inserir(75);
    fila_b.imprimir();

    var fila_c = Fila.merge(fila_a, fila_b);
    fila_c.imprimir();
  }
}
