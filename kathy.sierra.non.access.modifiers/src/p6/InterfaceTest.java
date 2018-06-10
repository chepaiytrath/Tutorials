package p6;

public class InterfaceTest {

}
abstract class Ball implements Bounceable{
	
	public void bounce() {
		// TODO Auto-generated method stub
		
	}
}

class Football extends Ball{

	@Override
	public void setBounceFactor(int bf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveIt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSphericalThing() {
		// TODO Auto-generated method stub
		
	}
	
}

interface Bounceable extends Moveable, Spherical { // ok!
	void bounce();

	void setBounceFactor(int bf);
}

interface Moveable {
	void moveIt();
}

interface Spherical {
	void doSphericalThing();
}