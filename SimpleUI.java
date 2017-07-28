import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
  public void setGame(BlackjackGame game) {
        this.game = game;
    }

  /* Display the cards held by the House and the player (you).   */
  @Override
  public void display() {
      System.out.println(" \n House holds: ");
      System.out.println(game.getHouseCards());
      System.out.println("\n You Hold:");
      System.out.println(game.getYourCards());     
    }

   /* Prompt the user if they want another card.  Return true if another card desired.  */
  @Override
    public boolean hitMe() {
      boolean ans=false;
      if(game.score(game.getYourCards())<21){
          System.out.println("Hit Me? y for yes or n for no");
          String answer = user.next();
          
          if(answer.equals("y")){
             
              ans=true;
          }else if(answer.equals("n")){
              ans=false;
          }
          
      }
      return ans;      
    }

  @Override
    public void gameOver() {
      System.out.println("Game over");
      System.out.println("House Holds:");
      System.out.println(game.getHouseCards());
      System.out.println("You hold:");
      System.out.println(game.getYourCards());
      System.out.println("Your score:"+game.score(game.getYourCards())+", House score: "+game.score(game.getHouseCards()));
      
      if(game.score(game.getYourCards())>21){
          System.out.println("You Lose"); 
      }
      else if((game.score(game.getYourCards())==21)&&(game.score(game.getHouseCards())!=21)||game.score(game.getHouseCards())>21){
         System.out.println("You Win"); 
      }else if(game.score(game.getYourCards())>game.score(game.getHouseCards())){
         System.out.println("You Win"); 
      }
      else{
          System.out.println("You Lose"); 
      }
    }

}
