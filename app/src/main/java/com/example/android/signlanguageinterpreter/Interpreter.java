package com.example.android.signlanguageinterpreter;

/**
 * Created by hpavilion-au171TX on 3/22/2018.
 */

public class Interpreter {



    private int[] dataArray;
    private String rawData;
    private int[] counter;


        public Interpreter( String rawData) {
        this.rawData=rawData;
        dataArray= new int[4];
        counter = new int[4];

    }

    public String getString() {
        String[] data = rawData.split(",");

        checkData(data);
        return null;
        }

    private void checkData(String[] data) {



    }


}
