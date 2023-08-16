import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner _reader = new Scanner(System.in);
    public static void main(String[] args) {
        escreverBytesNoArquivo();
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

    public static void exibirMaiorEMenor(){
        int[] vetor = new int[10];
        int maior = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;

        printLn("Digite 10 números inteiros e saiba o maior e o menor.");

        for(int i = 0; i < 10; i++){

            printLn("Digite o " + (i + 1) + "º número: ");
            vetor[i] = validateInteger(_reader.next());

            if(vetor[i] > maior)
            {
                maior = vetor[i];
            }

            if(vetor[i] < menor)
            {
                menor = vetor[i];
            }
        }

        printLn("Dentre os números do vetor: " + vetorToString(vetor)
                + "\n o maior é o: " + maior + ";\n e o menor é o: " + menor + ".");
    }

    public static void mediaAritimetica(){
        int[] vetor = new int[6];
        float media = 0, montante = 0;

        printLn("Digite 6 números inteiros e saiba sua média e os maiores que a média.");

        for(int i = 0; i < 6; i++){

            printLn("Digite o " + (i + 1) + "º número: ");
            vetor[i] = validateInteger(_reader.next());
            montante = montante + vetor[i];
        }

        media = montante/6;
        var maiores = new StringBuilder();

        for(int j = 0; j < 6; j++){
            if(vetor[j]> media){
                maiores.append(vetor[j]).append(" ");
            }
        }

        printLn("Os elementos maiores que a média são: " + maiores);
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

    public static void manipularArquivo(){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\teste.txt");
        if (meuArquivo.exists()){
            printLn("\nDados do arquivo " +
                         meuArquivo.getAbsolutePath());
            printLn("\nTamano " +
                         meuArquivo.length() + "bytes");
            printLn("\nPode ser escrito? " +
                         meuArquivo.canWrite());
        }
        else {
            try{
                meuArquivo.createNewFile();
            }
            catch(IOException e){
                printLn("O arquivo não existe.");
            }
        }
    }

    public static void manipularDiretorio(){
        File meuDiretorio = new File("C:\\Users\\daniel_silva37\\Documents\\Daniel");
        if(!meuDiretorio.exists()){
            meuDiretorio.mkdir();
        }
        for(int i = 0; i< 10; i++){
            String nome = "Arquivo";

            nome = nome + (i+1) + ".png";
            printLn(nome);

            File temp = new File(meuDiretorio.getAbsolutePath() + "\\" + nome);
            try{

                temp.createNewFile();
            }
            catch(IOException e){
                printLn("Arquivos não criados.");
            }
        }
    }

    public static void lerCaracteresDoArquivo(){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\teste.txt");
        try{
            int c;
            FileReader r = new FileReader(meuArquivo);
            while((c = r.read()) != -1){
                printLn("Li o arquivo " + (char)c);
            }
            r.close();
        }
        catch (FileNotFoundException e){
            printLn("O arquivo não existe.");
        }
        catch (IOException e){
            printLn("Erro ao ler arquivo.");
        }
    }

    public static void lerLinhasDoArquivo(){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\teste.txt");
        try{
            FileReader leitorDeArquivo = new FileReader(meuArquivo);
            BufferedReader leitorDeLinhas = new BufferedReader(leitorDeArquivo);
            String linha;

            while((linha = leitorDeLinhas.readLine()) != null){
                printLn(linha);
            }
            leitorDeLinhas.close();
        }
        catch (FileNotFoundException e){
            printLn("O arquivo não existe.");
        }
        catch (IOException e){
            printLn("Erro ao ler arquivo.");
        }
    }

    public static void escreverNoArquivo(){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\teste.txt");
        try{
            FileWriter canal = new FileWriter(meuArquivo, true);
            BufferedWriter operador = new BufferedWriter(canal);

            operador.write("\nEscrevendo no arquivo.");

            operador.close();
            canal.close();
        }
        catch (IOException e){
            printLn("Erro ao escrever no arquivo.");
        }
    }

    public static void lerArquivoEmBytes(){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\relatorio.docx");
        try{
            FileInputStream leitorEmBinario = new FileInputStream(meuArquivo);

            int i = -1;
            do{
                i = leitorEmBinario.read();
                if(i != -1){
                    System.out.print(Integer.toBinaryString(i));
                }
            } while(i!= -1);
            leitorEmBinario.close();
        }
        catch (IOException e){
            printLn("Erro ao abrir o arquivo");
        }
    }

    public static void escreverBytesNoArquivo(){
        File meuArquivo = new File("C:\\Users\\daniel_silva37\\Documents\\relatorio.docx");
        try{
            FileOutputStream canalDeEscrita = new FileOutputStream(meuArquivo, true);

            canalDeEscrita.write(new byte[]{'b', 'o', 'd','e'});

            canalDeEscrita.close();
        }
        catch (IOException e){
            printLn("Erro ao abrir o arquivo");
        }
    }
}

