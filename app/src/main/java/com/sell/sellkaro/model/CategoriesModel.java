package com.sell.sellkaro.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoriesModel implements Parcelable {
    String id;
    String category;
    String icon;
    String created_at;
    boolean active;
    boolean isselected;

    public CategoriesModel(String id, String category, String icon, String created_at, boolean active, boolean isselected) {
        this.id = id;
        this.category = category;
        this.icon = icon;
        this.created_at = created_at;
        this.active = active;
        this.isselected = isselected;
    }

    public CategoriesModel(Parcel in) {
        this.id = in.readString();
        this.category = in.readString();
        this.icon = in.readString();
        this.created_at = in.readString();
        this.active = Boolean.parseBoolean(in.readString());
    }

    public boolean isIsselected() {
        return isselected;
    }

    public void setIsselected(boolean isselected) {
        this.isselected = isselected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(category);
        parcel.writeString(icon);
        parcel.writeString(created_at);
        parcel.writeString(String.valueOf(active));
    }

    public static final Creator<CategoriesModel> CREATOR = new Creator<CategoriesModel>()
    {
        public CategoriesModel createFromParcel(Parcel in)
        {
            return new CategoriesModel(in);
        }
        public CategoriesModel[] newArray(int size)
        {
            return new CategoriesModel[size];
        }
    };
}
