package cn.libery.componentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lzh.nonview.router.Router;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.libery.core.BaseActivity;

public class MainActivity extends BaseActivity {

    @BindView(R.id.show_good)
    TextView mShowGood;
    @BindView(R.id.show_shop)
    TextView mShowShop;
    @BindView(R.id.start)
    TextView mStart;
    @BindView(R.id.start_tab)
    TextView mStartTab;

    public static final int RESULT_CODE = 1000;
    @BindView(R.id.show_type)
    TextView mShowType;
    @BindView(R.id.start_fragment)
    TextView mStartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mShowType.setText("assembleDebug : ");
        mShowType.append(BuildConfig.ASSEMBLE_TYPE);
    }

    @OnClick({R.id.show_good, R.id.show_shop, R.id.start, R.id.start_tab, R.id.start_fragment})
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
            case R.id.start_tab:
                // libery://tab?tabs=fragment1,tabName1,key1:value&fragment2,tabName2,key2:value2,key3:value3
                Router.create("libery://tab?tabs=" + Fragment1.class.getCanonicalName()
                        + "&tabs=" + Fragment2.class.getCanonicalName() + ",Tab1" + ",name:x1"
                        + "&tabs=" + Fragment1.class.getCanonicalName() + ",Tab2" + ",name:x2"
                        + "&tabs=" + Fragment2.class.getCanonicalName() + ",Tab3" + ",name:x3" + ",text:xx")
                        .open(this);
                break;
            case R.id.start_fragment:
                Router.create("libery://fragment?fragment="
                        + Fragment2.class.getCanonicalName() + ",Tab3" + ",name:x3" + ",text:xx")
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
