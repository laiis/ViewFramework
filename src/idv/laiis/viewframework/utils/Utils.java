package idv.laiis.viewframework.utils;

import idv.laiis.viewframework.configs.ViewFrameworkLocalConfig;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public final class Utils {
	
	private Utils() {

	}

	public final static void showToastMsg(Context context, CharSequence msg, int duration) {
		Toast toast = Toast.makeText(context, msg, duration);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
	
	public final static void showCustomToastMsg(Context context,View view,final int resourceId,String str){
		((TextView)view.findViewById(resourceId)).setText(str);
		Toast toast=new Toast(context);
		toast.setView(view);
		toast.show();
	}

	public final static void showShortToastMsg(Context context, CharSequence msg) {
		showToastMsg(context, msg, Toast.LENGTH_SHORT);
	}

	public final static void showLongToastMsg(Context context, CharSequence msg) {
		showToastMsg(context, msg, Toast.LENGTH_LONG);
	}

	public final static void logDebugMsg(Class<?> cls, CharSequence debugMsg, boolean isDebug) {
		if (isDebug)
			Log.d(cls.getName(), " ---> ViewFramework debug message:" + debugMsg);
	}

	public final static void logDebugMsg(Class<?> cls, CharSequence debugMsg) {
		logDebugMsg(cls, debugMsg, ViewFrameworkLocalConfig.IS_DEBUG);
	}

	public final static void logErrorMsg(Class<?> cls, Exception e, boolean isLogError) {
		if (isLogError) {
			Log.e(cls.getName(), " ---> ViewFramework exception name:" + e.getClass().getName() + " , exception message:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public final static void logErrorMsg(Class<?> cls, Exception e) {
		logErrorMsg(cls, e, ViewFrameworkLocalConfig.IS_ERROR);
	}

}
