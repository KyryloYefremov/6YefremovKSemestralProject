package semestral_project;

import java.util.Scanner;

public class UI {

    static final Scanner sc = new Scanner(System.in);

    /**
     * This program evaluates the sum and product for each two polynomials. The
     * input polynomials are given by degree and individual coefficients.
     *
     * @author KyryloYefremov
     * @version 0.1 12/12/22
     */
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

    /**
     * This method displays a guide menu
     */
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

    /**
     * This method launches the program SemesterWork
     */
    public static void semesterWork() {
        int degree1, degree2;
        int[] coeffs1, coeffs2;
        System.out.println("\n" + "|<><><><><><><><><><><><><><><><><><><>|");
        System.out.println("|                                      |");
        System.out.println("|   Vitejte v moji semestralni praci!  |");
        System.out.println("|                                      |");
        System.out.println("|<><><><><><><><><><><><><><><><><><><>|" + "\n");
        do {
            System.out.println("❆ Zadejte stupen prvniho polynomu: (kdyz chcete ukoncit, zadejte zapornou hodnotu) ");
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
            PolynomialTools.reverse(coeffs1);
            writeOutPolynom(coeffs1);
            System.out.print("❆ Druhy polynom: ");
            PolynomialTools.reverse(coeffs2);
            writeOutPolynom(coeffs2);
            int[] polynomsSum = PolynomialTools.sum(coeffs1, coeffs2);
            System.out.print("❆ Soucet polynomu: ");
            writeOutPolynom(polynomsSum);
            System.out.print("❆ Soucin polymonu: ");
            int[] polymomsProduct = PolynomialTools.product(coeffs1, coeffs2);
            writeOutPolynom(polymomsProduct);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        } while (degree1 >= 0);

    }

    /**
     * This method gets a degree of a polynomial.
     *
     * @return degree
     */
    public static int getPolynomDegree() {
        int degree = sc.nextInt();
        return degree;
    }

    /**
     * This method gets polynomial coefficients. A number of coefficients is 1
     * more than a degree of a polynomial.
     *
     * @param degree
     * @return array of coefficients
     */
    public static int[] getPolynomCoeffs(int degree) {
        int[] coeffs = new int[degree + 1];
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = sc.nextInt();
        }
        return coeffs;
    }

    /**
     * This method writes out a polynomial in a math view Example: 3x^3 - 2x^2 +
     * 5x - 1
     *
     * @param coeffs array of coefficients
     */
    public static void writeOutPolynom(int[] coeffs) {
        int degree = coeffs.length - 1;
        char x = 'x';
        // Here we check if a coefficient at the highest degree is not 0. If it is, we skip writing out this element, 
        // lowering the degree. Also we control if a degree is not less than 1, because if it is, for example, equal 0
        // we will reduce it and we will get a negative degree, which is not valid for us, because we use it as an array index
        while (coeffs[degree] == 0 && degree > 0) {
            degree--;
        }
        // Here we write out elements of a polynomial 
        // First of all, we control a sign of every element (if it is positive or negative), secondly, we control a value
        // of coefficients (if a coef. == 1 and a degree is not equal 0 (in this case we will write out), 
        // we will not write this coef. out. Then we control if a degree is/is not equal zero, on this depends two things:
        // will we write out 'x' and will we write out a degree (if a degree == 1 or 0, then we will not do writing out)
        System.out.print((coeffs[degree] >= 0 ? "" : "-") + "" + (Math.abs(coeffs[degree]) == 1 && degree != 0 ? "" : Math.abs(coeffs[degree]))
                + "" + (degree == 0 ? "" : x) + (degree <= 1 ? "" : ("^" + degree)));
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

    /**
     * This method launches the Main method of the program ChristmasTask
     */
    public static void christmasTask() {
        String[] args = new String[0];
        ChristmasTask.main(args);
    }
}
