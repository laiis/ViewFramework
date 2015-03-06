package idv.laiis.viewframework.sample;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by laiis on 2015/3/6.
 */
public abstract class AbstractBaseModel implements Parcelable {

    public AbstractBaseModel() {

    }

    public AbstractBaseModel(Parcel source) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
