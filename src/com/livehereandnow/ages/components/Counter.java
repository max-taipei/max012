/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.components;

import com.livehereandnow.ages.exception.AgesException;

/**
 *
 * @author mark
 */
public class Counter {

    private int point;

    public Counter() {
        point = 0;
    }

    public int getPoint() {
        return point;
    }

    /**
     *
     * @param k
     * @throws AgesException
     */
    public void earnPoint(int k) {
        point = point + k;
    }

    /**
     *
     * @param k must be positive integer
     * @throws AgesException
     */
    public void payPoint(int k) throws AgesException {
        point = point - k;
        if (point < 0) {
            throw new AgesException("point<0，付點數時出問題");
        }
    }

    public boolean isEnoughToPay(int k) {
        if (point >= k) {
            return true;
        }
        return false;
    }

    public void setPoint(int point) throws AgesException {
        this.point = point;
        if (point < 0) {
            throw new AgesException("point<0，設定點數值出問題");
        }
    }

}
