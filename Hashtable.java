public class Hashtable {

    Node[] buckets;


    Hashtable(){
        buckets = new Node[2027];
    }


    boolean containsKey(String key) {
        if (key==null){
            return false;
        }
        int hashcode = java.lang.Math.abs(key.hashCode());
        int index = hashcode%buckets.length;
        try {
            String v = buckets[index].key;
            if (v==key){
                return true;
            }
            return (containsKey(v));
        }
        catch (NullPointerException e){
            return false;
        }
    }
    String get(String key){
        int hashcode = java.lang.Math.abs(key.hashCode());
        int index = hashcode%buckets.length;
        Node x = buckets[index];
        while (x.key!=key&&x!=null){
            x=x.next;
        }
        if (x==null){
            return null;
        }
        String v = x.value;
        return v;
    }

    void put(String key, String value){
        int hashcode = java.lang.Math.abs(key.hashCode());
        int index = hashcode%buckets.length;
        if (buckets[index]==null){
            buckets[index] = new Node(key,value, buckets[index]);
        }
        else{
            Node temp =buckets[index];
            buckets[index] = new Node(key,value, buckets[index]);
            buckets[index].next=temp;
        }


    }
    String remove(String key){
        int hashcode = java.lang.Math.abs(key.hashCode());
        int index = hashcode%buckets.length;
        Node n = buckets[index];
        while (n.key!=key&&n!=null){
            n=n.next;
        }
        if (n==null){
            throw new NullPointerException();
        }
        String v = n.value;
        buckets[index]= remove(buckets[index], key);
        return v;
    }

    Node remove(Node n, String key){
        Node temp = n;
        if (temp.key.equals(key)){
            return temp.next;
        }
        if (temp==null){
            return null;
        }
        return remove(n.next,key);
    }



}
