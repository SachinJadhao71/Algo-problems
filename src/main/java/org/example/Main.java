package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arr[] = {1,4,7,1,1,5,3,4};

        System.out.println("Original Array : " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
    public static void mergeSort(int arr[]){

        if(arr.length <= 1) return;

        int middle = arr.length/2;
        int left[] = new int[middle];

        int right[] = new int[arr.length - middle];

        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }

        for (int i = middle; i < arr.length; i++) {
            right[i-middle] = arr[i];
        }

//        call for left and right
        mergeSort(left);
        mergeSort(right);

//        merge both the array

        mergeBoth(arr,left,right);
    }
    public static void mergeBoth(int arr[], int left[], int right[]){


        int i=0,j=0,k=0;

        while(i < left.length && j < right.length){

            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }
            else{
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        if(i==left.length){
            while(j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        if(j==right.length){
            while(i < left.length){
                arr[k] = left[i];
                i++;
                k++;
            }
        }
    }
}