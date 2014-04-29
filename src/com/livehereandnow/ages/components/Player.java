/*
 === 需求 ===
 想要降低 在GameEngine裡面程式碼的
 玩家[當前玩家].get農業(0).set藍點(玩家[當前玩家].get農業(0).get藍點()+玩家[當前玩家].get農業(0).get黃點());


 */
package com.livehereandnow.ages.components;

import static com.livehereandnow.ages.components.CardType.內政;
import static com.livehereandnow.ages.components.CardType.棕色;
import static com.livehereandnow.ages.components.CardType.灰色;
import static com.livehereandnow.ages.components.CardType.科技;
import static com.livehereandnow.ages.components.CardType.紅色;
import com.livehereandnow.ages.exception.AgesException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author max
 */
public class Player {

    private Cards cards;
    private Counter civilCounter;
    private Counter militaryCounter;

    private ScoreBoard scoreBoard;
    private Points workPool;
    private PlayerTable table;

//    private Card[] ages實驗室;
//    private Card[] ages神廟;
//    private Card[] ages農場;
//    private Card[] ages礦山;
//    private Card[] ages步兵;
    public Counter getCivilCounter() {
        return civilCounter;
    }

    public Counter getMilitaryCounter() {
        return militaryCounter;
    }

    private String name;

    private String 失敗原因;

    public String getName() {
        return name;
    }

    public String get失敗原因() {
        return 失敗原因;
    }

