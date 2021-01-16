package heap;

public class HeapMain {

    public static void main(String[] argv) {
        int[] input = {5, 8, 7, 1, 9, 2, 4, 3};

        MaxHeap maxHeap = new MaxHeap(input);

        System.out.println(maxHeap);

        int  r = -1;
        do {
            r = maxHeap.poll();
            System.out.println(r);
        } while (r != -1);

    }
}
