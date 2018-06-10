package p7;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class ExcptionExercise {
	static String s = "1";
	
	public static void main(String[] args) {
		String s = "jatin";
		try {
			s = reverse(s);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(s);
		}
	}

	private static String reverse(String s) throws Exception {
		if (s.length() == 0) {
			throw new Exception();
		} else {
			String reverseStr = "";
			for (int i = s.length() - 1; i >= 0; --i) {
				reverseStr += s.charAt(i);
			}
			return reverseStr;
		}
	}
	
	private static void method1() throws FileNotFoundException, MyCheckedException {
		RandomAccessFile raf = new RandomAccessFile("myfile.txt", "r");
		throw new MyCheckedException();
		throw new MyUncheckedException();
	}
	
	private void method2() {
		System.out.println("after try");
	}
	
	private void method3() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			throw e;
		}
	}
}