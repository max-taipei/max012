/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import com.livehereandnow.ages.exception.AgesException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class WonderStage {

    public int getStageDoneCnt() {
        return stageDoneCnt;
    }

    public boolean addStageDoneCnt() throws AgesException {
        this.stageDoneCnt++;
     
        if (stageDoneCnt==stageMaxCnt){
            System.out.println("DOING...當建造完畢，要將該牌從建造區移到已完成區");
              return true;
        }
        if (stageDoneCnt>stageMaxCnt){
        //      throw new AgesException("stageDoneCnt>stageMaxCnt , 該奇蹟已經建造完畢，不能再建造了 ");
        return false;
        }
        return true;
    }

//    public int getStageCnt() {
//        return stageMaxCnt;
//    }

//    public void setStageCnt(int stageCnt) {
//        this.stageMaxCnt = stageCnt;
//    }

    public int[] getStage() {
        return stage;
    }

    public void setStage(int[] stage) {
        this.stage = stage;
    }

    int stageDoneCnt = 0;
    int stageMaxCnt = 0;// MAX is 5
    int[] stage = new int[5];

    public WonderStage(String stages) {
        String[] strTokens = stages.split(",");
//        List<String> tokens = new ArrayList<>();
        stageMaxCnt = 0;
        stageDoneCnt = 0;
//        int val=0;
        for (String item : strTokens) {
            if (item.length() > 0) {
//                tokens.add(item);
                // val=
                stage[stageMaxCnt] = Integer.parseInt(item);
                //  stageDoneCnt++;
                stageMaxCnt++;
            }
        }

      

    }

    @Override
    public String toString() {

        return getStageString();
    }

    private String getStageString() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < stageMaxCnt - 1; k++) {
            sb.append(stage[k]);
            sb.append(",");

        }
        sb.append(stage[stageMaxCnt - 1]);
        return getStageStatusString()+"/"+sb.toString();
    }

    private String getStageStatusString() {
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < stageMaxCnt - 1; k++) {
            if (stageDoneCnt - 1 >= k) {
                sb.append("*");
            } else {
                sb.append(stage[k]);
            }
            sb.append(",");

        }
        int k = stageMaxCnt - 1;
        if (stageDoneCnt - 1 >= k) {
            sb.append("*");
        } else {
            sb.append(stage[k]);
        }
        return sb.toString();
    }
}
