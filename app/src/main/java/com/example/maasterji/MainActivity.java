package com.example.maasterji;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.add_new_garments);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this,addnewgarments.class);
                 startActivity(intent);
             }
         });
    }



    int quantity=0;
    int quantity1=0;
    String priceMessage="";
    public void submitOrder(View view) {
        CheckBox l = (CheckBox)findViewById(R.id.whipped_cream_check_box);
        boolean value1 = l.isChecked();
        CheckBox wl= (CheckBox)findViewById(R.id.choclate_check_box);
        boolean value2 = wl.isChecked();

        priceMessage="Name:mohini yadav"+"\nAdd lining ? "+value1+"\nAdd without lining ? "+value2+"\nQuanity: "+quantity+"\nTotal price : $"+calculateprice(quantity,value1,value2)+"\nThank You!";
        display(quantity);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Code For mohini yadav");
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void increment(View view) {
        quantity=quantity+1;
        display(quantity);
    }
    public void increment1(View view) {
        quantity1=quantity1+1;
        display1(quantity1);
    }

    public void decrement(View view) {
        if(quantity>0)
            quantity=quantity-1;
        else
            quantity=0;
        display(quantity);

    }
    public void decrement1(View view) {
        if(quantity1>0)
            quantity1=quantity1-1;
        else
            quantity1=0;
        display1(quantity1);

    }

    public int calculateprice(int quantity,boolean value1,boolean value2)
    {
        int price;
        price = quantity * 5;
        if(value1==true)
        {
            price+=1;
        }
        if(value2==true)
        {
            price+=2;
        }
        return price;

    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void display1(int number1) {
        TextView quantityTextView1 = (TextView) findViewById(R.id.quantity_text_view1);
        quantityTextView1.setText("" + number1);
    }

}