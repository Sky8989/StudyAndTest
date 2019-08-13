package com.datastructure.array.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,3,4,5,2,1};

        System.out.println("排序前 =" + Arrays.toString(arr));
        int[] res = bubbleSortDsc(arr);
        System.out.println("排序后 =" + Arrays.toString(res));
        int[] res1 = bubbleSortDesc(arr);
        System.out.println("排序后 =" + Arrays.toString(res1));
    }

    private static int[] bubbleSortDesc(int[] arr) {
        for(int i = 0; i <= arr.length-1; i++){
          //  System.out.println(i);
            for (int j = i + 1; j < arr.length; j++){
           //     System.out.print(j);
                if(arr[i] < arr[j]){
                    swap(arr,i,j);
                }
            }
         //   System.out.println();
        }
        return arr;
    }

    private static int[] bubbleSortDsc(int[] arr) {

        for(int i = 0; i <= arr.length-1; i++){
           // System.out.println(i);
            for (int j = i + 1; j < arr.length; j++){
             //   System.out.print(j);
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
            //System.out.println();
        }

        return arr;
    }

    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
