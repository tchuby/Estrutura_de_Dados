package TchubyLinkedList;

public class Node {
    private Integer information;
    private Node next;

    public Node(){
        this.next = null;
        this.information = null;
    }

    public Node(Integer information, Node next){
        this.setInformation(information);
        this.setNext(next);
    }

    public Integer getInformation(){
        return this.information;
    }

    public void setInformation(Integer information){
        this.information = information;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
