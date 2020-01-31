package com.wb.pro.vo;

/**
 * 变量
 *
 * @author: WangBin
 * @create: 2020-01-30 10:19
 **/
public class VariateSafe {
    private int num = 0;
    private final String name = "a";

    /**
     * 方法内的变量是线程安全的
     * synchronized 取得的锁都是对象锁而不是把一段代码或方法当作锁
     *
     * @param username
     */
    public void addI(String username) {
        try {
            if (name.equals(username)) {
                num = 100;
                System.out.println("a set value");

                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set value");
            }
        } catch (InterruptedException e) {
            System.out.println("set value catch" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(username + "num 的值为：" + num);
    }

}
