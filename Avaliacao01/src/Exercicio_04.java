import java.util.Scanner;

public class Exercicio_04 {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    private static void interagir(){
        int vetor[] = new int[8];
        int somatorioIterativo = 0, somatorioRecursivo = 0;
        for(int i = 1; i <= 7;){
            imprimir("Digite um número:");
            vetor[i] = validateInteger(_leitor.next());
            vetor[i-1] = vetor[i] * 2;
            i += 2;
        }
        imprimir("imprimindo somatório por iteratividade: ");
        for(int j = 0; j < vetor.length; j++){
            somatorioIterativo = somatorioIterativo + vetor[j];
        }
        imprimir("" + somatorioIterativo);

        imprimir("\nImprimindo somatório por recursividade: ");
            imprimir(""+ somarComRecursividade(vetor, (vetor.length-1)));
    }
    private static int somarComRecursividade(int vetor[], int posicao){
        if(posicao == 0){
            return vetor[0];
        }
        return 0 + vetor[posicao] + somarComRecursividade(vetor, posicao -1);
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
    private static void imprimir(String texto){
        System.out.println(texto);
    }
}
