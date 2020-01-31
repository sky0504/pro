package com.wb.pro.service.observable;

import com.wb.pro.util.LogPrintUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * 淘宝电商接口
 *
 * @author: WangBin
 * @create: 2020-01-31 20:10
 **/
public class ProductListTbObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newProduct = arg.toString();
        LogPrintUtil.systemOutPrintln("发送新产品【" + newProduct + "】同步到淘宝商城");
    }
}
