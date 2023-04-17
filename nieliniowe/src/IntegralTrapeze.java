import java.util.function.DoubleFunction;

public class IntegralTrapeze {
    public  static double integral(double a, double b, int n){
        double dx = (b - a) / n;
        double result = 0;
        for (double i = 0; i < n - 1; i++) {
            result += f(a + i * dx);
        }
        result = (result + ((f(a) - f(b) / 2))) * dx;

        return result;
    }
    public static double f(double x) {
        return x*x;
    }
    public static void main(String[] args) {
        System.out.println(integral(-1,1,10000));

    }
}
