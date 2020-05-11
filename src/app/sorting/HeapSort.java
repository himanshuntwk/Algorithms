package app.sorting;

import java.util.Arrays;

/**
 * Class demonstrating Heap sort algorithm.<br>
 * Highest element is sorted first (right to left sorting).
 */
public class HeapSort {
	
	public void sort(int arr[]) {
		int n = arr.length;
		
		//Building max-heap starting from last non-leaf node.
		for(int i=n/2-1; i>=0; i--) {
			heapify(arr,n,i);
		}
		
		//Swapping last element with first and performing heap on reduced array.
		for(int i=n-1; i>=0; i--) {
			int temp =arr[0];
			arr[0]  =arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}	
	/**
	 * 
	 * @param arr - array
	 * @param n - size of heap
	 * @param i - root node
	 */
	public void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2*i + 1;
		int right =2*i + 2;
		
		if(left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if(right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
		HeapSort heapSort = new HeapSort();
    heapSort.sort(arr);
    System.out.println(Arrays.toString(arr));
	}

}
