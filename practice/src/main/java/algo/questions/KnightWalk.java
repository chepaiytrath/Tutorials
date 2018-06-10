package algo.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class KnightWalk {
	private static int arrX[] = { 2, 2, 1, 1, -2, -2, -1, -1 };
	private static int arrY[] = { 1, -1, 2, -2, 1, -1, 2, -2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			String[] nm = sc.nextLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			String[] input = sc.nextLine().split(" ");
			Integer x1 = Integer.parseInt(input[0]);
			Integer y1 = Integer.parseInt(input[1]);
			Integer x2 = Integer.parseInt(input[2]);
			Integer y2 = Integer.parseInt(input[3]);
			int shortestDistance = findShortestDistance(n, m, new Location(x1, y1), new Location(x2, y2));
			System.out.println(shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance);
		}
	}

	private static int findShortestDistance(int n, int m, Location source, Location destination) {
		int distance = Integer.MAX_VALUE;
		Map<Location, Boolean> visitedMap = new HashMap<Location, Boolean>();
		if (source.equals(destination)) {
			return 0;
		}
		Queue<Location> queue = new LinkedList<Location>();
		queue.add(source);

		while (!queue.isEmpty()) {
			Location location = queue.poll();
			visitedMap.put(location, true);
			if(location.equals(destination) && distance > location.getDistance()) {
				distance = location.getDistance();
				continue;
			}
			List<Location> nextChoices = findNextChoices(n, m, location, visitedMap);
			queue.addAll(nextChoices);
		}
		return distance;
	}

	private static List<Location> findNextChoices(int n, int m, Location parentLocation, Map<Location, Boolean> visitedMap) {
		int parentDistance = parentLocation.getDistance();
		List<Location> list = new ArrayList<Location>();
		int i = 0;
		while (i < 8) {
			int newX = parentLocation.getX() + arrX[i];
			int newY = parentLocation.getY() + arrY[i];
			Location loc = new Location(newX, newY);
			loc.setDistance(parentDistance + 1);
			if (((null == visitedMap.get(loc)) || (null != visitedMap.get(loc) && visitedMap.get(loc) == false)) 
					&& (newX >= 1 && newX <= n && newY >= 1 && newY <= m)) {
				list.add(loc);
			}
			i++;
		}
		return list;
	}
}

class Location {
	int x;
	int y;
	int distance;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.distance = 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + ", distance=" + distance + "]";
	}
	
}
