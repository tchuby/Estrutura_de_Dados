import java.util.Scanner;

public class FatorialRecursividade {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    private static void interagir(){
        imprimir("Digite um número inteiro e saiba seu número fatorial:");
        var param = validateInteger(_leitor.nextLine());
        var saida = produtoFatorial(param);
        imprimir("O produto fatorial de " + param + "! é: " + saida + ".");
    }
    private static int produtoFatorial(int param)
    {
        if(param == 1){
            return 1;
        }
        return param * (produtoFatorial(param-1));
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
