package idv.laiis.viewframework.sample;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import idv.laiis.viewframework.viewholders.AbstractViewHolder;


/**
 * Created by laiis on 2015/3/6.
 */
public class TestViewHolder extends AbstractViewHolder {

    private TextView mTvTitle;
    private TextView mTvDesc;

    @Override
    public View initialViewHolder(Context context, Fragment fragment, BaseAdapter adapter, ViewGroup parent,
            int index) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_test, parent, false);
        mTvTitle = (TextView) view.findViewById(R.id.id_tv_title);
        mTvDesc = (TextView) view.findViewById(R.id.id_tv_desc);
        return view;
    }

    @Override
    public void filloutViewHolderContent(Context context, Fragment fragment, Object item, Object data, int index) {
        if (item != null && item instanceof TestModel) {
            TestModel testModel = (TestModel) item;

            mTvTitle.setText(testModel.title);
            mTvDesc.setText(testModel.desc);
        }
    }
}
