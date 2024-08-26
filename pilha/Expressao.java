public class Expressao {
  public static boolean is_valida(String expressao) {
    var pilha = new Pilha<Character>(expressao.length());
    Character char_topo_pilha = null;

    for (int i = 0; i < expressao.length(); ++i) {
      Character char_i = expressao.charAt(i);

      switch (char_i) {
        case '(':
        case '[':
        case '{':
          pilha.empilhar(char_i);
          char_topo_pilha = char_i;
          break;
        case ')':
        case ']':
        case '}':
          if (char_topo_pilha == null
              || char_i == ')' && char_topo_pilha != '('
              || char_i == '[' && char_topo_pilha != ']'
              || char_i == '{' && char_topo_pilha != '}') {
            return false;
          }
          pilha.desempilhar();
          char_topo_pilha = pilha.consultar();
          break;
        default:
          break;
      }
    }

    return true;
  }
}
