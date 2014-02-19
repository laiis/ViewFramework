package idv.laiis.viewframework.interfaces;

import android.location.Location;

public interface IServiceObserver {
	
	public abstract void registerService(IServiceCommunicator serviceCommunicator);
	
	public abstract void unregisterService(IServiceCommunicator serviceCommunicator);

	public abstract void updateNotify(Location location);
	
	public abstract boolean bindServiceByServiceCommunicator();

	public abstract boolean unbindServiceByServiceCommunicator();
}
