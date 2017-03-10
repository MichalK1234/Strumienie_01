
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarsList {

	private List<Car> carsList = new LinkedList<>();

	public List<Car> getCarsList() {
		return carsList;
	}

	public void setCarsList(List<Car> carsList) {
		this.carsList = carsList;
	}

	public CarsList(List<Car> carsList) {
		super();
		this.carsList = carsList;
	}

	public void addToList(Car s) {
		carsList.add(s);
	}

	public CarsList(String fileName) {

		File file = new File(fileName + ".txt");

		try (Scanner sc = new Scanner(file);) {

			while (sc.hasNextLine()) {

				String[] tab = sc.nextLine().split(" ");

				String[] arrEquipment = new String[] {};

				arrEquipment = Arrays.copyOfRange(tab, 4, tab.length);

				carsList.add(new Car(tab[0], Double.parseDouble(tab[1]), Double.parseDouble(tab[2]),
						Double.parseDouble(tab[3]), new ArrayList<>(Arrays.asList(arrEquipment))));

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	@Override
	public String toString() {
		return carsList.stream().map(x -> x.toString()).collect(Collectors.joining("\n"));

	}

	public List<Car> sortByName() {

		System.out.println("Samochody posortowane po nazwie: ");

		return carsList.stream().sorted((o1, o2) -> o1.getBrand().compareToIgnoreCase(o2.getBrand()))
				.collect(Collectors.toList());
	}

	public List<Car> sortByPrice() {

		System.out.println("Samochody posortowane po cenie: ");

		return carsList.stream().sorted((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice()))
				.collect(Collectors.toList());

	}

	public List<Car> sortByCapacity() {

		System.out.println("Samochody posortowane po pojemnosci: ");

		return carsList.stream().sorted((o1, o2) -> Double.compare(o1.getCapacity(), o2.getCapacity()))
				.collect(Collectors.toList());

	}

	public List<Car> sortByMileage() {

		System.out.println("Samochody posortowane po przebiegu: ");

		return carsList.stream().sorted((o1, o2) -> Double.compare(o1.getMileage(), o2.getMileage()))
				.collect(Collectors.toList());
	}

	public List<Car> sortByEquipment() {

		System.out.println("Samochody posortowane po ilosci elementow wyposazenia: ");

		return carsList.stream().sorted((o1, o2) -> Integer.compare(o1.getEquipment().size(), o2.getEquipment().size()))
				.collect(Collectors.toList());
	}

	public List<Car> removeElementsAboveMileage(double mileage) {

		System.out.println("Samochody o przebiegu powyzej: " + mileage);

		return carsList.stream().filter(e -> e.getMileage() > mileage).collect(Collectors.toList());

	}

	public List<String> brandMileageList() {

		System.out.println("Lista marka-przebieg: ");

		return carsList.stream().map(o -> o.getBrand() + "-" + o.getMileage()).sorted((o1, o2) -> o1.compareTo(o2))
				.collect(Collectors.toList());
	}

	public void statistics() {

		System.out.println("Statystyka pojemnosci min: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getCapacity)).getMin());
		System.out.println("Statystyka pojemnosci srednia: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getCapacity)).getAverage());
		System.out.println("Statystyka pojemnosci max: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getCapacity)).getMax());

		System.out.println("Statystyka przebiegu min: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getMileage)).getMin());
		System.out.println("Statystyka przebiegu srednia: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getMileage)).getAverage());
		System.out.println("Statystyka przebiegu max: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getMileage)).getMax());

		System.out.println("Statystyka ceny min: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getPrice)).getMin());
		System.out.println("Statystyka ceny srednia: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getPrice)).getAverage());
		System.out.println("Statystyka ceny max: ");
		System.out.println(carsList.stream().collect(Collectors.summarizingDouble(Car::getPrice)).getMax());
	}

	public Optional<Car> elementWithHighestPrice() {
		System.out.println("Element o najwiekszej cenie: ");

		return carsList.stream().sorted((s1, s2) -> (Double.compare(s2.getPrice(), s1.getPrice()))).findFirst();

	}

	public List<Car> equipmentSorting() {

		System.out.println("Elementy wyposazenia posortowane alfabetycznie: ");

		return carsList.stream()
				.map(x -> new Car(x.getBrand(), x.getPrice(), x.getCapacity(), x.getMileage(),
						x.getEquipment().stream().sorted((w1, w2) -> w1.compareTo(w2)).collect(Collectors.toList())))
				.collect(Collectors.toList());

	}

	public boolean ifContainsEquipment(String equipmentElements) {

		return carsList.stream().allMatch(o -> o.getEquipment().contains(equipmentElements));
	}
}
