package com.jatin.code.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindNumberOfPlatforms {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int size = sc.nextInt();
			int[] arrival = new int[size];
			int[] departure = new int[size];

			for (int i = 0; i < size; i++) {
				arrival[i] = sc.nextInt();
			}
			for (int i = 0; i < size; i++) {
				departure[i] = sc.nextInt();
				if(departure[i] < arrival[i])
	                departure[i] += 2400;
			}
			
			//List<Train> list = sortArrivals(arrival, departure, size);
			System.out.println(betterApproach(arrival, departure, size));
		}
	}

	private static int betterApproach(int[] arrival, int[] departure, int size) {
		Arrays.sort(arrival);
		Arrays.sort(departure);
		int i = 0; int j = 0;
		int trainsRunning = 0; int maxTrains = 1;
		while(i < size && j < size) {
			if(arrival[i] < departure[j]) {
				trainsRunning++;
				i++;
				maxTrains = Math.max(maxTrains, trainsRunning);
			}else {
				trainsRunning--;
				j++;
			}
			
		}
		return maxTrains;
	}
	
	private static int findNumberOfPlatformsRequired(List<Train> list, int size) {
		List<Integer> depTimingList = new ArrayList<Integer>();
		depTimingList.add(list.get(0).getDeparture());
		int i = 1;
		while(i < size) {
			if(list.get(i).getArrival() >= depTimingList.get(0)) {
				depTimingList.set(0, list.get(i).getDeparture());
			}else{
				depTimingList.add(list.get(i).getDeparture());
			}
			Collections.sort(depTimingList);
			i++;
		}
		return depTimingList.size();
	}
	
	
	private static List<Train> sortArrivals(int[] arrival, int[] departure, int size) {
		int i = 0;
		List<Train> list = new ArrayList<Train>();
		while(i < size) {
			Train t = new Train(arrival[i], departure[i]);
			list.add(t);
			i++;
		}
		Collections.sort(list);
		return list;
	}
}


class Train implements Comparable<Train>{
	private int arrival;
	private int departure;
	public Train(int arrival, int departure) {
		super();
		this.arrival = arrival;
		this.departure = departure;
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	public int getDeparture() {
		return departure;
	}
	public void setDeparture(int departure) {
		this.departure = departure;
	}
	
	@Override
	public int compareTo(Train o) {
		if(this.getArrival() < o.getArrival()) {
			return -1;
		}else {
			return 1;
		}
	}
	@Override
	public String toString() {
		return "Train [arrival=" + arrival + ", departure=" + departure + "]";
	}
}