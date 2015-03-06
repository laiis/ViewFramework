package idv.laiis.viewframework.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.BaseExpandableListAdapter;

public abstract class AbstractExpandableViewHolder {

	public abstract View initialViewHolder(Context context, BaseExpandableListAdapter parent, int position, int parentIndex);

	public abstract void filloutViewHolderContent(Context context,  Object item, Object data, final boolean isExpanded, final int index, final int parentIndex);
}
