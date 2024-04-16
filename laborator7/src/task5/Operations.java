package task5;

import java.util.function.Function;

public class Operations {
    public static final Function<Double, Double> MULTIPLY_BY_SCALAR2 = number -> number * 2;
    public static final Function<Double, Double> MULTIPLY_BY_SCALAR3 = number -> number * 3;
    public static final Function<Double, Double> INCREMENT = number -> number + 1;
    public static final Function<Double, Double> INVERSE = number -> 1 / number;
    public static final Function<Double, Double> SQUARE = number -> number * number;
    public static final Function<Double, Double> SINE = Math::sin;
    public static final Function<Double, Double> COSINE = Math::cos;

}
