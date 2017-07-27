import java.util.AbstractList;
import java.util.*;

public class BlackjackGame {

  private CardPile deck;
  private CardPile houseCards;
  private CardPile yourCards;
  private boolean houseDone;
  private boolean playerDone;
  private UserInterface ui;

  public BlackjackGame(UserInterface ui) {
    this.ui = ui;
    ui.setGame(this);
    deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    houseCards = new CardPile();
    yourCards = new CardPile();
    houseDone = false;
    playerDone = false;
  }

  public void start() {
    Card c;
    c = deck.removeRandom();
    c.setFaceUp(false);
    getHouseCards().add(c);
    getHouseCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    getYourCards().add(deck.removeRandom());
    ui.display();
  }

  public void play() {
    while (!houseDone || !playerDone) {
      if (!houseDone) {
        if (score(getHouseCards()) <= 17) {
          getHouseCards().add(deck.removeRandom());
          ui.display();
        } else {
          houseDone = true;
        }
      }
      if (!playerDone) {
        if (ui.hitMe()) {
          getYourCards().add(deck.removeRandom());
          ui.display();
        } else {
          playerDone = true;
        }
      }
    }
  }

  public void end() {
    getHouseCards().getCards().get(0).setFaceUp(true);
    ui.gameOver();
  }

  /* Determine the score of a pile of cards. */
  public int score(CardPile p) {
   ArrayList<Card> cardSum;
   cardSum = p.getCards();
   int add= 0;
   
   for(int i = 0;i<cardSum.size();i++){
       if(cardSum.get(i).CardRank==14){
           if(add<= 10){
               add+=11;
           }
           
           else if (add>10){
               add+=1;
           }
           
       }else if (cardSum.get(i).CardRank >10 && cardSum.get(i).CardRank <14){
           add+=10;
       }else{
           add+=cardSum.get(i).CardRank;
       }
           
       }
    return add;
  }
  
  /* @return the houseCards   */
  public CardPile getHouseCards() {
    return houseCards;
  }

  /* @return the yourCards */
  public CardPile getYourCards() {
    return yourCards;
  }

  public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
}
