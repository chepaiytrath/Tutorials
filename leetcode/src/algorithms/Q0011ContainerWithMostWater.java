package algorithms;

public class Q0011ContainerWithMostWater {
	public static void main(String[] args) {
		int[] arr = {0,2,5,8888,8888,3,4};
		System.out.println(maxAreaON(arr));
	}

	public static int maxAreaON2(int[] arr) {
	    int maxArea = 0;
	    
	    int i = 0;
	    while(i < arr.length - 1) {
	    	int j = i+1;
	    	while(j < arr.length) {
	    		int area = (j - i) * Math.min(arr[i], arr[j]);
		    	maxArea = Math.max(maxArea, area);
		    	j++;
	    	}
	    	i++;
	    }
	    return maxArea;
    }
	
	public static int maxAreaON(int[] arr) {
	    int maxArea = 0;
	    int i = 0, j = arr.length-1; 
	    while(i < j) {
    		int area = (j - i) * Math.min(arr[i], arr[j]);
	    	maxArea = Math.max(maxArea, area);
	    	
	    	if(arr[i] < arr[j]) {
	    		i++;
	    	}else {
	    		j--;
	    	}
	    }
	    return maxArea;
    }
}
