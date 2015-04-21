package com.company;

/**
 * Created by Katherine on 4/20/2015.
 */
public class Sorting {

    static int[] heapSort(int [] arr){
        int numItems = arr.length;
        int position = (numItems-2)/2;
        int temp;

        while (position != 0){
            //if the current node's left subchild is larger, siftdown
            if (arr[position] < arr[position*2+1]){
                temp = arr[position];
                arr[position] = arr[position*2+1];
                arr[position*2+1] = temp;
            }
            //if the current node's right subchild is larger, siftdown
            else if (arr[position] < arr[position*2+2]) {
                temp = arr[position];
                arr[position] = arr[position * 2 + 2];
                arr[position * 2 + 2] = temp;
            }
            position--;
        }

        return arr;
    }

    static int[] quickSort(int [] arr){
        int[] no = {0};
        return no;
    }

    static int[] mergeSort(int [] arr){
        int[] no = {0};
        return no;
    }
}
