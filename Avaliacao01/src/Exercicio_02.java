import java.util.Scanner;

public class Exercicio_02 {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    public static void interagir(){
        int cela[][] = new int[3][2];
        int celula = 1;

        imprimir("Considerando 1 para célula elevada e 0 para célula plana em uma cela Braille; e\n" +
                " Considerando as seguintes posições para cada célula na cela: \n"+
                "| 1 | 4 |\n"+
                "| 2 | 5 |\n"+
                "| 3 | 6 |\n"+
                "Informe o preenchimento das células a seguir:\n");
        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 2; coluna++){
                imprimir("Célula " + (celula++) + ".");
                cela[linha][coluna] = validarEntrada(_leitor.next());
            }
        }
        imprimir(contarCelulasElevadas(cela));
        imprimir(ehLetraA(cela));
    }
    public static String contarCelulasElevadas(int[][] cela){
        int elevadas = 0;

        for(int linha = 0; linha < 3; linha++){
            for(int coluna = 0; coluna < 2; coluna++){
                if(cela[linha][coluna]== 1){
                    elevadas++;
                }
            }
        }
        return "Há " + elevadas + " células elevadas na cela.";
    }
    public static String ehLetraA(int[][] cela){
        if(cela[0][0]==1 && cela[0][1]==0 &&
          cela[1][0]==0 && cela[1][1]==0 &&
          cela[2][0]==0 && cela[2][1]==0)
        {
            return "A cela representa a letra 'a'.";
        }
        else{
            return "A cela não repesenta a letra 'a'.";
        }
    }
    private static void imprimir(String texto){
        System.out.println(texto);
    }
    private static Integer validarEntrada(String entrada){
        int saida = 0;
        boolean controle = true;
        while(controle){
            if(entrada.equals("1") || entrada.equals("0")){
                saida = Integer.parseInt(entrada);
                        controle = false;
            }
            else{
                imprimir("Caracter inválido, digite apenas 1 ou 0.");
                entrada = _leitor.next();
            }
        }
        return saida;
    }
}
