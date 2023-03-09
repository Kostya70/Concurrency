public class Counter {
    private int  value;
    private int  value2;

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();

    public synchronized void inc(){
        value++;
    }

    public synchronized void dec(){
        value--;
    }

    public int getValue() {
        return value;
    }

    public synchronized void inc2(){
        value++;
    }

    public synchronized void dec2(){
        value--;
    }

    public int getValue2() {
        return value;
    }
}
