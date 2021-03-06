package cn.libery.core;

import com.lzh.nonview.router.module.RouteCreator;
import com.lzh.nonview.router.module.RouteMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Libery on 2016/12/22.
 * Email:libery.szq@qq.com
 */

public class TabFragmentRouter implements RouteCreator {

    @Override
    public Map<String, RouteMap> createRouteRules() {
        Map<String, RouteMap> routes = new HashMap<>();
        routes.put("libery://tab", new RouteMap(TabFragmentActivity.class)
                .addParam("tabs", RouteMap.STRING));
        routes.put("libery://fragment", new RouteMap(FragmentsActivity.class)
                .addParam("fragment", RouteMap.STRING));
        return routes;
    }

}
