package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonViewPagerAdapter;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public final class ViewFrameworkCommonViewPagerAdapter<T> extends AbstractCommonViewPagerAdapter<T> {

	public ViewFrameworkCommonViewPagerAdapter(Context context, FragmentManager fm) {
		super(context, fm);
	}
	
	@Override
	public int getItemPosition(Object object) {
		return POSITION_NONE;
	}

	@Override
	public final Fragment getItem(int index) {
		if(getFragments().size()>0){
			return getFragments().get(index);	
		}
		
		return null;
	}

}
