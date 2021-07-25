package Clone;

public class Kart implements Cloneable{
	private int speed;
	private int weight;
	private Pilot pilot;

	public Kart(int speed, int weight, Pilot pilot) {
		this.speed = speed;
		this.weight = weight;
		this.pilot = pilot;
	}

	public Kart() {
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Pilot clonedPilot = (Pilot) this.getPilot().clone();
		Kart kart = new Kart();
		kart.setPilot(clonedPilot);
		kart.setSpeed(this.getSpeed());
		kart.setWeight(this.getWeight());
		return kart;
	}

	@Override
	public String toString() {
		return "Kart{" +
				"speed=" + speed +
				", weight=" + weight +
				", pilot=" + pilot +
				'}';
	}
}
