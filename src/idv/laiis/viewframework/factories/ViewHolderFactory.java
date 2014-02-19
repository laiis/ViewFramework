package idv.laiis.viewframework.factories;

import idv.laiis.viewframework.utils.Utils;
import idv.laiis.viewframework.viewholders.AbstractExpandableViewHolder;
import idv.laiis.viewframework.viewholders.AbstractViewHolder;
import android.content.Context;

public final class ViewHolderFactory {

	private static ViewHolderFactory sViewHolderFactory;

	public final static ViewHolderFactory newInstance() {
		if (sViewHolderFactory == null) {
			synchronized (ViewHolderFactory.class) {
				if (sViewHolderFactory == null) {
					sViewHolderFactory = new ViewHolderFactory();
				}
			}
		}

		return sViewHolderFactory;
	}

	private ViewHolderFactory() {
		// do nothing
	}

	public final AbstractViewHolder getViewHolder(Context context, Class<?> cls) {
		AbstractViewHolder viewHolder = null;

		try {
			if (viewHolder == null) {
				synchronized (ViewHolderFactory.class) {
					if (viewHolder == null) {
						viewHolder = (AbstractViewHolder) cls.newInstance();
					}
				}
			}

		} catch (Exception e) {
			Utils.logErrorMsg(ViewHolderFactory.class, e);
		}

		return viewHolder;
	}

	public final AbstractExpandableViewHolder getExpandableViewHolder(Context context, Class<?> cls) {
		AbstractExpandableViewHolder viewHolder = null;

		try {
			if (viewHolder == null) {
				synchronized (ViewHolderFactory.class) {
					if (viewHolder == null) {
						viewHolder = (AbstractExpandableViewHolder) cls.newInstance();
					}
				}
			}
		} catch (Exception e) {
			Utils.logErrorMsg(ViewHolderFactory.class, e);
		}

		return viewHolder;
	}
}
