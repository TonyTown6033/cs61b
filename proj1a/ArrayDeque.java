public class ArrayDeque<T> {

    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque(){

        items =(T[]) new Object[8];
        nextFirst = 2;
        nextLast = 3;
        size = 0;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }


    public void addLast(T x){
        extend();
        size += 1;
        items[nextLast] = x;
        nextLast = (nextLast+1)%items.length;
    }

    public void addFirst(T x){
        extend();
        size += 1;
        items[nextFirst] = x;
        nextFirst = (nextFirst - 1 + items.length)%items.length;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i=0;
        int pos = this.nextFirst+1;
        while (i<size){
            System.out.print(items[pos]+" ");
            pos = (pos+1)%items.length;
            i++;
        }
        System.out.println();
    }

    public T removeFirst(){
        cut();
        if(this.isEmpty()){
            return null;
        }
        nextFirst = (nextFirst + 1 )%items.length;
        size--;
        return items[nextFirst];
    }

    public T removeLast(){
        cut();
        if(this.isEmpty()){
            return null;
        }
        nextLast = (nextLast - 1 + items.length) % items.length;
        size--;
        return items[nextLast];
    }

    public T get(int index){
        if(index<0 || index > items.length - 1){
            return null;
        }
        return items[(nextFirst + 1+index)%items.length];
    }

    private boolean isFull(){
        if(size==items.length){
            return true;
        }
        return false;
    }
    private void resize(int capacity){
        T[] a = (T[])new Object[capacity];
        int start = a.length/4;
        int end = start + this.size+1;
        for(int i =0;i<this.size;i++){
            int pos = (start + i + 1)%a.length;
            a[pos] = this.get(i);

        }
        items = a;
        this.nextFirst = start;
        this.nextLast = end;
    }
    private void extend(){
        if(this.isFull()){
            resize(items.length*2);
        }
    }

    private void cut(){
        double load_exponet =(double) size / items.length;
        if(load_exponet < 0.25){
            resize(items.length/2);
        }

    }
}