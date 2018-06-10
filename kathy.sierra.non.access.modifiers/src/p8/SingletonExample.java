package p8;

import java.util.HashSet;
import java.util.Set;

public class SingletonExample {
	public static void main(String[] args) {
		SingletonExample obj = new SingletonExample();
		obj.ticketAgentBook("1A");
		obj.ticketAgentBook("1B");
	}

	public void ticketAgentBook(String seat) {
		Show show = Show.getInstance();
		System.out.println(show.bookTicket(seat));
	}
}

class Show {
	private static final Show singleton = new Show();
	private Set<String> availableSeats;

	private Show() {
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}

	public static Show getInstance() {
		return singleton;
	}

	public boolean bookTicket(String seat) {
		return availableSeats.remove(seat);
	}
}