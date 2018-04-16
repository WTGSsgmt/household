package com.household_accounts.ks.householdaccounts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;

public class AddIncomeActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_income);
    }

    public void setNumber(View view) {
        // 入力値取得
        Button button = (Button)view;
        String s = button.getText().toString();

        // テキストビュー取得
        TextView text = (TextView)findViewById(R.id.textView2);
        if (text != null) {
            String result = text.getText().toString();
            result += s;
            text.setText(result);
        } else {
            text.setText(s);
        }
    }
    public void addReaction(View view) {
        // 入力値取得
        Button button = (Button) view;
        // 現在の数値取得
        TextView text = (TextView)findViewById(R.id.textView2);
        String action = button.getText().toString();
        switch (action) {
            case "AC":
                text.setText("");
                break;
            case "C":
                text.setText("");
                break;
            case "保存":
                addResource(text);
                text.setText("");
                break;
        }
    }

    private void addResource(TextView text) {
        Resources res = createResource(text);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("resources");
        String key = reference.push().getKey();
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, res.toMap());
        reference.updateChildren(map);
    }

    @NonNull
    private Resources createResource(TextView text) {
        return new Resources("cash", text.getText().toString(), new Date().toString());
    }
}
