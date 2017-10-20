package pkowalski;

public class Car {
    private String registrationNumber;
    private String producer;
    private String model;
    private String productionYear;
    private boolean rented;

    private static final String[] registrationNumberPatterns = {
            "LL_DDDDD",     // XY_12345
            "LL_DDDDL",     // XY_1234A
            "LL_DDDLL",     // XY_123AC
            "LL_DLDDD",     // XY_1A234
            "LL_DLLDD",     // XY_1AC23

            "LLL_LDDD",     // XYZ_A123
            "LLL_DDLL",     // XYZ_12AC
            "LLL_DLDD",     // XYZ_1A23
            "LLL_DDLD",     // XYZ_12A3
            "LLL_DLLD",     // XYZ_1AC2
            "LLL_LLDD",     // XYZ_AC12
            "LLL_DDDDD",    // XYZ_12345
            "LLL_DDDDL",    // XYZ_1234A
            "LLL_DDDLL",    // XYZ_123AC
            "LLL_LDDL",     // XYZ_A12C
            "LLL_LDLL",     // XYZ_A1CE
    };

    private boolean checkCharacter(char option, char registrationNumberChar) {
        switch (option) {
            case 'L':
                return Character.isLetter(registrationNumberChar);

            case 'D':
                return Character.isDigit(registrationNumberChar);

            case '_':
                return Character.isSpaceChar(registrationNumberChar);

            default:
                throw new IllegalArgumentException(option +
                        ": niedozwolony znak wzorca." +
                        "\nDozwolone znaki: 'L', 'D', '_'.");
        }
    }

    private void checkRegistrationNumberPattern(String registrationNumber) {
        boolean continueValidation;  // If pattern validation should continue.

        for (String pattern : registrationNumberPatterns) {
            if (registrationNumber.length() == pattern.length()) {
                continueValidation = true;

                for (int i = 0; i < pattern.length(); i++) {
                    char option = pattern.charAt(i);
                    char registrationNumberChar = registrationNumber.charAt(i);

                    continueValidation = checkCharacter(option, registrationNumberChar);

                    if (!continueValidation) // If at least one character is different.
                        break;
                }

                if (continueValidation) // If registrationNumber matches the pattern.
                    return;
            }
        }

        throw new IllegalArgumentException("Numer rejestracyjny niezgodny z dopuszczalnym wzorcem.");
    }

    private void validateRegistrationNumber(String registrationNumber) {
        if (registrationNumber.contains("B") ||
                registrationNumber.contains("D") ||
                registrationNumber.contains("I") ||
                registrationNumber.contains("O") ||
                registrationNumber.contains("Z") ||
                registrationNumber.contains("0")) {
            throw new IllegalArgumentException("Numer rejestracyjny zawiera niedozwolone znaki (B,D,I,O,Z,0).");
        }

        checkRegistrationNumberPattern(registrationNumber);
    }

    public final void setRegistrationNumber(String registrationNumber) {
        registrationNumber = registrationNumber.toUpperCase();
        validateRegistrationNumber(registrationNumber);
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public final void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public final void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    private void validateProductionYear(String productionYear) {
        if (productionYear.length() != 4)
            throw new IllegalArgumentException("Nieprawidłowy rok produkcji.");

        for (char prodYearChar : productionYear.toCharArray())
            if (!Character.isDigit(prodYearChar))
                throw new IllegalArgumentException("Nieprawidłowy rok produkcji.");
    }

    public final void setProductionYear(String productionYear) {
        validateProductionYear(productionYear);
        this.productionYear = productionYear;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public final void rentCar() {
        if (rented) {

            // Na pewno exception?
            throw new IllegalStateException("Samochód jest już wynajęty.");
        } else {
            this.rented = true;
        }
    }

    public final void giveCar() {
        if (!rented) {
            throw new IllegalStateException("Samochód nie został wynajęty.");
        } else {
            this.rented = false;
        }
    }

    public Car(String registrationNumber, String producer, String model, String productionYear, boolean rented) {
        setRegistrationNumber(registrationNumber);
        setProducer(producer);
        setModel(model);
        setProductionYear(productionYear);
        this.rented = rented;
    }

    public Car(String registrationNumber, String producer, String model, String productionYear) {
        this(registrationNumber, producer, model, productionYear, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(producer).append(" ").append(model).append(" ").append(productionYear).append("\n");
        sb.append("Registration number: ").append(registrationNumber).append("\n");
        sb.append("Status: ");

        if (rented) {
            sb.append("Rented");
        } else {
            sb.append("Available");
        }

        return sb.toString();
    }
}
