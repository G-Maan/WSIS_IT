package pkowalski;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class CarRental {
    private ArrayList<Car> cars;
    private ArrayList<CarLog> logs;
    private int rentedCars;

    CarRental() {
        cars = new ArrayList<>();
        logs = new ArrayList<>();
        rentedCars = 0;
    }

    @Nullable
    private Car findCar(String registrationNumber) {
        for (Car car : cars) {
            if (car.getRegistrationNumber().equals(registrationNumber))
                return car;
        }
        return null;
    }

    boolean canRentCar(String registrationNumber) {
        Car car = findCar(registrationNumber);
        return car != null && !car.isRented();
    }

    private void rentCar(Car car) throws IllegalStateException {
        car.rent();
        logs.add(new CarLog(car.getRegistrationNumber(), car.getProducer(), car.getModel(),
                car.getProductionYear(), car.isRented()));
        rentedCars++;
    }

    void rentCar(String registrationNumber) throws IllegalArgumentException, IllegalStateException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            rentCar(car);
    }

    void rentCar(int index) throws IllegalStateException, IndexOutOfBoundsException {
        Car car = cars.get(index);
        rentCar(car);
    }

    private void giveCar(Car car) throws IllegalStateException {
        car.give();
        logs.add(new CarLog(car.getRegistrationNumber(), car.getProducer(), car.getModel(),
                car.getProductionYear(), car.isRented()));
        rentedCars--;
    }

    void giveCar(String registrationNumber) throws IllegalArgumentException, IllegalStateException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else {
            giveCar(car);
        }
    }

    void giveCar(int index) throws IllegalStateException, IndexOutOfBoundsException {
        Car car = cars.get(index);
        giveCar(car);
    }

    boolean addCar(String registrationNumber, String producer, String model, String productionYear)
            throws IllegalArgumentException {
        Car car = findCar(registrationNumber);
        return car == null && cars.add(new Car(registrationNumber, producer, model, productionYear));
    }

    boolean removeCar(String registrationNumber) throws IllegalArgumentException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            return cars.remove(car);
    }

    boolean removeCar(int index) throws IndexOutOfBoundsException {
        cars.remove(index);
        return true;
    }

    private void editCar(Car car, String registrationNumber, String producer, String model, String productionYear)
            throws IllegalArgumentException {
        if (!registrationNumber.equals(""))
            car.setRegistrationNumber(registrationNumber);

        if (!producer.equals(""))
            car.setProducer(producer);

        if (!model.equals(""))
            car.setModel(model);

        if (!productionYear.equals(""))
            car.setProductionYear(productionYear);
    }

    void editCar(String oldRegistrationNumber, String newRegistrationNumber, String producer, String model,
                 String productionYear) throws IllegalArgumentException {
        Car car = findCar(oldRegistrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            editCar(car, newRegistrationNumber, producer, model, productionYear);
    }

    void editCar(int index, String registrationNumber, String producer, String model, String productionYear)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        Car car = cars.get(index);
        editCar(car, registrationNumber, producer, model, productionYear);
    }

    String stats() {
        return "Samochody w wypożyczalni: " + cars.size() + "\n" +
                "Wypożyczone: " + rentedCars + "\n" +
                "Dostępne: " + (cars.size() - rentedCars) + "\n";
    }

    String logsAll() {
        logs.sort(new CarLog.CarLogComparator());
        StringBuilder sb = new StringBuilder();

        for (CarLog log : logs)
            sb.append(log.toString());

        return sb.toString();
    }

    String logs(String registrationNumber) {
        logs.sort(new CarLog.CarLogComparator());
        StringBuilder sb = new StringBuilder();

        for (CarLog log : logs)
            if (registrationNumber.equals(log.getRegistrationNumber()))
                sb.append(log.toString());

        return sb.toString();
    }

    String carToString(int index) throws IndexOutOfBoundsException {
        return cars.get(index).toString();
    }

    String carToString(String registrationNumber) throws IllegalArgumentException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            return car.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cars.size(); i++) {
            sb.append("[").append(i + 1).append("]\n");
            sb.append(cars.get(i).toString()).append("\n");
        }

        return sb.toString();
    }
}
