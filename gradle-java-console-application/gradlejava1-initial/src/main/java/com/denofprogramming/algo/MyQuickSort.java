package com.denofprogramming.algo;


import java.util.Arrays;
import java.util.List;

public class MyQuickSort {

    public static void main (String[] args) {
//        int[] arr = {2, 5, 3, 9, 6, 1, 4, 8};
        int[] arr = {2, 5, 3, 9, 1, 6, 4, 8};
        for (int i : arr) {
            System.out.println(i);
        }
        MyQuickSort sort = new MyQuickSort();


        int n = 1;
        int position = arr.length-n;
        int v = sort.nthLargest(arr, 0, arr.length-1, position);
        System.out.println(n + "th largest value: " + v);

        sort.sort(arr, 0, arr.length-1);
        System.out.println("sorted: " + Arrays.asList(arr).toString());
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public int nthLargest(int[] arr, int l, int h, int p) {

        int returnVal = -1;

        int pivotPosition = partition2(arr, l, h);
        if (pivotPosition < p) {
            returnVal = nthLargest(arr, pivotPosition + 1, h, p);
        } else if (pivotPosition > p){
            returnVal = nthLargest(arr, l, pivotPosition - 1, p);
        } else {
            returnVal = arr[pivotPosition];
        }

        return returnVal;
    }

    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotPosition = partition(arr, low, high);
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
                // no need, since a[h] is p
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
    // {2, 5, 3, 9, 1, 6, 4, 8}
    public int partition(int[] arr, int l, int h) {

        int i = l - 1;    // < i: lower than pivot value
        int j = l;        // < i+1 to j: larger than pilot value
        int pivot = arr[h];

        while (j < h) {
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
