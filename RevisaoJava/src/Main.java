import java.util.Scanner;

public class Main {

    private static Scanner _reader = new Scanner(System.in);
    public static void main(String[] args) {
        imprimirPares();
        _reader.close();
    }

    public static void inverterVetor(){
        int[] vetor = { 10, 9, 8, 7, 6}, auxiliar = new int[5];
        int lenght = vetor.length;

        printLn("Vetor de entrada: " + vetorToString(vetor));

        for(int i = 0; i < lenght; i++){
            auxiliar[(lenght - i) - 1] = vetor[i];
        }

        printLn("Vetor invertido: " + vetorToString(auxiliar));
    }

    public static void somaDosElementosDoVetor(){
        int[] vetor = new int[10];
        int soma = 0;

        printLn("Digite 10 números inteiros e saiba sua soma.");

        for(int i = 0; i < 10; i++){
            printLn("Digite o " + (i + 1) + "º número: ");
            vetor[i] = validateInteger(_reader.next());
            soma = soma + vetor[i];
        }

        printLn("A soma dos elementos do vetor " + vetorToString(vetor) + " é: " + soma + ".");
    }

    public static void imprimirPares(){
        boolean controle = true;
        String[] entradas;
        int tamanhoEntrada = 0;

        printLn("Digite números separados por espaço: ");

        entradas = _reader.nextLine().split(" ");
        tamanhoEntrada = entradas.length;


        int vetor[] = new int[tamanhoEntrada];

        StringBuilder pares = new StringBuilder();

        for(int i = 0; i < tamanhoEntrada; i++ ){
            vetor[i] = validateInteger(entradas[i]);
            if((vetor[i]%2)==0){
                pares.append(" "+ vetor[i]);
            }
        }

        printLn("Dentre os números " + vetorToString(vetor)
                + " são pares os seguintes {" + pares + " }");
    }

    public static String vetorToString(int[] vetor){
        int lenght = vetor.length;

        StringBuilder output = new StringBuilder();

        for(int i = 0; i < lenght; i++) {
            if(i == 0){
                output.append("{").append(vetor[i]).append(", ");
            }
            else if (i == (lenght-1)){
                output.append(vetor[i]).append("}");
            }
            else {
                output.append(vetor[i]).append(", ");
            }
        }
        return output.toString();
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
                printLn("Caracter inválido, tente novamente.");
                printLn("Use apenas números inteiros");
                input = _reader.next();
            }
        }
        return outInt;
    }

    public static void printLn(String text){
        System.out.println(text);
    }
}

