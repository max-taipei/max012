/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author max
 */
public class Cards implements CardType {

    List<Card> cards;
    List<Card> initCards;
    Card init政府;
    Card init實驗室;
    Card init神廟;
    Card init農場;
    Card init礦山;
    Card init步兵;

    public Card getInit政府() {
        return init政府;
    }

    public Card getInit實驗室() {
        return init實驗室;
    }

    public Card getInit神廟() {
        return init神廟;
    }

    public Card getInit農場() {
        return init農場;
    }

    public Card getInit礦山() {
        return init礦山;
    }

    public Card getInit步兵() {
        return init步兵;
    }

    public Card getInitGovernment() {
        return init政府;
    }

    public List<Card> copyInitCards() {
        List<Card> temp = new ArrayList<>();
        for (int k = 0; k < initCards.size(); k++) {
            temp.add(initCards.get(k));
        }

        return temp;
    }

    public List<Card> get所有的牌() {
        return cards;
    }

    public void show和手牌數相關的牌() {
        System.out.println("顯示出get和手牌數相關的牌()");
//        System.out.println("335678" + this.get和手牌數相關的牌().size());
//        this.get和手牌數相關的牌().get(內政).get卡名()
        for(Card card:get和手牌數相關的牌()){
            System.out.println(card.toString(9));
        }
//return ;
    }

    public List<Card> get和手牌數相關的牌() {
        List<Card> list = new ArrayList<>();

             //        cards.add(new Card(5, "漢摩拉比", 0, 內政, 領袖, 綠色, "領袖", "內政點數+1，軍事點數-1", "0"));
//        cards.add(new Card(9, "金字塔", 0, 內政, 奇蹟, 紫色, "奇蹟", "內政點數+1", "3,2,1"));
//        cards.add(new Card(10, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+2", "0"));
//         cards.add(new Card(6, "亞歷山大圖書館", 0, 內政, 奇蹟, 紫色, "奇蹟", "科技生產+1，文化生產+1，內政手牌上限+1，軍事手牌上限+1", "1,2,2,1"));
//        cards.add(new Card(54, "法典", 1, 內政, 科技, 藍色, "內政", "內政點數+1", "6"));
        for (int k = 0; k < cards.size(); k++) {
            if ((cards.get(k).get右上().equals("政府"))) {
                list.add(cards.get(k));
            }
        }
        
        list.add(new Card(5, "漢摩拉比", 0, 內政, 領袖, 綠色, "領袖", "內政點數+1，軍事點數-1", "0"));
        list.add(new Card(9, "金字塔", 0, 內政, 奇蹟, 紫色, "奇蹟", "內政點數+1", "3,2,1"));
        list.add(new Card(10, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+2", "0"));
        list.add(new Card(6, "亞歷山大圖書館", 0, 內政, 奇蹟, 紫色, "奇蹟", "科技生產+1，文化生產+1，內政手牌上限+1，軍事手牌上限+1", "1,2,2,1"));
        list.add(new Card(54, "法典", 1, 內政, 科技, 藍色, "內政", "內政點數+1", "6"));
        return list;
    }

    public List<Card> get時代A內政牌() {
        List<Card> 時代A內政牌 = new ArrayList<>();
        for (int k = 0; k < cards.size(); k++) {
            if ((cards.get(k).get時代() == 0) && (cards.get(k).get牌背() == 內政)) {
                時代A內政牌.add(cards.get(k));
            }
        }
        return 時代A內政牌;
    }

    public List<Card> get某時代內政牌(int age) {
        List<Card> 內政牌 = new ArrayList<>();
        for (int k = 0; k < cards.size(); k++) {
            if ((cards.get(k).get時代() == age) && (cards.get(k).get牌背() == 內政)) {
                內政牌.add(cards.get(k));
            }
        }
        return 內政牌;
    }

    public List<Card> get測試牌(int test) {
        List<Card> 內政牌 = new ArrayList<>();
        switch (test) {
            case 1://時代1的科技牌
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get時代() == 1) && (cards.get(k).get類型() == 科技)) {
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            case 2://時代0跟時代1的奇蹟跟領袖
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get類型() == 奇蹟) || (cards.get(k).get類型() == 領袖)) {
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            case 3://所有時代的領袖牌
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get類型() == 領袖)) {
                        內政牌.add(cards.get(k));
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            case 4://所有時代的奇蹟
                for (int k = 0; k < cards.size(); k++) {
                    if ((cards.get(k).get類型() == 奇蹟)) {
                        內政牌.add(cards.get(k));
                        內政牌.add(cards.get(k));
                    }
                }
                break;
            default:
        }

