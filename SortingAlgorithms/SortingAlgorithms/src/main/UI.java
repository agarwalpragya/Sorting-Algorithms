package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import main.Utils.Bubble_Sort_Helper;
import main.Utils.Heap_Sort_Helper;
import main.Utils.Insertion_Sort_Helper;
import main.Utils.Merge_Sort_Helper;
import main.Utils.Quick_Sort_Helper;
import main.Utils.Quick_Sort_3medians_Helper;
import main.Utils.Selection_Sort_Helper;

public class UI implements ActionListener {
	JButton sort_Button, compareResults_Button;
	JRadioButton mergeSort_radiobutton, heapSort_radiobutton, quickSort_radiobutton, q3_radiobutton,
			insertionSort_radiobutton, selectionSort_radiobutton, bubbleSort_radiobutton;
	static JLabel getArrayElements_label, sortedArray_label, sortedArray_label2, unsortedArray_label, elapsedtime_label,
			bubbleSortResult_label, selectionSortResult_label, mergeSortResult_label, heapSortResult_label,
			quickSort3Result_label, insertionSortResult_label, quickSortResult_label, bubbleSortResult_datalabel,
			selectionSortResult_datalabel, mergeSortResult_datalabel, heapSortResult_datalabel,
			quickSort3Result_datalabel, insertionSortResult_datalabel, quickSortResult_datalabel, selectAlgorithm_label,
			arrayDataInvalid_label, compareResultsHeader1_label, compareResultsHeader2_label;
	JPanel main_panel, radioButton_panel, button_panel, sort_results_panel, compare_results_panel;
	JSeparator separator;
	JTextField getarrayElements_textfield;
	ButtonGroup buttonGroup;
	JFrame mainFrame;
	static int array_elements[];
	static Instant startT, endT;
	static float timeElapsed;
	static DecimalFormat decimalFormat = new DecimalFormat("###.####");
	static UI ui;

	public static void main(String args[]) {
		ui = new UI();
	}

	public void createRadioBtns() {
		/* Radio Button for implementing Merge Sort */
		mergeSort_radiobutton = new JRadioButton();
		mergeSort_radiobutton.setBounds(300, 130, 200, 50);
		mergeSort_radiobutton.setActionCommand("Merge");
		mergeSort_radiobutton.addActionListener(this);
		mergeSort_radiobutton.setText("Merge Sort");

		/* Radio Button for implementing Heap Sort */
		heapSort_radiobutton = new JRadioButton();
		heapSort_radiobutton.setBounds(100, 230, 200, 50);
		heapSort_radiobutton.setActionCommand("Heap");
		heapSort_radiobutton.addActionListener(this);
		heapSort_radiobutton.setText("Heap Sort");

		/* Radio Button for implementing Quick Sort */
		quickSort_radiobutton = new JRadioButton();
		quickSort_radiobutton.setBounds(100, 230, 200, 50);
		quickSort_radiobutton.setActionCommand("Quick");
		quickSort_radiobutton.addActionListener(this);
		quickSort_radiobutton.setText("Quick Sort");

		/* Radio Button for implementing Quick Sort using 3 medians */
		q3_radiobutton = new JRadioButton();
		q3_radiobutton.setBounds(100, 230, 200, 50);
		q3_radiobutton.setActionCommand("Q3");
		q3_radiobutton.addActionListener(this);
		q3_radiobutton.setText("Quick Sort using 3 medians");

		/* Radio Button for implementing Insertion Sort */
		insertionSort_radiobutton = new JRadioButton();
		insertionSort_radiobutton.setBounds(100, 230, 200, 50);
		insertionSort_radiobutton.setActionCommand("Insertion");
		insertionSort_radiobutton.addActionListener(this);
		insertionSort_radiobutton.setText("Insertion Sort");

		/* Radio Button for implementing Selection Sort */
		selectionSort_radiobutton = new JRadioButton();
		selectionSort_radiobutton.setBounds(100, 230, 200, 50);
		selectionSort_radiobutton.setActionCommand("Selection");
		selectionSort_radiobutton.addActionListener(this);
		selectionSort_radiobutton.setText("Selection Sort");

		/* Radio Button for implementing for Bubble Sort */
		bubbleSort_radiobutton = new JRadioButton();
		bubbleSort_radiobutton.setBounds(100, 230, 200, 50);
		bubbleSort_radiobutton.setActionCommand("Bubble");
		bubbleSort_radiobutton.addActionListener(this);
		bubbleSort_radiobutton.setText("Bubble Sort");

		/* Buttons Group */
		buttonGroup = new ButtonGroup();
		buttonGroup.add(mergeSort_radiobutton);
		buttonGroup.add(heapSort_radiobutton);
		buttonGroup.add(quickSort_radiobutton);
		buttonGroup.add(q3_radiobutton);
		buttonGroup.add(insertionSort_radiobutton);
		buttonGroup.add(selectionSort_radiobutton);
		buttonGroup.add(bubbleSort_radiobutton);
	}

