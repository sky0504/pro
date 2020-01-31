package com.wb.pro.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: WangBin
 * @create: 2020-01-29 20:07
 **/
@Getter
@Setter
public class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    synchronized public void printString(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("sleep catch " + e.getMessage());
            e.printStackTrace();
        }
        this.password = password;
    }
}
