package idv.laiis.viewframework.utils;

import java.util.ArrayList;

import android.os.Parcelable;

public final class DataUtils {

	private DataUtils(){
		
	}
	
	public final static int getIntArgValue(Object obj) {
		return ((Integer) obj).intValue();
	}

	public final static float getFloatArgValue(Object obj) {
		return ((Float) obj).floatValue();
	}

	public final static double getDoubleArgValue(Object obj) {
		return ((Double) obj).doubleValue();
	}

	public final static CharSequence getCharSequenceArgValue(Object obj) {
		return ((CharSequence) obj);
	}

	public final static boolean getBooleanArgValue(Object obj) {
		return ((Boolean) obj).booleanValue();
	}

	public final static byte getByteArgValue(Object obj) {
		return ((Byte) obj).byteValue();
	}

	public final static long getLongArgValue(Object obj) {
		return ((Long) obj).longValue();
	}

	public final static short getShortArgValue(Object obj) {
		return ((Short) obj).shortValue();
	}

	public final static String getStringArgValue(Object obj) {
		return ((String) obj).toString();
	}

	public final static Character getCharArgValue(Object obj) {
		return ((Character) obj).charValue();
	}

	public final static Parcelable getParcelableArgValue(Object obj) {
		return ((Parcelable) obj);
	}
	
	@SuppressWarnings("unchecked")
	public final static ArrayList<? extends Parcelable> getParcelableArrayList(Object obj){
		return ((ArrayList<? extends Parcelable>) obj);
	}
}
