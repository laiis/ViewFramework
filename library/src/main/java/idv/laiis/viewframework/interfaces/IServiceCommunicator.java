package idv.laiis.viewframework.interfaces;

import android.location.Location;

public interface IServiceCommunicator {

	public abstract void registerServiceObserver(IServiceObserver serviceObserver);

	public abstract void unregisterServiceObserver(IServiceObserver serviceObserver);

	public abstract void notifyServiceObersver(Location location);
	
	public abstract boolean bindServiceByServiceCommunicator();

	public abstract boolean unbindServiceByServiceCommunicator();
}
