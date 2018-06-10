package algorithms;

public class QuickSort {
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 6, 10, 4, 5, 8, 3, 7, 2, 9, 1 };

		System.out.println("Given Array");
		printArray(arr);

		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

	private void sort(int[] arr, int left, int right) {
		if(left >= right) {
			return;
		}
		int partitionIndex = partition(arr, arr[(left + right) / 2], left, right);
		sort(arr, left, partitionIndex - 1);
		sort(arr, partitionIndex + 1, right);
	}

	private int partition(int[] arr, int pivot, int left, int right) {
		while(left < right) {
			while(arr[left] < pivot) {
				left++;
			}
			while(arr[right] > pivot) {
				right--;
			}
			if(left < right) {
				swap(arr, left, right);
				left++; 
				right--;
			}
		}
		return left;
	}

	private void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
