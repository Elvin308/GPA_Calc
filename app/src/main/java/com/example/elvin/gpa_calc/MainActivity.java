package com.example.elvin.gpa_calc;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText classField1, classField2, classField3, classField4, classField5;
    private EditText creditField1, creditField2, creditField3, creditField4, creditField5;
    private EditText gradeField1, gradeField2, gradeField3, gradeField4, gradeField5;
    private Button compute;
    private Button clearAll;
    private boolean typeMode;
    private TextView myTextView;
    private ScrollView myColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myColor=findViewById(R.id.layout_main);

        classField1=findViewById(R.id.class1);
        classField2=findViewById(R.id.class2);
        classField3=findViewById(R.id.class3);
        classField4=findViewById(R.id.class4);
        classField5=findViewById(R.id.class5);
        creditField1=findViewById(R.id.credit1);
        creditField2=findViewById(R.id.credit2);
        creditField3=findViewById(R.id.credit3);
        creditField4=findViewById(R.id.credit4);
        creditField5=findViewById(R.id.credit5);
        gradeField1=findViewById(R.id.grade1);
        gradeField2=findViewById(R.id.grade2);
        gradeField3=findViewById(R.id.grade3);
        gradeField4=findViewById(R.id.grade4);
        gradeField5=findViewById(R.id.grade5);
        compute=findViewById(R.id.btn1);
        clearAll=findViewById(R.id.clear);


        classField1.addTextChangedListener(fieldTextWatcher);
        classField2.addTextChangedListener(fieldTextWatcher);
        classField3.addTextChangedListener(fieldTextWatcher);
        classField4.addTextChangedListener(fieldTextWatcher);
        classField5.addTextChangedListener(fieldTextWatcher);
        creditField1.addTextChangedListener(fieldTextWatcher);
        creditField2.addTextChangedListener(fieldTextWatcher);
        creditField3.addTextChangedListener(fieldTextWatcher);
        creditField4.addTextChangedListener(fieldTextWatcher);
        creditField5.addTextChangedListener(fieldTextWatcher);
        gradeField1.addTextChangedListener(fieldTextWatcher);
        gradeField2.addTextChangedListener(fieldTextWatcher);
        gradeField3.addTextChangedListener(fieldTextWatcher);
        gradeField4.addTextChangedListener(fieldTextWatcher);
        gradeField5.addTextChangedListener(fieldTextWatcher);

        myTextView=(TextView)findViewById(R.id.GPA);

        compute.setOnClickListener(this::setGPA);
        clearAll.setOnClickListener(this::clearAllNow);

    }

    public void setGPA(View view){

        if(Integer.parseInt(gradeField1.getText().toString()) >100 || Integer.parseInt(gradeField2.getText().toString()) >100 ||Integer.parseInt(gradeField3.getText().toString()) >100
                ||Integer.parseInt(gradeField4.getText().toString()) >100 ||Integer.parseInt(gradeField5.getText().toString()) >100)
        {
            myTextView.setText("Your GPA");
            myColor.setBackgroundColor(Color.WHITE);
            Toast.makeText(MainActivity.this,"Grade cannot be higher than 100 for any given class",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(Integer.parseInt(creditField1.getText().toString()) >4 || Integer.parseInt(creditField2.getText().toString()) >4 ||Integer.parseInt(creditField3.getText().toString()) >4
                    ||Integer.parseInt(creditField4.getText().toString()) >4 ||Integer.parseInt(creditField5.getText().toString()) >4)
            {
                myTextView.setText("Your GPA");
                myColor.setBackgroundColor(Color.WHITE);
                Toast.makeText(MainActivity.this,"Credit cannot be higher than 4 for any given class",Toast.LENGTH_SHORT).show();
            }
            else
            {
                double num1= ((Double.parseDouble(gradeField1.getText().toString())/20)-1)*(Double.parseDouble(creditField1.getText().toString()));
                double num2= ((Double.parseDouble(gradeField2.getText().toString())/20)-1)*(Double.parseDouble(creditField2.getText().toString()));
                double num3= ((Double.parseDouble(gradeField3.getText().toString())/20)-1)*(Double.parseDouble(creditField3.getText().toString()));
                double num4= ((Double.parseDouble(gradeField4.getText().toString())/20)-1)*(Double.parseDouble(creditField4.getText().toString()));
                double num5= ((Double.parseDouble(gradeField5.getText().toString())/20)-1)*(Double.parseDouble(creditField5.getText().toString()));

                double credits=(Double.parseDouble(creditField1.getText().toString()))+(Double.parseDouble(creditField2.getText().toString()))+(Double.parseDouble(creditField3.getText().toString()))+
                        (Double.parseDouble(creditField4.getText().toString()))+(Double.parseDouble(creditField5.getText().toString()));
                double answer= (num1+num2+num3+num4+num5)/credits;


                String finalAnswer =String.format("GPA: %.2f", answer);

                myTextView.setText(finalAnswer);

                if (answer>=2.7)
                myColor.setBackgroundColor(Color.GREEN);
                else if (answer >= 1 && answer <2.7)
                    myColor.setBackgroundColor(Color.YELLOW);
                else
                    myColor.setBackgroundColor(Color.RED);
            }

        }
        compute.setEnabled(false);
    }

    public void clearAllNow(View view)
    {

        classField1.setText("");
        classField2.setText("");
        classField3.setText("");
        classField4.setText("");
        classField5.setText("");
        creditField1.setText("");
        creditField2.setText("");
        creditField3.setText("");
        creditField4.setText("");
        creditField5.setText("");
        gradeField1.setText("");
        gradeField2.setText("");
        gradeField3.setText("");
        gradeField4.setText("");
        gradeField5.setText("");

        myTextView.setText("Your GPA");
        myColor.setBackgroundColor(Color.WHITE);
        clearAll.setEnabled(false);
    }


    private TextWatcher fieldTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String field1 = classField1.getText().toString().trim();
            String field2 = classField2.getText().toString().trim();
            String field3 = classField3.getText().toString().trim();
            String field4 = classField4.getText().toString().trim();
            String field5 = classField5.getText().toString().trim();
            String field6 = creditField1.getText().toString().trim();
            String field7 = creditField2.getText().toString().trim();
            String field8= creditField3.getText().toString().trim();
            String field9 = creditField4.getText().toString().trim();
            String field10 = creditField5.getText().toString().trim();
            String field11 = gradeField1.getText().toString().trim();
            String field12 = gradeField2.getText().toString().trim();
            String field13 = gradeField3.getText().toString().trim();
            String field14 = gradeField4.getText().toString().trim();
            String field15 = gradeField5.getText().toString().trim();

            compute.setEnabled(!field1.isEmpty() && !field2.isEmpty() && !field3.isEmpty() && !field4.isEmpty() && !field5.isEmpty() &&
                    !field6.isEmpty() && !field7.isEmpty() && !field8.isEmpty() && !field9.isEmpty() && !field10.isEmpty() &&
                    !field11.isEmpty() && !field12.isEmpty() && !field13.isEmpty() && !field14.isEmpty() && !field15.isEmpty());

            clearAll.setEnabled(!field1.isEmpty() || !field2.isEmpty() || !field3.isEmpty() || !field4.isEmpty() || !field5.isEmpty() ||
                    !field6.isEmpty() || !field7.isEmpty() || !field8.isEmpty() || !field9.isEmpty() || !field10.isEmpty() ||
                    !field11.isEmpty() || !field12.isEmpty() || !field13.isEmpty() || !field14.isEmpty() || !field15.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
