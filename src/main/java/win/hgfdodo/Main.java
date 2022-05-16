package win.hgfdodo;

import java.text.DecimalFormat;
import java.util.Random;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        int n = 3;
        int m = 5;
        double min = 0.01;
        Random random = new Random();
        DecimalFormat  formatter = new DecimalFormat("#.##");
        double f = 0.075;
        out.println(f);
        out.println(formatter.format(f));
    }


}