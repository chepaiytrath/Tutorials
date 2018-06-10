package algorithms;

public class MergeSort {

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[] = { 6,10,4,5,8,3,7,2,9,1 };

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, new int[arr.length], 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}

	private void sort(int[] arr, int[] temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		
		int mid = (leftStart + rightEnd) / 2;
		sort(arr, temp, leftStart, mid);
		sort(arr, temp, mid + 1, rightEnd);
		
		mergeHalves(arr, temp, leftStart, rightEnd);
	}

	private void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd + 1;
		
		int i = leftStart, j = rightStart, index = leftStart;
		while(i <= leftEnd && j <= rightEnd) {
			if(arr[i] <= arr[j]) {
				temp[index++] = arr[i++];
			}else {
				temp[index++] = arr[j++];
			}
		}
		
		int size = rightEnd - leftStart + 1;
		System.arraycopy(arr, j, temp, index, rightEnd - j + 1);
		System.arraycopy(arr, i, temp, index, leftEnd - i + 1);
		System.arraycopy(temp, leftStart, arr, leftStart, size);
	}
}
