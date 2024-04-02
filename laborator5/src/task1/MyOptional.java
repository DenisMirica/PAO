package task1;

import java.util.NoSuchElementException;

public class MyOptional<T> {
    private final T value;

    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> of(T value) {
        if (value == null) {
            return new MyOptional<>(null);
        }
        return new MyOptional<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("NoSuchElementException");
        }
        return value;
    }
}
