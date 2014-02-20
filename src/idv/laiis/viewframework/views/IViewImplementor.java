package idv.laiis.viewframework.views;

import java.io.Serializable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public interface IViewImplementor extends Serializable{
	
	public abstract void fillOutViewContent(Bundle data);
	
	public abstract void handleArguments(Bundle bundle);
	
	public abstract View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState);
	
	public abstract void onActivityCreated(Bundle savedInstanceState);
	
	public abstract void onActivityResult(int requestCode, int resultCode, Intent data);
	
	public abstract boolean onBackPressed();
	
	public abstract void onStart();
	
	public abstract void onResume();
	
	public abstract void onPause();
	
	public abstract void onStop();
	
	public abstract void onDestroyView();
	
	public abstract void onDestroy();
	
	public abstract void setActionBar();
	
	public abstract void handleRequestResult(int requestType,Bundle resultData);
	
	public abstract boolean onOptionsItemSelected(MenuItem item);
	
	public abstract boolean onCreateOptionsMenu(Menu menu, MenuInflater inflater);
	
	public abstract void onInitial(FragmentActivity activity,Fragment fragment);
	
	public abstract void refreshFragment();
	
	public abstract void setParentViewImpl(IViewImplementor parentViewImpl);
	
	public abstract IViewImplementor getParentViewImpl();
	
}
