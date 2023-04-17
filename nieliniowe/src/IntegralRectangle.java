import java.util.function.DoubleFunction;

public class IntegralRectangle {

    public static double integral(double a, double b, int n) {
        double dx = (b - a) / n;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            double x = a + i * dx;
            sum += f(x);
        }
        return dx * sum;
    }

    public static double f(double x) {
        return x*x;
    }

    public static void main(String[] args) {
        System.out.println(integral(0,1,1000));
    }

}
