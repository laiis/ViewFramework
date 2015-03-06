package idv.laiis.viewframework.adapters.impl;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import idv.laiis.viewframework.adapters.AbstractCommonAdapter;
import idv.laiis.viewframework.factories.ViewHolderFactory;
import idv.laiis.viewframework.viewholders.AbstractViewHolder;


public final class ViewFrameworkCommonAdapter<T> extends AbstractCommonAdapter<T> {

    public ViewFrameworkCommonAdapter(Context context, Fragment fragment, Class<?> cls) {
        super(context, fragment, cls);
    }

    @Override
    public final View getView(int position, View convertView, ViewGroup parent) {
        AbstractViewHolder viewHolder = null;

        if (convertView == null) {
            viewHolder = ViewHolderFactory.newInstance().getViewHolder(mContext, mCls);
            convertView = viewHolder.initialViewHolder(mContext, mFragment, this, parent, position);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (AbstractViewHolder) convertView.getTag();
        }

        viewHolder.filloutViewHolderContent(mContext, mFragment, getItem(position), getData(), position);

        return convertView;
    }
}
