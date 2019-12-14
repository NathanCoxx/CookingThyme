package com.example.timerapp20;

public class ExampleItem {
    private int mImageResourece;
    private String mText1;
    private String mText2;

    public ExampleItem(int imageResourece, String text1, String text2){
        mImageResourece = imageResourece;
        mText1 = text1;
        mText2 = text2;
    }
    public int getmImageResourece(){
        return mImageResourece;
    }
    public String getmText1(){
        return mText1;
    }
    public String getmText2(){
        return mText2;
    }
}
