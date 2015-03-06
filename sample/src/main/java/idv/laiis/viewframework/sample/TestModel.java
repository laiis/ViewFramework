package idv.laiis.viewframework.sample;

import android.os.Parcel;


/**
 * Created by laiis on 2015/3/6.
 */
public class TestModel extends AbstractBaseModel {

    public String title;
    public String desc;

    public TestModel() {

    }

    public TestModel(Parcel source) {
        super(source);

        title = source.readString();
        desc = source.readString();
    }

    @Override
    public int describeContents() {
        return super.describeContents();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);

        dest.writeString(title);
        dest.writeString(desc);
    }

    public static final Creator<AbstractBaseModel> CREATOR = new Creator<AbstractBaseModel>() {
        @Override
        public AbstractBaseModel createFromParcel(Parcel source) {
            return new TestModel(source);
        }

        @Override
        public AbstractBaseModel[] newArray(int size) {
            return new AbstractBaseModel[size];
        }
    };
}