	public void createBtns() {
		/* Sort button to implement selected sorting algorithm */
		sort_Button = new JButton();
		sort_Button.setPreferredSize(new Dimension(350, 40));
		sort_Button.addActionListener(this);
		sort_Button.setText("Sort");
		sort_Button.setFocusable(false);
		sort_Button.setHorizontalTextPosition(JButton.CENTER);

		/* Compare button for comparing run time of all the algorithms */
		compareResults_Button = new JButton();
		compareResults_Button.addActionListener(this);
		compareResults_Button.setText("Compare All");
		compareResults_Button.setFocusable(false);
		compareResults_Button.setHorizontalTextPosition(JButton.CENTER);
	}

	public void createLabels() {
		/* Label for inputing array elements */
		getArrayElements_label = new JLabel();
		Font labelFont1 = new Font(getArrayElements_label.getFont().getName(), Font.BOLD,
				getArrayElements_label.getFont().getSize());
		getArrayElements_label.setFont(labelFont1);
		getArrayElements_label.setText("Enter the array elements (“,” separated): ");

		/* Label for selecting sorting algorithm */
		selectAlgorithm_label = new JLabel();
		Font labelFont2 = new Font(selectAlgorithm_label.getFont().getName(), Font.BOLD,
				selectAlgorithm_label.getFont().getSize());
		selectAlgorithm_label.setFont(labelFont2);
		selectAlgorithm_label.setText("Select the sorting algorithm: ");

		/* Labels for displaying sorting result */
		sortedArray_label2 = new JLabel();
		Font labelFont3 = new Font(sortedArray_label2.getFont().getName(), Font.BOLD, sortedArray_label2.getFont().getSize());
		sortedArray_label2.setFont(labelFont3);
		sortedArray_label = new JLabel();
		unsortedArray_label = new JLabel();
		elapsedtime_label = new JLabel();

		/*
		 * Labels for displaying result of run time comparison of all the sorting
		 * algorithms
		 */
		mergeSortResult_label = new JLabel();
		heapSortResult_label = new JLabel();
		quickSortResult_label = new JLabel();
		insertionSortResult_label = new JLabel();
		quickSort3Result_label = new JLabel();
		selectionSortResult_label = new JLabel();
		bubbleSortResult_label = new JLabel();
		mergeSortResult_datalabel = new JLabel();
		heapSortResult_datalabel = new JLabel();
		quickSortResult_datalabel = new JLabel();
		insertionSortResult_datalabel = new JLabel();
		quickSort3Result_datalabel = new JLabel();
		selectionSortResult_datalabel = new JLabel();
		bubbleSortResult_datalabel = new JLabel();

		compareResultsHeader1_label = new JLabel();
		compareResultsHeader1_label.setText("Algorithm");
		Font labelFont4 = new Font(compareResultsHeader1_label.getFont().getName(), Font.BOLD,
				compareResultsHeader1_label.getFont().getSize());
		compareResultsHeader1_label.setFont(labelFont4);

		compareResultsHeader2_label = new JLabel();
		Font labelFont5 = new Font(compareResultsHeader2_label.getFont().getName(), Font.BOLD,
				compareResultsHeader2_label.getFont().getSize());
		compareResultsHeader2_label.setFont(labelFont5);
		compareResultsHeader2_label.setText("Time (in ms)");

		/* Label for displaying error message */
		arrayDataInvalid_label = new JLabel();
		arrayDataInvalid_label.setText("Invalid or empty array elements");
		arrayDataInvalid_label.setVisible(false);
	}

