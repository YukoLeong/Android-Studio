package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kanon on 1/8/2016.
 */
public class FileReadWrite extends AppCompatActivity {
    EditText fname, fcontent, fnameread;
    TextView filecon;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filereadwrite);

        fname = (EditText) findViewById(R.id.fname);
        fcontent = (EditText) findViewById(R.id.ftext);
        fnameread = (EditText) findViewById(R.id.fnameread);
        filecon = (TextView) findViewById(R.id.filecon);
        btn1 = (Button) findViewById(R.id.btnRead);
        btn2 = (Button) findViewById(R.id.btnwrite);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filename = fname.getText().toString();
                String filecontent = fcontent.getText().toString();
                FileOperations fop = new FileOperations();
                fop.write(filename, filecontent);
                if (fop.write(filename, filecontent)) {
                    Toast.makeText(getApplicationContext(), filename + ".txt created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String readfilename = fnameread.getText().toString();
                FileOperations fop = new FileOperations();
                String text = fop.read(readfilename);
                if (text != null) {
                    filecon.setText(text);
                } else {
                    Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
                    filecon.setText(null);
                }
            }
        });
    }

//    public void btnWrite_Click(View view) {
//        String filename = fname.getText().toString();
//        String filecontent = fcontent.getText().toString();
//        FileOperations fop = new FileOperations();
//        fop.write(filename, filecontent);
//        if (fop.write(filename, filecontent)) {
//            Toast.makeText(getApplicationContext(), filename + ".txt created", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "I/O error", Toast.LENGTH_SHORT).show();
//        }
//    }

//    public void btnRead_Click(View view) {
//        String readfilename = fnameread.getText().toString();
//        FileOperations fop = new FileOperations();
//        String text = fop.read(readfilename);
//        if (text != null) {
//            filecon.setText(text);
//        } else {
//            Toast.makeText(getApplicationContext(), "File not Found", Toast.LENGTH_SHORT).show();
//            filecon.setText(null);
//        }
//    }
}
