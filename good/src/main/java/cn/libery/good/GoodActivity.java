package cn.libery.good;

import android.os.Bundle;
import android.widget.TextView;

import com.lzh.compiler.parceler.annotation.Arg;
import com.lzh.nonview.router.Router;

import butterknife.BindView;
import butterknife.OnClick;
import cn.libery.core.BaseActivity;

/**
 * Created by Libery on 2016/12/19.
 * Email:libery.szq@qq.com
 */

public class GoodActivity extends BaseActivity {

    @Arg
    String goodId;

    @BindView(R2.id.good_show_id)
    TextView mShowId;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.good_activity_good);
        mShowId.setText(goodId);
        mShowId.append(getLocalClassName());
        mShowId.append("\n");
        mShowId.append(" click start ShopActivity");
    }

    @OnClick(R2.id.good_show_id)
    public void onClick() {
        Router.create("libery://shop?shopId=qwerty").open(this);
    }
}
