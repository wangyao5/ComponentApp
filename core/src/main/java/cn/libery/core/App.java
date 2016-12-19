package cn.libery.core;

import android.app.Application;
import android.net.Uri;
import android.util.Log;

import com.lzh.nonview.router.Router;
import com.lzh.nonview.router.exception.NotFoundException;
import com.lzh.nonview.router.route.RouteCallback;

/**
 * Created by Libery on 2016/12/16.
 * Email:libery.szq@qq.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 对Router设置Activity Route Callback,作辅助功能
        Router.setGlobalRouteCallback(new RouteCallback() {

            @Override
            public void notFound(Uri uri, NotFoundException e) {
                Log.e("App", e.getNotFoundName() + " not find");
            }

            @Override
            public void onOpenSuccess(Uri uri, String clzName) {
                Log.e("App", String.format("Launch activity %s success", clzName));
            }

            @Override
            public void onOpenFailed(Uri uri, Exception e) {
                Log.e("App", e.getMessage());
            }
        });

    }
}
