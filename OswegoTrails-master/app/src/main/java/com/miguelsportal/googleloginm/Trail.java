package com.miguelsportal.googleloginm;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by James on 11/12/2016.
 */

public class Trail implements Parcelable
{//class that creates trail objects to be referenced later.
    private long trailID;
    private String id;
    private String name;
    private String description;
    private String image;
    private int bike;
    private int rating;

    public Trail (Parcel parcel)
    {
        trailID = parcel.readLong();
        name = parcel.readString();
        description = parcel.readString();
        image = parcel.readString();
        bike = parcel.readInt();
        rating = parcel.readInt();
    }


    public Trail ()
    {//No argument constructor

    }

    //getter methods
    public double getTrailID() { return trailID; }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public String getImage() { return image; }

    public int getBike() { return bike; }

    public String getId() {return id; }

    public int getRating() {return rating;}

    //setter methods
    public void setTrailID(long id) { this.trailID = id; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setImage(String image) { this.image = image; }

    public void setBike(int bike) { this.bike = bike; }

    public void setRating(int rating) {this.rating = rating;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeLong(trailID);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(image);
        parcel.writeInt(bike);
        parcel.writeInt(rating);
    }

    public static  final Parcelable.Creator<Trail> CREATOR = new Parcelable.Creator<Trail>()
    {
        @Override
        public Trail createFromParcel(Parcel source)
        {
            return new Trail(source);
        }

        @Override
        public Trail[] newArray(int size)
        {
            return new Trail[size];
        }
    };
}
