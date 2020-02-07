package com.company;

import java.util.List;
import java.util.Optional;

public class OptionalExample {
    static class Car {
        private List<String> details;

        public List<String> getDetails() {
            return details;
        }
    }

    public static void main(String[] args) {
        Optional<String> message = makeErrorMessage(false);
        Integer length = message.map(e -> e.length()).orElse(0);

        System.out.println("Length of error message = " + length);

        int count = make()
                .map(Car::getDetails)
                .map(d -> d.size())
                .orElse(0);

        System.out.println(count);
    }

    private static Optional<Car> make() {
        return Optional.ofNullable(null);
//        return Optional.of(new Car());
    }

    private static void oldStyle() {
        String message = makeErrorMessageOldStyle(false);
        int length = 0;
        if (message != null) {
            length = message.length();
        }
        System.out.println("Length of error message = " + length);
    }

    private static String makeErrorMessageOldStyle(boolean hasError) {
        if (hasError) {
            return "My pretty BUG:)";
        }

        return null;
    }

    private static Optional<String> makeErrorMessage(boolean hasError) {
        if (hasError) {
            return Optional.of("My pretty BUG:)");
        }

        return Optional.empty();
    }
}
