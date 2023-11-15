public class Ordenacao {

    public static void main(String[] args) {
        int[] vetor = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Iniciando...");
        /*
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i] + ", ");
        }
        */

        Ordenacao.mergeSort(vetor);

        /*
        System.out.println("\nApós processamento: ");
        for (int i = 0; i < vetor.length; i++){
            System.out.println(vetor[i] + ", ");
        }*/
    }

    public static void bubbleSortIterativoV1(int[] v){

        int n = v.length;
        for(int i = n -1; i > 1; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(v[j] > v[j+1])
                {
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSortIterativoV2(int[] v){
        int n = v.length;
        for(int i = n -1; i > 1; i--)
        {
            boolean troca = false;
            for(int j = 0; j < i; j++)
            {
                if(v[j] > v[j+1])
                {
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                    troca = true;
                }
            }
            if(!troca){
                return;
            }
        }
    }

    public static void bubbleSortRecursivo(int[] v){
        bubbleSortRecursivoAux(v.length, v);
    }

    private static void bubbleSortRecursivoAux(int n, int[] v){
        boolean troca = false;
        for(int i = 0; i < n -1; i++){
            if(v[i] > v [i+1]){
                int temp = v[i];
                v[i] = v[i+1];
                v[i + 1] = temp;
                troca = true;
            }
        }
        if(troca){
            bubbleSortRecursivoAux(n-1, v);
        }
    }

    public static void quickSort(int[] v){
        quickSortRec(v, 1, v.length -1);
    }

    private static void quickSortRec(int[] v, int a, int b){
        if(a >= b){
            return;
        }
        int indice = particiona(v, a, b);
        quickSortRec(v, a, indice);
        quickSortRec(v, indice + 1, b);
    }

    private static void troca(int v[], int a, int b){
        int temp = v[a];
        v[a] = v[b];
        v[b] = temp;
    }

    private static int particiona(int v[], int a, int b){
        int x = v[a];
        while(a < b){
            while(v[a] < x){
                a++;
            }
            while(v[b] > x){
                b--;
            }
            troca(v, a, b);
        }
        return a;
    }

    public static void mergeSort(int[] v){
        mergeSortRec(v, 0, v.length -1, 0);
    }

    private static void mergeSortRec(int[] v, int ini, int fim, int nivelRec){
        if(fim <= ini){
            return;
        }

        int meio = (ini + fim)/2;

        System.out.println(nivelRec + " = { " + ini + " | " + meio + " | " + fim + " }");

        mergeSortRec(v, ini , meio, nivelRec+1);
        mergeSortRec(v, meio+1, fim , nivelRec+1);

        int A[] = new int[meio - ini + 1];
        int B[] = new int[fim - meio ];
        for (int i = 0; i <= (meio - ini); i++) {
            A[i] = v[ini + i];
            //System.out.print(A[i] + " ");
        }
        //System.out.println();
        for (int i = 0; i <= (fim - meio -1); i++) {
            B[i] = v[meio+1 + i];
            //System.out.print(A[i] + " ");
        }

        //System.out.println();

        int i = 0, j = 0;
        for (int k = ini; k <= fim; k++) {
            if (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    v[k] = A[i++];
                } else {
                    v[k] = B[j++];
                }
            } else if (i < A.length) {
                v[k] = A[i++];
            } else if (j < B.length) {
                v[k] = B[j++];
            }
        }
        return;
    }
}
