package TchubyLinkedList;

public class TchubyLinkedList {
    private Node first;
    private Node last;
    private int counter;

    public TchubyLinkedList(){
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    public boolean add(Integer value){

        Node node = new Node( value, null);

        if(this.isEmpty()){
            this.first = node;
            this.last = node;
        }
        else{
            this.last.setNext(node);
            this.last = node;
        }
        counter ++;
        return true;
    }

    public void add(int position, Integer value){

    }

    public Integer remove(int position){
        return 0;
    }

    public boolean removeFirst(Integer value){
        return false;
    }

    public Integer get(int value){
        return 0;
    }

    public void clear(){
        this.first = null;
        this.last = null;
        this.counter = 0;
    }

    public Integer set(){
        return 0;
    }

    public int size(){
        return this.counter;
    }

    public boolean isEmpty(){
        if(this.counter > 0)
            return false;

        return true;
    }

    public boolean contains(Integer value){
        Node node = first;
        if(counter == 0){
            return false;
        }
        while(node.getNext() != null){
            if(node.getInformation().equals(value)){
                return true;
            }
            else{
                node = node.getNext();
            }
        }
        
        return false;
    }

    public int indexOf(Integer value){
        return 0;
    }

    public int lastIndexOf(Integer value){
        return 0;
    }

    public Integer[] toArray(){
        return new Integer[0];
    }
}
