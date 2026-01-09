//we have a folder/'package' inside src called main/java/com/mycompany/kidsgame
//in this package are all of the classes that we will use 
//so to access the classes of different files, they must be in the same package


package com.mycompany.kidsgame;
import java.util.Scanner;

//random method exists in the Scanner class

public class Game {

    Scanner input = new Scanner(System.in); //new scanner for user to input their answer


    public int score; //keep track of the user's score
    public String summary=""; //to keep track eventually of the user's results: if the answers were true/false
    

    //make the lives private variable to implement encapsulation
    private int lives = 3; 

    //takes the current lives and subtracts 1 from it each time
    public int set_lives(int lives){
        this.lives = lives - 1; 
        return this.lives; 
    }

    public void get_lives(){

        System.out.println("[ Lives = "+lives+" ]");

    }





    public void gameModes(){

        System.out.println("==== Math Learning Game ====");
        System.out.println("1) Make a Wish");
        System.out.println("2) No Mistakes");
        System.out.println("3) Take Chances (3 lives)");
        System.out.println("4) Time Trial");


    }


    public boolean generateAddQuestions(){

       

        //employ the random method to generate random numbers for the equation
        //Math.random() is used to generate a pseudorandom double that is...
        // >= 0.0 and <= 1.0


        int num1 = (int)(Math.random() * 20); //this is how we generate a random number from a specific range -- now the range generated from will be 0-19
        int num2 = (int)(Math.random() * 20);

        int actualAnswer = num1+num2; //store the correct answer

        System.out.println("What is "+num1+" + "+num2+" ?"); //print prompt for user
        int userAnswer = input.nextInt(); //get the user's answer        
        
        summary += "\n"+num1+"+"+num2+"="+userAnswer+":"+(userAnswer==actualAnswer)+"   Answer: "+actualAnswer+"\n"; //to show if the user entered the correct answer (using true/false)

        //return true or false based on the user's answer
        if(actualAnswer == userAnswer){
            ++score; //there is one score variable in the entire class
            return true; 

        }else{

            return false; 
        }
        
    }

    public boolean generateSubQuestions(){
        

        int num1 = (int)(Math.random() * 20);
        int num2 = (int)(Math.random() * 20);

        int actualAnswer = num1 - num2;

        System.out.println("What is "+num1+" - "+num2+" ?");
        int userAnswer = input.nextInt(); 

        summary += "\n"+num1+"-"+num2+"="+userAnswer+":"+(userAnswer==actualAnswer)+"   Answer: "+actualAnswer+"\n";

        //return true or false based on the user's answer
        if(actualAnswer == userAnswer){

            ++score; //there is one score variable in the entire class
            return true; 
        }else{
            return false; 
        }
    }

    public boolean generateMulQuestions(){


        int num1 = (int)(Math.random() * 20); //this 
        int num2 = (int)(Math.random() * 20);

        int actualAnswer = num1*num2;

        System.out.println("What is "+num1+" x "+num2+" ?");
        int userAnswer = input.nextInt(); 

        summary += "\n"+num1+"*"+num2+"="+userAnswer+":"+(userAnswer==actualAnswer)+"   Answer: "+actualAnswer+"\n";

       //return true or false based on the user's answer
        if(actualAnswer == userAnswer){




            ++score; //there is one score variable in the entire class
            return true; 



        }else{

            return false; 
        }
        //input.close();
    }
   
public boolean generateDivQuestions(){
        // todo: check that the inputted divisor is in the range of 1 to 10
        int num1 = (int) (Math.random() * 10); //no restriction on the dividend
        int num2 = (int) (Math.random() * 10) + 1; //divisor must be in range 1-10

        //below is called widening casting 
        //done automatically when passing a smaller size type into a larger size type such as integer to float 

        float num1f = num1; 
        float num2f = num2;

        float actualAnswer = num1f / num2f; 


        //use teh Math.round() merthod to round to the nearest hundredeth
        //1. multiply by 100 
        //2.use the math.round
        //3. then divide by 100
        double new_ans = Math.round(actualAnswer * 100); //pass a double value to Math.round -- the double value is from actualAnswer
        new_ans = new_ans/ 100; //after rounding it to the nearest integer, divide it by 100 to get back the 2 decimal places (rounded to 2 decimal places)

        System.out.println("What is "+num1+" / "+num2+" ?");

        // todo: get the user's answer: 


        double userAnswer = input.nextDouble(); 

        //check if the user input is equal to actual answer

        summary += "\n"+num1+"/"+num2+"="+userAnswer+":"+(userAnswer==new_ans)+"   Answer: "+new_ans+"\n";
        

        //return true or false based on the user's answer
        if(new_ans == userAnswer){

            ++score; //there is one score variable in the entire class
            return true; 

        }else{

            return false; 
        }

    }


    public void printSummary(){
        System.out.println("Your Score:"+score+"\n");
        System.out.println("------Summary-----\n"+summary);
    }
    
}

class Player{

    public String name; 
    public int score; 
    public String summary; 


}







