public class Casting
{
        public static void main(String args[])
    {
        System.out.println(9+4);
        System.out.println(9*4);
        System.out.println(9/4);

        //Expand the lines below to see different ways to cast the result of line 7 to a double
        

       /* System.out.println(9.0/4); //AUTOMATIC WIDENING
        System.out.println(9/4.0); //AUTOMATIC WIDENING
        System.out.println(9.0/4.0); 
        System.out.println((double)(9)/4); //Casting - Widening
        System.out.println(9/(double)(4)); //Casting - Widening
        */
        
        //System.out.println((double)(9/4)); //does not work since 9/4 is type int and then gets casted to a double

        //System.out.println((int)((9.0)/(4.0))); //Casting - Narrowing

        //int a = 5.4/3.0; //incompatible data types --- double division cannot be stored as an int. Narrowing does not occur automatically.
        
        
    }
}










