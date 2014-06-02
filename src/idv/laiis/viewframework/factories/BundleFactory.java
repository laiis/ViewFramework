package idv.laiis.viewframework.factories;

import idv.laiis.viewframework.configs.LocalConfig;
import idv.laiis.viewframework.utils.DataUtils;

import java.util.ArrayList;
import java.util.Map;

import android.os.Bundle;
import android.os.Parcelable;

public final class BundleFactory {

	private BundleFactory() {

	}

	public final static Bundle getSubBundle(String[] idxStrArr, Object[] valueArr) throws Exception {
		if (idxStrArr.length != valueArr.length) {
			throw new Exception("參數數量不正確！");
		}

		Bundle bundle = new Bundle();
		for (int i = 0; i < idxStrArr.length; i++) {
			if (valueArr[i] instanceof Integer) {
				bundle.putInt(idxStrArr[i],DataUtils.getIntArgValue(valueArr[i]));
			}

			else if (valueArr[i] instanceof Long) {
				bundle.putLong(idxStrArr[i],DataUtils.getLongArgValue(valueArr[i]));
			}

			else if (valueArr[i] instanceof Float) {
				bundle.putFloat(idxStrArr[i],DataUtils.getFloatArgValue(valueArr[i]));
			} 
			
			else if (valueArr[i] instanceof Double) {
				bundle.putDouble(idxStrArr[i],DataUtils.getDoubleArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof Character) {
				bundle.putChar(idxStrArr[i],DataUtils.getCharArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof String) {
				bundle.putString(idxStrArr[i],DataUtils.getStringArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof CharSequence) {
				bundle.putCharSequence(idxStrArr[i],DataUtils.getCharSequenceArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof Short) {
				bundle.putShort(idxStrArr[i],DataUtils.getShortArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof Byte) {
				bundle.putByte(idxStrArr[i],DataUtils.getByteArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof Boolean) {
				bundle.putBoolean(idxStrArr[i],DataUtils.getBooleanArgValue(valueArr[i]));
			}
			
			else if (valueArr[i] instanceof Parcelable) {
				bundle.putParcelable(idxStrArr[i],DataUtils.getParcelableArgValue(valueArr[i]));
			}
			
			else if( valueArr[i] instanceof ArrayList){
				bundle.putParcelableArrayList(idxStrArr[i],  DataUtils.getParcelableArrayList(valueArr[i]));
			}
		}

		return bundle;
	}

	public final static Bundle getSubBundle(Map<String, Object> argsMap) {
		Bundle bundle = new Bundle();
		for (String idxStr : argsMap.keySet()) {
			setValue(bundle, idxStr, argsMap.get(idxStr));
		}

		return bundle;
	}
	
	public final static Bundle getMainBundleDefault(int viewType, Bundle subBundle) {
		Bundle args = new Bundle();
		args.putInt(LocalConfig.MAIN_VIEW, viewType);
		args.putBundle(LocalConfig.MAIN_ARGS, subBundle);

		return args;
	}

	private final static void setValue(Bundle bundle, String idxStr, Object value) {
		if (value instanceof Integer) {
			bundle.putInt(idxStr, DataUtils.getIntArgValue(value));
		}
		
		else if (value instanceof Long) {
			bundle.putInt(idxStr, DataUtils.getIntArgValue(value));
		}
		
		else if (value instanceof Float) {
			bundle.putFloat(idxStr, DataUtils.getFloatArgValue(value));
		}
		
		else if (value instanceof Double) {
			bundle.putDouble(idxStr, DataUtils.getDoubleArgValue(value));
		}
		
		else if (value instanceof Character) {
			bundle.putChar(idxStr, DataUtils.getCharArgValue(value));
		}
		
		else if (value instanceof String) {
			bundle.putString(idxStr, DataUtils.getStringArgValue(value));
		}
		
		else if (value instanceof CharSequence) {
			bundle.putCharSequence(idxStr, DataUtils.getCharSequenceArgValue(value));
		}
		
		else if (value instanceof Short) {
			bundle.putShort(idxStr, DataUtils.getShortArgValue(value));
		}
		
		else if (value instanceof Byte) {
			bundle.putByte(idxStr, DataUtils.getByteArgValue(value));
		}
		
		else if (value instanceof Boolean) {
			bundle.putBoolean(idxStr, DataUtils.getBooleanArgValue(value));
		}
		
		else if( value instanceof ArrayList){
			bundle.putParcelableArrayList(idxStr,  DataUtils.getParcelableArrayList(value));
		}
		
		else if (value instanceof Parcelable) {
			bundle.putParcelable(idxStr, DataUtils.getParcelableArgValue(value));
		}
		
	}

}
