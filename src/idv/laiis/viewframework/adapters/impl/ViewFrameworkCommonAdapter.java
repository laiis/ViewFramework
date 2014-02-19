package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonAdapter;
import idv.laiis.viewframework.factories.ViewHolderFactory;
import idv.laiis.viewframework.viewholders.AbstractViewHolder;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public final class ViewFrameworkCommonAdapter<T> extends AbstractCommonAdapter<T> {

	public ViewFrameworkCommonAdapter(Fragment fragment, Class<?> cls) {
		super(fragment, cls);
	}

	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		AbstractViewHolder viewHolder = null;

		if (convertView == null) {
			viewHolder = ViewHolderFactory.newInstance().getViewHolder(mContext, mCls);
			convertView = viewHolder.initialViewHolder(mFragment, this);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (AbstractViewHolder) convertView.getTag();
		}

		viewHolder.filloutViewHolderContent(mFragment, getItem(position), getData(),position);

		return convertView;
	}
}
