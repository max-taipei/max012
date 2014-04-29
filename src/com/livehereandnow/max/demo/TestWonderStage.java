/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.livehereandnow.max.demo;

import com.livehereandnow.ages.components.WonderStage;
import com.livehereandnow.ages.exception.AgesException;

/**
 *
 * @author mark
 */
public class TestWonderStage {
    public static void main(String[] args) throws AgesException{
        WonderStage ws=new WonderStage("1,2,2,1");
        System.out.println(ws.toString());
        ws.addStageDoneCnt();
        System.out.println(ws.toString());
        ws.addStageDoneCnt();
        System.out.println(ws.toString());
        ws.addStageDoneCnt();
        System.out.println(ws.toString());
        ws.addStageDoneCnt();
        System.out.println(ws.toString());
        ws.addStageDoneCnt();
        System.out.println(ws.toString());
        
        
    }
}
