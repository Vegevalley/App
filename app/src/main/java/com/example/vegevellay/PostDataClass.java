package com.example.vegevellay;

import com.google.gson.annotations.SerializedName;

public class PostDataClass {

    @SerializedName("VEGE_CONTENT_ID")
    public long VEGE_CONTENT_ID;

    @SerializedName("AUTHOR_ID")
    public long AUTHOR_ID;

    @SerializedName("TITLE")
    public String TITLE ;

    @SerializedName("MAIN_TEXT")
    public String MAIN_TEXT;

    @SerializedName("DATE_CREATED")
    public String DATE_CREATED;

    @SerializedName("LAST_UPDATED")
    public String LAST_UPDATED;

    @SerializedName("VEGE")
    public String VEGE;

    @SerializedName("SELL_CHECK")
    public boolean SELL_CHECK;

    @SerializedName("LOCAL_ID")
    public long LOCAL_ID;

    @SerializedName("DATE_BUY")
    public String DATE_BUY;

    public String toString() {
        return "PostResult{" +
                "VEGE_CONTENT_ID=" + VEGE_CONTENT_ID +
                ", AUTHOR_ID=" + AUTHOR_ID +
                ", TITLE='" + TITLE + '\'' +
                ", MAIN_TEXT='" + MAIN_TEXT + '\'' +
                ", DATE_CREATED='" + DATE_CREATED + '\'' +
                ", LAST_UPDATED='" + LAST_UPDATED + '\'' +
                ", VEGE='" + VEGE + '\'' +
                ", SELL_CHECK='" + SELL_CHECK +
                ", LOCAL_ID='" + LOCAL_ID +
                ", DATE_BUY='" + DATE_BUY + '\'' +
                '}';
    }
}
