public class LinkedListDeque<T> {
    private class Node{
        public T items;
        public Node before;
        public Node next;

        public Node(T i,Node af,Node be){
            items = i;
            next = af;
            before = be;
        }
    }
    private Node sentinel_head;
    private Node first;
    private Node sentinel_tail ;
    private int size;

    public LinkedListDeque(){
        sentinel_head = new Node(null,null,null);
        sentinel_tail = new Node(null,null,null);
        sentinel_head.next  = sentinel_tail;
        sentinel_tail.before = sentinel_head;
        size = 0;
    }

    public void addFirst(T item){
        size += 1;
        Node ptr = sentinel_head.next;
        sentinel_head.next = new Node(item,sentinel_head.next,sentinel_head);
        ptr.before = sentinel_head.next;
    }

    public void addLast(T item){
        size += 1;
        Node ptr = sentinel_tail.before;
        sentinel_tail.before = new Node(item,sentinel_tail,sentinel_tail.before);
        ptr.next = sentinel_tail.before;
    }

    public boolean isEmpty(){
        if(sentinel_head.next.next==null){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
       if(this.isEmpty()){
           return;
       }
       Node data = this.sentinel_head.next;
       int i = 0;
       while(i<this.size()){
           System.out.print(data.items+" ");
           data = data.next;
           i++;
       }
    }

    public T removeFirst(){
        size--;
        if(this.isEmpty()){
            return null;
        }
        Node first = this.sentinel_head.next;
        T backValue = first.items;
        Node second = first.next;
        first = null;
        this.sentinel_head.next = second;
        second.before = this.sentinel_head;
        return backValue;
    }

    public T removeLast(){
        size--;
        if(this.isEmpty()){
            return null;
        }
        Node last = this.sentinel_tail.before;
        T backValue = last.items;
        Node secode2last = last.before;
        last = null;
        this.sentinel_tail.before = secode2last;
        secode2last.next = this.sentinel_tail;
        return backValue;
    }

    public T get(int index){
        if(index < 0 || index >this.size()){
            return null;
        }
        Node ptr = this.sentinel_head.next;
        int i = 0;
        while(i<index){
            ptr = ptr.next;
            i++;
        }
        return ptr.items;
    }

    /** there is some err
    public T getRecursive(int index){
        if(index < 0 || index >this.size()){
            return null;
        } else if (index==0) {
            return this.sentinel_head.next.items;
        }
        this.removeFirst();
        return getRecursive(index-1);
    }

    */

    public T getRecursive(int index){
        return null;
    }


}