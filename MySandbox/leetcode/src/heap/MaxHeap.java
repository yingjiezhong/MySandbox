package heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap implements IHeap{

    private int[] queue;

    public MaxHeap(int[] input) {
        queue = input.clone();
        initialize2();
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

                    // do more to send the node down




                }
            }
            System.out.println("iteration " + i);
            System.out.println(this);
        }

    }

    private void initialize2() {

        for (int i = queue.length/2; i >= 0; i--) {
            heapify(i);
            System.out.println("iteration " + i);
            System.out.println(this);
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
        if (queue != null && queue.length > 1) {
            int ret = queue[0];
            int[] q1 = new int[queue.length - 1];
            System.arraycopy(queue, 0, q1, 0, queue.length - 1);
            q1[0] = queue[queue.length - 1];
            queue = q1.clone();
            heapify(0);
            return ret;
        } else if (queue != null && queue.length == 1){
            int ret = queue[0];
            queue = null;
            return ret;
        } else {
            return -1;
        }
    }

    /**
     * sending the indexed node down if needed
     */
    private void heapify(int index) {

        while(true) {
            int lc = leftChild(index);
            int rc = rightChild(index);
            if (lc > queue.length-1) {
                break;
            } else if (rc > queue.length -1){
                if (queue[index] < queue[lc]) {
                    swap(index, lc);
                    index = lc;
                } else {
                    break;
                }
            } else {
                if (queue[lc] > queue[rc]) {
                    if (queue[index] < queue[lc]) {
                        swap(index, lc);
                        index = lc;
                    } else {
                        break;
                    }
                } else {
                    if (queue[index] < queue[rc]) {
                        swap(index, rc);
                        index = rc;
                    } else {
                        break;
                    }
                }
            }

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
