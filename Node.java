public class Node {

    Node next;
    String key;
    String value;

    public Node(String key, String value, Node next){
        this.key=key;
        this.value=value;
        this.next=next;
    }

    public void setData(String key, String value){
        this.key=key;
        this.value=value;
    }
    public void setNext(Node next){
        this.next=next;
    }

}
