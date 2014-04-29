/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.ages.components;

/**
 *
 * @author mark
 */
public class PlayerDeck {
    Card card;

   
    public Card getCard() {
        return card;
    }

    public void setCard(Card leader) {
        this.card = leader;
    }

 
    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        return  card.toString();
    }
    
    
}
