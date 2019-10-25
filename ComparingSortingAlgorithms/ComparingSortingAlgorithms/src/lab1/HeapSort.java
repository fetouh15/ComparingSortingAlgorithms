/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.Arrays;

/**
 *
 * @author fetouh
 */
public class HeapSort {

    private int heapsize;

    public HeapSort(int heapsize) {
        this.heapsize = heapsize;
    }

    private void maxHeapify(int[] C, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int max;
        if (hasleft(i)) {
            if (hasright(i)) {
                if (C[right] > C[left]) {
                    max = C[right];
                    if (max > C[i]) {
                        C[right] = C[i];
                        C[i] = max;
                        maxHeapify(C, right);
                    }
                }
            }
            max = C[left];
            if (max > C[i]) {
                C[left] = C[i];
                C[i] = max;
                maxHeapify(C, left);
            }
        }
    }

    private boolean hasleft(int i) {
        int left = i * 2 + 1;
        if (left <= heapsize - 1) {
            return true;
        } else {
            return false;
        }

    }

    private boolean hasright(int i) {
        int right = i * 2 + 2;
        if (right <= heapsize - 1) {
            return true;
        } else {
            return false;
        }

    }

    public void build(int C[]) {
        for (int i = (heapsize - 1) / 2; i >= 0; i--) {
            maxHeapify(C, i);
        }

    }

    public long heapSort(int[] arr) {
                long startTime = System.nanoTime();

        build(arr);

        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapsize--;
            // call max heapify on the reduced heap
            maxHeapify(arr, 0);
        }
        return (System.nanoTime() - startTime);
    }

}
