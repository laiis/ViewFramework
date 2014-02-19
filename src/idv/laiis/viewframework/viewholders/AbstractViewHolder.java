package idv.laiis.viewframework.viewholders;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * 抽像類 實作類請依Layout各自實作
 * 
 * @author laiis
 * 
 */
public abstract class AbstractViewHolder {

	public abstract View initialViewHolder(Fragment fragment,BaseAdapter parent);

	public abstract void filloutViewHolderContent(Fragment fragment, Object item, Object data,final int index);
}
