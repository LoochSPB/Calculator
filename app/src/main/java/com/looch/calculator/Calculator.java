package com.looch.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable {

    private String monitortxt = "";
    private String argOne;
    private String argTwo;
    private String result;

    public Calculator() {
    }

    public Calculator(String monitortxt) {
        this.monitortxt = monitortxt;
    }

    protected Calculator(Parcel in) {
        monitortxt = in.readString();
    }

    public static final Creator<Calculator> CREATOR = new Creator<Calculator>() {
        @Override
        public Calculator createFromParcel(Parcel in) {
            return new Calculator(in);
        }

        @Override
        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    public void setMonitortxt(String monitortxt) {
        this.monitortxt = monitortxt;
    }

    public String getMonitortxt() {
        return monitortxt;
    }

    public void buttonPressed(int id) {
        switch (id) {

            case R.id.key_1:
                monitortxt += "1";
                break;
            case R.id.key_2:
                monitortxt += "2";
                break;
            case R.id.key_3:
                monitortxt += "3";
                break;
            case R.id.key_4:
                monitortxt += "4";
                break;
            case R.id.key_5:
                monitortxt += "5";
                break;
            case R.id.key_6:
                monitortxt += "6";
                break;
            case R.id.key_7:
                monitortxt += "7";
                break;
            case R.id.key_8:
                monitortxt += "8";
                break;
            case R.id.key_9:
                monitortxt += "9";
                break;
            case R.id.key_clear:
                setMonitortxt("");
                break;
            case R.id.key_addition:
                addition(monitortxt);

        }
    }

    private void addition(String arg) {
        if (argOne == null) {
            argOne = arg;
            monitortxt = "";
        } else {
            argTwo = arg;
            result = Integer.toString(Integer.getInteger(argOne) + Integer.getInteger(argTwo));
            monitortxt = result;
            argTwo=null;
            argOne=null;
        }


    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(monitortxt);
    }
}
