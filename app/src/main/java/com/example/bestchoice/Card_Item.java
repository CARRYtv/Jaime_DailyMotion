package com.example.bestchoice;

import android.widget.Button;

public class Card_Item {
    private int mImageResource;
    private Button btnColore;
    private Button btnImmagine;

    public Card_Item(int img) {
        mImageResource = img;

    }

    public int getmImageResource(){
        return mImageResource;
    }

    public Button getBtnColore(){
        return btnColore;
    }

    public Button getBtnImmagine(){
        return btnImmagine;
    }
}
