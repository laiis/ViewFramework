package idv.laiis.viewframework.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * 抽像類<br/>
 * 實作請看各Layout畫面
 * 
 * @author laiis
 * 
 */
@SuppressWarnings({ "serial" })
public abstract class AbstractViewImplementorAdapter implements IViewImplementor {

	protected FragmentActivity mActivity;
	protected Fragment mFragment;
	protected IViewImplementor mParentViewImpl;

	@Override
	public void fillOutViewContent(Bundle data) {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onStart() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onResume() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onPause() {
		// To override and implement this method if you need it
	}

	@Override
	public void onStop() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onDestroyView() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void handleRequestResult(int requestType, Bundle resultData) {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
		return false;
	}

	@Override
	public void setActionBar() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public boolean onBackPressed() {
		return true;
	}

	@Override
	public void refreshFragment() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();
	}

	@Override
	public void onDestroy() {
		// To override and implement this method if you need it,
		// but do not super.thisMethod();		
	}

	@Override
	public void setParentViewImpl(IViewImplementor parentViewImpl) {
		this.mParentViewImpl=parentViewImpl;
	}

	@Override
	public IViewImplementor getParentViewImpl() {
		return mParentViewImpl;
	}
}
