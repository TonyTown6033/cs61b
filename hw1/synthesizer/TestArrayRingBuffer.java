package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);
        assertTrue(arb.isEmpty());
        arb.enqueue(5.2); //5.2
        arb.enqueue(15.1); //5.2 15.1
        arb.enqueue(2.1);  //5.2 15.1 2.1
        assertFalse(arb.isFull());
        arb.enqueue(1.2);  //5.2 15.1 2.1 1.2
        assertTrue(arb.isFull());
        double value = arb.dequeue();
        assertEquals(5.2,value,0.0001);
        value = arb.dequeue();
        assertEquals(15.1,value,0.00001);
    }

    @Test
    public void test2(){
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);
        while (!arb.isFull()){
            arb.enqueue(2.2);
        }
        assertTrue(arb.isFull());
        while (!arb.isEmpty()){
            arb.dequeue();
        }
        assertTrue(arb.isEmpty());

    }

    @Test
    public void test3(){
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(4);
        double noise = 0.0;
        while(!arb.isFull()){
            arb.enqueue(noise);
            noise += 1.0 ;
        }
        for(double t : arb){
            System.out.println(t);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
