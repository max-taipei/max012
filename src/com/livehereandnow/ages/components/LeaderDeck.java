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
public class LeaderDeck extends PlayerDeck {

    boolean[] checked = new boolean[4];// for 4 ages, to check when get given age's leader's card

    public LeaderDeck() {
        super();
        checked[0] = false;
        checked[1] = false;
        checked[2] = false;
        checked[3] = false;

    }

    /**
     *
     * @param k age number, 0:A, 1:I, 2:II, 3:III
     * @return true: got this age's leader's before
     */
    public boolean isChecked(int k) {
        return checked[k];
    }

    public void setChecked(int k) {
        checked[k] = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ages:");
        for (int k = 0; k < 4; k++) {
            if (checked[k]) {
                sb.append("*");
            } else {
                sb.append(k);
            }
        }
        return card.toString(9) + sb.toString();
    }

}
