package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonExpandableAdapter;
import idv.laiis.viewframework.factories.ViewHolderFactory;
import idv.laiis.viewframework.viewholders.AbstractExpandableViewHolder;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public final class ViewFrameworkCommonBaseExpandableAdapter<T> extends AbstractCommonExpandableAdapter<T> {

	public ViewFrameworkCommonBaseExpandableAdapter(Fragment fragment, Class<?> parentCls, Class<?> childCls) {
		super(fragment, parentCls, childCls);
	}

	@Override
	public final View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		AbstractExpandableViewHolder parentViewHolder = null;

		if (convertView == null) {
			parentViewHolder = ViewHolderFactory.newInstance().getExpandableViewHolder(mFragment.getActivity(), mParentCls);
			convertView = ((AbstractExpandableViewHolder) parentViewHolder).initialViewHolder(mFragment, this);
			convertView.setTag(parentViewHolder);
		} else {
			parentViewHolder = (AbstractExpandableViewHolder) convertView.getTag();
		}

		parentViewHolder.filloutViewHolderContent(mFragment, getGroup(groupPosition), getParentData(), isExpanded, groupPosition, 0);

		return convertView;
	}

	@Override
	public final View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		AbstractExpandableViewHolder childViewHolder = null;

		if (convertView == null) {
			childViewHolder = ViewHolderFactory.newInstance().getExpandableViewHolder(mFragment.getActivity(), mChildCls);
			convertView = ((AbstractExpandableViewHolder) childViewHolder).initialViewHolder(mFragment, this);
			convertView.setTag(childViewHolder);
		} else {
			childViewHolder = (AbstractExpandableViewHolder) convertView.getTag();
		}

		childViewHolder.filloutViewHolderContent(mFragment, getChild(groupPosition, childPosition), getChildData(), isLastChild, childPosition, groupPosition);

		return convertView;
	}

}
