package idv.laiis.viewframework.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class AbstractGroupViewHolder extends AbstractViewHolder {

	public abstract View initialGroupViewHolder(Context context, BaseAdapter parent, Object childeObj, Object parentObj, String itemData, int position);

}
	