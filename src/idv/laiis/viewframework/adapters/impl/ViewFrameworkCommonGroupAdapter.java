package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonAdapter;
import idv.laiis.viewframework.factories.ViewHolderFactory;
import idv.laiis.viewframework.viewholders.AbstractGroupViewHolder;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public final class ViewFrameworkCommonGroupAdapter<T> extends AbstractCommonAdapter<T> {

	private String mItemCata;
	
	public ViewFrameworkCommonGroupAdapter(Fragment fragment, Class<?> cls,String itemCata) {
		super(fragment, cls);
		this.mItemCata=itemCata;
	}

	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		AbstractGroupViewHolder viewHolder = null;

		if (convertView == null) {
			viewHolder = (AbstractGroupViewHolder) ViewHolderFactory.newInstance().getViewHolder(mContext, mCls);
			convertView = viewHolder.initialGroupViewHolder(mFragment,this,getItem(position),getData(),mItemCata);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (AbstractGroupViewHolder) convertView.getTag();
		}
		
		viewHolder.filloutViewHolderContent(mFragment, getItem(position), getData(),position);

		return convertView;
	}

}
