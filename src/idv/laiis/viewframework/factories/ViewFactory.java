package idv.laiis.viewframework.factories;

import idv.laiis.viewframework.utils.Utils;
import idv.laiis.viewframework.views.IViewImplementor;
import android.util.SparseArray;

public final class ViewFactory {

//	private static Map<String, Class<?>> sViewImplMap = Collections.synchronizedMap(new HashMap<String, Class<?>>());

	private static ViewFactory sViewFactory;

	public final static ViewFactory getInstance() {
		if (sViewFactory == null) {
			synchronized (ViewFactory.class) {
				if (sViewFactory == null) {
					sViewFactory = new ViewFactory();
				}
			}
		}

		return sViewFactory;
	}

	private ViewFactory() {
		// do nothing
	}

	public final IViewImplementor getViewImplementor(SparseArray<Class<?>> map, int clsType) {
		IViewImplementor viewImpl = null;

		try {
			viewImpl = (IViewImplementor) map.get(clsType).newInstance();
		} catch (Exception e) {
			Utils.logErrorMsg(ViewFactory.class, e);
		}
		
		Utils.logDebugMsg(ViewFactory.class, "we get view number:" + viewImpl);

		return viewImpl;
	}

	public final IViewImplementor getViewImplementor(Class<?> cls) {
		IViewImplementor viewImpl = null;

		Utils.logDebugMsg(ViewFactory.class, "we get view name:" + cls.getName());

		try {
			viewImpl = (IViewImplementor) cls.newInstance();
		} catch (Exception e) {
			Utils.logErrorMsg(ViewFactory.class, e);
		}

		return viewImpl;
	}
}
