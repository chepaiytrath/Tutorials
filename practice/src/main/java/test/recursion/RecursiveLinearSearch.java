package test.recursion;

public class RecursiveLinearSearch {
	public static void main(String[] args) {
		int arr[] = new int[] {3,5,1,9,6,4,8};
		int i = recursiveLinearSearch(arr, 2, 5);
		System.out.println(i);
	}
	private static int recursiveLinearSearch(int arr[], int index, int num){
		if(index > arr.length - 1) {
			return -1;
		}else if(arr[index] == num) {
			return index;
		}
		return recursiveLinearSearch(arr, index + 1, num);
	}
}
