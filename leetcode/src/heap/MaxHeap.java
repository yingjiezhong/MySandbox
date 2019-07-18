package heap;

public class MaxHeap implements IHeap{

    private int[] queue;

    public MaxHeap(int[] input) {
        queue = input.clone();
        initialize();
    }

    // heapify the initial array

    /**
     * from half of the array go backwards
     */
    private void initialize() {

    }

    private int parentIndex(int index) {
        return (index-1)/2;
    }

    private int leftChild(int index) {
        return index*2+1;
    }

    /**
     *      0
     *    1    2
     *  3   4 5  6
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index*2+2;
    }

    @Override
    public int poll() {
        return 0;
    }

    @Override
    public void add(int e) {

    }
}
