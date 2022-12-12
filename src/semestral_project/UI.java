package semestral_project;

import java.util.Scanner;

public class UI {

    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        boolean end = false;

        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 ->
                    semesterWork();
                case 2 ->
                    christmasTask();
                case 0 ->
                    end = true;
                default ->
                    System.out.println("❆ Neplatna volba. Zkuste jeste jednou");
            }
        } while (!end); // end == false
    }

    public static void displayMenu() {
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("|                   Vitejte v menu!                  |");
        System.out.println("|       Vyberte program, ktery chcete spustit.       |");
        System.out.println("| Pokud chcete spustit semestralni praci, zadejte 1; |");
        System.out.println("|    Pokud chcete spustit vanocni ukol, zadejte 2;   |");
        System.out.println("|          Pokud chcete ukoncit, zadejte 0.          |");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.print(">> ");
    }

    public static void semesterWork() {
        int degree1, degree2;
        int[] coeffs1, coeffs2;
        System.out.println("\n" + "|<><><><><><><><><><><><><><><><><><><>|");
        System.out.println("|                                      |");
        System.out.println("|   Vitejte v moji semestralni praci!  |");
        System.out.println("|                                      |");
        System.out.println("|<><><><><><><><><><><><><><><><><><><>|" + "\n");
        do {
            System.out.println("❆ Zadejte stupen prvniho polynomu: ");
            System.out.print(">> ");
            if ((degree1 = getPolynomDegree()) < 0) {
                break;
            }
            System.out.println("❆ Zadejte koeficienty prvniho polynomu: ");
            System.out.print(">> ");
            coeffs1 = getPolynomCoeffs(degree1);
            System.out.println("❆ Zadejte stupen druheho polynomu: ");
            System.out.print(">> ");
            degree2 = getPolynomDegree();
            System.out.println("❆ Zadejte koeficienty druheho polynomu: ");
            System.out.print(">> ");
            coeffs2 = getPolynomCoeffs(degree2);
            System.out.print("❆ Prvni polynom: ");
            writeOutPolynom(coeffs1);
            System.out.print("❆ Druhy polynom: ");
            writeOutPolynom(coeffs2);
            int[] polynomsSum = PolynomialTools.sum(coeffs1, coeffs2);
            System.out.print("❆ Soucet polynomu: ");
            writeOutPolynom(polynomsSum);
            System.out.print("❆ Soucin polymonu: ");
            int[] polymomsProduct = PolynomialTools.product(coeffs1, coeffs2);
            writeOutPolynom(polymomsProduct);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } while (degree1 >= 0);

    }

    public static int getPolynomDegree() {
        int degree = sc.nextInt();
        return degree;
    }

    public static int[] getPolynomCoeffs(int degree) {
        int[] coeffs = new int[degree + 1];
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = sc.nextInt();
        }
        return coeffs;
    }

    public static void writeOutPolynom(int[] coeffs) {
        int degree = coeffs.length - 1;
        char x = 'x';
        PolynomialTools.reverse(coeffs);
        while (coeffs[degree] == 0) {
            degree--;
        }
        System.out.print((coeffs[degree] > 0 ? "" : "-") + "" + (Math.abs(coeffs[degree]) == 1 && degree != 0 ? "" : Math.abs(coeffs[degree])) + ""
                + (degree == 0 ? "" : x) + (degree <= 1 ? "" : ("^" + degree)));
        for (int i = degree - 1; i >= 0; i--) {
            if (coeffs[i] < 0) {
                System.out.print(" - " + (Math.abs(coeffs[i]) == 1 && i != 0 ? "" : Math.abs(coeffs[i])) + "" + (i == 0 ? "" : x) + ""
                        + (i <= 1 ? "" : ("^" + i)));
            } else if (coeffs[i] > 0) {
                System.out.print(" + " + (coeffs[i] == 1 && i != 0 ? "" : coeffs[i]) + "" + (i == 0 ? "" : x) + ""
                        + (i <= 1 ? "" : ("^" + i)));
            }
        }
        System.out.println();
    }

    public static void christmasTask() {
        String[] args = new String[0];
        ChristmasTask.main(args);        
    }
}
