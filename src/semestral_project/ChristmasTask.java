package semestral_project;

import java.util.Scanner;

public class ChristmasTask {
    // colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    
    static Scanner sc = new Scanner(System.in);
    static char pattern1 = '*';
    static char pattern2 = 'x';
    static String color1 = ANSI_BLACK;
    static String color2 = ANSI_BLACK;
    
    
    public static void main(String[] args) {
        int choice;
        boolean end = false;
        //System.out.println("$ $ $ " + pattern1 + " $ $ $ ");
        //System.out.println(ANSI_CYAN + "This text is red!" + ANSI_RESET);

        do {
            displayMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1 ->
                    paintTreeDecoration();
                case 2 ->
                    settings();
                case 0 ->
                    end = true;
                default -> {
                    System.out.println("\n" + "|********************|");
                    System.out.println(     "|   Neplatna volba   |" );
                    System.out.println(       "|********************|" + "\n");
                }
            }
            System.out.println();
        } while (!end); // end == false
    }

    private static void displayMenu() {
        System.out.println("|****************************************************|");
        System.out.println("|             Zdravim te v nasem programu!           |");
        System.out.println("|  Tento program kresli dekoraci na vanocni stromek  |");
        System.out.println("|                    Zadej volbu:                    |");
        System.out.println("|          1. Nakreslit ve vychozim nastaveni        |");
        System.out.println("|         2. Nastavit barvu a vzor na dekoraci       |");
        System.out.println("|                 0. Ukoncit program                 |");
        System.out.println("|****************************************************|");
        System.out.print(">> ");
        
        
    }
    
    // there you can change type of patterns and their colors
    private static void settings() {
        int choice;
        boolean end;
        System.out.println("|******************************************************|");
        System.out.println("|                   Vitejme v nastaveni                |");
        System.out.println("|      Tady muzete nastavit barvy a vzory dekorace     |");
        System.out.println("|       Nastav prvni a druhou barvu, k dispozici:      |" );
        System.out.println("|  __________________________________________________  |");
        System.out.println("|  0. Ve vychozim nastaveni (podle tematy bila/cerna)  |");
        System.out.println("|                     1. Cervena                       |");
        System.out.println("|                     2. Zelena                        |");
        System.out.println("|                     3. Zluta                         |");
        System.out.println("|                     4. Modra                         |");
        System.out.println("|                     5. Fialova                       |");
        System.out.println("|                     6. Azurova                       |");
        System.out.println("|              Zadej barvu prvni dekorace:             |");
        System.out.println("|******************************************************|");
        System.out.print(">> ");        
        do {
            end = true;
            choice = sc.nextInt();
            switch (choice) {
                case 0 -> 
                    color1 = ANSI_BLACK;
                case 1 ->
                    color1 = ANSI_RED;
                case 2 ->
                    color1 = ANSI_GREEN;
                case 3 ->
                    color1 = ANSI_YELLOW;
                case 4 ->
                    color1 = ANSI_BLUE;
                case 5 ->
                    color1 = ANSI_PURPLE;
                case 6 ->
                    color1 = ANSI_CYAN;
                default -> {
                    end = false;
                    System.out.println("\n" + "|***************************************|");
                    System.out.println(     "|   Neplatna volba, zkus jeste jednou   |");
                    System.out.println(       "|***************************************|" + "\n");
                    System.out.print(">> ");
                }
            }
        }while(!end);
        System.out.println("\n" + "|*******************************|");
        System.out.println(     "|  Zadej barvu druhe dekorace:  |");
        System.out.println(       "|*******************************|");
        System.out.print(">> ");
        choice = sc.nextInt();
        do {
            switch (choice) {
                case 0 -> 
                    color2 = ANSI_BLACK;
                case 1 ->
                    color2 = ANSI_RED;
                case 2 ->
                    color2 = ANSI_GREEN;
                case 3 ->
                    color2 = ANSI_YELLOW;
                case 4 ->
                    color2 = ANSI_BLUE;
                case 5 ->
                    color2 = ANSI_PURPLE;
                case 6 ->
                    color2 = ANSI_CYAN;
                default -> {
                    end = false;                    
                    System.out.println("Neplatna volba, zkus jeste jednou");
                }
            }
        }while(!end);
        System.out.println("|*******************************************************|");
        System.out.println("|   Nastav vzory (zadej kazdy vzor jako jeden symbol)   |");
        System.out.println("|*******************************************************|");
        System.out.println("Prvni:");
        System.out.print(">> ");
        pattern1 = sc.next().charAt(0);
        System.out.println("Druhy:");
        System.out.print(">> ");
        pattern2 = sc.next().charAt(0);
        
        //check
        // System.out.println(color + pattern1 + ' ' + pattern2 + ANSI_RESET);

        
    }

    private static void paintTreeDecoration() {
        paintTop();
        paintBody();
    }

    private static void paintTop() {
        System.out.println();
        printSpace(15);
        System.out.println("-----");
        printSpace(14);
        System.out.println("/     \\");
        printSpace(13);
        System.out.println("|       |");
        printSpace(20);
        System.out.println('/');
        printSpace(15);
        System.out.println("-----");
        printSpace(15);
        System.out.println("| $ |");
    }

    private static void paintBody() {
        // 1. row
        printSpace(11); 
        printRow(1, 3, pattern1);  
        // 2. row
        printSpace(7); 
        printRow(7, 2, pattern1);
        // 3-4. rows
        for (int i = 0; i < 2; i++) {
            printSpace(5);
            printRow(11, 1, pattern2);
        }
        // 5-7. rows
        for (int i = 0; i < 3; i++) {
            printSpace(3);
            if (i < 2) 
                printRow(13, 1, pattern1);
            else
                printRow(13, 1, pattern2);
        }
        // middle row
        printSpace(1);
        printRow(15, 1, pattern2);
        // 9-11. rows
        for (int i = 0; i < 3; i++) {
            printSpace(3);
            if (i < 2) 
                printRow(13, 1, pattern1);
            else
                printRow(13, 1, pattern2);
        }
        // 12-13. rows
        for (int i = 0; i < 2; i++) {
            printSpace(5);
            if (i < 1) 
                printRow(11, 1, pattern1);
            else
                printRow(11, 1, pattern2);
        }      
        // 14. row
        printSpace(7);
        printRow(7, 2, pattern2);
        // 15. row
        printSpace(11);
        printRow(1, 3, pattern1); 
        // the last row
        printSpace(17);
        System.out.println("$");          
    }
 
    // this method print spaces. Input arg is amount of spaces.
    private static void printSpace(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(' ');
        }
    }
    
    // this method print a row. Input args: amount of patterns, amount of '$' and a type of pattern
    private static void printRow(int patternsCount, int dollarsCount, char currentPattern) {
        for (int i = 0; i < dollarsCount; i++) {
            System.out.print("$ ");
        }
        for (int i = 0; i < patternsCount; i++) {
            if (currentPattern == pattern1)
                System.out.print(color1 + currentPattern + " " + ANSI_RESET);
            else 
                System.out.print(color2 + currentPattern + " " + ANSI_RESET);
        }
        for (int i = 0; i < dollarsCount; i++) {
            System.out.print("$ ");
        }
        System.out.println();
    }
    
}

