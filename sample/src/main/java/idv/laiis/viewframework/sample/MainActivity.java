package idv.laiis.viewframework.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import idv.laiis.viewframework.adapters.AbstractCommonAdapter;
import idv.laiis.viewframework.adapters.impl.ViewFrameworkCommonAdapter;


/**
 * Created by laiis on 2015/3/6.
 */
public class MainActivity extends Activity {

    private ListView mListView;
    private AbstractCommonAdapter<TestModel> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initials();
        setDummyDatas();
    }

    private void initials() {
        if (mAdapter == null) {
            mAdapter = new ViewFrameworkCommonAdapter<TestModel>(this, null, TestViewHolder.class);
        }

        mListView = (ListView) findViewById(android.R.id.list);
        mListView.setAdapter(mAdapter);
    }

    private void setDummyDatas() {
        List<TestModel> list = new ArrayList<TestModel>();

        for (int i = 0; i < 100; i++) {
            TestModel tm = new TestModel();
            tm.title = String.valueOf((char) ('A' + i));
            tm.desc = "test desc";

            list.add(tm);
        }

        mAdapter.addItems(list);
    }
}
