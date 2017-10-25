package pkowalski;

import java.util.Comparator;
import java.util.Date;

public class CarLog {
    private final Date date;
    private final String registrationNumber;
    private final String producer;
    private final String model;
    private final String productionYear;
    private final boolean rented;

    Date getDate() {
        return date;
    }

    String getRegistrationNumber() {
        return registrationNumber;
    }

    String getProducer() {
        return producer;
    }

    String getModel() {
        return model;
    }

    String getProductionYear() {
        return productionYear;
    }

    boolean isRented() {
        return rented;
    }

    CarLog(String registrationNumber, String producer, String model, String productionYear, boolean rented) {
        this.date = new Date();
        this.registrationNumber = registrationNumber;
        this.producer = producer;
        this.model = model;
        this.productionYear = productionYear;
        this.rented = rented;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(date.toString());

        if (rented)
            sb.append("\tWypożyczenie\t");
        else
            sb.append("\tZwrot\t\t");

        sb.append(producer).append(" ").append(model).append(" ").append(productionYear)
                .append(" (").append(registrationNumber).append(")\n");

        return sb.toString();
    }

    static class CarLogComparator implements Comparator<CarLog> {
        public int compare(CarLog cl1, CarLog cl2) {
            return cl2.date.compareTo(cl1.date);
        }
    }
}
