import java.util.Random;
import java.util.Scanner;

public class Lab10 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Q1();
        Q2();
        Q3();
        Q4();
        scan.close();
    }

    public static void Q1() {
        while (true){
            System.out.println("Pick a shape: square, rectangle, circle (or 'q' to quit)");
            String input = scan.nextLine();
            if (input.equals("q")) {
                return;
            }

            if (input.equals("square")) {
                double a;
                System.out.println("Enter the length of all sides: ");
                a = Double.parseDouble(scan.nextLine());
                //Changed the terms of circumference of square and rectangle
                //To perimeter
                System.out.println("The perimeter of the square is: " + a * 4);
                System.out.println("The area of the square is: " + a * a);

            } else if (input.equals("rectangle")) {
                double a, b;
                System.out.println("Enter the length of side a: ");
                a = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the length of side b: ");
                b = Double.parseDouble(scan.nextLine());
                System.out.println("The perimeter of the rectangle is: " + (2 * a + 2 * b));
                System.out.println("The area of the rectangle is: " + (a * b));
            } else if (input.equals("circle")) {
                double r;
                System.out.println("Enter the radius: ");
                //Changed turning a string to a double to reading a double
                r = scan.nextDouble();
                System.out.println("The circumference of the circle is: " + (2 * Math.PI * r));
                System.out.println("The area of the circle is: " + (Math.PI * r * r));
            }
        }
    }

    public static void Q2() {
        System.out.println("Q2: Enter the current day (1-31): ");
        int num = scan.nextInt();
        System.out.println("Enter the current month: (1-12)");
        int num2 = scan.nextInt();
        //Reduced the number of days down by taking in all the 
        //Numbers that will have a "th" at the end
        if (num == 1)
            System.out.print("You selected 1st of ");
        else if (num == 2)
            System.out.print("You selected 2nd of ");
        else if (num == 3)
            System.out.print("You selected 3rd of ");
        else if (num == 21)
            System.out.print("You selected 21st of ");
        else if (num == 22)
            System.out.print("You selected 22nd of ");
        else if (num == 23)
            System.out.print("You selected 23rd of ");
        else if (num == 31)
            System.out.print("You selected 31st of ");
        else {
            System.out.println("You selected " + num + "th of ");
        }
        //Made a switch insead of a block of if else
        switch (num2) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
        }
    }

    public static void Q3() {
        //Question 3 was not indented correctly and would never run
        //So I indented it in a way that makes it run like all the other questions
        System.out.println("Q3: Enter how many numbers you want to check for primality: ");
        int n = scan.nextInt();
        //Changed from scanning and converting a string into integer
        //To just scanning an integer
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (i < 2)
                continue;
            boolean check = true;

            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    check = false;
                    break;
                } else {

                }
            }
            if (check == true) {
                counter++;
            } else {
            }
        }

        System.out.println("There are: " + counter + " primes between 0 and " + n);
    }

    public static void Q4() {
        Random rng = new Random();

        String next;
        System.out.println(
                "Q4: Let's play a game. Type \"A\" to attack, \"B\" to buff your next attack. Kill the enemy to win!");
        System.out.println(
                "Q4: You must roll higher than the enemy armor class (12) to hit. Roll 20 for a critical hit!");
        System.out.println("Q4: Your damage is 2-16 (2d8)");

        int enemyHP = 100;
        int a = 0;

        boolean check = false;
        while (true) {

            boolean doAttack = false;
            boolean check2 = false;
            while (!check2) {
                next = scan.nextLine();
                check2 = true;
                switch (next) {
                    case "A", "a":
                        doAttack = true;
                        break;
                    case "B", "b":
                        check = true;
                        System.out.println("Buffing! +5 to your next attack roll and damage");
                        break;
                    default:
                        System.out.println("Invalid input");
                        check2 = false;
                }
            }

            if (doAttack) {
                a++;
                int attackRoll = rng.nextInt(21); 
                //I changed the random to have an upper limit of 21, yet not includin 21
                //Rather than adding 1 onto every single roll, as this didn't make sense.
                int damage = 0;
                System.out.print("You rolled: " + attackRoll);
                if (check) {
                    attackRoll += 5;
                    System.out.print(" + 5 (buff active)\n");
                } else {
                    System.out.println();
                }
                if (attackRoll >= 12) {
                    damage = rng.nextInt(8) + 1;
                    damage += rng.nextInt(8) + 1;
                    if (check) {
                        damage += 5;
                    }
                    if (attackRoll == 20 || (check && attackRoll == 20 + 5)) {
                        damage *= 2;
                        System.out.print("Critical hit! ");
                    }
                    System.out.print("You dealt " + damage + " damage");
                    if (check) {
                        System.out.print(" (buffed attack)");
                    }
                    enemyHP -= damage;
                    System.out.println("\nEnemy HP: " + Math.max(0, enemyHP));

                } else {
                    System.out.println("Miss");
                }

                check = false;
                if (enemyHP <= 0) {
                    System.out.println("Enemy died in " + a + " turns");
                    scan.close();
                    return;
                }
            }

        }
    }
}
