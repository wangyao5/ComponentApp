package cn.libery.componentapp;

import com.lzh.nonview.router.Router;

import cn.libery.core.App;
import cn.libery.good.GoodRouter;
import cn.libery.shop.ShopRouter;

/**
 * Created by Libery on 2016/12/19.
 * Email:libery.szq@qq.com
 */

public class MyApp extends App {
    @Override
    public void onCreate() {
        super.onCreate();
        Router.addRouteCreator(new GoodRouter());
        Router.addRouteCreator(new ShopRouter());
    }
}
