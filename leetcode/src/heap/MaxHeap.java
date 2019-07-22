package heap;

import java.util.ArrayList;
import java.util.List;

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

        for (int i = queue.length/2; i >= 0; i--) {
            if (queue.length -1 >= leftChild(i)) {
                int larger;

                if (queue.length -1 < rightChild(i)) {
                   larger = leftChild(i);
                } else {
                    try {
                        larger = queue[leftChild(i)] > queue[rightChild(i)] ? leftChild(i) : rightChild(i);
                    } catch (Exception e) {
                        System.out.println("exception");
                        throw e;
                    }
                }

                if (queue[larger] > queue[i]) {
                    swap(larger, i);
                }
            }
        }

    }

    private void swap(int i, int j) {
        int t = queue[i];
        queue[i] = queue[j];
        queue[j] = t;
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
        int ret = queue[0];
        System.arraycopy(queue, 0, queue, 0, queue.length-1);
        queue[0] = queue[queue.length-1];
        heapify();
        return ret;
    }

    private void heapify() {

        int index = 0;
        while(true) {

        }
    }

    @Override
    public String toString() {
        List<Integer> list = new ArrayList<>();

        for (int i : queue) {
            list.add(i);
        }

        return list.toString();
    }

    @Override
    public void add(int e) {

    }
}
