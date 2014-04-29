
package com.livehereandnow.ages.components;


/**
 *
 * @author mark
 */
public class Points {
    int points;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points){
        this.points = points;
 
    }
    public void addPoints(int k) {
        this.points += k;
    }    

    @Override
    public String toString() {
        return ""+points ;
    }
    
}
