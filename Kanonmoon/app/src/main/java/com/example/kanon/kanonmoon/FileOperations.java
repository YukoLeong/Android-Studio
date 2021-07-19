package com.example.kanon.kanonmoon;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by kanon on 1/7/2016.
 */
public class FileOperations {
    public FileOperations() {

    }

    public Boolean write(String fname, String fcontent) {
        try {
            String fpath = Environment.getExternalStorageDirectory().getPath() + File.separator + "txt";
            File myfile = new File(fpath);
            if (!myfile.exists()) {
                myfile.createNewFile();
            }
            FileWriter fw = new FileWriter(myfile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fcontent);
            bw.close();
            Log.d("Success", "Success");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String read(String fname) {
        BufferedReader br = null;
        String response = null;
        try {
            StringBuffer output = new StringBuffer();
            String fpath = Environment.getExternalStorageDirectory().getPath() + File.separator + fname + ".txt";
            br = new BufferedReader(new FileReader(fpath));
            String line = "";
            while ((line = br.readLine()) != null) {
                output.append(line + "\n");
            }
            response = output.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return response;
    }
}














