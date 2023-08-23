import java.util.Scanner;

public class PotenciaRecursividade {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    private static void interagir(){
        imprimir("Digite um número inteiro para a base da potência:");
        var base = validateInteger(_leitor.nextLine());

        imprimir("Digite um número inteiro para o expoente da potência:");
        var expoente = validateInteger(_leitor.nextLine());

        var saida = potenciacao(base, expoente);

        imprimir(base + " elevado a " + expoente + " é: " + saida + ".");
    }
    private static int potenciacao(int base, int expoente){
        if(expoente == 0){
            return 1;
        }
        return base * potenciacao(base, (expoente-1));
    }
    private static void imprimir(String mensagem){
        System.out.println(mensagem);
    }
    public static Integer validateInteger(String input){
        int outInt = 0;
        boolean controlFlow = true;

        while(controlFlow){
            try{
                outInt = Integer.parseInt(input);
                controlFlow = false;
            }
            catch(NumberFormatException exception){
                imprimir("Caracter inválido, tente novamente.");
                imprimir("Use apenas números inteiros");
                input = _leitor.next();
            }
        }
        return outInt;
    }
}
