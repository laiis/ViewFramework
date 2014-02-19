package idv.laiis.viewframework.viewholders;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.BaseAdapter;

public abstract class AbstractGroupViewHolder extends AbstractViewHolder{
	
	public abstract View initialGroupViewHolder(Fragment fragment,BaseAdapter parent,Object childeObj,Object parentObj,String itemData);
	
}
