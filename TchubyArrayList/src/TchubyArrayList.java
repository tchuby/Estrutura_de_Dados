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
    public boolean add(Integer value){
        if(this.isFull()){
            return false;
        }
        else if(resizable){
            resizeArrayList();
        }

        array[this.counter] = value;

        this.counter++;

        return true;
    }

    public boolean add(int index, Integer value){
        return true;
    }

    private void resizeArrayList(){
        var arraySize = array.length;

        Integer[] newSizeArray = new Integer[arraySize + this.X];

        for(int i = 0; i < array.length; i++){
            newSizeArray[i] = this.array[i];
        }

        array = newSizeArray;
    }

    public Integer remove(int indice){
        if(indice < 0 || indice >= counter){
            return null;
        }
        var valorRemovido = array[indice];

        counter--;

        for(; indice < counter; indice++){
            array[indice] = array[indice + 1];
        }

        return valorRemovido;
    }

    public boolean removeFirst(Integer number){
        for(int i = 0; i < counter; i++){
            if(array[i].equals(number)){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public Integer get(int indice){
        if(indice >= 0 && indice < this.counter){
            return this.array[indice];
        }

        return null;
    }

    public void clear(){
        this.counter = 0;

        if(resizable)
            this.array = new Integer[this.initialCapacity];
    }

    public Integer set(int index, Integer number){
        if(index >= counter || index < 0){
            return null;
        }

        var replaced = array[index];

        array[index] = number;

        return replaced;
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

    public boolean contains(){
        return false;
    }

    public int indexOf(Integer object){
        return 0;
    }

    public int lastIndexOf(Integer object){
        return 0;
    }

    public Integer[] toArray(){
        Integer novoArray[] = new Integer[10];
        return novoArray;
    }

    @Override
    public String toString(){
        var saida = "";
        for(int i = 0; i < counter; i++){
            saida += array[i] + " ";
        }
        return saida;
    }
}
