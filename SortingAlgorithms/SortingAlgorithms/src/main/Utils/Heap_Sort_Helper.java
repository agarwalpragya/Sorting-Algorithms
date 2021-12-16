package main.Utils;

/* Heap sort implementation */

public class Heap_Sort_Helper {
	/* Heapify function */
	public	void helper(int arrA[], int totalElem, int x) {
		
		subtreeHelper(arrA,  totalElem,  x); /* Calling function to sort unsorted array using Heap Sort */
	}
	/* Swapping current greatest value with new greatest value */
	public void swapElements(int arrA[], int x, int greatestElem) { 
		int temp = arrA[x];
		arrA[x] = arrA[greatestElem];
		arrA[greatestElem] = temp;		
	}
	public void subtreeHelper(int arrA[], int totalElem, int x){
		int greatestElem = x; /* Initially taking root value as greatest value */
		int leftElem = 2 * x; /* Storing left sub-tree node */
		int rightElem = 2 * x + 1; /* Storing right sub-tree node */

		if (leftElem <= totalElem-1 && arrA[leftElem] > arrA[greatestElem]) /* Checking if left sub-tree node is greater than greatest element */
		{
			greatestElem = leftElem;
		}

		if (rightElem <= totalElem-1 && arrA[rightElem] > arrA[greatestElem]) /* Checking if right sub-tree node is greater than greatest element */
		{
			greatestElem = rightElem;
		}

		if (greatestElem != x) /* Comparing if value of initial greatest value has changed or not. If changed update greatest value. */
		{
			swapElements(arrA,x,greatestElem);
			subtreeHelper(arrA, totalElem, greatestElem);
		}
	}

	public void sortArray(int arrA[]) {
		int array_length = arrA.length;

		/* Build the heap */
		for (int x = array_length / 2 - 1; x >= 0; x--)
		{
			subtreeHelper(arrA, array_length, x);
		}

		for (int x = array_length-1; x > 0; x--) 
		{
			int temp = arrA[0];
			arrA[0] = arrA[x];
			arrA[x] = temp;

			subtreeHelper(arrA, x, 0);
		}
	}
}