	public void createPanels() {
		/* Main Panel */
		main_panel = new JPanel();
		main_panel.setLayout(new GridLayout(3, 1));
		mainFrame.add(main_panel);
		main_panel.add(getArrayElements_label);
		main_panel.add(getarrayElements_textfield);
		main_panel.add(selectAlgorithm_label);

		/* Radio Button Panel */
		radioButton_panel = new JPanel();
		radioButton_panel.setPreferredSize(new Dimension(710, 110));
		radioButton_panel.setLayout(new GridLayout(3, 3));
		mainFrame.add(radioButton_panel);
		radioButton_panel.add(mergeSort_radiobutton);
		radioButton_panel.add(heapSort_radiobutton);
		radioButton_panel.add(quickSort_radiobutton);
		radioButton_panel.add(q3_radiobutton);
		radioButton_panel.add(insertionSort_radiobutton);
		radioButton_panel.add(selectionSort_radiobutton);
		radioButton_panel.add(bubbleSort_radiobutton);
		radioButton_panel.setVisible(true);

		/* Button Panel */
		button_panel = new JPanel();
		button_panel.setLayout(new GridLayout(1, 2));
		mainFrame.add(button_panel);
		button_panel.add(sort_Button);
		button_panel.add(compareResults_Button);
		sort_Button.setEnabled(false);

		/* Sort Results Panel */
		separator = new JSeparator();

		sort_results_panel = new JPanel();
		sort_results_panel.setPreferredSize(new Dimension(700, 120));
		sort_results_panel.setLayout(new GridLayout(6, 1));
		mainFrame.add(sort_results_panel);
		sort_results_panel.add(sortedArray_label2);
		sort_results_panel.add(separator);
		sort_results_panel.add(unsortedArray_label);
		sort_results_panel.add(sortedArray_label);
		sort_results_panel.add(elapsedtime_label);
		sort_results_panel.setVisible(false);

		/* Compare Results Panel */
		compare_results_panel = new JPanel();
		compare_results_panel.setPreferredSize(new Dimension(700, 190));
		compare_results_panel.setLayout(new GridLayout(8, 2));
		mainFrame.add(compare_results_panel);
		compare_results_panel.add(compareResultsHeader1_label);
		compare_results_panel.add(compareResultsHeader2_label);
		compare_results_panel.add(mergeSortResult_label);
		compare_results_panel.add(mergeSortResult_datalabel);
		compare_results_panel.add(heapSortResult_label);
		compare_results_panel.add(heapSortResult_datalabel);
		compare_results_panel.add(quickSortResult_label);
		compare_results_panel.add(quickSortResult_datalabel);
		compare_results_panel.add(quickSort3Result_label);
		compare_results_panel.add(quickSort3Result_datalabel);
		compare_results_panel.add(insertionSortResult_label);
		compare_results_panel.add(insertionSortResult_datalabel);
		compare_results_panel.add(selectionSortResult_label);
		compare_results_panel.add(selectionSortResult_datalabel);
		compare_results_panel.add(bubbleSortResult_label);
		compare_results_panel.add(bubbleSortResult_datalabel);
		compare_results_panel.setVisible(false);
	}

