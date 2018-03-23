package com.example.android.signlanguageinterpreter;

import android.util.Log;

import java.util.Arrays;

import static android.content.ContentValues.TAG;

/**
 * Created by hpavilion-au171TX on 3/22/2018.
 */

public class Interpreter {


    private int count;
    private int[] dataArray;
    private String rawData;
    public int[] counter;
    private String [] prevDataraw;
    public int [] prevData;

        public Interpreter() {
        counter = new int[4];
        count=1;
        prevDataraw = new String[2];
        prevDataraw[0] = "0000";
    }


    public String getString(String rawData) {
        int[] data={0,0,0,0};
            try{
            data = getArray(rawData);}catch(Exception e){
                Log.d(TAG, "getString: Could not convert String to array");
            }

        if(count>1){
            count=0;
        }

        prevDataraw[count] = rawData;
        count++;
        checkData(data);
        String s = getStringfromDB(counter);
        return s;
        }



    private void checkData(int[] data) {
        prevData= getArray(prevDataraw[0]);
        Log.d(TAG, "checkData: current"+ Arrays.toString(data));
        int pdata;
        int cdata;
        for (int c=0;c<4;c++) {
            pdata= prevData[c];
            cdata= data[c];
            if(pdata != cdata){
                counter[c]=counter[c]+1;
            }

            }

        }





    private String getStringfromDB(int[] counter) {
        int num = convertArrtoNum(counter);
        String output = "";
        switch(num){

            case 1000:
                output = "Hi";

                break;

            case 2000:
                output = "Bye";

                break;

            default: output = null;
        }

        return output;
    }


    private void reset() {
            counter = new int[4];
    }


    private int convertArrtoNum(int[] counter) {

        int[] arr=counter;
        int out=0;
        int i = arr.length-1;
        for(int c=1;c<10000;c*=10){
            out = out+arr[i]*c;
            i--;
        }
        return out;
        }

    private int[] getArray(String rawData) throws IndexOutOfBoundsException{
        int[] arr= new int[rawData.length()];
        for (int c=0;c<arr.length;c++){
            arr[c]=Integer.parseInt(String.valueOf(rawData.charAt(c)));
        }
        return arr;
    }


}
