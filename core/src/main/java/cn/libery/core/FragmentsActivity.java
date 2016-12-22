package cn.libery.core;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.lzh.compiler.parceler.annotation.Arg;

/**
 * Created by Libery on 2016/12/22.
 * Email:libery.szq@qq.com
 */

public class FragmentsActivity extends BaseActivity {

    private static final String PLACE_HOLDER = ",";
    private static final String PARAM_HOLDER = ":";

    @Arg
    String fragment;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.core_fragment_activity);
        createFragment();
    }

    private void createFragment() {
        try {
            if (fragment.contains(PLACE_HOLDER)) {
                String[] contents = fragment.split(PLACE_HOLDER);
                Bundle args = new Bundle();
                Fragment f = (Fragment) Class.forName(contents[0]).newInstance();
                int length = contents.length;
                if (length > 2) {
                    for (int i = 1; i < length; i++) {
                        String s = contents[i];
                        if (s.contains(PARAM_HOLDER)) {
                            String[] x = s.split(PARAM_HOLDER);
                            Log.e("param", x[0] + "&&" + x[1]);
                            args.putString(x[0], x[1]);
                        }
                    }
                    args.putString("title", contents[1]);
                }
                f.setArguments(args);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.layout_container, f)
                        .commit();
            } else {
                Fragment f = (Fragment) Class.forName(fragment).newInstance();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.layout_container, f)
                        .commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
