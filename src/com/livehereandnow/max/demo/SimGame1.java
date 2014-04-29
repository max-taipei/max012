/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.max.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author chenp_000
 */
public class SimGame1 {

    public static void main(String[] args) throws IOException {
        InputStreamReader cin = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(cin);
        String cmd = "";
        String[] tokens;
        while (true) {
            System.out.print("input >> ");
            cmd = in.readLine();
            tokens = cmd.split(" ");
            System.out.println("sys >>>");
            int cnt=0;
            for (String token : tokens) {
                if (token.length()>0) {
                    System.out.println(cnt +"   >>>" + token);
                    cnt ++;
                }

            }
        }
    }

}
