public class Main {
  public static void main(String[] args) {
    System.out.println(Expressao.is_valida("{(1+5)}*(56+12)"));
    System.out.println(Expressao.is_valida("(1+5)*)56+12)"));
    System.out.println(Expressao.is_valida("(1+5)*[56+12)"));
    System.out.println(Expressao.is_valida("(((1+2)-3)*6)"));
  }
}
