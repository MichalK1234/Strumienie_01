
import java.util.ArrayList;
import java.util.List;

public class Car {

	private String brand;
	private double price;
	private double capacity;
	private double mileage;
	private List<String> equipment;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public List<String> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<String> equipment) {
		this.equipment = equipment;
	}

	public Car() {

		equipment = new ArrayList<>();
	}

	public Car(String brand, double price, double capacity, double mileage, List<String> equipment) {
		super();
		this.brand = brand;
		this.price = price;
		this.capacity = capacity;
		this.mileage = mileage;
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return "Samochod [brand=" + brand + ", price=" + price + ", capacity=" + capacity + ", mileage=" + mileage
				+ ", equipment=" + equipment + "]";
	}

}
