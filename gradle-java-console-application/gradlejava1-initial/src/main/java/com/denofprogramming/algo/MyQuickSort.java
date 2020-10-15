package com.denofprogramming.algo;


import java.util.Arrays;
import java.util.List;

public class MyQuickSort {

    public static void main (String[] args) {
        int[] arr = {2, 5, 3, 9, 6, 1, 4, 8};
        for (int i : arr) {
            System.out.println(i);
        }
        MyQuickSort sort = new MyQuickSort();
        sort.sort(arr, 0, arr.length-1);

        System.out.println("sorted: " + Arrays.asList(arr).toString());
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotPosition = partition2(arr, low, high);
            sort(arr, low, pivotPosition -1);
            sort(arr, pivotPosition + 1, high );
        }
    }

    // https://www.youtube.com/watch?v=7h1s2SojIRw
    public int partition2(int[] a, int l, int h) {
        int i = l;
        int j = h-1;
        int p = a[h];

        while (i < j) {
            while (a[i] < p) {
                i++;
//                if (i>h-1) break;
            }
            while (a[j] > p ) {
                j--;
                if (j<0) break;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, j+1, h);

        return j+1;
    }

    // return pivot position
    public int partition(int[] arr, int low, int high) {

        int i = low - 1;    // < i: lower than pivot value
        int j = low;        // < i+1 to j: larger than pilot value
        int pivot = arr[high];

        while (arr[j] < pivot) {
            j++;
        }
        i = j -1;

        while (j < high) {
            if (arr[j] > pivot) {
                j++;
            } else {
                i++;
                swap(arr, i, j);
                j++;
            }
        }

        // swap the pivot with the first one in the larger partition
        swap(arr, i+1, j);

        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
