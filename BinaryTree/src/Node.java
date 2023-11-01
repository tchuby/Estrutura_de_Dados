public class Node {
    private Integer info;
    private Node left;
    private Node right;

    public Node(){
        this(null, null, null);
    }

    public Node(Integer info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
