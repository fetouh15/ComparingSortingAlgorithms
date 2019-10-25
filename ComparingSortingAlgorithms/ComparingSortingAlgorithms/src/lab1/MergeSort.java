/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Youssef
 */
public class MergeSort {

    public long sort(int arr[], int l, int r) {
                long startTime = System.nanoTime();
        if (l < r) {            
            int m = (l + r) / 2;
            
            sort(arr, l, m);
            sort(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }       
        return System.nanoTime() - startTime;
    }

    private void merge(int arr[], int start, int middle, int end) {           
        
        int arr1[] = new int[middle - start + 1];
        int arr2[] = new int[end - middle];                        
        
        for (int i = 0; i < arr1.length; ++i) {
            arr1[i] = arr[start + i];
        }
        for (int j = 0; j < arr2.length; ++j) {
            arr2[j] = arr[middle + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = start;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        
        
        
        
        while (j < arr2.length) {
            arr[k] = arr2[j];
            j++;
            k++;
        } 
    } 
}
