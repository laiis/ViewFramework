package idv.laiis.viewframework.interfaces;

import android.support.v4.app.FragmentActivity;

public interface IServiceMediator {

	public abstract void register(FragmentActivity activity);

	public abstract void unregister(FragmentActivity activity);
}
