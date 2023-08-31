import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio_03 {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    private static void interagir(){
        boolean controle = true;

        while(controle){
            mostrarPainel();
            int opcao = validateInteger(_leitor.next());
            double primeiroTermo = 0.0, segundoTermo = 0.0, resultado = 0.0;

            if(opcao == 5){
                controle = false;
                continue;
            }

            imprimir("Digite o primeiro termo: ");
            primeiroTermo = validarDouble(_leitor.next());

            imprimir("Digite o segundo termo: ");
            segundoTermo = validarDouble(_leitor.next());

            if(opcao == 1){
                resultado = adicao(primeiroTermo, segundoTermo);
            }
            else if(opcao == 2){
                resultado = subtracao(primeiroTermo, segundoTermo);
            }
            else if(opcao == 3){
                resultado = divisao(primeiroTermo, segundoTermo);
            }
            else if(opcao == 4){
                resultado = multiplicacao(primeiroTermo, segundoTermo);
            }
            else{
                imprimir("Opção inválida.");
            }
            escreverNoArqivo(primeiroTermo, segundoTermo, resultado, opcao);
        }
    }
    private static double adicao(double primeiroTermo, double segundoTermo){
        return primeiroTermo + segundoTermo;
    }
    private static double subtracao(double primeiroTermo, double segundoTermo){
        return primeiroTermo - segundoTermo;
    }
    private static double divisao(double primeiroTermo, double segundoTermo){
        return primeiroTermo / segundoTermo;
    }
    private static double multiplicacao(double primeiroTermo, double segundoTermo){
        return primeiroTermo * segundoTermo;
    }

    private static void escreverNoArqivo(double primeiroTermo, double segundoTermo, double resultado, int opcao){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\historico.txt");
        try{
            FileWriter canal = new FileWriter(meuArquivo, true);
            BufferedWriter operador = new BufferedWriter(canal);

            if(opcao == 1){
                operador.write(primeiroTermo + " + " + segundoTermo + " = " + resultado + "\n");
            }
            else if(opcao == 2){
                operador.write(primeiroTermo + " - " + segundoTermo + " = " + resultado + "\n");
            }
            else if(opcao == 3){
                operador.write(primeiroTermo + " / " + segundoTermo + " = " + resultado + "\n");
            }
            else if(opcao == 4){
                operador.write(primeiroTermo + " * " + segundoTermo + " = " + resultado + "\n");
            }

            operador.close();
            canal.close();
        }
        catch (IOException e){
            imprimir("Erro ao escrever no arquivo.");
        }
    }
    private static void mostrarPainel(){
        imprimir("[1] Adição;");
        imprimir("[2] Subtração;");
        imprimir("[3] Divisão;");
        imprimir("[4] Multiplicação;");
        imprimir("[5] Sair;");
    }
    private static void imprimir(String texto){
        System.out.println(texto);
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
    private static Double validarDouble(String entrada){
        double saidaDouble = 0.00;
        boolean controleFluxo = true;

        while(controleFluxo){
            var modifiedInput = entrada.replace(',', '.');
            try{
                saidaDouble = Double.parseDouble(modifiedInput);
                controleFluxo = false;
            }
            catch(NumberFormatException exception){
                imprimir("Caracter inválido, tente novamente.");
                entrada = _leitor.next();
            }
        }
        return saidaDouble;
    }
}
