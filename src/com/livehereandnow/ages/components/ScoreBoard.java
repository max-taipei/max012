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
public class ScoreBoard {

    Points 文化;
    Points 文化生產;
    Points 科技;
    Points 科技生產;
    Points 軍力;

    public ScoreBoard() {
        文化 = new Points();
        文化生產 = new Points();
        科技 = new Points();
        科技生產 = new Points();
        軍力 = new Points();
    }

    @Override
    public String toString() {
        return "ScoreBoard{" + "\u6587\u5316=" + 文化 + ", \u6587\u5316\u751f\u7522=" + 文化生產 + ", \u79d1\u6280=" + 科技 + ", \u79d1\u6280\u751f\u7522=" + 科技生產 + ", \u8ecd\u529b=" + 軍力 + '}';
    }

}
