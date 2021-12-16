package main;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import main.Utils.Bubble_Sort_Helper;
import main.Utils.Heap_Sort_Helper;
import main.Utils.Insertion_Sort_Helper;
import main.Utils.Merge_Sort_Helper;
import main.Utils.Quick_Sort_Helper;
import main.Utils.Quick_Sort_3medians_Helper;
import main.Utils.Selection_Sort_Helper;

public class MainClass {

	static int array_elements[];
	static int array_size;
	static Scanner input = new Scanner(System.in);
	static Instant startT, endT;
	static float timeElapsed;
	static DecimalFormat decimalFormat = new DecimalFormat("###.####");

	public void getArrayElements() {

		/* Takes user input to implement sorting */
		try {

			System.out.println();
			System.out.println("Select from below options : ");
			System.out.println("1. Enter the elements");
			System.out.println("2. Generate random elements");
			int option = input.nextInt();

			/* Takes user input for number of elements to be sorted */
			System.out.println();
			System.out.println("Enter the number of array elements to be sorted : ");
			array_size = input.nextInt();
			array_elements = new int[array_size];

			/* If user wants to manually input array elements to be sorted */
			if (option == 1) {
				System.out.println();
				System.out.println("Enter the array elements to be sorted: ");
				for (int x = 0; x < array_size; x++) {
					try {
						array_elements[x] = input.nextInt();
					} catch (NumberFormatException ex) {
						System.out.println("Invalid array element");
					}
				}
			}
			/* If user wants random numbers to be sorted */
			else if (option == 2) {
				Random random = new Random();
				for (int x = 0; x < array_size; x++) {
					array_elements[x] = random.nextInt(1000);
				}
			}

		}
		/* Displays error message if invalid user input */
		catch (NumberFormatException ex) {
			System.out.println("Invalid input");
		}
		System.out.println();
	}

	public static void showMenu() {
		System.out.println("Select the Sorting Algorithm : ");
		System.out.println("1. Merge Sort");
		System.out.println("2. Heap Sort");
		System.out.println("3. QuickSort");
		System.out.println("4. QuickSort using 3 medians");
		System.out.println("5. Insertion Sort");
		System.out.println("6. Selection Sort");
		System.out.println("7. Bubble Sort");
		System.out.println();
		System.out.println("OR");
		System.out.println();
		System.out.println("Select any other operation : ");
		System.out.println("8. Compare All");
		System.out.println("9. Exit");
		System.out.println();
	}

	public static void main(String args[]) {

		int selectedOperation;
		MainClass mainObj = new MainClass();

		/* Choose sorting algorithm or other action(s) to be performed */
		do {

			showMenu();

			selectedOperation = input.nextInt();

			if (selectedOperation == 9) {
				System.exit(0);
			}

			mainObj.getArrayElements();

			switch (selectedOperation) {

			/* To display result of Merge Sort */
			case 1:
				System.out.println("Sorting of array using Merge Sort");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				mergeSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Merge sort took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result of Heap Sort */
			case 2:
				System.out.println("Array sorting using Heap Sort");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				heapSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Heap sort took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result of Quick Sort */
			case 3:
				System.out.println("Sorting of array using Quick Sort");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				quickSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Quick sort took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result of Quick Sort using 3 medians */
			case 4:
				System.out.println("Sorting of array using Quick Sort using 3 medians");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				quick3MedianSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Quick sort using 3 medians took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result of Insertion Sort */
			case 5:
				System.out.println("Sorting of array using Insertion Sort");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				insertionSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Insertion sort took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result of Selection Sort */
			case 6:
				System.out.println("Sorting of array using Selection Sort");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				selectionSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Selection sort took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result of Bubble Sort */
			case 7:
				System.out.println("Sorting of array using Bubble Sort");
				System.out.println("------------------------------------------------------");
				startT = Instant.now();

				System.out.println("Unsorted Array: " + Arrays.toString(array_elements));

				bubbleSort();

				System.out.println("Sorted Array: " + Arrays.toString(array_elements));

				endT = Instant.now();
				timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
				System.out.println("Bubble sort took " + decimalFormat.format(timeElapsed)
						+ " ms for input with array length " + array_elements.length);
				break;

			/* To display result for run time comparison of all algorithms */
			case 8:
				System.out.println("Comparing run time for all algorithms");
				System.out.println("------------------------------------------------------");

				compareAllAlgorithms();

				break;

			default:
				System.out.println("Invalid Input");

			}

			System.out.println("------------------------------------------------------");
			System.out.println();
			System.out.println();

		} while (true);

	}

	public static void mergeSort() {
		Merge_Sort_Helper mergeSortObj = new Merge_Sort_Helper();
		mergeSortObj.sortArray(array_elements, 0, array_elements.length - 1);
	}

	public static void heapSort() {
		Heap_Sort_Helper heapSortObj = new Heap_Sort_Helper();
		heapSortObj.sortArray(array_elements);
	}

	public static void quickSort() {
		Quick_Sort_Helper quickSortObj = new Quick_Sort_Helper();
		quickSortObj.sortArray(array_elements, 0, array_elements.length - 1);
	}

	public static void quick3MedianSort() {
		Quick_Sort_3medians_Helper quickSort3Obj = new Quick_Sort_3medians_Helper();
		quickSort3Obj.sort(array_elements, 0, array_elements.length - 1);
	}

	public static void insertionSort() {
		Insertion_Sort_Helper insertionSortObj = new Insertion_Sort_Helper();
		insertionSortObj.sortArray(array_elements);
	}

	public static void selectionSort() {
		Selection_Sort_Helper selectionSortObj = new Selection_Sort_Helper();
		selectionSortObj.sortArray(array_elements);
	}

	public static void bubbleSort() {
		Bubble_Sort_Helper bubbleSortObj = new Bubble_Sort_Helper();
		bubbleSortObj.sortArray(array_elements);
	}

	public static void compareAllAlgorithms() {
		/* Run time for Merge Sort */
		startT = Instant.now();

		mergeSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("MergeSort :" + decimalFormat.format(timeElapsed) + " ms");

		/* Run time for Heap Sort */
		startT = Instant.now();

		heapSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("HeapSort :" + decimalFormat.format(timeElapsed) + " ms");

		/* Run time for Quick Sort */
		startT = Instant.now();

		quickSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("Quick Sort :" + decimalFormat.format(timeElapsed) + " ms");

		/* Run time for Quick Sort using 3 median */
		startT = Instant.now();

		quick3MedianSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("Quick Sort using 3 medians :" + decimalFormat.format(timeElapsed) + " ms");

		/* Run time for Insertion Sort */
		startT = Instant.now();

		insertionSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("InsertionSort :" + decimalFormat.format(timeElapsed) + " ms");

		/* Run time for Selection Sort */
		startT = Instant.now();

		selectionSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("SelectionSort :" + decimalFormat.format(timeElapsed) + " ms");

		/* Run time for Bubble Sort */
		startT = Instant.now();

		bubbleSort();

		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;
		System.out.println("BubbleSort :" + decimalFormat.format(timeElapsed) + " ms");
	}
}
