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

    private static final char[] registrationNumberInvalidChars = {'B', 'D', 'I', 'O', 'Z', '0'};

    private boolean checkCharacter(char option, char registrationNumberChar) throws IllegalArgumentException {
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

    private void checkRegistrationNumberPattern(String registrationNumber) throws IllegalArgumentException {
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

    private void validateRegistrationNumber(String registrationNumber) throws IllegalArgumentException {
        checkRegistrationNumberPattern(registrationNumber);

        String regNumberSubstring = registrationNumber.substring(3);

        for (char invalidChar : registrationNumberInvalidChars)
            if (regNumberSubstring.contains(String.valueOf(invalidChar)))
                throw new IllegalArgumentException("Wyróżnik pojazdu zawiera niedozwolone znaki (B,D,I,O,Z,0).");
    }

    final void setRegistrationNumber(String registrationNumber) throws IllegalArgumentException {
        registrationNumber = registrationNumber.toUpperCase();
        validateRegistrationNumber(registrationNumber);
        this.registrationNumber = registrationNumber;
    }

    String getRegistrationNumber() {
        return registrationNumber;
    }

    final void setModel(String model) {
        this.model = model;
    }

    String getModel() {
        return model;
    }

    final void setProducer(String producer) {
        this.producer = producer;
    }

    String getProducer() {
        return producer;
    }

    private void validateProductionYear(String productionYear) throws IllegalArgumentException {
        for (char prodYearChar : productionYear.toCharArray())
            if (!Character.isDigit(prodYearChar))
                throw new IllegalArgumentException("Rok produkcji zawiera niedozwolone znaki.");

        if (productionYear.length() != 4)
            throw new IllegalArgumentException("Nieprawidłowy rok produkcji.");
    }

    final void setProductionYear(String productionYear) throws IllegalArgumentException {
        validateProductionYear(productionYear);
        this.productionYear = productionYear;
    }

    String getProductionYear() {
        return productionYear;
    }

    final void rent() throws IllegalStateException {
        if (rented)
            throw new IllegalStateException("Samochód jest już wynajęty.");
        else
            this.rented = true;
    }

    final void give() throws IllegalStateException {
        if (!rented)
            throw new IllegalStateException("Samochód nie został jeszcze wynajęty.");
        else
            this.rented = false;
    }

    boolean isRented() {
        return rented;
    }

    Car(String registrationNumber, String producer, String model, String productionYear, boolean rented)
            throws IllegalArgumentException {
        setRegistrationNumber(registrationNumber);
        setProducer(producer);
        setModel(model);
        setProductionYear(productionYear);
        this.rented = rented;
    }

    Car(String registrationNumber, String producer, String model, String productionYear)
            throws IllegalArgumentException {
        this(registrationNumber, producer, model, productionYear, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getProducer()).append(" ").append(getModel()).append(" ").append(getProductionYear()).append("\n");
        sb.append("Numer rejestracyjny: ").append(getRegistrationNumber()).append("\n");
        sb.append("Status: ");

        if (rented)
            sb.append("Wypożyczony\n");
        else
            sb.append("Dostępny\n");

        return sb.toString();
    }
}
