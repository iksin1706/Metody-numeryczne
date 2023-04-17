import java.util.function.DoubleFunction;

public class Bisekcji {
    private static final double DX = 0.0001;
    public static double bisection(double a,double b,double e){



        double s= (a+b)/2;
        int count=0;
        while(Math.abs(f(s))>e){

            if(f(a)*f(s)<0){
                b=s;
            } else {
                a=s;
            }
            s = (a+b)/2;
            count++;
        }
        System.out.println("Ilosc iteracji: "+count);
        return s;
    }
    static double f(double x){
        return (x+1)*(Math.pow((x-1),4));
    }
    static double f(DoubleFunction<Double> f, double x) {
        return f.apply(x);
    }
    private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
        return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
    }
}
