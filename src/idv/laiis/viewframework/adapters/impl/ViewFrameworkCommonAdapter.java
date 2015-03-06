package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonAdapter;
import idv.laiis.viewframework.factories.ViewHolderFactory;
import idv.laiis.viewframework.viewholders.AbstractViewHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public final class ViewFrameworkCommonAdapter<T> extends AbstractCommonAdapter<T> {

	public ViewFrameworkCommonAdapter(Context context, Class<?> cls) {
		super(context,  cls);
	}

	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		AbstractViewHolder viewHolder = null;

		if (convertView == null) {
			viewHolder = ViewHolderFactory.newInstance().getViewHolder(mContext, mCls);
			convertView = viewHolder.initialViewHolder(mContext,  this, position);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (AbstractViewHolder) convertView.getTag();
		}

		viewHolder.filloutViewHolderContent(mContext,  getItem(position), getData(), position);

		return convertView;
	}
}
