
public class Main {

	// PROGRAM WYKONANY W RAMACH SZKOLENIA KM-PROGRAMS
	// http://km-programs.pl/

	public static void main(String[] args) {

		CarsList l = new CarsList("Samochody");

		System.out.println(l);

		l.sortByName().forEach(e -> System.out.println(e));
		l.sortByPrice().forEach(e -> System.out.println(e));
		l.sortByCapacity().forEach(e -> System.out.println(e));
		l.sortByMileage().forEach(e -> System.out.println(e));
		l.sortByEquipment().forEach(e -> System.out.println(e));
		l.removeElementsAboveMileage(35000.0).forEach(e -> System.out.println(e));
		l.brandMileageList().forEach(e -> System.out.println(e));

		l.statistics();
	}

}
