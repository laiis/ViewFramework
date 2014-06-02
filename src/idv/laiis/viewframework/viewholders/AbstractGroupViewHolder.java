package idv.laiis.viewframework.viewholders;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class AbstractGroupViewHolder extends AbstractViewHolder {

	public abstract View initialGroupViewHolder(Context context,Fragment fragment, BaseAdapter parent, Object childeObj, Object parentObj, String itemData, int position);

}
