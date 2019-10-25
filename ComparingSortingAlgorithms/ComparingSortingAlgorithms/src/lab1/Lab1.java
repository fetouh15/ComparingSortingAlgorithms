/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author fetouh
 */
public class Lab1 {

    static int[] generateDataSet(int size) {
        int[] random = new int[size];

        for (int i = 0; i < random.length; i++) {
            random[i] = (int) (1 + Math.random() * 10000);
        }
        return random;
    }

    static void writeRandomToFile(File file, int size) throws IOException {

        //try with resources to automatically close files
        try (
                FileWriter writer = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(writer);) {

            int[] arr = generateDataSet(size);

            //Loop to write to file           
            for (int i = 0; i < arr.length; i++) {
                printWriter.println(arr[i]);
            }
        }
    }

    static void saveArray(File file, int size, int[] arr) throws IOException {

        //try with resources to automatically close files
        try (
                FileWriter writer = new FileWriter(file);
                PrintWriter printWriter = new PrintWriter(writer);) {

            //Loop to write to file           
            for (int i = 0; i < arr.length; i++) {
                printWriter.println(arr[i]);
            }
        }
    }

    static void test(File file, int size,int testNumber) throws FileNotFoundException, IOException {

        //try with resources to automatically close files
        try (
                BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
                BufferedReader bufferedReader4 = new BufferedReader(new FileReader(file));
                BufferedReader bufferedReader5 = new BufferedReader(new FileReader(file));
                BufferedReader bufferedReader6 = new BufferedReader(new FileReader(file));) {
            File file11 = new File("SortedArray/datasorted1t"+testNumber+".txt");
            File file12 = new File("SortedArray/datasorted2t"+testNumber+".txt");
            File file13 = new File("SortedArray/datadorted3t"+testNumber+".txt");
            File file14 = new File("SortedArray/datasorted4t"+testNumber+".txt");
            File file15 = new File("SortedArray/datasorted5t"+testNumber+".txt");
            File file16 = new File("SortedArray/datasorted6t"+testNumber+".txt");

            int arr[] = new int[size];

            //Loop to read from file
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(bufferedReader1.readLine());
            }
            HeapSort heap = new HeapSort(size);
            long heapSortTime = heap.heapSort(arr);

            //Display sort time
            System.out.println("Heap Sort: " + heapSortTime + " ns");
            saveArray(file11, arr.length, arr);
            //Loop to read from file
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(bufferedReader2.readLine());
            }
            MergeSort mergeSort = new MergeSort();
            long mergeSortTime = mergeSort.sort(arr, 0, arr.length - 1);

            //Display sort time
            System.out.println("Merge Sort: " + mergeSortTime + " ns");
            saveArray(file12, arr.length, arr);
            //Loop to read from file
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(bufferedReader3.readLine());
            }

            QuickSort QS = new QuickSort();
            long quickSortTime = QS.quickSort(arr, 0, arr.length - 1);

            //Display sort time
            System.out.println("Quick Sort: " + quickSortTime + " ns");
            saveArray(file13, arr.length, arr);
            //Loop to read from file
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(bufferedReader4.readLine());
            }

            InsertionSort insertionSort = new InsertionSort();
            long insertionSortTime = insertionSort.sort(arr);

            //Display sort time
            System.out.println("Insertion Sort: " + insertionSortTime + " ns");
            saveArray(file14, arr.length, arr);
            //Loop to read from file
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(bufferedReader5.readLine());
            }

            SelectionSort SS = new SelectionSort();
            long selectionSortTime = SS.sort(arr);

            //Display sort time
            System.out.println("Selection Sort: " + selectionSortTime + " ns");
            saveArray(file15, arr.length, arr);
            //Loop to read from file
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(bufferedReader6.readLine());
            }

            BubbleSort bubbleSort = new BubbleSort();
            long bubbleSortTime = bubbleSort.sort(arr);

            //Display sort time
            System.out.println("Bubble Sort: " + bubbleSortTime + " ns");
            saveArray(file16, arr.length, arr);
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        File file1 = new File("dataset1.txt");
        File file2 = new File("dataset2.txt");
        File file3 = new File("dataset3.txt");
        File file4 = new File("dataset4.txt");
        File file5 = new File("dataset5.txt");

        //To create the files with random inputs of size 10000
//        Files are already created...        
//        writeRandomToFile(file1, 1000000);
//        writeRandomToFile(file2, 1000000);
//        writeRandomToFile(file3, 1000000);
//        writeRandomToFile(file4, 1000000);
//        writeRandomToFile(file5, 1000000);
        System.out.println("Test1: ");
        test(file1, 100,1);

        System.out.println("\n\nTest2: ");
        test(file2, 1000,2);

        System.out.println("\n\nTest3: ");
        test(file3, 10000,3);

        System.out.println("\n\nTest4: ");
        test(file4, 100000,4);

        System.out.println("\n\nTest5: ");
        test(file5, 1000000,5);
    }

}
