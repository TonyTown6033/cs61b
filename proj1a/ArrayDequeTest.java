import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
    @Test
    public void addLastTest(){
        ArrayDeque<Integer> p = new ArrayDeque<Integer>();
        int i;
        for(i=0;i<8;i++){
            p.addLast(i);
        }
        int[] expected = new int[]{5,6,7,0,1,2,3,4};

    }
    @Test
    public void addFirstTest(){
        ArrayDeque<Integer> p = new ArrayDeque<Integer>();
        int i;
        for(i=0;i<8;i++){
            p.addFirst(i);
        }
        int[] expected = new int[]{2,1,0,7,6,5,4,3};
        p.printDeque();

    }

    @Test
    public void removeTest(){
        ArrayDeque<Integer> p = new ArrayDeque<Integer>();
        int i;
        for(i=0;i<8;i++){
            p.addLast(i);
        }


        int temp1 = p.removeFirst();
        int temp2 = p.removeLast();
        int temp3 = p.get(3);
        p.printDeque();


    }

    @Test
    public void extendTest() {
        ArrayDeque<Integer> p = new ArrayDeque<Integer>();
        int i;
        for (i = 0; i < 10; i++) {
            p.addLast(i);
        }

        for(i = 0;i<9;i++){
            p.removeFirst();
        }
    }


    }