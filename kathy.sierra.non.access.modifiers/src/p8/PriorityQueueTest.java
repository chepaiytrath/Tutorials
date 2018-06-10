package p8;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] arr1 = new int[3];
		arr1[0] = 2;
		arr1[1] = 1;
		arr1[2] = 0;
		
		for(int x : arr1) {
			pq.offer(x);
		}
		for(int x : arr1) {
			System.out.println(pq.poll());
		}
		
	}
}
