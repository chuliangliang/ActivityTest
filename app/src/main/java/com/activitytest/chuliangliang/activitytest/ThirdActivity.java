package com.activitytest.chuliangliang.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Intent intent = getIntent();
        String dataString =  intent.getStringExtra("my_pudata");
        Log.d(TAG,"dataString" + dataString);
        Toast.makeText(this, dataString, Toast.LENGTH_SHORT).show();

        Button button = (Button) findViewById(R.id.button_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inent = new Intent();
                inent.putExtra("data_return","第三个活动返回处理结果");
                setResult(RESULT_OK,inent);
                finish();
            }
        });

        Button button_ext = (Button)findViewById(R.id.button_ext);
        button_ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityController.finishAll();
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent inent = new Intent();
        inent.putExtra("data_return","第三个活动返回处理结果");
        setResult(RESULT_OK,inent);

        super.onBackPressed();

    }
}
