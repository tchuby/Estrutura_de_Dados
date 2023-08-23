import java.util.Scanner;

public class SomatorioRecursividade {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    private static void interagir(){
        int param = 0;
        boolean controle = true;
        imprimir("Digite um número inteiro e saiba o somatório de todos os seus antecessores:");
        while(controle){
            param = validateInteger(_leitor.nextLine());
            if(param < 0){
                imprimir("O número deve ser positivo.");
            }
            else{
                controle = false;
            }
        }
        var saida = somatorio(param);
        imprimir("O somatórios dos antecessores de " + param + " é: " + saida + ".");
    }
    private static int somatorio(int param){
        if(param == 0)
        {
            return 0;
        }

        return param + somatorio(param - 1);
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
