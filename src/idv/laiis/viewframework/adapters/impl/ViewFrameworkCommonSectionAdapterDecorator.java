package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonAdapter;
import idv.laiis.viewframework.factories.ViewHolderFactory;
import idv.laiis.viewframework.viewholders.AbstractViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public final class ViewFrameworkCommonSectionAdapterDecorator<T> extends AbstractCommonAdapter<T> {

	public static final int TYPE_ITEM = 0;
	public static final int TYPE_SEPARATOR = 1;

	private AbstractCommonAdapter<T> mCommonAdapter;
	private List<Integer> mSectionList = Collections.synchronizedList(new ArrayList<Integer>());
	private Class<?> mSectionCls;

	public ViewFrameworkCommonSectionAdapterDecorator(Context context, Class<?> cls, Class<?> sectionCls, AbstractCommonAdapter<T> commonAdapter) {
		super(context,  cls);
		this.mCommonAdapter = commonAdapter;
		this.mSectionCls = sectionCls;
	}

	@Override
	public final void addItems(List<T> tList) {
		mCommonAdapter.addItems(tList);
		notifyDataSetChanged();
	}

	@Override
	public final void addItem(T t) {
		mCommonAdapter.addItem(t);
		notifyDataSetChanged();
	}

	@Override
	public final int getCount() {
		return mCommonAdapter.getCount() + mSectionList.size();
	}

	@Override
	public final T getItem(int position) {
		if (mSectionList.contains(position)) {
			return null;
		} else {
			int secSize = mSectionList.size();
			if (secSize > 0) {
				for (int i = secSize - 1; i >= 0; i--) {
					if (position < mSectionList.get(i)) {
						secSize--;
					} else if (position == mSectionList.get(i)) {
						return null;
					}
				}
			}
			return mCommonAdapter.getItem(position - secSize);
		}
	}

	@Override
	public final List<T> getItems() {
		return mCommonAdapter.getItems();
	}

	@Override
	public final long getItemId(int position) {
		if (mSectionList.contains(position)) {
			return 0;
		} else {
			int secSize = mSectionList.size();
			if (secSize > 0) {
				for (int i = secSize - 1; i >= 0; i--) {
					if (position < mSectionList.get(i)) {
						secSize--;
					} else if (position == mSectionList.get(i)) {
						return 0;
					}
				}
			}
			return mCommonAdapter.getItemId(position - secSize);
		}
	}

	@Override
	public final void removeAllItems() {
		mCommonAdapter.removeAllItems();
		mSectionList.clear();
		notifyDataSetChanged();
	}

	public final void addSectionHeaderItem(T t) {
		mSectionList.add(mCommonAdapter.getCount());
		notifyDataSetChanged();
	}

	@Override
	public final int getViewTypeCount() {
		return 2;// ITEM , SEPARATOR
	}

	@Override
	public final int getItemViewType(int position) {
		return mSectionList.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
	}

	@Override
	public final View getView(int position, View convertView, ViewGroup parent) {
		AbstractViewHolder viewHolder = null;
		int rowType = getItemViewType(position);
		if (convertView == null) {
			switch (rowType) {
			case TYPE_ITEM:
				viewHolder = ViewHolderFactory.newInstance().getViewHolder(mContext, mCls);
				break;
			case TYPE_SEPARATOR:
				viewHolder = ViewHolderFactory.newInstance().getViewHolder(mContext, mSectionCls);
				break;
			}

			convertView = viewHolder.initialViewHolder(mContext,  this, position);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (AbstractViewHolder) convertView.getTag();
		}

		viewHolder.filloutViewHolderContent(mContext,  getItem(position), getData(), position);

		return convertView;
	}

}
