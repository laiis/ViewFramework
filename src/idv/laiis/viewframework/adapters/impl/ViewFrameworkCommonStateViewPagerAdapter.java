package idv.laiis.viewframework.adapters.impl;

import idv.laiis.viewframework.adapters.AbstractCommonStateViewPagerAdapter;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public final class ViewFrameworkCommonStateViewPagerAdapter<T> extends AbstractCommonStateViewPagerAdapter<T> {

	public ViewFrameworkCommonStateViewPagerAdapter(Context context, FragmentManager fm) {
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