	UI() {

		/* Radio buttons for choosing sorting algorithm */

		createRadioBtns();

		/* Buttons */

		createBtns();

		/* Labels */

		createLabels();

		/* Text Fields */

		getarrayElements_textfield = new JTextField();
		getarrayElements_textfield.setPreferredSize(new Dimension(700, 40));

		/* GUI Frame */

		mainFrame = new JFrame();
		mainFrame.setTitle("Sorting Algorithms");
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 1000, 10));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 600);

		/* Panels */

		createPanels();

		mainFrame.add(arrayDataInvalid_label);

		mainFrame.setVisible(true);
	}

	public Boolean getArrayElements() {

		String array = getarrayElements_textfield.getText();
		String[] array_items = array.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
		array_elements = new int[array_items.length];

		for (int i = 0; i < array_items.length; i++) {
			try {
				array_elements[i] = Integer.parseInt(array_items[i]);
			} catch (NumberFormatException ex) {
				System.out.println("Invalid or empty array elements");
				sort_results_panel.setVisible(false);
				compare_results_panel.setVisible(false);
				arrayDataInvalid_label.setVisible(true);
				return false;
			}
		}
		arrayDataInvalid_label.setVisible(false);
		return true;
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
	
	@Override
	public void actionPerformed(ActionEvent e) {

		/* RADIOBUTTON Handler */
		if (e.getSource() == mergeSort_radiobutton || e.getSource() == heapSort_radiobutton
				|| e.getSource() == quickSort_radiobutton || e.getSource() == q3_radiobutton
				|| e.getSource() == insertionSort_radiobutton || e.getSource() == selectionSort_radiobutton
				|| e.getSource() == bubbleSort_radiobutton) {
			sort_Button.setEnabled(true);
		}

		/* SORT BUTTON Handler */
		else if (e.getSource() == sort_Button) {
			compare_results_panel.setVisible(false);
			sort_results_panel.setVisible(true);

			ButtonModel btnGrpSelection = buttonGroup.getSelection();
			String radioButtonselection = "NA";
			if (btnGrpSelection != null) {
				radioButtonselection = btnGrpSelection.getActionCommand();
			}

			Boolean isValid = getArrayElements();
			if (isValid) {

				switch (radioButtonselection) {

				/* Merge Sort */
				case "Merge":
					System.out.println("Merge Sort");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Merge Sort");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					mergeSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Merge sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					elapsedtime_label.setText("Merge sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					break;

				/* Heap Sort */
				case "Heap":
					System.out.println("Heap Sort");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Heap Sort");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					heapSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Heap sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					elapsedtime_label.setText("Heap sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					break;

				/* Quick Sort */
				case "Quick":
					System.out.println("Quick Sort");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Quick Sort");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					quickSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Quick sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					elapsedtime_label.setText("Quick sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					break;

				/* Quick SORT using 3 medians */
				case "Q3":
					System.out.println("Quick SORT using 3 medians ");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Quick Sort 3 medians");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					quick3MedianSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Quick Sort using 3 medians  took " + decimalFormat.format(timeElapsed)
							+ " ms for input size " + array_elements.length);
					elapsedtime_label.setText("Quick Sort using 3 medians  took " + decimalFormat.format(timeElapsed)
							+ " ms for input size " + array_elements.length);
					break;

				/* Insertion Sort */
				case "Insertion":
					System.out.println("Insertion Sort");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Insertion Sort");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					insertionSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Insertion sort took " + decimalFormat.format(timeElapsed)
							+ " ms for input size " + array_elements.length);
					elapsedtime_label.setText("Insertion sort took " + decimalFormat.format(timeElapsed)
							+ " ms for input size " + array_elements.length);
					break;

				/* Selection Sort */
				case "Selection":
					System.out.println("Selection Sort");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Selection Sort");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					selectionSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Selection sort took " + decimalFormat.format(timeElapsed) + " ms for input size"
							+ array_elements.length);
					elapsedtime_label.setText("Selection sort took " + decimalFormat.format(timeElapsed)
							+ " ms for input size " + array_elements.length);
					break;

				/* Bubble Sort */
				case "Bubble":
					System.out.println("Bubble Sort");
					System.out.println("------------------------------------------------------");
					sortedArray_label2.setText("Array sorting using Bubble Sort");

					startT = Instant.now();

					System.out.println("Unsorted Array: " + Arrays.toString(array_elements));
					unsortedArray_label.setText("Unsorted Array: " + Arrays.toString(array_elements));

					bubbleSort();

					System.out.println("Sorted Array: " + Arrays.toString(array_elements));
					sortedArray_label.setText("Sorted Array: " + Arrays.toString(array_elements));

					endT = Instant.now();
					timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

					System.out.println("Bubble sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					elapsedtime_label.setText("Bubble sort took " + decimalFormat.format(timeElapsed) + " ms for input size "
							+ array_elements.length);
					break;

				default:
					System.out.println("Invalid Input");
				}
			}
			System.out.println();
			System.out.println();
		}

		/* COMPARE BUTTON Handler */
		else if (e.getSource() == compareResults_Button) {
			Boolean isValid = getArrayElements();
			if (isValid) {
				sort_results_panel.setVisible(false);
				compare_results_panel.setVisible(true);

				compareAllAlgorithms();
				
			}
		}

	}
	
	public static void compareAllAlgorithms() {
		/* Merge Sort */
		startT = Instant.now();
		mergeSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("MergeSort :" + decimalFormat.format(timeElapsed) + " ms");
		mergeSortResult_label.setText("MergeSort:");
		mergeSortResult_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");

		/* Heap Sort */
		startT = Instant.now();
		heapSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("HeapSort :" + decimalFormat.format(timeElapsed) + " ms");
		heapSortResult_label.setText("HeapSort:");
		heapSortResult_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");

		/* Quick Sort */
		startT = Instant.now();
		quickSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("Quick Sort :" + decimalFormat.format(timeElapsed) + " ms");
		quickSortResult_label.setText("Quick Sort:");
		quickSortResult_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");

		/* Quick Sort using 3 medians */
		startT = Instant.now();
		quick3MedianSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("Quick Sort using 3 median :" + decimalFormat.format(timeElapsed) + " ms");
		quickSort3Result_label.setText("Quick Sort using 3 median:");
		quickSort3Result_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");

		/* Insertion Sort */
		startT = Instant.now();
		insertionSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("InsertionSort :" + decimalFormat.format(timeElapsed) + " ms");
		insertionSortResult_label.setText("InsertionSort:");
		insertionSortResult_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");

		/* Selection Sort */
		startT = Instant.now();
		selectionSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("SelectionSort :" + decimalFormat.format(timeElapsed) + " ms");
		selectionSortResult_label.setText("SelectionSort:");
		selectionSortResult_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");

		/* Bubble Sort */
		startT = Instant.now();
		bubbleSort();
		endT = Instant.now();
		timeElapsed = (float) Duration.between(startT, endT).toNanos() / 1000000;

		System.out.println("BubbleSort :" + decimalFormat.format(timeElapsed) + " ms");
		bubbleSortResult_label.setText("BubbleSort:");
		bubbleSortResult_datalabel.setText(" " + decimalFormat.format(timeElapsed) + " ms");
		System.out.println();
	}

}
