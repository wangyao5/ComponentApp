package cn.libery.good;


import com.lzh.nonview.router.module.RouteCreator;
import com.lzh.nonview.router.module.RouteMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Libery on 2016/12/19.
 * Email:libery.szq@qq.com
 */

public class GoodRouter implements RouteCreator {
    @Override
    public Map<String, RouteMap> createRouteRules() {
        Map<String, RouteMap> routes = new HashMap<>();
        routes.put("libery://good", new RouteMap(GoodActivity.class).addParam("goodId", RouteMap.STRING));
        return routes;
    }
}
