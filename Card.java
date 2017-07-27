public class Card implements Comparable {
  //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  public int CardRank;
  public int CardSuit;
  public boolean CardFaceup;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   */
  public Card(int rank, int suit, boolean faceUp) {
      CardRank = rank;
      CardSuit = suit;
      CardFaceup = faceUp;
  }

  /* @return the faceUp   */
  public boolean isFaceUp() {
      return CardFaceup;
  }
  
  /*  faceUp the faceUp to set    */
  public void setFaceUp(boolean faceUp) {
       if (faceUp==true){
          CardFaceup=true;
      } else{ CardFaceup=false;
       }
   }

   public int getRank() {
    return CardRank; 
  }

    public int getSuit() {
    return CardSuit;
  }

  @Override
  public boolean equals(Object aa) {
    if (!(aa instanceof Card)) {
      return false;
    }
    Card c = (Card) aa;
      
    if((this.CardRank==c.CardRank)&&(this.CardSuit==c.CardSuit)){
        return true;
    }
    else{
        return false;
    }
  }

  @Override
  public int hashCode() {//DO NOT MODIFY
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {//DO NOT MODIFY
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
      int cardCompare=0;
      if(this.CardRank==c.CardRank){
          if(this.CardSuit<c.CardSuit){
              cardCompare=-1;
          }else if(this.CardSuit>c.CardSuit){
              cardCompare=1;
          }
      }else {
          if(this.CardRank<c.CardRank){
          cardCompare=-1;
      }
          else if(this.CardRank>c.CardRank){
              cardCompare=1;
          }
      }
    return cardCompare; 
  }

  public String getRankString() {
      if(CardRank==2){
          return "2";
      }
      if(CardRank==3){
          return "3";
      }
      if(CardRank==4){
          return "4";
      }
      if(CardRank==5){
          return "5";
      }
      if(CardRank==6){
          return "6";
      }
      if(CardRank==7){
          return "7";
      }
      if(CardRank==8){
          return "8";
      }
      if(CardRank==9){
          return "9";
      }
      if(CardRank==10){
          return "10";
      }
      if(CardRank==11){
          return "Jack";
      }
      if(CardRank==12){
          return "Queen";
      }
      if(CardRank==13){
          return "King";
      }
      if(CardRank==14){
          return "Ace";
      }
      
  return "error";
  }

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString() {
      if(CardSuit==0){
          return "Clubs";
      }
      if(CardSuit==1){
          return "Diamonds";
      }
      if(CardSuit==2){
          return "Hearts";
      }
      if(CardSuit==3){
          return "Spades";
      }
    return "error";  
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
      if(CardFaceup==false){
          return "?" + "\n";
      }
    return getRankString() +" "+ getSuitString() +"\n" + " ";
     
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}
