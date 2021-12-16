package main.Utils;

/* Selection sort implementation */

public class Selection_Sort_Helper {
	
	public void sortArray(int arrA[])
    {
		sortUnsortedArray(arrA); /* Calling function to sort unsorted array using selection sort */
    }
	/* Swapping elements */
	public void swapElements(int arrA[], int min_element, int x) {
        int temp_element = arrA[min_element];
        arrA[min_element] = arrA[x];
        arrA[x] = temp_element;		
	}
	public void sortUnsortedArray(int arrA[])
	{
        int array_length = arrA.length;

        for (int x = 0; x < array_length-1; x++)
        {
            int min_element = x; /* Taking first element as minimum element */
            for (int y = x+1; y < array_length; y++)
            {
                if (arrA[y] < arrA[min_element]) /* Locating minimum element in unsorted array */
                {
                	min_element = y; /* New minimum element */
                } 
            }
            swapElements(arrA,min_element,x); /* Calling swapElements */

        }
	}

}
