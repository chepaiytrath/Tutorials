package algorithms;

public class Q0014LongestCommonPrefix {
	public static void main(String[] args) {
		String[] arr = { "fog", "flower", "flowish" };
		System.out.println(longestCommonPrefixVerticalScanning(arr));

	}

	public static String longestCommonPrefixHorizontalScanning(String[] arr) {
		if(arr == null || arr.length == 0) {
			return "";
		}
		String output = arr[0];
		for(int i = 1; i < arr.length; i++) {
			while(arr[i].indexOf(output) != 0) {
				output = output.substring(0, output.length() - 1);
				if(output.length() == 0) {
					return "";
				}
			}
		}
		return output;
	}

	public static String longestCommonPrefixVerticalScanning(String[] arr) {
		if(arr == null || arr.length == 0) {
			return "";
		}
		for(int i = 0; i < arr[0].length(); i++) {
			char c = arr[0].charAt(i);
			for(int j = 1; j < arr.length; j++) {
				if(i == arr[j].length() || c != arr[j].charAt(i)) {
					return arr[0].substring(0, i);
				}
			}
		}
		return arr[0];
	}
	
	
}
