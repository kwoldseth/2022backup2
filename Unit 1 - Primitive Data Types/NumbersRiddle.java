/*
 * Activity 1.1.6
 * 
 * @author Kelly Woldseth
 * @date 6/23/21
 * 
 * Your program should allow any number to be stored in a variable and printed out. 
 * Then, the program should output its double, output six added to it, output that number divided in half, and, 
 * finally, output that number subtracted by the original number. In this way, the program displays each 
 * calculation, and of course, the final result of three.
 */

 public class NumbersRiddle
 {
    public static void main(String[] args)
    {

        //extension: use a scanner to gather user input
        //extension: use a while loop to keep replaying the riddle until the user says no

        double number = 5; //comment out to test other cases
        //double number = -5; //comment out to test other cases
        //double number = 1; //comment out to test other cases
        //double number = 0; //comment out to test other cases
        //double number = 6.4; //comment out to test other cases
        //double number = -6.4; //comment out to test other cases

        System.out.println("The number is " + number);
        System.out.println("Doubling the number gives " + number*2);
        double number2 = number*2+6;
        System.out.println("Adding six gives " + number2);
        System.out.println("Diving by 2 gives " + number2/2);
        double number3 = (number2/2) - number;
        System.out.println("Subtracting the original number gives " + number3);

    }//end of main
 }//end of class
