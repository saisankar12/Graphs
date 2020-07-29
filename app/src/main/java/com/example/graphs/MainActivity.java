package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {

    EditText et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Checkout.preload(getApplicationContext());
        et1=findViewById(R.id.number1);
        et2=findViewById(R.id.number2);
        et3=findViewById(R.id.number3);
        et4=findViewById(R.id.number4);
        et5=findViewById(R.id.number5);

    }

    public void pie(View view) {
        String s1= et1.getText().toString();
        String s2= et2.getText().toString();
        String s3= et3.getText().toString();
        String s4= et4.getText().toString();
        String s5= et5.getText().toString();
        Intent i =new Intent(this, PieGraphActivity.class);
        i.putExtra("s1",s1);
        i.putExtra("s2",s2);
        i.putExtra("s3",s3);
        i.putExtra("s4",s4);
        i.putExtra("s5",s5);
        startActivity(i);
    }
    public void bar(View view) {
        String s1= et1.getText().toString();
        String s2= et2.getText().toString();
        String s3= et3.getText().toString();
        String s4= et4.getText().toString();
        String s5= et5.getText().toString();
        Intent i =new Intent(this, BarGraphActivity.class);
        i.putExtra("s1",s1);
        i.putExtra("s2",s2);
        i.putExtra("s3",s3);
        i.putExtra("s4",s4);
        i.putExtra("s5",s5);
        startActivity(i);
    }

    public void payment(View view) {
        Checkout checkout =new Checkout();
        checkout.setKeyID("rzp_test_iH4pydnsj9sLIy");
        checkout.setImage(R.drawable.ic_launcher_foreground);
        Activity activity =this;

        try {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("name","Sai Sankar");
            jsonObject.put("theme.color","#238747");
            jsonObject.put("currency","INR");
            jsonObject.put("Amount","2000");
            checkout.open(activity,jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, ""+s, Toast.LENGTH_SHORT).show();
    }
}