package cn.libery.shop;


import com.lzh.nonview.router.module.RouteCreator;
import com.lzh.nonview.router.module.RouteMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Libery on 2016/12/19.
 * Email:libery.szq@qq.com
 */

public class ShopRouter implements RouteCreator {
    @Override
    public Map<String, RouteMap> createRouteRules() {
        Map<String, RouteMap> routes = new HashMap<>();
        routes.put("libery://shop", new RouteMap(ShopActivity.class).addParam("shopId", RouteMap.STRING));
        return routes;
    }
}
