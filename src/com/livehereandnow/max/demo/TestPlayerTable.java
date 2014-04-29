/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max.demo;

import com.livehereandnow.ages.Main;
import com.livehereandnow.ages.components.Card;
import static com.livehereandnow.ages.components.CardType.內政;
import static com.livehereandnow.ages.components.CardType.棕色;
import static com.livehereandnow.ages.components.CardType.科技;
import com.livehereandnow.ages.components.PlayerTable;
import com.livehereandnow.ages.exception.AgesException;
import java.io.IOException;

/**
 *
 * @author mark
 */
public class TestPlayerTable {

    Card card;

    public static void main(String[] args) {
//        new TestPlayerTable().test2();//匿名的實例直接調用方式，
//        TestPlayerTable 
//        System.out.println("將class TestPlayerTable實例一個名為k的變量");        
//        System.out.println("用k調用方法test2");
        TestPlayerTable k=new TestPlayerTable();
        k.test2();
         k.test1();
        
    }

    public void test1() {

        PlayerTable pt1 = new PlayerTable();
        PlayerTable pt2 = new PlayerTable();
//        pt2=pt1;//此時pt2的物件地址同pt1的物件地址;因此pt1所變更的任何東西不僅在pt1有效果，也影響到pt2;反之亦然
        //請問，反之亦然在這裡是指什麼?

        System.out.println("new game");
        pt1.show("pt1");
        pt2.show("pt2");
//pt1.
        System.out.println("給第一個用戶的時代A實驗室黃點+1");

        //pt1.getCard(3, 0).getBluePoints().setPoints(2);
//        pt1.add黃點(1, 0, 1);
//        pt1.add黃點(3, 0, 2);
//        pt1.add黃點(3, 1, 3);
//        pt1.show("pt1, some setting");
//        pt2.show("pt2, do nothing yet");
//        pt2.add黃點(2, 0, 999);
//        pt1.show("pt1, 沒做事");
//        pt2.show("pt2, 故意將神廟黃點改為999");
    }

    public void test2() {
        System.out.println("===高階的程式編寫範例===");
        PlayerTable pt1 = new PlayerTable();
        pt1.add黃點(3, 0, 7);
        pt1.show("pt1");
//cards農場[1] = new Card(55, "灌溉", 1, 內政, 科技, 棕色, "農場", "食物生產+2", "3");
//cards農場[2] = new Card(55, "灌溉2", 2, 內政, 科技, 棕色, "農場", "食物生產+2", "3");
//cards農場[3] = new Card(55, "灌溉3", 3, 內政, 科技, 棕色, "農場", "食物生產+2", "3");
        card = new Card(55, "灌溉", 1, 內政, 科技, 棕色, "農場", "食物生產+2", "3");
        pt1.setCard(card, 3, 1);
        card = new Card(55, "灌溉2", 2, 內政, 科技, 棕色, "農場", "食物生產+2", "3");
        pt1.setCard(card, 3, 2);
        pt1.show("pt1");
        pt1.add黃點(3, 0, -1);
        pt1.add黃點(3, 1, 1);
        pt1.show("已經由時代A升級一點到時代I");
//       pt1.add黃點(3, 0, -1);
//        pt1.add黃點(3, 2, 1);
        pt1.upgrade黃點(3, 0, 2);
        pt1.show("已經由時代A升級一點到時代I");

        
    }
}
