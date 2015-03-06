package idv.laiis.viewframework.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * 
 * 抽像類<br/>
 * 
 * @author laiis
 * @param <T>
 */
public abstract class AbstractCommonViewPagerAdapter<T> extends FragmentPagerAdapter{
	
	protected Context mContext;
	
	private List<T> mList=Collections.synchronizedList(new ArrayList<T>());
	private List<Fragment> mFragmentList=Collections.synchronizedList(new ArrayList<Fragment>());
	
	private Bundle mData;
	
	public AbstractCommonViewPagerAdapter(Context context,FragmentManager fm) {
		super(fm);
		this.mContext=context;
	}
	
	@Override
	public final int getCount() {
		return mFragmentList.size();
	}
	
	public final T getListItem(int index){
		if(mList.size()>index){
			return mList.get(index);	
		}
			
		return null;
	}
	
	public final List<T> getItems(){
		return mList;
	}
	
	public final void addItems(List<T> tList){
		if(tList!=null && tList.size()>0){
			mList.addAll(tList);
		}
	}
	
	public final void removeItems(){
		mList.clear();
	}
	
	public final void addItem(T t){
		mList.add(t);
	}
	
	public final void setData(Bundle data){
		this.mData=data;
	}
	
	public final Bundle getData(){
		return mData;
	}

	public final Context getmContext() {
		return mContext;
	}

	public final void setmContext(Context mContext) {
		this.mContext = mContext;
	}
	
	public final void removeFragments(){
		mFragmentList.clear();
	}
	
	public final void addFragment(Fragment fragment){
		if(fragment!=null){
			mFragmentList.add(fragment);
		}
	}
	
	public final void addFragments(List<Fragment> baseFragmentList){
		if(baseFragmentList!=null){
			mFragmentList.addAll(baseFragmentList);
		}
	}
	
	public final List<Fragment> getFragments(){
		return mFragmentList;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return super.isViewFromObject(view, object);
	}
	
}
