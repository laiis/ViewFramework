package idv.laiis.viewframework.viewholders;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseExpandableListAdapter;

public abstract class AbstractExpandableViewHolder {
	
	public abstract View initialViewHolder(Fragment fragment, BaseExpandableListAdapter parent);

	public abstract void filloutViewHolderContent(Fragment fragment, Object item, Object data,final boolean isExpanded,final int index,final int parentIndex);
}