    public void set失敗原因(String 失敗原因) {
        this.失敗原因 = 失敗原因;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean doFarm() throws AgesException {
        // draft by Mark, 
        // 2014-4-25 17:11
        System.out.println("   === draft by Mark (start)");

//        this.init牌.get(2).getYellowPoints().addPoints(1);
        this.工人閒置區.addPoints(-1);
        System.out.println("   === draft by Mark (end)");
        //

        //
        System.out.println("玩家的DOFarm");
        System.out.println("工人區" + 工人閒置區.getPoints());
        this.工人閒置區.addPoints(-1);
        System.out.println("工人區" + 工人閒置區.getPoints());
//        System.out.println("農場0黃" + this.農場[0].get黃點());
//        this.農場[0].set黃點(this.農場[0].get黃點() + 1);
//        System.out.println("農場0黃" + this.農場[0].get黃點());
        return true;
    }

    public boolean isAnyGovernmentCardOnHand() {
        for (Card card : 手上的牌) {
            if (card.get右上().equals("政府")) {
                return true;
            }
        }
        return false;
    }

    public int getIndexOfGovernmentCardOnHand() {
        int k = -1;
        for (Card card : 手上的牌) {
            k++;
            if (card.get右上().equals("政府")) {
                return k;
            }
        }
        return k;
    }

    public boolean doGovernment() throws AgesException {
        System.out.println("99996647221245()");
        System.out.println("DOING... Player.doRevolution()");
        System.out.println("1. Do I have Govt card on hand?");
        if (isAnyGovernmentCardOnHand()) {
            System.out.println("   Yes, I have.");
            System.out.println("2. What is the card number on hand?");
            int cardIndex = getIndexOfGovernmentCardOnHand();
            System.out.println("The index is " + cardIndex);
            Card newGovt = 手上的牌.get(cardIndex);
            System.out.println("3. Now, to replace the Govt with " + newGovt);
//            this.government = newGovt;
            table.setCard政府(newGovt);
            System.out.println("*** NOT TO ALLOW MORE THAN ONE GOVT CARD ON HAND ??? *** ");

            return true;
        } else {
            System.out.println("   No, I don't.");
            return false;
        }
    }

    public boolean doIncreasePolutaion() throws AgesException {
        System.out.println(" ... only to perform: transfer yellow token from YellowBank to WorkPool");
        this.工人閒置區.addPoints(-1);
        this.workPool.addPoints(+1);
        return true;
    }

    public boolean doRevolution() throws AgesException {
        System.out.println("99996647221245()");
        System.out.println("DOING... Player.doRevolution()");
        System.out.println("1. Do I have Govt card on hand?");
        if (isAnyGovernmentCardOnHand()) {
            System.out.println("   Yes, I have.");
            System.out.println("2. What is the card number on hand?");
            int cardIndex = getIndexOfGovernmentCardOnHand();
            System.out.println("The index is " + cardIndex);
            Card newGovt = 手上的牌.get(cardIndex);
            System.out.println("3. Now, to replace the Govt with " + newGovt);
            //ver 0.49
            //this.government = newGovt;           
            table.setCard(newGovt, 0, newGovt.get時代());

//            System.out.println("*** NOT TO ALLOW MORE THAN ONE GOVT CARD ON HAND ??? *** ");
            return true;
        } else {
            System.out.println("   No, I don't.");
            return false;
        }
    }

    public boolean doStartRound() throws AgesException {//ver 0.41
        System.out.println("玩家的回合開始，補充內政和軍事點數---從政府牌補充");
//        getCivilCounter().setPoint(getCurrentGovernment().getWhite().getPoints());
//        getMilitaryCounter().setPoint(getCurrentGovernment().getRedPoints().getPoints());
        getCivilCounter().setPoint(table.getCard政府().getWhite().getPoints());
        getMilitaryCounter().setPoint(table.getCard政府().getRedPoints().getPoints());
        System.out.println("玩家的回合開始，補充內政和軍事點數---除了政府牌以外，A領袖 漢模拉比 ，A奇蹟 金字塔 ，II特殊科技-內政，II特殊科技-內政，III特殊科技-內政");

        return true;
    }

    public boolean doChangeGovernment() throws AgesException {
        System.out.println("DOING... Player.doChangeGovernment()和平轉移政權");
        System.out.println("99996647221245()");
        System.out.println("DOING... Player.doRevolution()");
        System.out.println("1. Do I have Govt card on hand?我有沒有政府牌在手上");
        if (isAnyGovernmentCardOnHand()) {
            System.out.println("   Yes, I have.");
            System.out.println("2. What is the card number on hand?");
            int cardIndex = getIndexOfGovernmentCardOnHand();
            System.out.println("The index is " + cardIndex);
            Card newGovt = 手上的牌.get(cardIndex);
            System.out.println("3. Now, to replace the Govt with " + newGovt);

            //ver 0.49
            //this.government = newGovt;           
            table.setCard(newGovt, 0, newGovt.get時代());

            //System.out.println("*** NOT TO ALLOW MORE THAN ONE GOVT CARD ON HAND ??? *** ");
            return true;
        } else {
            System.out.println("   No, I don't.");
            return false;
        }
//        return true;
    }

    public boolean doConstructWonder() throws AgesException {
        if (table.get奇蹟待建區().size() == 0) {
            System.out.println("你沒有奇蹟");
            return false;

        }

        boolean result = table.get奇蹟待建區().get(0).getWonderStage().addStageDoneCnt();
        if (result) {
            System.out.println("第" + table.get奇蹟待建區().get(0).getWonderStage().getStageDoneCnt() + "階段建造成功");
            if (table.get奇蹟待建區().get(0).getWonderStage().getStageDoneCnt() == table.get奇蹟待建區().get(0).getWonderStage().stageMaxCnt) {
                table.get奇蹟完成區().add(table.get奇蹟待建區().get(0));
                table.get奇蹟待建區().remove(0);
                System.out.println("奇蹟待建區=" + table.get奇蹟待建區().size());
            }
        } else {
            System.out.println("程式出錯了");
        }

        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    YellowBank 工人閒置區;
    BlueBank blueBank;

    public BlueBank getBlueBank() {
        return blueBank;
    }

    public YellowBank get工人閒置區() {
        return 工人閒置區;
    }

//  A{文明,食物,资源,科技}={0,0,0,0}
//    private int 文明;
//    private XXXScore 點數;
//
//    public XXXScore get點數() {
//        return 點數;
//    }
//    private int 食物;//請列出食物點數的計算方式
    //當我們要計算花費食物的時候要呼叫食物的副程式
    //
    //[農業0的值]=農業0的藍點數*1
    //[農業1的值]=農業1的藍點數*2
    //[農業2的值]=農業2的藍點數*3
    //[農業3的值]=農業3的藍點數*5
    //加總起來 回傳
    //[食物]=[農業0的值]+[農業1的值]+[農業2的值]+[農業3的值]
    //[農業0的藍點數]獲得方式
    //1.回合結束時每個在農業的黃點會生產一個符合該等級的藍點
    //2.事件獲得
    //3.侵略、戰爭獲得
    //4.黃牌獲得
//    private int 拿過的時代A領袖牌數;
//    public int get拿過的時代A領袖牌數() {
//        return 拿過的時代A領袖牌數;
//    }
//
//    public void set拿過的時代A領袖牌數(int 拿過的時代A領袖牌數) {
//        this.拿過的時代A領袖牌數 = 拿過的時代A領袖牌數;
//    }
//    private int 資源;
//    private int 科技;
////政府的影響
////    private int 內政點數;//該玩家即時的內政點數
//    private int 軍事點數;
//        System.out.println("    2, 在Player內設置當前領袖位置.戰術牌位置.待建奇蹟位置.建好的奇蹟.值民地位置,預計花0.5個小時完成,4/20日完成");
    //起始面板設置
//    private int 農業;//黃點數量
//    private int 農業0;
//    private int 農業1;
//    private int 農業2;
//    private int 農業3;
//  農業系列用於，記錄黃點數量，記錄藍點數量，記錄是否拿取科技，記錄是否已經打出這項科技。
//  希望有類似什麼樣的指令來操作
//  我希望有指令可以對農業黃點作存取，農業黃點必須是正整數或0，農業黃點需要是個陣列，要四個值
//　農業藍點同農業黃點
//    另外需要同樣陣列來標記農業科技是否拿取
//    同時需要類似陣列來標記農業科技是否打出
// === 需求分析 ===
//    農業我們需要有四個物件
//    每個物件要能記錄黃點、藍點、是否拿取、是否打出
    // === 原本想要的，就跟醫生講說開個止痛藥給我 ===
//   public void get農業黃點[x](int 農業黃點) 
//   public void set農業黃點[x](int 農業黃點)
//   public void get農業藍點[x](int 農業藍點) 
//   public void set農業藍點[x](int 農業藍點) 
//   public void get拿取農業科技[x](boolean 拿取農業科技) 
//   public void set拿取農業科技[x](boolean 拿取農業科技)
//   public void get打出農業科技[x](boolean 打出農業科技) 
//   public void set打出農業科技[x](boolean 打出農業科技)
//    private int[] 農業=new int[4];//存放黃點數量
//    private boolean[] 打出農業科技=new boolean[4];//記錄科技是否已經啟用
////    private boolean[] 打出農業科技=new boolean[4];//記錄科技是否已經啟用
    //科技區
//    private Agriculture[] 農場 = new Agriculture[4];
//    private Agriculture[] 礦山 = new Agriculture[4];//礦業的需求與農業相同，
//    private Agriculture[] 神廟 = new Agriculture[4];
//    private Agriculture[] 實驗室 = new Agriculture[4];
//    private Agriculture[] 步兵 = new Agriculture[4];
//    private Agriculture[] 騎兵 = new Agriculture[4];
//    private Agriculture[] 砲兵 = new Agriculture[4];
//    private Agriculture[] 飛機 = new Agriculture[4];
//    private Agriculture[] 競技場 = new Agriculture[4];
//    private Agriculture[] 劇院 = new Agriculture[4];
//    private Agriculture[] 圖書館 = new Agriculture[4];
//    private boolean[] 已拿取時代領袖 = new boolean[4];
//    public Agriculture[] get農場() {
//        return 農場;
//    }
//
//    public void set農場(Agriculture[] 農場) {
//        this.農場 = 農場;
//    }
//
//    public Agriculture[] get礦山() {
//        return 礦山;
//    }
//
//    public void set礦山(Agriculture[] 礦山) {
//        this.礦山 = 礦山;
//    }
//
//    public Agriculture[] get神廟() {
//        return 神廟;
//    }
//
//    public void set神廟(Agriculture[] 神廟) {
//        this.神廟 = 神廟;
//    }
//
//    public Agriculture[] get實驗室() {
//        return 實驗室;
//    }
//
//    public void set實驗室(Agriculture[] 實驗室) {
//        this.實驗室 = 實驗室;
//    }
//
//    public Agriculture[] get步兵() {
//        return 步兵;
//    }
//
//    public void set步兵(Agriculture[] 步兵) {
//        this.步兵 = 步兵;
//    }
//
//    public Agriculture[] get騎兵() {
//        return 騎兵;
//    }
//
//    public void set騎兵(Agriculture[] 騎兵) {
//        this.騎兵 = 騎兵;
//    }
//
//    public Agriculture[] get砲兵() {
//        return 砲兵;
//    }
//
//    public void set砲兵(Agriculture[] 砲兵) {
//        this.砲兵 = 砲兵;
//    }
//
//    public Agriculture[] get飛機() {
//        return 飛機;
//    }
//
//    public void set飛機(Agriculture[] 飛機) {
//        this.飛機 = 飛機;
//    }
//
//    public Agriculture[] get競技場() {
//        return 競技場;
//    }
//
//    public void set競技場(Agriculture[] 競技場) {
//        this.競技場 = 競技場;
//    }
//
//    public Agriculture[] get劇院() {
//        return 劇院;
//    }
//
//    public void set劇院(Agriculture[] 劇院) {
//        this.劇院 = 劇院;
//    }
//
//    public Agriculture[] get圖書館() {
//        return 圖書館;
//    }
//
//    public void set圖書館(Agriculture[] 圖書館) {
//        this.圖書館 = 圖書館;
//    }
    public List<Card> get手上的牌() {
        return 手上的牌;
    }

    public void set手上的牌(List<Card> 手上的牌) {
        this.手上的牌 = 手上的牌;
    }

//    public Agriculture get農場(int k) {
//        return 農場[k];
//    }
//
//    public Agriculture get礦山(int k) {
//        return 礦山[k];
//    }
//
//    public Agriculture get神廟(int k) {
//        return 神廟[k];
//    }
//
//    public Agriculture get實驗室(int k) {
//        return 實驗室[k];
//    }
//
//    public Agriculture get步兵(int k) {
//        return 步兵[k];
//    }
//
//    public Agriculture get騎兵(int k) {
//        return 騎兵[k];
//    }
//
//    public Agriculture get砲兵(int k) {
//        return 砲兵[k];
//    }
//
//    public Agriculture get競技場(int k) {
//        return 競技場[k];
//    }
//
//    public Agriculture get飛機(int k) {
//        return 飛機[k];
//    }
//
//    public Agriculture get劇院(int k) {
//        return 劇院[k];
//    }
//
//    public Agriculture get圖書館(int k) {
//        return 圖書館[k];
//    }
//    private int 工人閒置區;
//    private int 黃點工人供應區;
//    private int 藍點資源供應區;
//    public int get內政點數() {
//        return 內政點數;
//    }
//
//    public void set內政點數(int 內政點數) {
//        this.內政點數 = 內政點數;
//    }
//    public int get軍事點數() {
//        return 軍事點數;
//    }
//
//    public void set軍事點數(int 軍事點數) {
//        this.軍事點數 = 軍事點數;
//    }
//    public int get工人閒置區() {
//        return 工人閒置區;
//    }
//
//    public void set工人閒置區(int 工人閒置區) {
//        this.工人閒置區 = 工人閒置區;
//    }
//    public int get黃點工人供應區() {
//        return 黃點工人供應區;
//    }
//
//    public void set黃點工人供應區(int 黃點工人供應區) {
//        this.黃點工人供應區 = 黃點工人供應區;
//    }
//
//    public int get藍點資源供應區() {
//        return 藍點資源供應區;
//    }
//
//    public void set藍點資源供應區(int 藍點資源供應區) {
//        this.藍點資源供應區 = 藍點資源供應區;
//    }
//    private Card government;
//
//    public Card getCurrentGovernment() {
//        return government;
//    }
//
//    public void setGovernment(Card government) {
//        this.government = government;
//    }
//    private List<Card> init牌;
    private List<Card> 手上的牌;
//    private List<Card> 桌上的牌;

//    public boolean is已拿取時代領袖(int k) {//是不是已拿過該時代的領袖牌
//        return 已拿取時代領袖[k];
//    }
    /**
     * 當想要拿科技牌時，檢查手上和桌上是不是有同卡名的牌 有的話，回是 .true 沒有的話，回不是 .false
     *
     * 特例 當對方打出科技戰爭時會導致，藍色科技被拿走，可能無法使用上面的判斷
     *
     * @param card
     * @return
     */
    public boolean is已拿過該科技牌(Card card) {//是不是拿過這張科技牌
//     * 當想要拿科技牌時，檢查手上和桌上是不是有同卡名的
//        想要拿的科技牌:card
//        手上的牌
//        桌上的牌
//        System.out.println("想要拿取 " + card.toString(1));

        for (int k = 0; k < this.get手上的牌().size(); k++) {
//            System.out.println("這是目前手上的牌 " + k + " " + this.get手上的牌().get(k).toString(1));
            if (card.get卡名() == this.get手上的牌().get(k).get卡名()) {
                return true;
            }

        }
//        for (int k = 0; k < this.get桌上的牌().size(); k++) {
//            System.out.println("這是目前桌上的牌 " + k + " " + this.get桌上的牌().get(k).toString(1));
//            if (card.get卡名() == this.get桌上的牌().get(k).get卡名()) {
//                return true;
//            }
//
//        }

//        this.get
        return false;//DEBUG,假設沒拿過該張科技牌
    }

//    public boolean isSameAgeLeaderOnHand已拿取時代領袖(Card card) {//是不是拿過這張科技牌
//        if (card.get右上().equals("領袖")) {
//            for (int k = 0; k < this.get手上的牌().size(); k++) {
//                System.out.println(" isSameAgeLeaderOnHande已拿取時代領袖...這是目前手上的牌 " + k + " " + this.get手上的牌().get(k).toString(1));
//                if (card.get時代() == this.get手上的牌().get(k).get時代()) {
//                    return true;
//                }
//            }
//        }
//        System.out.println(" ... on hande, checked, clean");
//        return false;
//    }
//
//    public boolean isSameAgeLeaderOnTable(Card card) {
//        if (card.get右上().equals("領袖")) {
//
//            if (table.getLeaderDeck().get時代() == card.get時代()) {
//                System.out.println(" on table, current leader is" + table.getLeaderDeck().toString(9));
//
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean is有沒有奇蹟待建(Card card) {//是不是拿過這張科技牌
//     * 當想要拿科技牌時，檢查手上和桌上是不是有同卡名的
//        想要拿的科技牌:card
//        手上的牌
//        桌上的牌
//        System.out.println("想要拿取 " + card.toString(1));

        if (table.get奇蹟待建區().size() != 0) {
            System.out.println("尚有待建的奇蹟 ");
            return true;
        }
        return false;//DEBUG,假設沒拿過該時代領袖牌
    }

//    public void set已拿取時代領袖(int k) {//標示已拿過該時代的領袖牌
//        this.已拿取時代領袖[k] = true;
//    }
    public PlayerTable getTable() {
        return table;
    }

    //起始設定
    public Player() {
        workPool = new Points();
        scoreBoard = new ScoreBoard();
        blueBank = new BlueBank();
        table = new PlayerTable();
        table.add黃點(1, 0, 1);
        table.add黃點(2, 0, 0);
        table.add黃點(3, 0, 2);
        table.add黃點(4, 0, 2);
        table.add黃點(5, 0, 1);
        civilCounter = new Counter();
        militaryCounter = new Counter();
//        失敗原因 = "";
////        點數 = new XXXScore();
//        for (int k = 0; k < 4; k++) {
//            已拿取時代領袖[k] = false;
//            農場[k] = new Agriculture(0, 0, false, false);
//            礦山[k] = new Agriculture(0, 0, false, false);
//            神廟[k] = new Agriculture(0, 0, false, false);
//            實驗室[k] = new Agriculture(0, 0, false, false);
//
//            競技場[k] = new Agriculture(0, 0, false, false);
//            劇院[k] = new Agriculture(0, 0, false, false);
//            圖書館[k] = new Agriculture(0, 0, false, false);
//
//            步兵[k] = new Agriculture(0, 0, false, false);
//            騎兵[k] = new Agriculture(0, 0, false, false);
//            砲兵[k] = new Agriculture(0, 0, false, false);
//            飛機[k] = new Agriculture(0, 0, false, false);
//
//        }
//        農場[0] = new Agriculture(2, 0, true, true);
//        礦山[0] = new Agriculture(2, 0, true, true);
//        神廟[0] = new Agriculture(0, 0, true, true);
//        實驗室[0] = new Agriculture(1, 0, true, true);
//        步兵[0] = new Agriculture(1, 0, true, true);

//        文明 = 0;
//        食物 = 0;
//        資源 = 0;
//        科技 = 0;
        手上的牌 = new ArrayList<Card>();
//        桌上的牌 = new ArrayList<Card>();
        工人閒置區 = new YellowBank();
//        government = new Cards().getInitGovernment();

        //
        //
        //
        blueBank.setPoints(66);
        工人閒置區.setPoints(77);

    }

//    public int get文明() {
//        return 文明;
//    }
//實例 物件 對象
//
//    public void set文明(int 文明) {
//        this.文明 = 文明;
//    }
//    public void set文明食物資源科技(int 文明, int 食物, int 資源, int 科技) {
//        this.文明 = 文明;
//        this.食物 = 食物;
//        this.資源 = 資源;
//        this.科技 = 科技;
//    }
//    public int get食物() {
//        return 食物;
//    }
//
//    public void set食物(int 食物) {
//        this.食物 = 食物;
//    }
//    public int get資源() {
//        return 資源;
//    }
//
//    public void set資源(int 資源) {
//        this.資源 = 資源;
//    }
//    public int get科技() {
//        return 科技;
//    }
//
//    public void set科技(int 科技) {
//        this.科技 = 科技;
//    }
////
    public void 執行生產() {
        System.out.println("   ...執行生產");
        for (int k = 0; k < 4; k++) {
            //
//            get農場(k).set藍點(get農場(k).get藍點() + get農場(k).get黃點());
//            get礦山(k).set藍點(get礦山(k).get藍點() + get礦山(k).get黃點());
//            get農場(k).doProduction();
//            get礦山(k).doProduction();
            try {
                table.getCard(3, k).doProduction();
                table.getCard(4, k).doProduction();
            } catch (Exception ex) {
                System.out.println("   no cards on age " + k);
            }
        }
    }

//    待加入 非起始科技，特殊科技，領袖，奇蹟，殖民地
//      食物 資源
//      文化 文化生產
//    科技 科技生產
//    軍力 笑臉
//    public void 展示現況() {
////        System.out.println("執行展示...");
////        for (int k = 0; k < 4; k++) {
//        for (int k = 3; k >= 0; k--) {
////            System.out.println("k="+k);
//            if (get農場(k).is打出() == true) {
//                System.out.print("農場" + k + "  " + get農場(k).get黃點() + "(黃點)/" + get農場(k).get藍點() + "(藍點)  ");
//            } else {
//                System.out.print("                        ");
//            }
//            if (get礦山(k).is打出() == true) {
//                System.out.print("礦山" + k + "  " + get礦山(k).get黃點() + "(黃點)/" + get農場(k).get藍點() + "(藍點)  ");
//            } else {
//                System.out.print("                        ");
//            }
//            if (get實驗室(k).is打出() == true) {
//                System.out.print("實驗室" + k + "  " + get實驗室(k).get黃點() + "(黃點)  ");
//            } else {
//                System.out.print("                        ");
//            }
//            if (get神廟(k).is打出() == true) {
//                System.out.print("神廟" + k + "  " + get神廟(k).get黃點() + "(黃點)  ");
//            } else {
//                System.out.print("                        ");
//            }
//            if (get步兵(k).is打出() == true) {
//                System.out.println("步兵" + k + "  " + get步兵(k).get黃點() + "(黃點)  ");
//            } else {
//                System.out.print("                        ");
//            }
//        }
//
//    }
//    public List<Card> get桌上的牌() {
//        return 桌上的牌;
//    }
//
//    public void set桌上的牌(List<Card> 桌上的牌) {
//        this.桌上的牌 = 桌上的牌;
//    }
    public boolean doPlayCardWithRoundNumber(int cardNum, int roundNum) throws AgesException {
        //
        // 
        //
        if ((cardNum + 1) > this.get手上的牌().size()) {
            System.out.println("... index of cards-on-hand should be from 0 to " + (this.get手上的牌().size() - 1));

            return false;
        }

        //
        //
        //
        Card card = this.get手上的牌().get(cardNum);
        //
        // card must stay on hand for at least one round
        //
        if (card.getRound() == roundNum) {
            System.out.println("... you cannot play this card this round ");

            return false;
        }

        //this.get桌上的牌().add(this.get手上的牌().get(cardNum));
        System.out.println("這張牌的類型是" + this.get手上的牌().get(cardNum).get類型());
        //        當打出科技牌的時候
//        灌溉為例
        System.out.println("右上=" + this.get手上的牌().get(cardNum).get右上());

//        if (this.get手上的牌().get(cardNum).get類型() == CardType.科技) {
        if (card.get類型() == CardType.領袖) {
//          
//            table.get
            table.getLeaderDeck().setCard(card);
        } else if (card.get類型() == CardType.科技) {
//            System.out.println("123");
            switch (this.get手上的牌().get(cardNum).get右上()) {
                case "政府":
                    table.setCard政府(card);

//                    ages農場[card.get時代()] = card;
                    break;

//                case "農場": {
//                    System.out.println("準備設定已打出");
//                    this.農場[this.get手上的牌().get(cardNum).get時代()].set打出(true);
//                    System.out.println("打出了嗎?" + this.農場[this.get手上的牌().get(cardNum).get時代()].is打出());
//                }
                // ver 0.44 農場 [A-農業--農場  黃點:0 藍點:0] 
                case "實驗室":
                    table.setCard(card, 1, card.get時代());

//                    /ages實驗室[card.get時代()] = card;
                    break;
                case "神廟":
//                    ages神廟[card.get時代()] = card;
                    table.setCard(card, 2, card.get時代());
                    break;
                case "農場":
                    table.setCard(card, 3, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;
                case "礦山":
                    table.setCard(card, 4, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;
                case "步兵":
                    table.setCard(card, 5, card.get時代());

//                    ages農場[card.get時代()] = card;
                    break;

                default:
                    System.out.println("DEBUG...CardType.科技??? " + card.toString(6));
            }

        } else {
            //
            // eventually we will find proper location for different types of cards
            //
//            this.get桌上的牌().add(this.get手上的牌().get(cardNum));
            // ver 0.48
            System.out.println("... DO AS WE CAN DO TO PUT IT TO PROPER GROUP!!!");
            table.addCardToOther(card);

        }
        this.get手上的牌().remove(cardNum);

        return true;
    }

    /**
     * 三個字的指令率先實施打政府牌
     *
     * @param cardNum
     * @param type 0=和平 1=革命
     * @return
     * @throws AgesException
     */
    public boolean doPlayCard(int cardNum, int type) throws AgesException {
        Card card = this.手上的牌.get(cardNum);
        System.out.println("DOING...打政府牌" + card);
        System.out.println("DOING...打政府牌" + card.get右上());

//        if (this.手上的牌.get(cardNum).get類型() == CardType.政府) {
        if (this.手上的牌.get(cardNum).get右上().equals("政府")) {

            if (type == 0) {
                System.out.println("和平方式");
            }
            if (type == 1) {
                System.out.println("革命方式");
            }
        } else {
            System.out.println("這個指令只支援政府牌使用");
        }

        return true;
    }

    /**
     * 玩家拿牌，基本規則可查詢，http://www.livehereandnow.com/?page_id=2259 1.1.1.2.1
     * 拿過領袖的記錄，在Player 設定一個boolean 領袖牌[k] k為時代 1.1.1.3.1
     * 當拿取領袖牌的時候，先檢測是否拿過該時代的領袖牌 1.1.1.3.1.1 如果沒有拿過，則依照該領袖牌的時代，在玩家數據內做拿過的記錄
     * 1.1.1.3.1.2 如果拿過，則提示已經拿過，並否決玩家的行動 不能拿拿過的科技牌 不能拿同時
     *
     * @param cost
     * @param card
     * @return true:表示拿牌成功
     */
    public boolean doTakeCard(int cost, Card card) throws AgesException {
        //TODO check any not allowed...
        this.set失敗原因("無失敗紀錄");

        //ver 0.56
        if (card.get類型() != CardType.奇蹟) {
            if (手上的牌.size() >= table.getCard政府().getWhite().getPoints()) {
                this.set失敗原因("Maximun onhand card count is " + table.getCard政府().getWhite().getPoints() + " based on Government's white!");
                return false;
            }
        }

        if (!civilCounter.isEnoughToPay(cost)) {//如果內政點數不夠支付的話
            this.set失敗原因("NOT ENOUGH CIVIL POINTS TO PAY THIS CARD," + card.get卡名());
            return false;
        }

        switch (card.get類型()) {
            case CardType.奇蹟: {
                if (this.is有沒有奇蹟待建(card)) {
                    this.set失敗原因("還有尚未完成的奇蹟" + card.get卡名());
                    return false;
                } else {
//                    手上的牌.add(card);
                    table.get奇蹟待建區().add(card);
                }
                break;
            }
//            case CardType.領袖: {//當拿取領袖牌的時候，
//
//                if (this.isSameAgeLeaderOnHand已拿取時代領袖(card.時代)) {//先檢測是否拿過該時代的領袖牌
//
//                    this.set失敗原因("已經拿過" + card.時代 + "時代的領袖牌");
////                    System.out.println("已經拿過" + card.時代 + "時代的領袖牌");//          如果拿過，則提示已經拿過， 
//                    return false;//並否決玩家的行動，以return false告知調用的程序，這次拿牌沒有成功
//                } else {
////                     System.out.println("還沒拿過"+card.時代+"時代的領袖牌");
//                    set已拿取時代領袖(card.時代);//          如果沒有拿過，則依照該領袖牌的時代，在玩家數據內做拿過的記錄
//
//                    手上的牌.add(card);
//                }
//                break;
//            }
            case CardType.領袖: {
//                System.out.println(" DOING...  ... NEED TO CHECH IF ANY LEADER CARD ON HAND OR ON TABLE");
                if (table.getLeaderDeck().isChecked(card.get時代())) {
                    System.out.println("   ... this age is checked, you cannot get this age's leader card any more!");
                } else {

                    手上的牌.add(card);
                    table.getLeaderDeck().setChecked(card.get時代());
                }
                break;
            }
//            當拿取科技牌的時候，
//            先檢測是否拿過
            case CardType.科技: {
                System.out.println("   ... NEED TO CHECH IF ANY 科技 CARD ON HAND OR ON TABLE");

                手上的牌.add(card);

                break;
            }
            case CardType.行動: {
//                System.out.println("   ... NEED TO PERFORM 行動 ...");

                手上的牌.add(card);
                break;
            }
            default:
        }
        //拿牌扣點
//        set內政點數(get內政點數() - cost);

        getCivilCounter().payPoint(cost);
        return true;
    }
//
//    public void showAgesX5() {
//        for (int k = 0; k < 4; k++) {
//            try {
//                System.out.print(" " + ages農場[k].toString(7));
//            } catch (Exception e) {
//
//            }
//        }
//    }
//
//    public void showAgesX5() {
//        showAgesX5("  實驗室", ages實驗室);
//        showAgesX5("  神廟", ages神廟);
//        showAgesX5("  農場", ages農場);
//        showAgesX5("  礦山", ages礦山);
//        showAgesX5("  步兵", ages步兵);
//
//    }
//
//    public void showAgesX5(String title, Card[] ages) {
//        System.out.print("  " + title);
//        for (int k = 0; k < 4; k++) {
//            try {
//                System.out.print(" " + ages[k].toString(6));
//            } catch (Exception e) {
//            }
//        }
//        System.out.println("  ");
//
//    }

    public void showPoints() {
//        System.out.println("\n   " + get點數());
        System.out.println("   內政點數=" + getCivilCounter().getPoint());
        System.out.println("   軍事點數=" + getMilitaryCounter().getPoint());
        System.out.println("   ScoreBoard=>" + scoreBoard);

    }

    public void showStatus() {
        showPoints();
        showBanksAndPool();
        showCards();

//        System.out.println("    工人閒置區:"+  工人閒置區.toString());
//        show農場礦山實驗室神廟步兵();
    }

//            礦山 實驗室 神廟  步兵
//    public void show農場礦山實驗室神廟步兵() {
//        String strAges[] = {"A", "I", "II", "III"};
//
//        System.out.print("   農場 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.農場[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get農場(k).toString(1));
//            }
//        }
//
//        System.out.print("\n   礦山 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.礦山[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get礦山(k).toString(1));
//            }
//        }
//        System.out.print("\n   實驗室 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.實驗室[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get實驗室(k).toString(2));
//            }
//        }
//        System.out.print("\n   神廟 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.神廟[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get神廟(k).toString(2));
//            }
//        }
//        System.out.print("\n   步兵 (Ages)黃點=>藍點, ");
//        for (int k = 3; k >= 0; k--) {
//            if (this.步兵[k].is打出() == true) {
//                System.out.print(" (" + strAges[k] + ")" + get步兵(k).toString(2));
//            }
//        }
//        System.out.println("");
//    }
    public void showBanksAndPool() {
        System.out.println("--------------------------");
        System.out.println("   BlueBank" + getBlueBank());
        System.out.println("   YellowBank工人閒置區 " + this.get工人閒置區());
        System.out.println("   WorkPool=" + this.workPool);

    }

    public void showCards() {
        System.out.println("--------------------------");
//        showGovernmentCard();
//        showInitCards();
        table.show();

        System.out.print("\n   手牌 ");
        showCardsOnHand();
        System.out.println("");
    }

//    public void showInitCards() {
////        System.out.println();
//        for (int k = 0; k < init牌.size(); k++) {
//            System.out.println("     " + k + init牌.get(k).toString(6));
//        }
//
//    }
//    public void showGovernmentCard() {
//        System.out.println("   Govt: " + government.toString(7));
//
//    }
    public void showCardsOnHand() {
        for (int k = 0; k < 手上的牌.size(); k++) {
            System.out.print(" " + k + 手上的牌.get(k).toString(15));
        }
        System.out.println();
    }

//    public void showCardsOnTable___OTHERS() {
//        for (int k = 0; k < 桌上的牌.size(); k++) {
//            System.out.print(" " + k + 桌上的牌.get(k).toString(5));
//        }
//        //   System.out.println();
//    }
//
//    public void show() {
//        System.out.print(" 手上的牌 ");
//        show手上的牌();
//        System.out.print("  礦場=" + 礦山);
//        System.out.print("  神廟=" + 神廟);
//        System.out.print("  實驗室=" + 實驗室);
//        System.out.print("  戰士=" + 步兵);
//        System.out.print("  工人閒置區=" + 工人閒置區);
//        System.out.println("  " + toString());
//
//    }
    @Override
    public String toString() {
        return "   ....TODO ...";
    }

}
