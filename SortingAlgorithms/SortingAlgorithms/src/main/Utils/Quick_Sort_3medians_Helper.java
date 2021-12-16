package main.Utils;

/* Quick sort using 3 medians implementation */

public class Quick_Sort_3medians_Helper {

	public void sort(int[] arrA, int start_indx, int end_indx) {
		sortUnsortedArray(arrA, start_indx, end_indx); /* Calling function to sort unsorted array using Quick sort using 3 medians */
	}
	
	/*Recursive call for implementing Quick sort using 3 medians*/
	public void sortUnsortedArray(int[] arrA, int start_indx, int end_indx) {
		int arrA_length = end_indx - start_indx + 1;
		if (arrA_length <= 3) /* If size of array is less than or equal to 3 then manually sort the array */
		{
			smallSort(arrA, start_indx, end_indx);
		}
		else 
		{
			double arrayMedian = findMedian(arrA, start_indx, end_indx); /* Calling function to choose median of first, middle and last elements */
			int partition = partitionArray(arrA, start_indx, end_indx, arrayMedian); /* Partition array based on pivot */
			sortUnsortedArray(arrA, start_indx, partition - 1); /* Recursively calling sortArray function on first partition */
			sortUnsortedArray(arrA, partition + 1, end_indx); /* Recursively calling sortArray function on second partition */
		}
		
	}
	
	/* Function for array size less than or equal to 3*/
	public void smallSort(int[] arrA, int start_indx, int end_indx) {
		int arrA_length = end_indx - start_indx + 1;
		if (arrA_length <= 1) /* Array size less than equal to 1*/
		{
			return;
		}
		if (arrA_length == 2) /* Array size less than equal to 2*/
		{
			if (arrA[start_indx] > arrA[end_indx])
				swapElements(arrA, start_indx, end_indx);
			return;
		} else /* Array size less than equal to 3*/
		{
			if (arrA[start_indx] > arrA[end_indx - 1])
			{
				swapElements(arrA, start_indx, end_indx - 1);
			}
			if (arrA[start_indx] > arrA[end_indx])
			{
				swapElements(arrA, start_indx, end_indx);
			}
			if (arrA[end_indx - 1] > arrA[end_indx])
			{
				swapElements(arrA, end_indx - 1, end_indx);
			}
		}
	}
	
	/* Finding median */
	public int findMedian(int[] arrA, int start_indx, int end_indx) {
		int mid_element = (start_indx + end_indx) / 2; /* Finding middle element */

		/* Comparing start, middle and end values. Placing lowest value at starting position and highest value in middle. choose median value as pivot. */
		if (arrA[start_indx] > arrA[mid_element])
		{
			swapElements(arrA, start_indx, mid_element);
		}

		if (arrA[start_indx] > arrA[end_indx])
		{
			swapElements(arrA, start_indx, end_indx);
		}

		if (arrA[mid_element] > arrA[end_indx])
		{
			swapElements(arrA, mid_element, end_indx);
		}
		swapElements(arrA, mid_element, end_indx - 1);
		return arrA[end_indx - 1]; /* Return last element as pivot */
	}
	
	/* Elements left in array are partitioned based on the fact whether they are less than or greater than pivot */
	public int partitionArray(int[] arrA, int start_indx, int end_indx, double pivot) {
		int leftPtr = start_indx;
		int rightPtr = end_indx - 1;
		while (true) 
		{
			while (arrA[++leftPtr] < pivot)
				;
			while (arrA[--rightPtr] > pivot)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swapElements(arrA, leftPtr, rightPtr);
		}
		swapElements(arrA, leftPtr, end_indx - 1);
		return leftPtr;
	}	

	/* Swapping elements */
	public void swapElements(int[] arrA, int x, int y) {
		int temp_element = arrA[x];
		arrA[x] = arrA[y];
		arrA[y] = temp_element;
	}
}
