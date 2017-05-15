package com.activitytest.chuliangliang.activitytest;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.URI;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    public  static void actionStart (Context ctx,String data1)
    {
        Intent intent = new Intent(ctx,SecondActivity.class);
        intent.putExtra("param_key",data1);
        ctx.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        //取出数据
        String dataString =  getIntent().getStringExtra("param_key");
        Log.d(TAG,"dataString" + dataString);
        Toast.makeText(this, dataString, Toast.LENGTH_SHORT).show();



        Button button = (Button)findViewById(R.id.button_2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "你好,第三个Activity";
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("my_pudata",data);
//                startActivity(intent); //单向 向下传值
                startActivityForResult(intent, 1); //双向 向下传值同时返回值
            }
        });


        Button webButton = (Button) findViewById(R.id.button_web);
        webButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://baidu.com"));
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){

            case 1:
            {
                if (resultCode == RESULT_OK)
                {
                    String returnString = data.getStringExtra("data_return");
                    Log.d(TAG,"returnString = " + returnString);
                    Toast.makeText(this, returnString, Toast.LENGTH_SHORT).show();
                }
            }
            break;

        }
    }
}
