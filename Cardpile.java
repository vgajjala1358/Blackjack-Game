import java.util.ArrayList;
import java.util.Random;
import java.util.*;

/* A pile of cards. */
public class CardPile {
  private ArrayList<Card> cards;

  public CardPile() {
      cards=new ArrayList<Card> ();
  }

  /* Add a card to the pile. */
  public void add(Card card) {
      cards.add(card);
  }

  /* Remove a card chosen at random from the pile. */
  public Card removeRandom() {
      int size= cards.size();
      Random randomGenerator = new Random();
      int randomIndex = randomGenerator.nextInt(size);
      
    return cards.remove(randomIndex); //FIX THIS
  }

  /* The string representation is a space separated list of each card.  */
  @Override
  public String toString() {
    
      String strname=" ";
      for(int i = 0;i<cards.size();i++){
        strname+=cards.get(i).toString();      
      }
    return " " + strname;  
  }

  /* @return the cards  */
  public ArrayList<Card> getCards() {
    return cards;
  }

  public static void main(String[] args) {
    CardPile p = new CardPile();
    p.add(new Card(2, 1, true));
    p.add(new Card(3, 2, true));
    p.add(new Card(4, 3, false));
    p.add(new Card(14, 1, true));
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("Removed: " + p.removeRandom());
    System.out.println("");
    CardPile deck = new CardPile();
    for (int i = 2; i < 15; i++) {
      for (int j = 0; j < 4; j++) {
        deck.add(new Card(i, j, true));
      }
    }
    for (int i = 0; i < 52; i++) {
      System.out.println((i + 1) + ": " + deck.removeRandom());

    }
  }
}
