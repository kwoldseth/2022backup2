/*
 * Mad Libs
 * 
 * @author Kelly Woldseth
 * @date 6/23/21
 * 
 * Simulate the game of mad libs, gaining user input to use for parts of speech.
 */

 import java.util.Scanner;

 public class MadLibs
 {
    public static void main(String[] args)
    {
        //extension: do more than three parts of speech
        //extension: do three parts of speech in a loop
        //extension: have an unknown amount of parts of speech (loop probably required) 

        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a adjective");
        String word1 = sc.nextLine();   

        System.out.println("Please input an noun");
        String word2 = sc.nextLine();   

        System.out.println("Please input a verb in the past tense");
        String word3 = sc.nextLine();      

        //uncomment to use the string
        //String str = "I went to the beach and saw a <adjective> <noun>. It <verb> at me!";
        String str = "Once upon a time in a <adjective> land, a <noun> quickly <verb>.";
        //String str= "A little bug was eaten by a <adjective> <noun>.  Then it went to heaven and <verb> the night away.";
        
        int index1 = str.indexOf("<");
        String madLib = str.substring(0, index1) + word1;
        int index2 = str.indexOf(">", index1);

        index1 = str.indexOf("<", index2);
        madLib += str.substring(index2+1, index1) + word2;
        index2 = str.indexOf(">", index1);

        index1 = str.indexOf("<", index2);
        madLib += str.substring(index2+1, index1) + word3;
        index2 = str.indexOf(">", index1);
        madLib += str.substring(index2+1); //copy rest of sentence

        System.out.println(madLib);

    }//end of main
 }//end of class