        return 內政牌;
    }

    public Cards() {
        //
        // 1. Player's Initial Cards
        //

//        init政府 = new Card("Despotism", 0, "???");
//        init政府.getWhite().setPoints(4);
//        init政府.getRedPoints().setPoints(2);
        //
        // 1.1 Goverment card
        //
        init政府 = new Card(10, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+2", "0");

//        System.out.println("   initial Govt card, done");
        //
        // 1.2 Other 5 cards
        //
        Card init實驗室 = new Card(13, "哲學", 0, 內政, 科技, 灰色, "實驗室", "科技生產+1", "3");
        Card init神廟 = new Card(11, "宗教", 0, 內政, 科技, 灰色, "神廟", "笑臉+1，文化生產+1", "3");
        Card init農場 = new Card(12, "農業", 0, 內政, 科技, 棕色, "農場", "食物生產+1", "2");
        Card init礦山 = new Card(15, "青銅", 0, 內政, 科技, 棕色, "礦山", "資源生產+1", "2");
        Card init步兵 = new Card(14, "戰士", 0, 內政, 科技, 紅色, "步兵", "軍力+1", "2");
        initCards = new ArrayList<>();
//        Card card1 = new Card("Philosophy", 0, "實驗室");//神廟
//        Card card2 = new Card("Religion", 0, "神廟");//
//        Card card3 = new Card("Agriculture", 0, "農場");
//        Card card4 = new Card("Bronze", 0, "礦山");
//        Card card5 = new Card("Warriors", 0, "???");
////        Card card6 = new Card("Despotism", 0, "???");
//        initCards.add(card1);
//        initCards.add(card2);
//        initCards.add(card3);
//        initCards.add(card4);
//        initCards.add(card5);

        initCards.add(new Card(13, "哲學", 0, 內政, 科技, 灰色, "實驗室", "科技生產+1", "3"));
        initCards.add(new Card(11, "宗教", 0, 內政, 科技, 灰色, "神廟", "笑臉+1，文化生產+1", "3"));
        initCards.add(new Card(12, "農業", 0, 內政, 科技, 棕色, "農場", "食物生產+1", "2"));
        initCards.add(new Card(15, "青銅", 0, 內政, 科技, 棕色, "礦山", "資源生產+1", "2"));
        initCards.add(new Card(14, "戰士", 0, 內政, 科技, 紅色, "步兵", "軍力+1", "2"));

        //Card init政府=
//        System.out.println("   initial 5 cards,哲學/宗教/農業/青銅/戰士 , done");

        //
        // 1. Cards for Card Row
        //
        cards = new ArrayList<>();
        cards.add(new Card(1, "亞歷山大大帝", 0, 內政, 領袖, 綠色, "領袖", "每一個紅色科技牌上的黃點，軍力+1", "0"));
        cards.add(new Card(2, "亞里士多得", 0, 內政, 領袖, 綠色, "領袖", "拿取科技牌時，科技+1", "0"));
        cards.add(new Card(3, "凱薩", 0, 內政, 領袖, 綠色, "領袖", "軍力+1，軍事點數+1", "0"));
        cards.add(new Card(4, "摩西", 0, 內政, 領袖, 綠色, "領袖", "擴充人口，食物需求-1", "0"));
        cards.add(new Card(5, "漢摩拉比", 0, 內政, 領袖, 綠色, "領袖", "內政點數+1，軍事點數-1", "0"));

        cards.add(new Card(6, "亞歷山大圖書館", 0, 內政, 奇蹟, 紫色, "奇蹟", "科技生產+1，文化生產+1，內政手牌上限+1，軍事手牌上限+1", "1,2,2,1"));

        cards.add(new Card(7, "巨人像", 0, 內政, 奇蹟, 紫色, "奇蹟", "軍力+1，文化生產+1，殖民點數+1", "3,3"));
        cards.add(new Card(8, "空中花園", 0, 內政, 奇蹟, 紫色, "奇蹟", "笑臉+2，文化生產+1", "2,2,2"));
        cards.add(new Card(9, "金字塔", 0, 內政, 奇蹟, 紫色, "奇蹟", "內政點數+1", "3,2,1"));
//        cards.add(new Card(10, "專制", 0, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+2", "0"));
//        cards.add(new Card(11, "宗教", 0, 內政, 科技, 灰色, "神廟", "笑臉+1，文化生產+1", "3"));
//        cards.add(new Card(12, "農業", 0, 內政, 科技, 棕色, "農場", "食物生產+1", "2"));
//        cards.add(new Card(13, "哲學", 0, 內政, 科技, 灰色, "實驗室", "科技生產+1", "3"));
//        cards.add(new Card(14, "戰士", 0, 內政, 科技, 紅色, "步兵", "軍力+1", "2"));
//        cards.add(new Card(15, "青銅", 0, 內政, 科技, 棕色, "礦山", "資源生產+1", "2"));
        cards.add(new Card(16, "富饒之土", 0, 內政, 行動, 黃色, "行動", "提供1資源建造農場或是礦山", "0"));
        cards.add(new Card(17, "工程天才", 0, 內政, 行動, 黃色, "行動", "提供2資源建造奇蹟", "0"));
        cards.add(new Card(18, "藝術作品", 0, 內政, 行動, 黃色, "行動", "文化+6", "0"));
        cards.add(new Card(19, "節儉", 0, 內政, 行動, 黃色, "行動", "支付正常價格擴充人口後，獲得1食物", "0"));
        cards.add(new Card(20, "荷馬", 0, 內政, 領袖, 綠色, "領袖", "建造戰士，資源需求-1(1回合1次)，回合結束戰士上的黃點提供文化生產+1(最多2)", "0"));
        cards.add(new Card(21, "建築工地", 0, 內政, 行動, 黃色, "行動", "提供1資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(22, "愛國主義", 0, 內政, 行動, 黃色, "行動", "軍事點數+1，提供1資源用於建造或升級軍隊", "0"));
        cards.add(new Card(23, "革新思想", 0, 內政, 行動, 黃色, "行動", "科技+1", "0"));
        cards.add(new Card(24, "無事件", 0, 軍事, 事件, 深綠色, "事件", "0", "0"));
        cards.add(new Card(25, "人口的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家免費擴充1人口", "0"));
        cards.add(new Card(26, "軍事的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以選擇是否使用1個閒置人口免費建造1個戰士", "0"));
        cards.add(new Card(27, "農業的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家食物+2", "0"));
        cards.add(new Card(28, "宗教的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以選擇是否使用1個閒置人口免費建造1個宗教", "0"));
        cards.add(new Card(29, "市場的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家資源+2", "0"));
        cards.add(new Card(30, "手工業的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以選擇食物+2或是資源+2", "0"));
        cards.add(new Card(31, "政治的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家可以抽3張軍事牌，本回合跳過軍事牌檢測階段", "0"));
        cards.add(new Card(32, "科技的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家科技+2", "0"));
        cards.add(new Card(33, "貿易的發展", 0, 軍事, 事件, 深綠色, "事件", "每個玩家獲得1食物1資源1科技", "0"));
        cards.add(new Card(34, "哥倫布", 1, 內政, 領袖, 綠色, "領袖", "你可以在政治階段改為打出1張殖民地，並且獲得它(只能使用1次)", "0"));
        cards.add(new Card(35, "聖女貞德", 1, 內政, 領袖, 綠色, "領袖", "你的每個神廟笑臉，使你的軍力+1，你受到侵略或是戰爭前，文化+5", "0"));
        cards.add(new Card(36, "巴巴羅薩", 1, 內政, 領袖, 綠色, "領袖", "你可以用1點內政點數，建造1個軍事單位，資源以及食物需求-1", "0"));
        cards.add(new Card(37, "成吉思汗", 1, 內政, 領袖, 綠色, "領袖", "忽略戰術牌的軍力加成，你麾下的騎兵軍力+1", "0"));
        cards.add(new Card(38, "米開朗基羅", 1, 內政, 領袖, 綠色, "領袖", "每個笑臉，文化生產+1", "0"));
        cards.add(new Card(39, "達文西", 1, 內政, 領袖, 綠色, "領袖", "當你打出科技牌時，獲得一個資源。科技生產值=你最高實驗室的等級", "0"));
        cards.add(new Card(40, "萬里長城", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+1，每個步兵和砲兵+1軍力", "2,2,3,2"));
        cards.add(new Card(41, "卡羅琳娜大學", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+1，科技生產+2", "3,3,3"));
        cards.add(new Card(42, "聖彼得大教堂", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+2，你的建築以及奇蹟笑臉*2", "4,4"));
        cards.add(new Card(43, "泰姬陵", 1, 內政, 奇蹟, 紫色, "奇蹟", "文化生產+3", "2,4,2"));
        cards.add(new Card(44, "戰爭機構", 1, 內政, 科技, 藍色, "軍事", "軍力+1，軍事點數+1", "4"));
        cards.add(new Card(45, "製圖術", 1, 內政, 科技, 藍色, "殖民", "軍力+1，殖民點數+2", "4"));
        cards.add(new Card(46, "劍士", 1, 內政, 科技, 紅色, "步兵", "軍力+2", "3"));
        cards.add(new Card(47, "劍士", 1, 內政, 科技, 紅色, "步兵", "軍力+2", "3"));
        cards.add(new Card(48, "印刷術", 1, 內政, 科技, 灰色, "圖書館", "文化生產+1，科技生產+1", "3"));
        cards.add(new Card(49, "印刷術", 1, 內政, 科技, 灰色, "圖書館", "文化生產+1，科技生產+1", "3"));
        cards.add(new Card(50, "君主制", 1, 內政, 科技, 橙色, "政府", "內政點數+5，軍事點數+3", "9,3"));
        cards.add(new Card(51, "河蟹娛樂", 1, 內政, 科技, 灰色, "競技場", "軍力+1，笑臉+2", "3"));
        cards.add(new Card(52, "戲劇", 1, 內政, 科技, 灰色, "劇院", "文化生產+2，笑臉+1", "4"));
        cards.add(new Card(53, "戲劇", 1, 內政, 科技, 灰色, "劇院", "文化生產+2，笑臉+1", "4"));

        cards.add(new Card(54, "法典", 1, 內政, 科技, 藍色, "內政", "內政點數+1", "6"));
        cards.add(new Card(55, "灌溉", 1, 內政, 科技, 棕色, "農場", "食物生產+2", "3"));
        cards.add(new Card(56, "灌溉", 1, 內政, 科技, 棕色, "農場", "食物生產+2", "3"));
        cards.add(new Card(57, "煉金術", 1, 內政, 科技, 灰色, "實驗室", "科技生產+2", "4"));
        cards.add(new Card(58, "煉金術", 1, 內政, 科技, 灰色, "實驗室", "科技生產+2", "4"));
        cards.add(new Card(59, "石工學", 1, 內政, 科技, 藍色, "建築", "當你建造以及預計升級建築物，1級減免1，2級減免1，3級減免1", "3"));
        cards.add(new Card(60, "神學", 1, 內政, 科技, 灰色, "神廟", "文化生產+1，每個步兵和砲兵+1軍力", "5"));
        cards.add(new Card(61, "神學", 1, 內政, 科技, 灰色, "神廟", "文化生產+1，每個步兵和砲兵+1軍力", "5"));
        cards.add(new Card(62, "神權政治", 1, 內政, 科技, 橙色, "政府", "內政點數+4，軍事點數+3，笑臉+2", "7,2"));
        cards.add(new Card(63, "鐵礦", 1, 內政, 科技, 棕色, "礦山", "資源生產+2", "5"));
        cards.add(new Card(64, "鐵礦", 1, 內政, 科技, 棕色, "礦山", "資源生產+2", "5"));
        cards.add(new Card(65, "騎士", 1, 內政, 科技, 紅色, "騎兵", "軍力+2", "4"));
        cards.add(new Card(66, "騎士", 1, 內政, 科技, 紅色, "騎兵", "軍力+2", "4"));
        cards.add(new Card(67, "豐收", 1, 內政, 行動, 黃色, "行動", "食物+2", "0"));
        cards.add(new Card(68, "富饒之土", 1, 內政, 行動, 黃色, "行動", "提供1資源建造農場或是礦山", "0"));
        cards.add(new Card(69, "富饒之土", 1, 內政, 行動, 黃色, "行動", "提供1資源建造農場或是礦山", "0"));
        cards.add(new Card(70, "工程天才", 1, 內政, 行動, 黃色, "行動", "提供3資源建造奇蹟", "0"));
        cards.add(new Card(71, "建築工地", 1, 內政, 行動, 黃色, "行動", "提供2資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(72, "建築工地", 1, 內政, 行動, 黃色, "行動", "提供2資源建造非農場或礦山的建築", "0"));
        cards.add(new Card(73, "愛國主義", 1, 內政, 行動, 黃色, "行動", "軍事點數+1，提供2資源用於建造或升級軍隊", "0"));
        cards.add(new Card(74, "突破", 1, 內政, 行動, 黃色, "行動", "支付正常打出科技後，獲得2科技", "0"));
        cards.add(new Card(75, "藝術作品", 1, 內政, 行動, 黃色, "行動", "文化+5", "0"));
        cards.add(new Card(76, "節儉", 1, 內政, 行動, 黃色, "行動", "支付正常價格擴充人口後，獲得2食物", "0"));
        cards.add(new Card(77, "革新思想", 1, 內政, 行動, 黃色, "行動", "科技+2", "0"));
        cards.add(new Card(78, "高效升級", 1, 內政, 行動, 黃色, "行動", "升級農場，礦山少支付2點資源", "0"));
        cards.add(new Card(79, "高效升級", 1, 內政, 行動, 黃色, "行動", "升級農場，礦山少支付2點資源", "0"));
        cards.add(new Card(80, "兵家必爭之地", 1, 軍事, 事件, 淺綠色, "領土", "+2軍力，立即抽3張軍事牌", "0"));
        cards.add(new Card(81, "十字軍東征", 1, 軍事, 事件, 深綠色, "事件", "最高軍力文化+4，最低軍力文化-4", "0"));
        cards.add(new Card(82, "歷史悠久之地", 1, 軍事, 事件, 淺綠色, "領土", "笑臉+1，文化+6", "0"));
        cards.add(new Card(83, "叛亂", 1, 軍事, 事件, 深綠色, "事件", "每一個不開心的工人，下回合開始內政點數-2", "0"));
        cards.add(new Card(84, "好收成", 1, 軍事, 事件, 深綠色, "事件", "每個玩家，生產一次農場", "0"));
        cards.add(new Card(85, "富饒肥沃之地", 1, 軍事, 事件, 淺綠色, "領土", "黃點+3，立即食物+3", "0"));
        cards.add(new Card(86, "恐怖地區", 1, 軍事, 事件, 深綠色, "事件", "軍力最低損失1個工人", "0"));
        cards.add(new Card(87, "文化的影響", 1, 軍事, 事件, 深綠色, "事件", "每個玩家，生產一次文化", "0"));
        cards.add(new Card(88, "新的礦藏", 1, 軍事, 事件, 深綠色, "事件", "每個玩家，生產一次礦山", "0"));
        cards.add(new Card(89, "有人居住之地", 1, 軍事, 事件, 淺綠色, "領土", "黃點+2，立即免費生產1個工人", "0"));
        cards.add(new Card(90, "物資豐富之地", 1, 軍事, 事件, 淺綠色, "領土", "藍點+3，立即資源+5，", "0"));
        cards.add(new Card(91, "瘟疫", 1, 軍事, 事件, 深綠色, "事件", "每個玩家損失1個工人", "0"));
        cards.add(new Card(92, "礦藏", 1, 內政, 行動, 黃色, "事件", "資源+2", "0"));
        cards.add(new Card(93, "科技先進之地", 1, 軍事, 事件, 淺綠色, "領土", "黃點+1，藍點+1，立即科技+3", "0"));
        cards.add(new Card(94, "科技突破", 1, 軍事, 事件, 深綠色, "事件", "每個玩家，生產一次科技", "0"));
        cards.add(new Card(95, "移民", 1, 軍事, 事件, 深綠色, "事件", "最高笑臉的玩家，生產1個工人", "0"));
        cards.add(new Card(96, "蠻族入侵", 1, 軍事, 事件, 深綠色, "事件", "分數最高的玩家，如果軍力最低，損失1個工人", "0"));
        cards.add(new Card(97, "邊境衝突", 1, 軍事, 事件, 深綠色, "事件", "軍力最高的玩家資源+3，軍力最低的玩家，拆除1個礦山或農場", "0"));
        cards.add(new Card(98, "領土糾紛", 1, 軍事, 事件, 深綠色, "事件", "軍力最高的玩家，增加1個黃點，軍力最低的玩家，減少1個黃點", "0"));
        cards.add(new Card(99, "鼠疫", 1, 軍事, 事件, 深綠色, "事件", "每個玩家失去所有食物", "0"));
        cards.add(new Card(100, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        cards.add(new Card(101, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        cards.add(new Card(102, "中世紀軍隊", 1, 軍事, 戰術, 深紅色, "戰術", "步馬+2", "0"));
        cards.add(new Card(103, "兵陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步+1", "0"));
        cards.add(new Card(104, "兵陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步+1", "0"));
        cards.add(new Card(105, "兵陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步+1", "0"));
        cards.add(new Card(106, "軍團", 1, 軍事, 戰術, 深紅色, "戰術", "步步步+2", "0"));
        cards.add(new Card(107, "軍團", 1, 軍事, 戰術, 深紅色, "戰術", "步步步+2", "0"));
        cards.add(new Card(108, "軍團", 1, 軍事, 戰術, 深紅色, "戰術", "步步步+2", "0"));
        cards.add(new Card(109, "方陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步馬+3", "0"));
        cards.add(new Card(110, "方陣", 1, 軍事, 戰術, 深紅色, "戰術", "步步馬+3", "0"));
        cards.add(new Card(111, "輕騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬+2", "0"));
        cards.add(new Card(112, "輕騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬+2", "0"));
        cards.add(new Card(113, "重騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬馬+4", "0"));
        cards.add(new Card(114, "重騎兵", 1, 軍事, 戰術, 深紅色, "戰術", "馬馬馬+4", "0"));
        cards.add(new Card(115, "掠奪", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2，對象玩家，失去資源和食物共3，你獲得相同資源食物", "0"));
        cards.add(new Card(116, "掠奪", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2，對象玩家，失去資源和食物共3，你獲得相同資源食物", "0"));
        cards.add(new Card(117, "奴役", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2，對象玩家人口-1，你獲得3資源", "0"));
        cards.add(new Card(118, "奴役", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2，對象玩家人口-1，你獲得3資源", "0"));
        cards.add(new Card(120, "突襲", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2，拆除對象目標建築物共1個，你獲得建造向下取整的一半資源", "0"));
        cards.add(new Card(121, "突襲", 1, 軍事, 侵略, 深棕色, "侵略", "軍事點數-2，拆除對象目標建築物共1個，你獲得建造向下取整的一半資源", "0"));
        cards.add(new Card(122, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2，殖民時殖民點數+1", "0"));
        cards.add(new Card(123, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2，殖民時殖民點數+1", "0"));
        cards.add(new Card(124, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2，殖民時殖民點數+1", "0"));
        cards.add(new Card(125, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2，殖民時殖民點數+1", "0"));
        cards.add(new Card(126, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2，殖民時殖民點數+1", "0"));
        cards.add(new Card(127, "防禦卡", 1, 軍事, 獎勵, 雙色, "獎勵", "受侵略時軍力+2，殖民時殖民點數+1", "0"));

    }
//ageA內政牌.add(new Card(0, "亞歷山大大帝", 0, CardType.領袖, 100));
//SELECT CONCAT(   'cards.add(new Card(',ID,','  ,'"' ,名稱 ,'",',時代,',',牌背,',',類型,',',顏色,',','"',右上,'"','"',內容,'"));') FROM `AGES` WHERE 1

}
