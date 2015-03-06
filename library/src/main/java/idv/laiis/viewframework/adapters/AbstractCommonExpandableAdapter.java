package idv.laiis.viewframework.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.BaseExpandableListAdapter;

@SuppressLint("UseSparseArrays")
public abstract class AbstractCommonExpandableAdapter<T> extends BaseExpandableListAdapter {

	protected Context mContext;
	protected Fragment mFragment;
	protected Class<?> mParentCls;
	protected Class<?> mChildCls;
	private Object mParentData;
	private Object mChildData;
	private Comparator<T> mParentComparator;
	private Comparator<T> mChildComparator;
	private List<T> mParentList = Collections.synchronizedList(new ArrayList<T>());
	private Map<Integer, List<T>> mParentMap = Collections.synchronizedMap(new HashMap<Integer, List<T>>());

	public AbstractCommonExpandableAdapter(Context context, Fragment fragment, Class<?> parentCls, Class<?> childCls) {
		this.mContext = context;
		this.mFragment = fragment;
		this.mParentCls = parentCls;
		this.mChildCls = childCls;
	}

	@Override
	public int getGroupCount() {
		return mParentList.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if (mParentMap.get(groupPosition) != null) {
			return mParentMap.get(groupPosition).size();
		}

		return 0;
	}

	@Override
	public T getGroup(int groupPosition) {
		return mParentList.get(groupPosition);
	}

	@Override
	public T getChild(int groupPosition, int childPosition) {
		if (mParentMap.get(groupPosition) != null) {
			return mParentMap.get(groupPosition).get(childPosition);
		}
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	public void setParentData(Object parentData) {
		this.mParentData = parentData;
	}

	public Object getParentData() {
		return mParentData;
	}

	public void setChildData(Object childData) {
		this.mChildData = childData;
	}

	public Object getChildData() {
		return mChildData;
	}

	public void addParentItems(List<T> parentList) {
		if (parentList != null && parentList.size() > 0) {
			if (mParentComparator != null)
				Collections.sort(parentList, mParentComparator);
			mParentList.addAll(parentList);
		}
	}

	public void removeAllParentItems() {
		mParentList.clear();
	}

	public void removeAllChildItems() {
		mParentMap.clear();
	}

	public void addChildItems(int parentIndex, List<T> childList) {
		if (childList != null && childList.size() > 0) {
			if (mChildComparator != null)
				Collections.sort(childList, mChildComparator);
			mParentMap.put(parentIndex, childList);
		}
	}

	public Comparator<T> getmParentComparator() {
		return mParentComparator;
	}

	public void setmParentComparator(Comparator<T> mParentComparator) {
		this.mParentComparator = mParentComparator;
	}

	public Comparator<T> getmChildComparator() {
		return mChildComparator;
	}

	public void setmChildComparator(Comparator<T> mChildComparator) {
		this.mChildComparator = mChildComparator;
	}

	public List<T> getGroups() {
		return mParentList;
	}

	public List<T> getChilds(int i) {
		return mParentMap.get(i);
	}
}
