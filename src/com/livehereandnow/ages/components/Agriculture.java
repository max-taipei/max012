/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

/**
 *
 * @author max
 */
//  農業系列用於，記錄黃點數量，記錄藍點數量，記錄是否拿取科技，記錄是否已經打出這項科技。
//  希望有類似什麼樣的指令來操作
//  我希望有指令可以對農業黃點作存取，農業黃點必須是正整數或0，農業黃點需要是個陣列，要四個值
//　農業藍點同農業黃點
//    另外需要同樣陣列來標記農業科技是否拿取
//    同時需要類似陣列來標記農業科技是否打出
// === 需求分析 ===
//    農業我們需要有四個物件
//    每個物件要能記錄黃點、藍點、是否拿取、是否打出
// === 拓展 ===
//    礦場跟農業的需求其實一樣
//    其他科技仍然可以直接使用，不用藍點即可
//    每個物件要能記錄黃點、藍點、是否拿取、是否打出
public class Agriculture {

    private int 黃點;
    private int 藍點;
    private boolean 拿取;
    private boolean 打出;

    public Agriculture(int 黃點, int 藍點, boolean 拿取, boolean 打出) {
        this.黃點 = 黃點;
        this.藍點 = 藍點;
        this.拿取 = 拿取;
        this.打出 = 打出;
    }

    @Override
    public String toString() {
        return "{" + "\u9ec3\u9ede=" + 黃點 + ", \u85cd\u9ede=" + 藍點 + ", \u62ff\u53d6=" + 拿取 + ", \u6253\u51fa=" + 打出 + '}';
    }

    public String toString(int k) {
        switch (k) {
            case 1:
                return 黃點 + "=>" + 藍點;
            case 2:
                return ""+黃點;
            default:
                return toString();
        }

    }

    // 2014-4-22, by Mark
    //    get農場(k).set藍點(get農場(k).get藍點() + get農場(k).get黃點());
    public void doProduction() {
        藍點 = 藍點 + 黃點;
    }

    public int get黃點() {
        return 黃點;
    }

    public void set黃點(int 黃點) {
        this.黃點 = 黃點;
    }

    public int get藍點() {
        return 藍點;
    }

    public void set藍點(int 藍點) {
        this.藍點 = 藍點;
    }

    public boolean is拿取() {
        return 拿取;
    }

    public void set拿取(boolean 拿取) {
        this.拿取 = 拿取;
    }

    public boolean is打出() {
        return 打出;
    }

    public void set打出(boolean 打出) {
        this.打出 = 打出;
    }

}
