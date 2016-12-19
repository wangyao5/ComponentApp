package cn.libery.componentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lzh.nonview.router.Router;

import butterknife.BindView;
import butterknife.OnClick;
import cn.libery.core.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.show_good)
    TextView mShowGood;
    @BindView(R.id.show_shop)
    TextView mShowShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick({R.id.show_good, R.id.show_shop})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_good:
                Router.create("libery://good?goodId=123456").open(this);
                break;
            case R.id.show_shop:
                Router.create("libery://shop?shopId=abcdefg").open(this);
                break;
        }
    }
}
