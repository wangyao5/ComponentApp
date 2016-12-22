package cn.libery.shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lzh.compiler.parceler.annotation.Arg;

import butterknife.BindView;
import butterknife.OnClick;
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
        mShowId.append(getLocalClassName());
    }

    @OnClick(R2.id.shop_show_id)
    public void onClick() {
        Intent intent = new Intent();
        intent.putExtra("extras", "result !!!");
        setResult(RESULT_OK, intent);
        finish();
    }
}
