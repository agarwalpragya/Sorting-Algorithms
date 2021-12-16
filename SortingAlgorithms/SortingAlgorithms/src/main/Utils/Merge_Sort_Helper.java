package main.Utils;

/* Merge sort implementation */

public class Merge_Sort_Helper {

	void merge(int arrA[], int lower_bound, int mid_element, int upper_bound) {
		subarraysMerge(arrA,lower_bound, mid_element,upper_bound); /* Calling function to sort unsorted array using Merge Sort */
	}
	public void sortArray(int arrA[], int lower_bound, int upper_bound) {
		if (lower_bound < upper_bound) 
		{

			int mid_element = lower_bound + (upper_bound - lower_bound) / 2; /* Finding middle element */

			sortArray(arrA, lower_bound, mid_element); /* Recursively calling sortArray function on first half */
			sortArray(arrA, mid_element + 1, upper_bound); /* Recursively calling sortArray function on second half */

			subarraysMerge(arrA, lower_bound, mid_element, upper_bound); /* Calling subarraysMerge function to merge sub-arrays */
		}
	}
	void subarraysMerge(int arrA[], int lower_bound, int mid_element, int upper_bound) {
		int subarray1_size = mid_element - lower_bound + 1; /* Size of sub-array 1 */
		int subarray2_size = upper_bound - mid_element; /* Size of sub-array 2 */
		
		/* Creating two new temporary arrays */
		int leftArrA[] = new int[subarray1_size];
		int rightArrA[] = new int[subarray2_size];
		
		/* Populating data into two new temporary arrays */
		for (int x = 0; x < subarray1_size; ++x)
		{
			leftArrA[x] = arrA[lower_bound + x];
		}
		for (int y = 0; y < subarray2_size; ++y)
		{
			rightArrA[y] = arrA[mid_element + 1 + y];
		}	

		int indx1 = 0, indx2 = 0; /* Initial value of indexes of subarray1 indx1 and subarray2 indx2*/

		int z = lower_bound; /* Initial index value of resultant merged array */
		
		while (indx1 < subarray1_size && indx2 < subarray2_size) 
		{
			if (leftArrA[indx1] <= rightArrA[indx2]) 
			{
				arrA[z] = leftArrA[indx1];
				indx1++;
			} 
			else 
			{
				arrA[z] = rightArrA[indx2];
				indx2++;
			}
			z++;
		}
		
		/* Populating remaining elements */
		while (indx1 < subarray1_size) {
			arrA[z] = leftArrA[indx1];
			indx1++;
			z++;
		}

		while (indx2 < subarray2_size) {
			arrA[z] = rightArrA[indx2];
			indx2++;
			z++;
		}
	}

}
