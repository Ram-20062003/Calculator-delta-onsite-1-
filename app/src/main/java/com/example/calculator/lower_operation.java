package com.example.calculator;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class lower_operation extends Fragment  {
    private static final String TAG = "lower_operation";
    private LowerOperationViewModel mViewModel;
    TextView textView2,textView1;
    public static lower_operation newInstance() {
        return new lower_operation();
    }
    Button b_ac,b_c,b_div,b_mul,b_add,b_sub,b_equals,b_exit,b1,b2,b3,b4,b5,b6,b7,b8,b9,b_dot;
    String perform="";
    int a=0;
    int i=0;
    double sum=0.0,pro=1.0;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.lower_operation_fragment, container, false);
        textView1=view.findViewById(R.id.low_text);
        textView2=view.findViewById(R.id.up_text);

        TextView[] textView= new TextView[]{textView1, textView2};
        b1=view.findViewById(R.id.one);
        b2=view.findViewById(R.id.two);
        b3=view.findViewById(R.id.three);
        b4=view.findViewById(R.id.four);
        b5=view.findViewById(R.id.five);
        b6=view.findViewById(R.id.six);
        b7=view.findViewById(R.id.seven);
        b8=view.findViewById(R.id.eight);
        b9=view.findViewById(R.id.nine);
        b_ac=view.findViewById(R.id.ac);
        b_c=view.findViewById(R.id.cross);
        b_div=view.findViewById(R.id.divide);
        b_mul=view.findViewById(R.id.multiply);
        b_add=view.findViewById(R.id.add);
        b_sub=view.findViewById(R.id.subtract);
        b_equals=view.findViewById(R.id.equal);
        b_dot=view.findViewById(R.id.point);
        zero();
        mViewModel = new ViewModelProvider(getActivity()).get(LowerOperationViewModel.class);
        Log.d(TAG, String.valueOf(Double.parseDouble("20.")+23));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView1.setShowSoftInputOnFocus(false);
            textView2.setShowSoftInputOnFocus(false);
        }
        textView2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                i=1;
                return false;
            }
        });
        textView1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                i=0;
                return false;
            }
        });
        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView[i].getText().toString().equals("")==false)
                {
                int c=textView[i].length();
                String get=textView[i].getText().toString();
                String get_after=get.substring(0,c-1);
                textView[i].setText(get_after);
                }
            }
        });
        b_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.setText("");
                textView2.setText("");
                mViewModel.selectitem("");
                zero();

            }
        });
        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append(".");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView[i].append("9");
            }
        });
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform="add";
                if(textView[0].getText() == "")
                {
                    textView[0].setText("0");
                }
                Log.d(TAG, "onClick: "+a);
                i=1;
            }
        });
        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform="sub";
                if(textView[0].getText() == "")
                {
                    textView[0].setText("0");
                }
                Log.d(TAG, "onClick: "+a);
                i=1;
            }
        });
        b_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform="mul";
                if(textView[0].getText() == "")
                {
                    textView[0].setText("0");
                }
                Log.d(TAG, "onClick: "+a);
                i=1;
            }
        });
        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                perform="div";
                if(textView[0].getText() == "")
                {
                    textView[0].setText("0");
                }
                Log.d(TAG, "onClick: "+a);
                i=1;
            }
        });
        b_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textView1.getText().toString().trim().equals(""))
                    textView1.setText("0");
                if(textView2.getText().toString().trim().equals(""))
                    textView2.setText("0");
                switch (perform)
                {
                    case "add":
                        sum=Double.parseDouble(textView[0].getText().toString())+Double.parseDouble(textView[1].getText().toString());
                        Log.d(TAG, "onClick: "+sum);
                        mViewModel.selectitem(String.valueOf(sum));
                        break;
                    case "sub":
                        sum=Double.parseDouble(textView[0].getText().toString())-Double.parseDouble(textView[1].getText().toString());
                        mViewModel.selectitem(String.valueOf(sum));

                        break;
                    case "mul":
                        pro=Double.parseDouble(textView[0].getText().toString())*Double.parseDouble(textView[1].getText().toString());
                        mViewModel.selectitem(String.valueOf(pro));
                        break;
                    case "div":
                        pro=Double.parseDouble(textView[0].getText().toString())/Double.parseDouble(textView[1].getText().toString());
                        mViewModel.selectitem(String.valueOf(pro));
                        break;
                    default:
                        mViewModel.selectitem("Operation not defined");

                }
            }

        });
        //mViewModel.selectitem("hi i am 1");
        return view;

    }
    private void zero()
    {
        textView1.setText("0");
        textView2.setText("0");
    }
}