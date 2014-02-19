package idv.laiis.viewframework.tabs.impl;

import idv.laiis.viewframework.tabs.AbstractTabManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public final class ViewFrameworkCommonTabManager extends AbstractTabManager{
	
	private Context mContext;
	
	public ViewFrameworkCommonTabManager(Context context,Fragment _fragment,TabHost _tabHost,int _containerId){
		super(_fragment, _tabHost, _containerId);
		this.mContext=context;
	}
	
	@Override
	public final void addTab(TabSpec tabSpec, Class<?> cls,Fragment fragment, Bundle args) {
		tabSpec.setContent(new AbstractTabManager.DummyTabFactory(mContext));
		
		String tag=tabSpec.getTag();
		TabInfo tabInfo=new TabInfo(tag, cls, args,getmTabHost().getTabWidget().getTabCount());
		tabInfo.setFragment(fragment);
		
		getmTabs().put(tag, tabInfo);
		getmTabHost().addTab(tabSpec);
		
	}
}
