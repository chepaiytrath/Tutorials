package p7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionHandling {
	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		ExceptionHandling e = new ExceptionHandling();
		/*System.out.println("before method");
		// System.out.println(e.method2());
		e.method3();
		System.out.println("after method");*/
		
		e.rethrow();
	}

	private void rethrow() throws SQLException, IOException {
		try {
			couldThrowAnException();
			//couldThrowAnException2();
			//throw new ArrayIndexOutOfBoundsException();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw e;
		}catch (IOException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	private void rethrow2() throws SQLException, IOException {
		try {
			couldThrowAnException();
			//couldThrowAnException2();
			//throw new ArrayIndexOutOfBoundsException();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	private void couldThrowAnException() throws IOException {
		throw new ArrayIndexOutOfBoundsException();
	}
	
	private void couldThrowAnException2() throws FileNotFoundException {
		throw new ArrayIndexOutOfBoundsException();
	}

	private void method3() {
		try {
			System.out.println("try1");
			int[] arr = new int[2];
			System.out.println(arr[2]);
			return;
		} catch (ArrayStoreException e) {
			System.out.println("catch1");
			// return;
		} finally {
			System.out.println("finally1");
			// return;
		}
		System.out.println("after try");
	}

	private int method2() {
		try {
			System.out.println("try1");
			int x = 0;
			if (x == 0) {
				throw new Exception();
			}
			return 1;
		} catch (Exception e) {
			System.out.println("catch1");
			try {
				System.out.println("try2");
				int x = 0;
				if (x == 0) {
					throw new Exception();
				}
				return 2;
			} catch (Exception e1) {
				System.out.println("catch2");
				return 3;
			} finally {
				System.out.println("finally2");
				return 4;
			}
			// return 5;
		} finally {
			System.out.println("finally1");
			try {
				System.out.println("try3");
				int x = 0;
				if (x == 0) {
					throw new Exception();
				}
				return 5;
			} catch (Exception e) {
				System.out.println("catch3 : " + e);
				return 6;
			} finally {
				System.out.println("finally3");
				return 7;
			}
			// return 8;
		}
		// return 4;
	}

	private int method() {
		try {
			System.out.println("try1");
			int x = 0;
			if (x == 0) {
				throw new Exception();
			}
			// return 1;
		} catch (Exception e) {
			System.out.println("catch1 : " + e);
			// System.exit(0);
			// return 2;
		} finally {
			try {
				System.out.println("try2");
				int x = 0;
				if (x == 0) {
					throw new Exception();
				}
				return 3;
			} catch (Exception e) {
				System.out.println("catch2 : " + e);
				return 4;
			} finally {
				System.out.println("finally2");
				// return 5;
			}
			System.out.println("finally1");
			// return 6;
		}
		return 4;
	}

}

// try needs at least either a catch or finally
// In non-void method, it must return either in try, catch, finally or after try
// Even if there is a return statement in the try block, the finally block
// executes right after the return statement is encountered
// and before the return executes!
// Same as above for return in catch. If catch returns, it is valid only if
// finally doesn't return anything

// 1. If in a non void method, in case an exception occurs and is caught :
// a. return from finally overrides return from try/catch.
// b. If no return in finally, return of catch is used.
// c. If no return in catch, return in try is used.
// d. A default return is still provided after try block in case exception
// occurs before try's return and flow never comes back to its return statement.

// return is required in either try + catch OR try + finally. If this condition
// is fulfilled, any return after try block is unreachable code. Otherwise, it
// is required.

// if return exists in finally OR try+catch, any return after try block is
// unreachable code.

// If exception is thrown but isn't caught in any catch block, finally block
// executes (if provided) and the exception is propogated don the call stack