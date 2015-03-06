package idv.laiis.viewframework.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * 抽像類 實作類請依Layout各自實作
 * 
 * @author laiis
 * 
 */
public abstract class AbstractViewHolder {

	public abstract View initialViewHolder(Context context, BaseAdapter parent, int index);

	public abstract void filloutViewHolderContent(Context context,  Object item, Object data, int index);
}
