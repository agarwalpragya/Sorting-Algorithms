package main.Utils;

/* Insertion sort implementation */

public class Insertion_Sort_Helper {
	public void sortArray(int[] arrA)
    {
		sortUnsortedArray(arrA); /* Calling function to sort unsorted array using Insertion Sort */
    }
	public void sortUnsortedArray(int[] arrA) {
        int array_length = arrA.length;
        int x;
        for (x = 1; x < array_length; ++x) /* Iterating all elements of array and comparing each element with its predecessor */
        {
            int key_element = arrA[x];
            int ptr =x;
            while (ptr > 0 && key_element<arrA[ptr-1] )  /* Move elements of array arrA one place ahead of their current position if it is greater than key_element */
            {
            	arrA[ptr] = arrA[ptr-1];
            	ptr--;
            }
            arrA[ptr] = key_element;
        }
	} 
}
