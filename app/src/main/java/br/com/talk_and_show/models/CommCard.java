package br.com.talk_and_show.models;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import br.com.talk_and_show.activities.CardView;
import br.com.talk_and_show.activities.MainActivity;
import br.com.talk_and_show.databinding.ActivityMainBinding;

public class CommCard implements Parcelable {
    // Atributos

    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    private String name;

    ActivityMainBinding binding;

    private CommCardCategories category;
    private int image;

    public static final Creator<CommCard> CREATOR = new Creator<CommCard>() {
        @Override
        public CommCard createFromParcel(Parcel in) {
            return new CommCard(in);
        }

        @Override
        public CommCard[] newArray(int size) {
            return new CommCard[size];
        }
    };

    // Métodos de acesso
    public CommCard(String name, CommCardCategories category, int image) {
        this.setName(name);
        this.setCategory(category);
        this.setImage(image);
    }

    protected CommCard(Parcel in) {
        this.setName(in.readString());
        this.setCategory(CommCardCategories.valueOf(in.readString()));
        this.setImage(in.readInt());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommCardCategories getCategory() {
        return category;
    }

    public void setCategory(CommCardCategories category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    // Parcelables methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(category.toString());
        dest.writeInt(image);
    }

}
