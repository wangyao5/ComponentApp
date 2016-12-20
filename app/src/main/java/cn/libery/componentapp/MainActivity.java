package cn.libery.componentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lzh.nonview.router.Router;

import butterknife.BindView;
import butterknife.OnClick;
import cn.libery.core.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.show_good)
    TextView mShowGood;
    @BindView(R.id.show_shop)
    TextView mShowShop;
    @BindView(R.id.start)
    TextView mStart;

    public static final int RESULT_CODE = 1000;
    @BindView(R.id.show_type)
    TextView mShowType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowType.setText("assembleDebug : ");
        mShowType.append(BuildConfig.ASSEMBLE_TYPE);
    }

    @OnClick({R.id.show_good, R.id.show_shop, R.id.start})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_good:
                Router.create("libery://good?goodId=123456").open(this);
                break;
            case R.id.show_shop:
                Router.create("libery://shop?shopId=abcdefg").open(this);
                break;
            case R.id.start:
                Bundle extras = new Bundle();
                extras.putString("shopId", "for result");
                Router.create("libery://shop").getActivityRoute()
                        .addExtras(extras)// 添加额外参数
                        .requestCode(RESULT_CODE)
                        //.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        //.setAnim(R.anim.anim_fade_in, R.anim.anim_fade_out)
                        .open(this);
                break;
        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RESULT_CODE) {
                Toast.makeText(this, data.getStringExtra("extras"), Toast.LENGTH_LONG).show();
            }
        }
    }
}
