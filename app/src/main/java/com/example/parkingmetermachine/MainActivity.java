package com.example.parkingmetermachine;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Activity context = MainActivity.this;

    private EditText cost;
    private EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cost = findViewById(R.id.e_cost);
        amount = findViewById(R.id.e_amount);

        findViewById(R.id.button).setOnClickListener(this);
    }

    double payTicket(double amount, double cost){
        return amount - cost;
    }

    void showReceipt(double change){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.alert_dialog_title);
        builder.setMessage("R " + change)
                .setNeutralButton(R.string.okay, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    void getTotal(){
        String a = amount.getText().toString().trim();
        String c = cost.getText().toString().trim();
        if(TextUtils.isEmpty(a) && TextUtils.isEmpty(c)){
            amount.setError("Cannot be empty");
            cost.setError("Cannot be empty");
        }else{
            double total = payTicket(Double.parseDouble(a), Double.parseDouble(c));
            showReceipt(total);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            getTotal();
        }
    }
}
