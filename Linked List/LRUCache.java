
/*
Prob.: LRU Cache
Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

PUT x y: sets the value of the key x with value y
GET x: gets the key of x if present else returns -1.
The LRUCache class has two methods get() and put() which are defined as follows.

get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
put(key, value): if the key is already present, update its value. If not present, add 
the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
In the constructor of the class the capacity of the cache should be initialized.
*/


class Node
{
    int key;
    int value;
    Node next;
    Node prev;
    
    public Node(int key,int val)
    {
        this.key=key;
        value=val;
        next=null;
        prev=null;
    }
}
class LRUCache {
    
    static int cap;
    static HashMap<Integer,Node> cache;
    static Node head;
    static Node tail;
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // code here
        this.cap=cap;
        cache=new HashMap<>();
        head=new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        // your code here
        if(!cache.containsKey(key))
        {
            return -1;
        }
        //Take the value Node of the key
        Node temp=cache.get(key);
        //remove it and again add it to place it in first position 
        remove(temp);
        add(temp);
        return temp.value;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        // your code here
        //if key contains in the map take the node and remove it from ll
        if(cache.containsKey(key))
        {
            Node temp=cache.get(key);
            remove(temp);
        }
        Node newNode=new Node(key,value);
        //Update map
        cache.put(key,newNode);
        //add node to the list
        add(newNode);
        
        //if capacity excede delete least used nide in the tail
        if(cache.size()>cap)
        {
            Node oldNode=tail.prev;
            remove(oldNode);
            cache.remove(oldNode.key);
        }
    }
    
    private static void add(Node node)
    {
        node.next=head.next;
        head.next=node;
        node.next.prev=node;
        node.prev=head;
    }
    private static void remove(Node node)
    {
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }
}
