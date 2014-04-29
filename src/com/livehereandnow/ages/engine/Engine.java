/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.engine;

import com.livehereandnow.ages.components.Player;
import com.livehereandnow.ages.exception.AgesException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class Engine {

    private EngineCore core;

    public Engine() throws AgesException {
        core = new EngineCore();

    }

//    public EngineCore getCore() {
//        return core;
//    }
    public Player getCurrentPlayer() {
        return core.get當前玩家();
    }

    public boolean doCmd(String keyword) throws IOException, AgesException {
        switch (keyword) {
            case "increase-population"://v0.52
            case "population"://v0.52
                return core.doIncreasePopulation();
            case "revolution"://v0.39
                return core.doRevolution();
            case "govt"://v0.39
            case "change-government"://v0.39
                return core.doChangeGovernment();

            case "construct-wonder":
            case "wonder":
                return core.doConstructWonder();

            case "farm":
                return core.doFarm();
            case "help":
                return core.doHelp();

            case "status":
                return core.doStatus();

            case "version":
                return doVersion();

            case "change-turn":
                return core.doChangeTurn();

            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;
        }
    }

    public boolean doCmd(String keyword, int parameter) throws IOException, AgesException {
        switch (keyword) {
            case "打":
            case "out":
            case "play":
            case "play-card":
            case "out-card":
                return core.doPlayCardWithRoundNumber(parameter);

            case "拿"://在我的環境NetBeans無法執行，但是在DOS可以
            case "拿牌":
            case "take":
            case "take-card":
                return core.doTakeCard(parameter);

            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;
        }
    }

    public boolean doCmd(String keyword, int parameter, int parameter2) throws IOException, AgesException {
        switch (keyword) {
            case "打":
            case "out":
            case "play":
            case "play-card":
            case "out-card":
                return core.doPlayCard(parameter, parameter2);

            default:
                System.out.println("Unknown keyword, " + keyword);
                return false;
        }
    }

    public boolean doVersion() {

        System.out.println();
                System.out.println("  === ver 0.58 ===  2014-4-29, 10:51, by Max　");
        System.out.println("    1. 修正*DEBUG 時代A的6張沒有被移除，仍然出現在第一次補牌 ");
        System.out.println("    ");
                System.out.println("  === ver 0.57.1 ===  2014-4-29, 10:00, by Max　");
        System.out.println("    1. *DEBUG 時代A的6張沒有被移除，仍然出現在第一次補牌 ");
        System.out.println();

        System.out.println("  === ver 0.57 ===  2014-4-29, 10:00, by Max　");
        System.out.println("    1. *預設牌庫及事件顯現位置 ");
        System.out.println();
        System.out.println("  === ver 0.56 ===  2014-4-28, 22:30, by Mark　");
        System.out.println("    1. ****secured maximum card numbers on-hand **** 設定手牌上限值");
        System.out.println();

        System.out.println("  === ver 0.55 ===  2014-4-28, 22:10, by Mark　");
        System.out.println("    1. ****secured cards be held for one round using RoundNumber on Card**** 進手牌當輪不能打出");
        System.out.println();

        System.out.println("  === ver 0.54 ===  2014-4-28, 21:20, by Mark　");
        System.out.println("    1. change Government holder to be Card ");
        System.out.println("    2. also fix 農場 and 礦山 doProduction 修正農場和礦山的生產方式");
        System.out.println();
        System.out.println("  === ver 0.53 ===  2014-4-28, 20:20, by Mark　");
        System.out.println("    1. secure not allow repeat leader within the same age 時代領袖");
        System.out.println("    2. new LeaderDeck class with ages:**23 layout");
        System.out.println();
        System.out.println("  === ver 0.52 ===  2014-4-28, 17:00, by Mark　");
        System.out.println("    1. basic population/increase-poluation 增加人口");
        System.out.println();
        System.out.println("  === ver 0.51 ===  2014-4-28, 16:30, by Mark　");
        System.out.println("    1. to show all components on player's side");
        System.out.println();
        System.out.println("  === ver 0.50 ===  2014-4-28, 15:50, by Mark　");
        System.out.println("    1. transfer wonders from Player to PlayerTable");
        System.out.println("    2. fixed, No repeat leader on the the age!");
        System.out.println();

        System.out.println("  === ver 0.49 ===  2014-4-28, 15:00, by Mark　");
        System.out.println("    1. doRevolution and doGovernment using PlayerTable");
        System.out.println("    2.  //this.government = newGovt;           \n"
                + "            table.setCard(newGovt, 0, newGovt.get時代()); ");
        System.out.println();

        System.out.println("  === ver 0.48 ===  2014-4-28, 14:30, by Mark　");
        System.out.println("    1. transfer leader to PlayerTable");
        System.out.println("    2. show leader as 領袖 [A內政-漢摩拉比 內政點數+1，軍事點數-1] ");
        System.out.println();

        System.out.println("  === ver 0.47 ===  2014-4-28, 13:45, by Mark　");
        System.out.println("    1. put PlayerTable to Player");
        System.out.println("    2. follow 實驗室 [A-哲學--實驗室  黃點:1 藍點:0] style to have 政府 [A-專制--政府  White點:4 Red點:2]  ONLY TO SEE LATEST ONE!!! ");
        System.out.println();

        System.out.println("  === ver 0.46 ===  2014-4-28, 11.24, by Max　");
        System.out.println("    1.***在PlayerTable裡面新建upgrade黃點的方法，調用了同樣是PlayerTable裡面add黃點，給【升級】做應用");
        System.out.println("    2.*在TestPlayerTable裡面知道如何建立不同的測試方法並調用他");

        System.out.println("  === ver 0.45 ===  2014-4-27, 21:50, by Mark　");
        System.out.println("    1.****** introduce PlayerTable");
        System.out.println("    2.****** provide method public void add黃點(int type, int age, int point)");

        System.out.println("  === ver 0.44 ===  2014-4-27, 7:36, by Mark　");
        System.out.println("    1.introduce Card[] ages實驗室,神廟,農場,礦山,步兵 to meet Max's Agriculture's idea");
        System.out.println("    2.for known type (實驗室,神廟,農場,礦山,步兵) card will go to proper player's card columns");
        System.out.println("    3.** showAgesX5(String title, Card[] ages) **");
        System.out.println();

        System.out.println("  === ver 0.43.1 ===  2014-4-26, 18:42, by Max　");
        System.out.println("新增help專有名詞說明");
        System.out.println("  === ver 0.43 ===  2014-4-26, 16:42, by Max　");
        System.out.println("    1. 字元檢測不能使用if (this.手上的牌.get(cardNum).get類型() == CardType.政府)");
        System.out.println("    2. 要使用正確規格if (this.手上的牌.get(cardNum).get右上().equals(\"政府\"))");

        System.out.println("  === ver 0.42 ===  2014-4-26, 15:32, by Max　");
        System.out.println("    1. 在help內增加Revolution");
        System.out.println("    2. 在help內增加change-government");
        System.out.println("    3. 模仿Revolution的方式讓change-government能夠運行 估計5分鐘");
        System.out.println("    4. 增加out x y x=手上牌的索引值，y=0代表和平 y=1代表革命");

        System.out.println("  === ver 0.41 ===  2014-4-26, 15:32, by Max　");
        System.out.println("    1. 補充內政和軍事點數改為由Player控制");

        System.out.println();

        System.out.println("  === ver 0.40 ===  2014-4-26, 12:50, by Mark　");
        System.out.println("    1. new command revolution");
        System.out.println("    2. after change-turn, update current player 內政點數 軍事點數 using  Govt: [A-專制--政府  White點:4 Red點:2] ");
        System.out.println();

        System.out.println("  === ver 0.39 ===  2014-4-26, 11:15, by Mark　");
        System.out.println("    1. *** show init cards using Max's cards info***");

        String strv039 = ""
                + "-------------------------"
                + "\nGovt: [A內政-專制 內政點數+4，軍事點數2 建造成本:0/0] "
                + "\n0[A-哲學--實驗室  黃點:1 藍點:0] "
                + "\n1[A-宗教--神廟  黃點:0 藍點:0] "
                + "\n2[A-農業--農場  黃點:2 藍點:0] "
                + "\n3[A-青銅--礦山  黃點:2 藍點:0] "
                + "\n4[A-戰士--步兵  黃點:1 藍點:0]";
        System.out.println(strv039);
        System.out.println();

        System.out.println("  === ver 0.38 ===  2014-4-25, 17:45, by Mark　");
        System.out.println("    1. *** introduce government with white and red points***");
        System.out.println("    2. change status to show current player only");
        System.out.println("    3. show government card info on status with toString(7) ");

        System.out.println();
        System.out.println("  === ver 0.37 ===  2014-4-25, 17:20, by Mark　");
        System.out.println("    1. *** draf farm action***");
        System.out.println("    ###Warning### String == IS NOT RIGHT");
        System.out.println();

        System.out.println("  === ver 0.37 ===  2014-4-25, 17:00, by Mark　");
        System.out.println("    1. introduce initCards on Cards");
        System.out.println("    2. on status, show initCards with Yellow and Blue points ");
        System.out.println("    3. secure Cards' private fields and fix calling methods");
        System.out.println("    4. ###Warning### String == IS NOT RIGHT");
        System.out.println();

        System.out.println("  === ver 0.36 ===  2014-4-25, 16:00, by Mark　");
        System.out.println("    1. introduce Points.java");
        System.out.println("    2. ***** new BlueBank and YellowBank extends Points *****");
        System.out.println("    3. done, play 2, java.lang.IndexOutOfBoundsException: Index: 2, Size: 2");
        System.out.println("    4. on each card, add yellowPoints and bluePoints using Points.java");
        System.out.println();
        System.out.println("  === ver 0.35 ===  2014-4-25, 15:30, by Mark　");
        System.out.println("    1. introduce HappyFaces.java");
        System.out.println("    2. split Score from Player.java");
        System.out.println("    3. TODO play 2, java.lang.IndexOutOfBoundsException: Index: 2, Size: 2");
        System.out.println();
        System.out.println("  === ver 0.34 ===  2014-4-25, 12:47, by Max　");
        System.out.println("    1. done 打出來的科技牌，激活該科技牌---時代1~3在農場和礦山各自只有1種應對的科技牌，時代I有2張，時代2.3各有1張");
        System.out.println("    2. done 奇蹟待建區完成後移至奇蹟建造完成區");
        System.out.println("    3. 優化status依照激活的方式展現科技");
        System.out.println("    4. 建立新的calss WorkPool");
        System.out.println("  === ver 0.33 ===  2014-4-24, 19:44, by Mark　");
        System.out.println("    1. done, starting round#2, add cards to Card Row");
        System.out.println("    2. TODO how to end game when no more cards");
        System.out.println();
        System.out.println("  === ver 0.32 ===  2014-4-24, 19:44, by Mark　");
        System.out.println("    1. *** introduce CardRow.java ***");
        System.out.println("    2. TODO addNewCivilCard");
        System.out.println();
        System.out.println("  === ver 0.31.1 ===  2014-4-24, 19:25, by Mark　");
        System.out.println("    1. hide 想要拿取...");
        System.out.println("    2. fix simple enter --- just do nothing and prompt again");
        System.out.println();
        System.out.println("  === ver 0.31 ===  2014-4-24, 19:08, by Mark　");
        System.out.println("    1. *** rearrange doCmd ***");
        System.out.println();
        System.out.println("  === ver 0.30 ===  2014-4-24, 18:30, by Mark　");
        System.out.println("    1. split Engine to Engine and EngineCore");
        System.out.println("    2. TODO add militaryCounter");
        System.out.println();

        System.out.println("  === ver 0.29 ===  2014-4-24, 13:42, by Mark　");
        System.out.println("    1. new WonderStage with constructing status in toString()");
        System.out.println("    2. add command 'construct-wonder','wonder' ");
        System.out.println("    3. done, 建造成本原本是用字符串的方式(只有人看得懂)，現在準備拆解為各階段數值內容(程式能判讀)");
        System.out.println("    4. TODO add militaryCounter");
        System.out.println();

        System.out.println("  === ver 0.28 ===  2014-4-24, 12:22, by Max　");
        System.out.println("    1. 設定多樣是toString");
        System.out.println("    2. 重設拿取領袖牌邏輯，設定奇蹟牌邏輯");
        System.out.println("    3. TODO 建造成本原本是用字符串的方式(只有人看得懂)，現在準備拆解為各階段數值內容(程式能判讀)");
        System.out.println("    4. TODO add militaryCounter");

        System.out.println("  === ver 0.27 ===  2014-4-24, 8:33, by Mark　");
        System.out.println("    1. introduce AgesException and new Counter class");
        System.out.println("    2. done, not allow to take card when 內政點數不夠");
        System.out.println("    3. add civilCounter");
        System.out.println("    4. TODO add militaryCounter");

        System.out.println("  === ver 0.26 ===  2014-4-23, 12:44, by Max　");
        System.out.println("    1. 實施拿牌沒有成功的原因");
        System.out.println("    2. done 拿牌沒有成功的原因:已經拿過0時代的領袖牌");
        System.out.println("    3. TODO 內政點數不夠，已經拿過該科技牌，尚有未完成的奇蹟");

        System.out.println("  === ver 0.25 ===  2014-4-23, 12:06, by Max　");
        System.out.println("    1. 在Player裡面增加 應對拿牌不同的類型，做出不同的判斷方式(目前只做了領袖跟一半的奇蹟)");
        System.out.println("    2.  在Emgine做take-card如果遭遇回傳false 顯示該牌");

        System.out.println("  === ver 0.24 ===  2014-4-23, 8:30, by Mark　");
        System.out.println("    1. rearrange package");
        System.out.println("    2. new com.livehereandnow.ages.Main");
        System.out.println("    3. new com.livehereandnow.ages.engine.Engine");
        System.out.println("    4. player with name, Max and Amy");

        System.out.println();
        System.out.println("  === ver 0.23 ===  2014-4-22, 20:30, by Mark　");
        System.out.println("    1. create doTakeCard on Player");
        System.out.println("    2. improve doStatus layout --- show 農場 (Ages)黃點=>藍點,  (III)0=>0 (II)0=>0 (I)0=>0 (A)2=>2");
        System.out.println();

        System.out.println("  === ver 0.22 ===  2014-4-22, 18:00, by Mark　");
        System.out.println("    1. implement --- A Wonder goes directly to the table. Only one Wonder can be “under construction”.");
        System.out.println("    2. improve doStatus layout");
        System.out.println();

        System.out.println("  === ver 0.21 ===  2014-4-22, 12:21, by MAX　");
        System.out.println("    1. 新增out-card指令用於打出手牌");
        System.out.println("    2. 增加玩家桌面的牌");
        System.out.println("    3. 顯示桌牌的內容");
        System.out.println("    4. 為方便測試暫時取消點數限制，能在第一回合取多張牌");
        System.out.println("    5.手上多張牌可以一直打第0張，能夠順利打到桌上，但是無法打第1張???");
        System.out.println("  === ver 0.20 ===  2014-4-22, 01:55, by MAX　");
        System.out.println("    1. 展示區改由Player提供方法");
        System.out.println("    2. 重新定義農業、礦業、戰士改為農場、礦山、步兵");
        System.out.println("  === ver 0.19.1 ===  2014-4-21, 11:50, by MAX　");
        System.out.println("    1. 建立展示點數雛型");
        System.out.println("  === ver 0.19 ===  2014-4-21, 11:33, by MAX　");
        System.out.println("    1. 將繁瑣的程式碼，放到該屬於Player自有的地方執行");
        System.out.println("    2. 將單一時代的農業擴展為4個時代");
        System.out.println("    3. 將農業擴展到其他科技");
        System.out.println("  === ver 0.18 ===  2014-4-21, 10:32, by MAX　");
        System.out.println("    1. 設定成功依照私有板塊獲得對應的資源");
        System.out.println("  === ver 0.17.1 ===  2014-4-19, 11:34, by MAX　");
        System.out.println("    1. 變更TODO,預計明日要完成事項");
        System.out.println("  === ver 0.17 ===  2014-4-19, 11:23, by MAX　");
        System.out.println("    1. 在時代A內政牌內匯入正確的牌，包括基礎暴力法和進階的篩選過濾法");
        System.out.println("    2. showcardRow的結構大更新，改由從card給String");
        System.out.println("    3. 單張牌顯示方式,[時代A內政-革新思想-行動]");
        System.out.println("  === ver 0.16 ===  2014-4-19, 10:34, by MAX　");
        System.out.println("    1. 在時代A內政牌暫時匯入所有的卡牌");
        System.out.println("    2. 在status裡面標示出卡牌的時代0.1.2.3");
        System.out.println("    2. 在status裡面標示出卡牌的時代名,時代A,時代I,時代II,時代III");
        System.out.println();
        System.out.println("  === ver 0.15 ===  2014-4-19, 9:14, by MAX　");
        System.out.println("    1. 新增class Cards 用於放所有的卡牌");
        System.out.println();
        System.out.println("  === ver 0.14 ===  2014-4-18, 10:48, by MAX　");
        System.out.println("    1. 已經可以在命令行設定文化指數");
        System.out.println();
        System.out.println("  === ver 0.13 ===  2014-4-18, 10:12, by MAX　");
        System.out.println("    1. 在class Player新增了一個內部類(Score),用於顯示玩家目前的分數");
        System.out.println();
        System.out.println("  === ver 0.12 ===  2014-4-17, 11:58, by MAX　");
        System.out.println("    1. Player 本來的p1~p4 改成陣列型態 大幅結構更動");
        System.out.println();
        System.out.println("  === ver 0.11 ===  2014-4-17, 11:34, by MAX　");
        System.out.println("    1. 建立科技陣列框架(特殊科技除外)，並在TestPlayer測試執行可用");
        System.out.println();

        System.out.println("  === ver 0.10 ===  2014-4-17, 11:08, by MAX　");
        System.out.println("    1. 建立資源陣列框架，並在TestPlayer測試執行可用");
        System.out.println();

        System.out.println("  === ver 0.9 ===  2014-4-16, 19:31, by MAX　");
        System.out.println("    1. 修復3個玩家和4個玩家時的拿牌扣點");
        System.out.println("    2. 新增簡易指令take");
        System.out.println();

        System.out.println("  === ver 0.8 ===  2014-4-16, 18:40, by Mark");
        System.out.println("    1. 2nd round forward, set points 4 to each player");
        System.out.println();

        System.out.println("  === ver 0.7 ===  2014-4-16, 18:00, by Mark");
        System.out.println("    1. fix 禁止讓玩家拿兩張A時代領袖");
        System.out.println("    2. enhance status layout, show card with typename");
        System.out.println("    3. enhance 4 player on first round taking cards");
        System.out.println();

        System.out.println();
        System.out.println("  === ver 0.6 ===  2014-4-16, 12:42");
        System.out.println("    1. 禁止讓玩家拿兩張A時代領袖");
        System.out.println();

        System.out.println("  === ver 0.5.1 ===  2014-4-16, 11:49");
        System.out.println("    1. 取消輸入英文變成小寫");
        System.out.println("    2. 新增TODO指令,記錄應該要處理的待辦事項");
        System.out.println();

        System.out.println("  === ver 0.5 ===  2014-4-16, 11:27");
        System.out.println("    1. 玩家再也無法拿空牌");
        System.out.println("    2. 玩家可以有效的拿取卡牌列上的牌,並有效的支付點數");
        System.out.println();

        System.out.println("  === ver 0.4 ===  2014-4-16, 11:00");
        System.out.println("    1. do拿牌扣點 可以有效的扣除該玩家拿牌後的內政點數");
        System.out.println("    2. 玩家內政點數沒有時無法拿取卡牌列0~4");
        System.out.println();

        System.out.println("  === ver 0.3 ===  2014-4-16, 09:50");
        System.out.println("    1. 拿牌限制在前13張,也就是take-card 0到12是有效值,不在這範圍的是無效指令");
        System.out.println();

        System.out.println("  === ver 0.2.2 ===  2014-4-16, 09:30");
        System.out.println("    1. 增加中文說明");
        System.out.println("    2. 增加version到help");
        System.out.println();

        System.out.println("  === ver 0.2.1 ===  2014-4-16, 08:30");
        System.out.println("    1. hide player 1 is going to 拿取 card#0");
        System.out.println("    2. show player 1 拿取 [凱薩]");
        System.out.println("    3. improve help command增加幫助指令");
        System.out.println();

        System.out.println("  === ver 0.2 ===  2014-4-16, 08:00");
        System.out.println("    1. allow palyers to take-card增加拿牌的指令,暫時沒有檢查有沒有足夠的內政點數");
        System.out.println("    2. design NOCARD when card was taken from CardRow牌拿走之後,該格補上一張空白牌");
        System.out.println("    3. show Player's on-hand cards顯示玩家們的手牌");
        System.out.println();

        System.out.println("  === ver 0.1 ===  2014-4-15, 18:00");
        System.out.println("    1. allow 2 to 4 players to change-turn讓2~4的玩家可以做 換下一位");
        System.out.println("    2. show CardRow with value 1,2 and 3展示卡牌列，並顯示各卡牌的價格");

        System.out.println("  === 版本控制說明 ===");
        System.out.println("    1. ver X.Y.Z");
        System.out.println("    2. X最大版本,基本功能尚未完備前為0");
        System.out.println("    3. Y中版本,任何和業務邏輯相關的新增移除功能,Y版本+1,只要Y的值增加,Z值歸0,當有重大結構性調整時仍然歸屬在Y版本");
        System.out.println("    4. Z最小版本,任何使用者介面的調整或增刪說明,與功能無關");
        return true;
    }
}
