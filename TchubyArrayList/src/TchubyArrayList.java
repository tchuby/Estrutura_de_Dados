/**
 * Lista com alocação de memória contígua.
 */
public class TchubyArrayList {
    private Integer[] array;
    private boolean resizable;
    private int initialCapacity;
    private int counter;
    private final static int X = 10;

    public TchubyArrayList(){
        this.initialCapacity = this.X;
        this.counter = 0;
        this.array = new Integer[this.X];
    }

    public TchubyArrayList(boolean isResizeble){
        this.initialCapacity = this.X;
        this.counter = 0;
        this.array = new Integer[this.X];
        this.resizable = isResizeble;
    }

    /**
     * Adiciona o elemento passado por parâmetro ao final da lista. Caso
     * a lista seja redimensionável faz a chamada para o método responsável
     * por redimensionar o array.
     * Retorna verdadeiro se foi possível e falso se não foi possível
     * adicioná-lo.
     */
    public boolean add(Integer valor){
        if(this.isFull()){
            return false;
        }
        else if(resizable){
            resizeArrayList();
        }

        array[this.counter] = valor;

        this.counter++;

        return true;
    }

    public boolean add(int indice, Integer valor){
        //Continuar, ainda não foram cobertos todos
        //os possíveis cenários;

        if(this.isFull()){
            return false;
        }
        else if(resizable){
            resizeArrayList();
        }
        else if(indice < 0 || indice >= array.length){
            return false;
        }

        int auxiliar = counter + 1;

        for(; auxiliar > indice; auxiliar--){
            this.array[auxiliar] = this.array[auxiliar - 1];
        }

        array[indice] = valor;

        this.counter++;

        return true;
    }

    private void resizeArrayList(){
        int arraySize = array.length;

        Integer[] newSizeArray = new Integer[arraySize + this.X];

        for(int i = 0; i < array.length; i++){
            newSizeArray[i] = this.array[i];
        }

        array = newSizeArray;
    }

    public Integer remove(int indice){
        if(!validarIndice(indice)){
            return null;
        }
        Integer valorRemovido = array[indice];

        counter--;

        for(; indice < counter; indice++){
            array[indice] = array[indice + 1];
        }

        return valorRemovido;
    }

    public boolean removeFirst(Integer valor){
        for(int i = 0; i < counter; i++){
            if(array[i].equals(valor)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public Integer get(int indice){
        if(validarIndice(indice)){
            return this.array[indice];
        }

        return null;
    }

    public void clear(){
        this.counter = 0;

        if(resizable)
            this.array = new Integer[this.initialCapacity];
    }

    public Integer set(int indice, Integer number){
        if(!validarIndice(indice)){
            return null;
        }

        Integer alterado = array[indice];

        array[indice] = number;

        return alterado;
    }

    public int size(){
        return this.counter;
    }

    public boolean isEmpty(){
        return this.counter == 0;
    }

    public boolean isFull(){
        if(resizable){
            return false;
        }
        else{
            return counter == array.length;
        }
    }

    public boolean contains(Integer valor){
        for(int i = 0; i < counter; i++){
            if(array[i].equals(valor)){
                return true;
            }
        }
        return false;
    }

    public int indexOf(Integer valor){
        for(int i = 0; i < counter; i++){
            if(array[i].equals(valor)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Integer valor){
        for(int i = counter; i >= 0; i--){
            if(array[i].equals(valor)){
                return i;
            }
        }
        return -1;
    }

    public Integer[] toArray(){
        Integer novoArray[] = new Integer[10];
        return novoArray;
    }

    @Override
    public String toString(){
        String saida = "";
        for(int i = 0; i < counter; i++){
            saida += array[i] + " ";
        }
        return saida;
    }

    private boolean validarIndice(int index){
        if(index >= counter || index < 0){
            return false;
        }
        return true;
    }
}
