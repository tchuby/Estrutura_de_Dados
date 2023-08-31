import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio_01 {
    private static Scanner _leitor = new Scanner(System.in);
    public static void main(String[] args){
        interagir();
        _leitor.close();
    }
    private static void interagir(){
        double vendaSemanal[] = new double[7];

        for(int i = 0; i < 7 ; i++){
            imprimir("Informe o valor das vendas do " +
                    (i+1) + "º dia da semana:");
            vendaSemanal[i] = validarDouble(_leitor.next());
        }
        imprimir(encontrarMediaDeVendas(vendaSemanal));
        imprimir(encontrarMaiorMenorValor(vendaSemanal));
        imprimir(encontrarMontanteVendas(vendaSemanal));
    }
    private static String encontrarMediaDeVendas(double[] vendas){
        double media = 0.0, montante = 0.0;
        for(double venda: vendas){
            montante += venda;
        }
        media = montante / vendas.length;

        return "O valor médio das vendas da semana foi de R$ "
                + formatarDouble(media) + ".";
    }
    private static String encontrarMaiorMenorValor(double[] vendas){
        Double menor = Double.MAX_VALUE, maior = Double.MIN_VALUE;
        Integer diaMenor = 0, diaMaior = 0;
        for(int j = 0; j < vendas.length; j++){
            if(vendas[j] < menor){
                menor = vendas[j];
                diaMenor = j+1;
            }

            if(vendas[j]> maior){
                maior = vendas[j];
                diaMaior = j+1;
            }
        }
        return "O maior valor de venda foi no " + diaMaior + "º dia; e\n" +
                "O menor valor de venda foi no " + diaMenor + "º dia.";
    }
    private static String encontrarMontanteVendas(double[]vendas){
        double montante = 0.0;
        for(double venda: vendas){
            montante += venda;
        }
        return "A soma das vendas da semana foi de: " + formatarDouble(montante);
    }
    private static void imprimir(String texto){
        System.out.println(texto);
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
    private static String formatarDouble(Double number){
        return new DecimalFormat("#,##0.00")
                            .format(number).toString();
    }
}
