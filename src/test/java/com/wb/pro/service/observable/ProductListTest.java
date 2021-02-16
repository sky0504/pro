package com.wb.pro.service.observable;

/**
 * 测试观察者模式
 *
 * @author: WangBin
 * @create: 2020-01-31 20:11
 **/
public class ProductListTest {
    /**
     * 测试观察者模式下新增商品后的动作
     *
     * @param args
     */
    public static void main(String[] args) {
        //获取被观察者实例
        ProductList productList = ProductList.getInstance();
        ProductListJdObserver jdObserver = new ProductListJdObserver();
        ProductListTbObserver tbObserver = new ProductListTbObserver();
        //添加观察者
        productList.addProductListObserver(jdObserver);
        productList.addProductListObserver(tbObserver);
        productList.addProduct("西瓜");
    }
}
