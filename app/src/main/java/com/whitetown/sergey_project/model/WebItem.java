package com.whitetown.sergey_project.model;

import android.os.Parcel;
import android.os.Parcelable;

public class WebItem  implements Parcelable
{
    private String title;
    private String url;
    private int iconId;
    public WebItem()
    {}

    public WebItem(String title, String url, int iconId)
    {
        this.title = title;
        this.url = url;
        this.iconId = iconId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /* This method is used to write instance variable to Parcel. */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url);
        dest.writeInt(iconId);
    }

    /* Must create this static class variable to make this class Parcelable. */
    public static final Creator<WebItem> CREATOR = new Creator<WebItem>()
    {
        @Override
        public WebItem createFromParcel(Parcel source) {
            WebItem ret = new WebItem();

            // The read order should be same as write order in writeToParcel method.
            ret.title = source.readString();
            ret.url = source.readString();
            ret.iconId = source.readInt();

            return ret;
        }

        @Override
        public WebItem[] newArray(int size) {
            return new WebItem[size];
        }
    };

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }


    public int getIconId()
    {
        return iconId;
    }

    public void setIconId(int iconId)
    {
        this.iconId = iconId;
    }
}
