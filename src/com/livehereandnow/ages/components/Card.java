/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Card implements CardType {

    private Points bluePoints;
    private Points yellowPoints;

    //for Government Cards
    private Points whitePoints;
    private Points redPoints;
    private int round; 

    
    public int getRound() {
        return round;
    }

    /**
     * Which round player take this card?
     * Except for Wonder card, all cards must be held on hand for at least one round
     * @param round 
     */
    public void setRound(int round) {
        this.round = round;
    }
    

      public void doProduction() {
      //  藍點 = 藍點 + 黃點;
          bluePoints.setPoints(bluePoints.getPoints()+yellowPoints.getPoints());
      }
    public Points getWhite() {
        return whitePoints;
    }

    public Points getRedPoints() {
        return redPoints;
    }

    public Points getBluePoints() {
        return bluePoints;
    }

    public Points getYellowPoints() {
        return yellowPoints;
    }

    public Card(int ID, String 卡名, int 時代, int 牌背, int 類型, int 顏色, String 右上, String 內容, String 建造成本) {

        this.右上 = 右上;
        this.內容 = 內容;
        this.顏色 = 顏色;
        this.ID = ID;
        this.牌背 = 牌背;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
//        this.建造成本 = 建造成本;
        wonderStage = new WonderStage(建造成本);
        whitePoints = new Points();
        redPoints = new Points();
        bluePoints = new Points();
        yellowPoints = new Points();

        if (右上.equals("政府")) {
//            System.out.print("卡名:" + 卡名);
//            System.out.println(" ... constructor of Card, for 政府 card, to parse " + 內容);
            String cmd = 內容;
            String[] strTokens = cmd.split("，");// **it's in Chinese, 2 bytes***
            //   List<String> tokens = new ArrayList<>();
            for (String item : strTokens) {
                if (item.length() > 0) {
//                    System.out.println("    =>" + item);
                    //         tokens.add(item);
                    String[] strTokens2 = item.split("[+]");
//                    String[] strTokens2 = item.split("=");// **it's in English, 1 byte***
//      

                    if (strTokens2[0].equals("內政點數")) {
//                        System.out.println("     =>=>" + strTokens2[1] + " for 內政點數, whitePoints");

                        this.whitePoints.setPoints(Integer.parseInt(strTokens2[1]));
                    }
                    if (strTokens2[0].equals("軍事點數")) {
//                        System.out.println("     =>=>" + strTokens2[1] + " for 軍事點數, redPoints");
                        this.redPoints.setPoints(Integer.parseInt(strTokens2[1]));

                    }

                    //   System.out.println("     =>=>"+strTokens2[1]);
                }
            }
            //System.out.println(" ... constructor of Card, for 政府 card, to parse 內政點數+4，軍事點數+2 ");
            //   System.out.println(""+tokens);

        }

    }

    public String get右上() {
        return 右上;
    }

    public void set右上(String 右上) {
        this.右上 = 右上;
    }

    public String get內容() {
        return 內容;
    }

    public void set內容(String 內容) {
        this.內容 = 內容;
    }

    public int get顏色() {
        return 顏色;
    }

    public void set顏色(int 顏色) {
        this.顏色 = 顏色;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int get牌背() {
        return 牌背;
    }

    public void set牌背(int 牌背) {
        this.牌背 = 牌背;
    }

//    public String get建造成本() {
//        return 建造成本;
//    }
//
//    public void set建造成本(String 建造成本) {
//        this.建造成本 = 建造成本;
//    }
    private String 右上;
    private int 編號;
    private int 加權值;
    private String 內容;
    private int 顏色;
    private int ID;
    private int 牌背;
    private int 時代;
    private String 卡名;
//    String 建造成本;
//    int[] 奇蹟建造成本=new int[5];//最多5個階段由階段0開始
//    int 奇蹟建造階段;//初值為0表示正在建造0階段 
    private int 類型;//0=領袖,1=奇蹟.2=黃牌
    private WonderStage wonderStage;
//    public int get奇蹟建造成本(int k) {
//        return 奇蹟建造成本[k];
//    }
//
//    public void set奇蹟建造成本(int k,int 奇蹟建造成本) {
//        this.奇蹟建造成本[k] = 奇蹟建造成本;
//    }
//
//    public int get奇蹟建造階段() {
//        return 奇蹟建造階段;
//    }
//
//    public void set奇蹟建造階段(int 奇蹟建造階段) {
//        this.奇蹟建造階段 = 奇蹟建造階段;
//    }

    public WonderStage getWonderStage() {
        return wonderStage;
    }

    public int get加權值() {
        return 加權值;
    }

    public void set加權值(int 加權值) {
        this.加權值 = 加權值;
    }

    /**
     * Basic info for initial 6 cards for each player
     *
     * @param 卡名
     * @param 時代
     * @param 右上
     */
    public Card(String 卡名, int 時代, String 右上) {
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.右上 = 右上;
        yellowPoints = new Points();
        bluePoints = new Points();
        whitePoints = new Points();
        redPoints = new Points();

    }

    public Card(int 編號, String 卡名, int 時代, int 類型) {
        this.編號 = 編號;
        this.卡名 = 卡名;
        this.時代 = 時代;
        this.類型 = 類型;
    }

//    public Card(int 編號, String 卡名, int 時代, int 類型, int 加權值) {
//        this.編號 = 編號;
//        this.卡名 = 卡名;
//        this.時代 = 時代;
//        this.類型 = 類型;
//        this.加權值 = 加權值;
//    }
    public Card() {
    }

    public int get編號() {
        return 編號;
    }

    public void set編號(int 編號) {
        this.編號 = 編號;
    }

    public String get卡名() {
        return 卡名;
    }

    public void set卡名(String 卡名) {
        this.卡名 = 卡名;
    }

    public int get時代() {
        return 時代;
    }

    public void set時代(int 時代) {
        this.時代 = 時代;
    }

    public int get類型() {
        return 類型;
    }

    // ver 0.7, by Mark, 2014-4-16
    public String get類型Name() {
        return CardType.CARD_TYPE_NAME[類型];
    }

    // ver 0.7, by Mark, 2014-4-16
    public String get卡名and類型Name() {
        return "[" + 卡名 + "-" + CardType.CARD_TYPE_NAME[類型] + "] ";
    }
//    待理解，時代為什麼可以這麼明確　2014-4-19 MAX

    public String get時代名() {
        String[] 時代名 = {"時代A", "時代I", "時代II", "時代III"};
        return 時代名[時代];
    }

    public String get只有時代的時代名() {
        String[] 時代名 = {"A", "I", "II", "III"};
        return 時代名[時代];
    }

    public String get牌背名() {
        String[] 牌背名 = {"內政", "軍事"};
        return 牌背名[牌背];
    }

    public void set類型(int 類型) {
        this.類型 = 類型;
    }

    //String 卡名;
    @Override
    public String toString() {
        return "[" + 卡名 + "]";
    }

    /**
     * FOR-MAX
     *
     * @param k <br>
     * 5=>[I-灌溉-科技-農場-建造成本:3/3] <br>
     * 6=>[A-Philosophy--實驗室 黃點:0 藍點:0]
     * 9 for Leader card, 
     * @return
     */
    public String toString(int k) {
        switch (k) {
            case 1://
                //  Value 1: 0[時代A內政-荷馬-領袖] 1[] 2[時代A內政-凱薩-領袖] 3[時代A內政-空中花園-奇蹟] 4[時代A內政-農業-科技] 
                if (卡名.equalsIgnoreCase("")) {

                    return "[] ";
                }
                return "[" + get時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "] ";
            case 2://[A內政-荷馬-領袖]
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "] ";
            case 3://奇蹟  [I內政-泰姬陵-奇蹟-建造成本:2,4,2]
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "-建造成本:" + wonderStage + "] ";
            //"-"+this.奇蹟待建區.get().建造成本
            case 4://奇蹟  [I內政-泰姬陵-奇蹟-建造成本:*,4,2] *表示該段建造完成
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + get牌背名() + "-" + get卡名() + "-" + get類型Name() + "-建造成本:" + wonderStage + "] ";
            case 5://  [I-灌溉-科技-農場-建造成本:3/3]，因為要確認右上的字
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + "-" + get卡名() + "-" + get類型Name() + "-" + get右上() + "-建造成本:" + wonderStage + "] ";
  case 15:// including Round# [I-灌溉-科技-農場-建造成本:3/3]，因為要確認右上的字
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[round#" +getRound()+"-"+ get只有時代的時代名() + "-" + get卡名() + "-" + get類型Name() + "-" + get右上() + "-建造成本:" + wonderStage + "] ";

            case 6://  0[A-Philosophy--實驗室  黃點:0 藍點:0]
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + "-" + get卡名() + "-" + "-" + get右上() + "  黃點:" + yellowPoints + " 藍點:" + bluePoints + "] ";
            case 7:// for Government card, 
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + "-" + get卡名() + "-" + "-" + get右上() + "  White點:" + whitePoints + " Red點:" + redPoints + "] ";

            case 8://for govt card
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + get牌背名() + "-" + get卡名() + " " + get內容() + " 建造成本:" + wonderStage + "] ";

            case 9://for leader
                if (卡名.equalsIgnoreCase("")) {
                    return "[] ";
                }
                return "[" + get只有時代的時代名() + get牌背名() + "-" + get卡名() + " " + get內容() + "] ";

            default:
                return toString();
        }
    }

//        System.out.print(k + "[" + cardRow.get(k).get時代名()+cardRow.get(k).get牌背名() + "-" + cardRow.get(k).get卡名() + "-" + cardRow.get(k).get類型Name() + "] ");
}
