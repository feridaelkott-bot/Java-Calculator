
package com.mycompany.kidsgame;
import java.util.Scanner;
import java.util.Comparator; //for sorting the array of players
import java.util.Arrays; // for the sort method 



public class KidsGame {

    public static void main(String[] args) {

        //todo: scanner for all inputs in this file
        Scanner input = new Scanner(System.in); 



        //todo: create game input
        Game game = new Game();
        game.gameModes(); 

        

        //todo: get user's mode choice
        int mode = input.nextInt();
   


        //todo: ask for number of players
        System.out.println("How many players are there? "); 
        int players = input.nextInt(); 
        input.nextLine(); 


        //todo: set an array of Player objects with 'player' number of items ~ gotten from user above
        Player [] arr_players = new Player[players]; 



        // todo: make a wish option 1
        if (mode == 1){



            //todo: 'i' will control the while loop condition for multiple students
            int i = 1; 



            System.out.println("How many questions?");
            int nQuestions = input.nextInt();  
            input.nextLine();//because input reads the integer only, and not the \n, we need to clear the newline character so that the next time we call nextLine(), it reads our next input, rather than the last '\n' that was left behind



            //todo: while i < # of players, keep playing in this mode
            while (i <= players){

            
            
                // todo: reset the summary and score vars in game object, for each new player
                game.summary = ""; //reset the summary string for each player
                game.score = 0; //reset the score as well 


               
                //todo: create new player object, ask for name, and clear input buffer
                Player player = new Player(); 
                System.out.println("Enter player "+ i+" name: ");
                player.name = input.nextLine(); 

                
                
    

                //todo: get current time in milliseconds
                long startTime = System.currentTimeMillis();
                



                //todo: for the number of times there are questions to be asked,:
                for(int j=0; j<nQuestions; j++){ 



                    //todo: get a random num between 1-4 to randomly decide which arithmetic to ask: +,-,x,/
                    int random_num = (int) (Math.random() * 4) + 1; 


                    //todo: use switch statement for calling functions
                    switch(random_num){

                        //the arrow replaces the break statement needed in switch statements

                        case 1 -> game.generateAddQuestions();
                        case 2 -> game.generateSubQuestions();
                        case 3 -> game.generateMulQuestions();
                        case 4 -> game.generateDivQuestions();

                    }
                   
                        

                    

                }

                //todo: OUT OF FOR LOOP: WE'VE ASKED ALL QUESTIONS FOR THIS ONE PLAYER 



                //todo: get the end time in system in milliseconds, get the user's total time elapsed, print the summary from game object
                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println("\nYou have taken: "+totalTime/1000+" seconds\n");
                game.printSummary();



                //todo: store the score and summary of the 
                player.score = game.score; 
                player.summary = game.summary; 


                
                // todo: append to the array this current player object
                arr_players[i-1] = player; //i - 1 is for indexing 



                //todo: increment 'i' and go back to the start of the while loop 
                i++; 

            }
            
            
            

            





        // todo: No mistakes 
        }else if (mode == 2){

            int i = 1; 
            while(i <= players){

                // todo: reset the summary and score vars in game object, for each new player
                game.summary = ""; //reset the summary string for each player
                game.score = 0; //reset the score as well 


                Player player = new Player(); 
                System.out.println("Enter player "+ i+" name: ");
                player.name = input.nextLine();
                

                boolean mode_is_on = true;
                long startTime = System.currentTimeMillis();//get the current time in the system and store it in startTime
                while(mode_is_on){

                    //generate num from 1-4 to choose from the methods
                    int random_num = (int)(Math.random() * 4) + 1; 

                    //variable to store the return val of the methods
                    boolean result = false; 
                    
                    switch(random_num){

                        case 1 -> result = game.generateAddQuestions();
                        case 2 -> result = game.generateSubQuestions();
                        case 3 -> result = game.generateMulQuestions();
                        case 4 -> result = game.generateDivQuestions();

                    }


                    //if the result of the method is false, then store false in mode_is_on to exit loop 
                    mode_is_on = (result == true) ? true : false;
                }


                long endTime = System.currentTimeMillis(); 
                long totalTime = endTime - startTime;

                System.out.println("\nThe user took " + totalTime/1000 + " seconds\n");
                //print the user's results 
                game.printSummary();
                
                
                player.score = game.score; 
                player.summary = game.summary;
                


                arr_players[i-1] = player; //i - 1 is for indexing                 

                i++; 
            }
            
























        // todo: Take Chances
        }else if (mode == 3){//for 3 lives 


            int i = 1; 
            while(i <= players){

                // todo: reset the summary and score vars in game object, for each new player
                game.summary = ""; //reset the summary string for each player
                game.score = 0; //reset the score as well 
                game.set_lives(4);//reset the lives -- this function is called later to subtract from teh private int lives, so it must start at 4 to set it to three at the beginning

                Player player = new Player(); 
                System.out.println("Enter player "+ i+" name: ");
                player.name = input.nextLine();

                boolean mode_is_on = true; 
                boolean result = false; 
                int lives_left = 3;  
                long startTime = System.currentTimeMillis();//get the current time in the system and store it in startTime

                while(mode_is_on){

                    //generate random number from 1-4 
                    int random_num = (int) (Math.random() * 4) + 1; 

                    game.get_lives(); //show that user starts with 3 lives BEFORE question is asked

                    switch(random_num){

                        case 1 -> result = game.generateAddQuestions();
                        case 2 -> result = game.generateSubQuestions();
                        case 3 -> result = game.generateMulQuestions();
                        case 4 -> result = game.generateDivQuestions();

                    }


                    //if the user entered incorrect answer
                    if(result == false){

                        //call the setter method to decrease number of lives left -- use the lives_left var
                        lives_left = game.set_lives(lives_left);

                        //if lives left is 0, then exit loop
                        if(lives_left == 0){

                            mode_is_on = false; 

                        }


                    
                    }


                }
                


                long endTime = System.currentTimeMillis(); 
                long totalTime = endTime - startTime;

                System.out.println("\nThe user took " + totalTime/1000 + " seconds\n");
                //print the user's results 
                game.printSummary();


                player.score = game.score; 
                player.summary = game.summary; 


                arr_players[i-1] = player; //i - 1 is for indexing 

                i++; 

            }














        // todo: Time Trial
        }else if (mode == 4){ 

            int i = 1; 
            while(i <= players){

                // todo: reset the summary and score vars in game object, for each new player
                game.summary = ""; //reset the summary string for each player
                game.score = 0; //reset the score as well 

                Player player = new Player(); 
                System.out.println("Enter player "+ i+" name: ");
                player.name = input.nextLine();


                //ask user for a time limit 
                System.out.println("Enter a time limit (seconds): "); 
                long limit = input.nextInt();
                input.nextLine(); //clears the input buffer from taking the \n left behind by read int

                long startTime = System.currentTimeMillis()/1000; 




                while((System.currentTimeMillis()/1000) < (startTime + limit)){

                    //generate num from 1-4 to choose from the arithmetic methods
                    int random_num = (int)(Math.random() * 4) + 1; 

                    //variable to store the return val of the methods
                    
                    
                    switch(random_num){

                        // do not store the return vals (boolean) in any variables because I do not need it
                        case 1 -> game.generateAddQuestions();
                        case 2 -> game.generateSubQuestions();
                        case 3 -> game.generateMulQuestions();
                        case 4 -> game.generateDivQuestions();

                    }


                    // we do not exit, even if user entered the wrong answer, until the timer goes off

                }

                //once we exit: 
                System.out.println("Time's Up!");
                //print the user's results 
                game.printSummary();
                
                player.score = game.score; 
                player.summary = game.summary; 


                arr_players[i-1] = player; //i - 1 is for indexing 


                i++;


            }


















            //from the very top of the game
            input.close(); 


        }




        




        // ! EXPLAIN COMPARATOR STUFF!!!!!!!


        Comparator<Player> playerScoreComparator = Comparator.comparingInt((Player p) -> p.score).reversed(); //I had to make it Player.score because there is another vairbale in the other file that is also called score
        Arrays.sort(arr_players, playerScoreComparator); //sort the array by 

        System.out.println("---- Leaderboard (score only) ----");
        for(int i = 0; i < arr_players.length; i++){ // ? didn't allow me to type arr.length() ..?

            System.out.println(arr_players[i].name+ ": "+arr_players[i].score);
        }
        
         


        

        

        
    }
}
