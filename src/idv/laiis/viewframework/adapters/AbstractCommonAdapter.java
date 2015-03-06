package idv.laiis.viewframework.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.widget.BaseAdapter;

/**
 * 抽像類 <br/>
 * 
 * @author laiis
 *
 * @param <T>
 */
public abstract class AbstractCommonAdapter<T> extends BaseAdapter {

	protected Context mContext;
	protected Class<?> mCls;
	private List<T> mList = Collections.synchronizedList(new ArrayList<T>());
	private Comparator<T> mComparator;
	private Object mData;

	public AbstractCommonAdapter(Context context, Class<?> cls) {
		this.mContext = context;
		this.mCls = cls;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public T getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public void addItems(List<T> tList) {
		if (tList != null && tList.size() > 0) {
			mList.addAll(tList);

			if (mComparator != null) {
				Collections.sort(mList, mComparator);
			}
			notifyDataSetChanged();
		}
	}

	public void addItem(T t) {
		if (t != null) {
			mList.add(t);
			notifyDataSetChanged();
		}
	}

	public List<T> getItems() {
		return mList;
	}

	public void removeAllItems() {
		mList.clear();
		notifyDataSetChanged();
	}

	public void setComparator(Comparator<T> comparator) {
		this.mComparator = comparator;
	}

	public void setData(Object data) {
		this.mData = data;
	}

	public Object getData() {
		return mData;
	}

}
