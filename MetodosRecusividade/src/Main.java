public class Main {
    public static void main(String[] args) {
        mostrarMensagem();
        mostrarMensagem(3);
        mostrarMensagemRecursivo(3);

        int x = 3, y = 4;
        System.out.println("A soma dos inteiros é: " + somaInteiros(x,y));
    }

    public static void mostrarMensagem(){
        System.out.println("Passei por aqui...");
    }

    public static void mostrarMensagem(int vezes){
        for(int i = 0; i < vezes; i++){
            System.out.println("Passei por aqui pela " + (i + 1) +"ª vez...\n");
        }
    }

    public static int somaInteiros(int x, int y){
        return x + y;
    }

    public static void mostrarMensagemRecursivo(int vezes){
        if(vezes != 0){
            mostrarMensagemRecursivo(vezes - 1);
            System.out.println("Passei por aqui pela " + ( vezes ) +"ª vez...\n");
        }
    }
}