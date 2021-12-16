package main.Utils;

/* Quick sort implementation */

public class Quick_Sort_Helper {
	
	public void sortArray(int[] arrA, int start_indx, int end_indx)
	{
		sortUnsortedArray(arrA,start_indx, end_indx); /* Calling function to sort unsorted array using Quick Sort */
	}
	
	/*Recursive call for implementing Quick sort*/
	public void sortUnsortedArray(int[] arrA, int start_indx, int end_indx) 
	{
		if (start_indx < end_indx)
		{  
			int pivot = partitionArray(arrA, start_indx, end_indx);
			sortUnsortedArray(arrA, start_indx, pivot - 1); /* Recursively calling sortUnsortedArray function on left partitions */
			sortUnsortedArray(arrA, pivot + 1, end_indx); /* Recursively calling sortUnsortedArray function on right partitions */
		}
	}
	
	static int partitionArray(int[] arrA, int start_indx, int end_indx) /* Partitioning array on the basis of pivot element */
	{
	     
	    int pivot = arrA[end_indx]; /* Picking last element as pivot element */

	    int x = (start_indx - 1); /* Capturing smaller element index */
	 
	    for(int y = start_indx; y <= end_indx - 1; y++)
	    {

	        if (arrA[y] < pivot) /* Perform swap if current element is smaller than pivot */
	        {
	            x++; /* Index of smaller element incremented */
	            swapElements(arrA, x, y);
	        }
	    }
	    swapElements(arrA, x + 1, end_indx);
	    return (x + 1);
	}

	static void swapElements(int[] arrA, int x, int y) /* Swapping elements */
	{
	    int temp_element = arrA[x];
	    arrA[x] = arrA[y];
	    arrA[y] = temp_element;
	}	 
}
