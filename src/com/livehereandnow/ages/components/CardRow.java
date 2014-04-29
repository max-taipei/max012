/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import com.livehereandnow.ages.exception.AgesException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mark
 */
public class CardRow {

    private List<Card> ageA內政牌;
    private List<Card> ageICivilCards;

    private List<Card> cardRow;
    private int playerCnt;

    public List<Card> getCards() {
        return cardRow;
    }
    private int round = 1;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public CardRow(int playerCnt) {
        this.playerCnt = playerCnt;

        Cards cards = new Cards();
    //    ageA內政牌 = cards.get時代A內政牌();
        ageICivilCards = cards.get某時代內政牌(1);

        ageA內政牌 = cards.get某時代內政牌(0);//DEBUG 暫用時代1
   //     ageA內政牌 = cards.get測試牌(1);//DEBUG 暫用時代1
        cardRow = new ArrayList<>();

        Collections.shuffle(ageA內政牌);

        Collections.shuffle(ageICivilCards);

        // only take first 13 cards and discard others
        for (int k = 0; k < 13; k++) {
            cardRow.add(ageA內政牌.get(k));
//            old___cardRow.add(cards.get某時代內政牌(1));
        }
    }

    /**
     *
     * @return false when no card available to add
     */
    public void addCards() throws AgesException {
        addCardsStep1();
        addCardsStep2();
        addCardsStep3();
    }

    private void addCardsStep1() {
        switch (playerCnt) {

            case 2:
                cardRow.remove(0);
            case 3:
                cardRow.remove(0);
            case 4:
                cardRow.remove(0);
                break;
        }

    }

    private void addCardsStep2() {
        for (int k = 0; k < cardRow.size(); k++) {
            if (cardRow.get(k).get卡名().length() == 0) {
                cardRow.remove(k);
            }
        }
    }

    private void addCardsStep3() throws AgesException {
        if (round == 2) {
            while (cardRow.size() < 13) {
                cardRow.add(ageA內政牌.get(0));
                ageA內政牌.remove(0);
            }
        }
        if (round > 2) {
          while (cardRow.size() < 13) {
                cardRow.add(ageICivilCards.get(0));
                ageICivilCards.remove(0);
                
          }
            System.out.println("... remaining Age I Civil Cards is "+ageICivilCards.size());
        }
    }

    
    public void show(int style){
      System.out.println("   === Card Row 卡牌列===");
        System.out.print("*  ");
        for (int k = 0; k < 5; k++) {
            System.out.print(k + cardRow.get(k).toString(style));
        }
        System.out.println();
        System.out.print("** ");
        for (int k = 5; k < 9; k++) {
            System.out.print(k + cardRow.get(k).toString(style));
        }
        System.out.println();
        System.out.print("***");
        for (int k = 9; k < 13; k++) {
            System.out.print(k + cardRow.get(k).toString(style));
        }
//        System.out.println("\n內政牌庫:???");
//        
    }
    
//    public void show() {
//        System.out.println("   === Card Row ===");
//        System.out.print("   Value 1: ");
//        for (int k = 0; k < 5; k++) {
//            System.out.print(k + cardRow.get(k).toString(1));
//        }
//        System.out.println();
//        System.out.print("   Value 2: ");
//        for (int k = 5; k < 9; k++) {
//            System.out.print(k + cardRow.get(k).toString(5));
//        }
//        System.out.println();
//        System.out.print("   Value 3: ");
//        for (int k = 9; k < 13; k++) {
//            System.out.print(k + cardRow.get(k).toString(5));
//        }
//        System.out.println();
//    }

}
