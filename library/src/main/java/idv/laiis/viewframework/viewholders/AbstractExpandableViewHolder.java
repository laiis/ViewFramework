package idv.laiis.viewframework.viewholders;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseExpandableListAdapter;

public abstract class AbstractExpandableViewHolder {

	public abstract View initialViewHolder(Context context, Fragment fragment, BaseExpandableListAdapter parent, int position, int parentIndex);

	public abstract void filloutViewHolderContent(Context context, Fragment fragment, Object item, Object data, final boolean isExpanded, final int index, final int parentIndex);
}
