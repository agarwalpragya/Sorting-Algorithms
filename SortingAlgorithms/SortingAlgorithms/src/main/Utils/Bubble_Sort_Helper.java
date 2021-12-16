package main.Utils;

/* Bubble sort implementation */

public class Bubble_Sort_Helper {
	public void sortArray(int arrayA[]) {
		sortUnsortedArray(arrayA); /* Calling function to sort unsorted array using Bubble Sort */
		
	}
	/* Swapping elements */
	public void swapElements(int arrayA[], int y, int z) {
		int temp_arrA = arrayA[y];
		arrayA[y] = arrayA[y + 1];
		arrayA[y + 1] = temp_arrA;		
	}
	public void sortUnsortedArray(int arrayA[]) {
			int array_length = arrayA.length; /* Storing array length */
			int x,y;
			boolean check=false; /* Check if all elements are in sorted order or not*/
			while(check==false) /* Execute till there is no more swapping required*/
			{
				check=true;
			/* Continuously swapping adjacent array elements till one iteration where no swapping is done */
				for (x = 0; x < array_length - 1; x++) /* Running element pointer for comparison */
				{
					for (y = 0; y < array_length - x - 1; y++)  /* Running element pointer for comparison */
					{
						if (arrayA[y] > arrayA[y + 1]) /* Comparing elements and swapping them */
						{
							int z =y+1;
							swapElements(arrayA,y,z);
							check=false;
						
						}
					}
				}
			}
		
	}
}
