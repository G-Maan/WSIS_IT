package pkowalski;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class CarRental {
    private ArrayList<Car> cars;

    public CarRental() {
        cars = new ArrayList<>();
    }

    @Nullable
    private Car findCar(String registrationNumber) {
        for (Car car : cars) {
            if (car.getRegistrationNumber().equals(registrationNumber))
                return car;
        }
        return null;
    }

    public boolean canRentCar(String registrationNumber) {
        Car car = findCar(registrationNumber);
        return car != null && !car.isRented();
    }

    public void rentCar(String registrationNumber) throws IllegalArgumentException, IllegalStateException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            car.rent();
    }

    public void rentCar(int index) throws IllegalStateException, IndexOutOfBoundsException {
        cars.get(index).rent();
    }

    public void giveCar(String registrationNumber) throws  IllegalArgumentException, IllegalStateException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            car.give();
    }

    public void giveCar(int index) throws IllegalStateException, IndexOutOfBoundsException {
        cars.get(index).give();
    }

    public boolean addCar(String registrationNumber, String producer, String model, String productionYear)
            throws IllegalArgumentException {
        Car car = findCar(registrationNumber);
        return car == null && cars.add(new Car(registrationNumber, producer, model, productionYear));
    }

    public boolean removeCar(String registrationNumber) throws IllegalArgumentException {
        Car car = findCar(registrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            return cars.remove(car);
    }

    public boolean removeCar(int index) throws IndexOutOfBoundsException {
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

    public void editCar(int index, String registrationNumber, String producer, String model, String productionYear)
            throws IllegalArgumentException, IndexOutOfBoundsException {
            Car car = cars.get(index);
            editCar(car, registrationNumber, producer, model, productionYear);
    }

    public void editCar(String oldRegistrationNumber, String newRegistrationNumber, String producer, String model,
                        String productionYear) throws IllegalArgumentException {
        Car car = findCar(oldRegistrationNumber);
        if (car == null)
            throw new IllegalArgumentException("Niepoprawny numer rejestracyjny.");
        else
            editCar(car, newRegistrationNumber, producer, model, productionYear);
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
