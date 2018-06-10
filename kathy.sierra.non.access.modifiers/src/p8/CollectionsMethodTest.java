package p8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsMethodTest {
	public static void main(String[] args) {
		List<Fruit> list = new ArrayList<>();
		list.add(new Fruit("apple"));
		list.add(new Fruit("orange"));
		list.add(new Fruit("grapes"));
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Comparator<Fruit> c = Collections.reverseOrder();
		
		Collections.sort(list, c);
		System.out.println(list);
		
	}
}

class Fruit implements Comparable<Fruit>{
	private String name;

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Fruit other = (Fruit) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + "]";
	}

	@Override
	public int compareTo(Fruit o) {
		return this.getName().compareTo(o.getName());
	}
}