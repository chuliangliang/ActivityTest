package com.activitytest.chuliangliang.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    private static final String TAG = "FirstActivity";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
            {

                Toast.makeText(FirstActivity.this,"添加",Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.remove_item:
            {
                Toast.makeText(FirstActivity.this,"移除",Toast.LENGTH_SHORT).show();
            }
            break;
            default:
            {

            }
            break;


        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        if (savedInstanceState != null) {
            String stingData = savedInstanceState.getString("data_key");
            Log.d(TAG, "恢复保存数据:" + stingData);
        }

        Button button = (Button) findViewById(R.id.button_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "点击我了", Toast.LENGTH_SHORT).show();
                pushSecondActivity();
            }
        });
    }

    private void  pushSecondActivity()
    {
        //显式调用
        /*
        *        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        *        startActivity(intent);
        * */

        //隐式调用
//        Intent intent = new Intent("com.activitytest.chuliangliang.ACTION_START");
//        intent.addCategory("android.intent.category.MY_SECOND");
//        startActivity(intent);

        SecondActivity.actionStart(this,"你好, 第二个活动");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tmpString = "我是保存的临时数据";
        outState.putString("data_key",tmpString);
    }
}
