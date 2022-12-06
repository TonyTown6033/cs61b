public class myLinkText {
    public static void addFirstTest(){
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addFirst(5);
        p.addFirst(4);
        p.addFirst(3);
    }

    public static void addLastTest(){
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
    }

    public static void isEmptyTest() {
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        if (p.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("not empty");

        }
    }

    public static void printDequeTest(){
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
        p.printDeque();
    }

    public static void removeFirstTest(){
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
        int x = p.removeFirst();
        System.out.println(x);
    }

    public static void removeLastTest(){
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
        int x = p.removeLast();
        System.out.println(x);
    }

    public static void  getTest(){
        LinkedListDeque<Integer> p = new LinkedListDeque<>();
        p.addLast(1);
        p.addLast(2);
        p.addLast(3);
        System.out.println(p.get(3));
    }
    public static void main(String[] args) {
        getTest();
    }
}