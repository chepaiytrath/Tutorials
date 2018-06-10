package algo.questions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumTipCalculator {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {

			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int[] arrRahul = new int[n];
			int[] arrAnkit = new int[n];

			int i = 0;
			while (i < n) {
				arrRahul[i] = sc.nextInt();
				i++;
			}

			sc.nextLine();
			i = 0;
			while (i < n) {
				arrAnkit[i] = sc.nextInt();
				i++;
			}

			long maxTip = fetchMaximumTip(n, x, y, arrRahul, arrAnkit);
			System.out.println(maxTip);
			if (sc.hasNextLine()) {
				sc.nextLine();
			}
		}
	}

	private static long fetchMaximumTip(int n, int x, int y, int[] tipRahulArr, int[] tipAnkitArr) {
		List<Order> orderList = new ArrayList<Order>();
		int i = 1;
		while (i <= n) {
			orderList.add(new Order(tipRahulArr[i - 1], tipAnkitArr[i - 1]));
			i++;
		}
		Collections.sort(orderList);

		int totalTip = 0;
		for (Order o : orderList) {
			if (o.getRahulTip() == Math.max(o.getRahulTip(), o.getAnkitTip())) {
				if (x > 0) {
					totalTip += o.getRahulTip();
					x--;
				} else {
					totalTip += o.getAnkitTip();
					y--;
				}
			} else {
				if (y > 0) {
					totalTip += o.getAnkitTip();
					y--;
				} else {
					totalTip += o.getRahulTip();
					x--;
				}
			}
		}
		return totalTip;
	}
}

class Order implements Comparable<Order> {
	private int rahulTip;
	private int ankitTip;

	public Order(int rahulTip, int ankitTip) {
		this.rahulTip = rahulTip;
		this.ankitTip = ankitTip;
	}

	public int getRahulTip() {
		return rahulTip;
	}

	public void setRahulTip(int rahulTip) {
		this.rahulTip = rahulTip;
	}

	public int getAnkitTip() {
		return ankitTip;
	}

	public void setAnkitTip(int ankitTip) {
		this.ankitTip = ankitTip;
	}

	public int compareTo(Order o) {
		return Math.abs(o.getRahulTip()-o.getAnkitTip()) - Math.abs(this.rahulTip-this.ankitTip);
	}

}
