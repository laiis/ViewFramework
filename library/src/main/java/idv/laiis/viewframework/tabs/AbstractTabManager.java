package idv.laiis.viewframework.tabs;

import java.util.Map;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TabHost;

public abstract class AbstractTabManager implements TabHost.OnTabChangeListener {

	/*
	 * =================================================== = Fields
	 * =====================================================
	 */

	private final Fragment mParentFragment;
	private final int mContainerId;
	private Map<String, TabInfo> mTabs;
	private TabHost mTabHost;
	private TabInfo mLastTab;
	private Map<String, Fragment> mFragmentMap;
	private int mCurrentTabIndex;
	private int mTabCount;

	/*
	 * =================================================== = Inner class
	 * =====================================================
	 */

	public static final class TabInfo {
		private final String tag;
		private final Class<?> cls;
		private final Bundle args;
		private Fragment fragment;
		private final int tabIndex;

		public TabInfo(String _tag, Class<?> _cls, Bundle _args, int _tabIndex) {
			tag = _tag;
			cls = _cls;
			args = _args;
			tabIndex = _tabIndex;
		}

		public Fragment getFragment() {
			return fragment;
		}

		public void setFragment(Fragment fragment) {
			this.fragment = fragment;
		}

		public String getTag() {
			return tag;
		}

		public Class<?> getCls() {
			return cls;
		}

		public Bundle getArgs() {
			return args;
		}

		public int getTabIndex() {
			return tabIndex;
		}
	}

	public static class DummyTabFactory implements TabHost.TabContentFactory {

		private final Context _context;

		public DummyTabFactory(Context ctx) {
			_context = ctx;
		}

		@Override
		public View createTabContent(String tag) {
			View v = new View(_context);
			v.setMinimumHeight(0);
			v.setMinimumWidth(0);
			return v;
		}
	}

	/*
	 * =================================================== = Contructor &
	 * methods =====================================================
	 */

	public AbstractTabManager(Fragment _fragment, TabHost _tabHost, int _containerId) {
		mParentFragment = _fragment;
		mTabHost = _tabHost;
		mContainerId = _containerId;
		mTabHost.setOnTabChangedListener(this);
	}

	@Override
	public void onTabChanged(String tabId) {
		TabInfo _newTab = getmTabs().get(tabId);

		if (getmLastTab() != _newTab) {
			FragmentTransaction ft = getmParentFragment().getChildFragmentManager().beginTransaction();

			if (getmLastTab() != null) {
				if (getmLastTab().getFragment() != null) {
					ft.detach(getmLastTab().getFragment());
				}
			}

			if (_newTab != null) {
				if (_newTab.getFragment() == null) {
					Fragment fragment = Fragment.instantiate(getmParentFragment().getActivity(), _newTab.getCls().getName(), _newTab.getArgs());
					_newTab.setFragment(fragment);
				}

				ft.replace(mContainerId, _newTab.getFragment(), _newTab.tag);
				ft.attach(_newTab.getFragment());
			}

			mCurrentTabIndex = _newTab.getTabIndex();
			setmLastTab(_newTab);
			ft.commitAllowingStateLoss();
			getmParentFragment().getChildFragmentManager().executePendingTransactions();
		}
	}

	public TabInfo getmLastTab() {
		return mLastTab;
	}

	public void setmLastTab(TabInfo mLastTab) {
		this.mLastTab = mLastTab;
	}

	public Fragment getmParentFragment() {
		return mParentFragment;
	}

	public TabHost getmTabHost() {
		return mTabHost;
	}

	public int getmContainerId() {
		return mContainerId;
	}

	public Map<String, TabInfo> getmTabs() {
		return mTabs;
	}

	public Map<String, Fragment> getFragmentMap() {
		return mFragmentMap;
	}

	public void setFragmentMap(Map<String, Fragment> fragmentMap) {
		this.mFragmentMap = fragmentMap;
	}

	public int getCurrentTabIndex() {
		return mCurrentTabIndex;
	}

	public void setCurrentTabIndex(int currentTabIndex) {
		this.mCurrentTabIndex = currentTabIndex;
	}

	public int getmTabCount() {
		return mTabCount;
	}

	public void setmTabCount(int mTabCount) {
		this.mTabCount = mTabCount;
	}

	public void setmTabHost(TabHost mTabHost) {
		this.mTabHost = mTabHost;
		mTabHost.setOnTabChangedListener(this);
	}

	public void setmTabs(Map<String, TabInfo> mTabs) {
		this.mTabs = mTabs;
	}

	public abstract void addTab(TabHost.TabSpec tabSpec, Class<?> cls, Fragment fragment, Bundle args);
}
