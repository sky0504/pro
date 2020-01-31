package com.wb.pro.service.observable;

import com.wb.pro.util.LogPrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * 被观察的产品列表
 *
 * @author: WangBin
 * @create: 2020-01-31 19:54
 **/
public class ProductList extends Observable {
    /**
     * 产品列表
     */
    private List<String> productList = null;
    /**
     * 类唯一实例
     */
    private static ProductList instance;

    /**
     * 构建方法私有化
     */
    private ProductList() {
    }

    /**
     * 获取唯一实例
     * <p>
     * 使用的是单例模式，，构造方法私有化，避免通过new的方式创建对象
     *
     * @return 产品列表唯一实例
     */
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<>();
        }
        return instance;
    }

    /**
     * 新增产品的观察者
     *
     * @param observer 观察者
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    /**
     * 新增产品
     *
     * @param newProduct 新产品
     */
    public void addProduct(String newProduct) {
        productList.add(newProduct);
        LogPrintUtil.systemOutPrintln("产品列表新增了产品：" + newProduct);
        //设置被观察对象发送变化
        this.setChanged();
        //通知观察者，并传递新产品
        this.notifyObservers(newProduct);
    }
}
