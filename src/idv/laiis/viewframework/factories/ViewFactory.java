package idv.laiis.viewframework.factories;

import idv.laiis.viewframework.utils.Utils;
import idv.laiis.viewframework.views.IViewImplementor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ViewFactory {

	private static Map<String, Class<?>> sViewImplMap = Collections.synchronizedMap(new HashMap<String, Class<?>>());

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

	public final IViewImplementor getViewImplementor(Map<String, Class<?>> map, String clsName) {
		IViewImplementor viewImpl = null;

		Utils.logDebugMsg(ViewFactory.class, "we get view:" + clsName);

		try {
			viewImpl = (IViewImplementor) map.get(clsName).newInstance();
		} catch (Exception e) {
			Utils.logErrorMsg(ViewFactory.class, e);
			e.printStackTrace();
		}

		return viewImpl;
	}

	public final IViewImplementor getViewImplementor(Class<?> cls) {
		IViewImplementor viewImpl = null;

		Utils.logDebugMsg(ViewFactory.class, "we get view:" + cls.getName());

		try {
			viewImpl = (IViewImplementor) cls.newInstance();
		} catch (Exception e) {
			Utils.logErrorMsg(ViewFactory.class, e);
			e.printStackTrace();
		}

		return viewImpl;
	}
}
