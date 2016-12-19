package cn.libery.shop;

import android.os.Bundle;
import android.widget.TextView;

import com.lzh.compiler.parceler.annotation.Arg;

import butterknife.BindView;
import cn.libery.core.BaseActivity;

/**
 * Created by Libery on 2016/12/19.
 * Email:libery.szq@qq.com
 */

public class ShopActivity extends BaseActivity {

    @Arg
    String shopId;

    @BindView(R2.id.shop_show_id)
    TextView mShowId;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_activity_shop);
        mShowId.setText(shopId);
    }

}
