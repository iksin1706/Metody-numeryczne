import java.util.Scanner;
import java.util.function.DoubleFunction;
public class Main {
    private static final double DX = 0.0001;



    public static double bisection(double a,double b,double e,DoubleFunction<Double> function){
        double s= (a+b)/2;
        int count=0;



        while(Math.abs(f(function,s))>e){

            if(f(function,a)*f(function,s)<0){
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

    static double fb(double x){
        return (x+1)*(Math.pow((x-1),4));
    }

        static double f(DoubleFunction<Double> f, double x) {
            return f.apply(x);
        }
        private static DoubleFunction<Double> derive(DoubleFunction<Double> f) {
            return (x) -> (f.apply(x + DX) - f.apply(x)) / DX;
        }

        public static void falsi(double a, double b, double e, DoubleFunction<Double> function) {
            if (f(function, a) * f(function, b) >= 0) {
                System.out.println(("Wartosci na koncach przedzialu sa takie same!"));
                return;
            }
                DoubleFunction<Double> f1 = derive(function);
                DoubleFunction<Double> f2 = derive(f1);

                double c = a;
                if (f(f1, a) * f(f2, a) >= 0) {
                    c = a;
                }
                if (f(f1, b) * f(f2, b) >= 0) {
                    c = b;
                }

                if (f(f1, b) * f(f2, b) >= 0 && f(f1, a) * f(f2, a) >= 0) {
                    if (f(function, a) * f(f2, a) >= 0) {
                        c = a;
                    }
                    if (f(function, b) * f(f2, b) >= 0) {
                        c = b;
                    }
                }
                double x;
                if (c == b)
                    x = a;
                else x = b;

                int cnt = 0;

                while (Math.abs(f(function, x)) >= e) {
                    x = x - (f(function, x) * (c - x)) / (f(function, c) - f(function, x));
                    cnt++;
                }

                System.out.println("x = " + x);
                System.out.println("Iteracje: " + cnt);
            }

    public static void styczne(double a, double b, double epsil, DoubleFunction<Double> rownanie) {
        if (f(rownanie, a) * f(rownanie, b) >= 0) {
            throw new IllegalArgumentException("Wartosci na koncach przedzialu sa takie same!");
        }
        DoubleFunction<Double> f1 = derive(rownanie);
        DoubleFunction<Double> f2 = derive(f1);
        double c = a;
        if (f(f1, a) * f(f2, a) >= 0) {
            c = a;
        }
        if (f(f1, b) * f(f2, b) >= 0) {
            c = b;
        }

        if (f(f1, b) * f(f2, b) >= 0 && f(f1, a) * f(f2, a) >= 0) {
            if (f(rownanie, a) * f(f2, a) >= 0) {
                c = a;
            }
            if (f(rownanie, b) * f(f2, b) >= 0) {
                c = b;
            }
        }
        int cnt = 0;
        while (Math.abs(f(rownanie, c)) >= epsil) {
            c = c - (f(rownanie, c) / f(f1, c));
            cnt++;
        }
        System.out.println("x" + " = " + c);
    }


    public static void main(String[] args) {
        DoubleFunction<Double> f = (x) -> (x+1)*(Math.pow((x-1),4));
        falsi(-1.5,0.75,0.01,f);

    }
}