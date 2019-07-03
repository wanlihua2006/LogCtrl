package com.lihua.test.logctrl;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.SystemProperties;

public class LogCtrlActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnEnable;
    private Button btnV;
    private Button btnD;
    private Button btnI;
    private Button btnW;
    private Button btnE;

    private final int VERBOSE_INT = 2;
    private final int DEBUG_INT = 3;
    private final int INFO_INT = 4;
    private final int WARN_INT = 5;
    private final int ERROR_INT = 6;
    private final String VERBOSE = "2";
    private final String DEBUG = "3";
    private final String INFO = "4";
    private final String WARN = "5";
    private final String ERROR = "6";

    private static boolean mLogDisable = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_ctrl);

        btnEnable =findViewById(R.id.btnEnable);
        btnV =findViewById(R.id.btnV);
        btnD =findViewById(R.id.btnD);
        btnI =findViewById(R.id.btnI);
        btnW =findViewById(R.id.btnW);
        btnE =findViewById(R.id.btnE);

        btnEnable.setOnClickListener(this);
        btnV.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnI.setOnClickListener(this);
        btnW.setOnClickListener(this);
        btnE.setOnClickListener(this);

        Settings.Global.getInt(getContentResolver(),
                "LogLevel", 0);
        //SystemProperties.set("persist.log.level","0");
    }

    @Override
    public void onClick(View v) {
        int tmp = 0;
        if (v == btnEnable){
            Toast.makeText(this, "press Enable", Toast.LENGTH_SHORT).show();
            if(mLogDisable) {
                //Settings.Global.putInt(getContentResolver(), "LogLevel", 1);
                mLogDisable = false;
                SystemProperties.set("persist.log.level","1");
                tmp = 0;
            }
            else {
                //Settings.Global.putInt(getContentResolver(), "LogLevel", 0);
                SystemProperties.set("persist.log.level","0");
                mLogDisable = true;
                tmp = 1;
            }
        }else if (v == btnV){
            //Settings.Global.putInt(getContentResolver(), "LogLevel", VERBOSE);
            //SystemProperties.set("persist.log.level",VERBOSE);
            Log.v("LogCtrlActivity", "wanlihua debug  press V");
            //tmp = Settings.Global.getInt(getContentResolver(), "LogLevel", 0);
            tmp = SystemProperties.getInt("persist.log.level",VERBOSE_INT);
            /*if (tmp >= VERBOSE_INT)*/{
                Log.v("LogCtrlActivity", "wanlihua debug press v");
                Toast.makeText(this, "press V ,tmp : " + tmp, Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnD){
            //Settings.Global.putInt(getContentResolver(), "LogLevel", DEBUG);
            //tmp = Settings.Global.getInt(getContentResolver(), "LogLevel", 0);
            SystemProperties.set("persist.log.level",DEBUG);
            tmp = SystemProperties.getInt("persist.log.level",DEBUG_INT);
            /*if (tmp >= DEBUG_INT)*/ {
                Toast.makeText(this, "press d, tmp" + tmp, Toast.LENGTH_SHORT).show();
                Log.d("LogCtrlActivity", "wanlihua debug press d");
            }
        }else if (v == btnI){
            //Settings.Global.putInt(getContentResolver(), "LogLevel", INFO);
            //tmp = Settings.Global.getInt(getContentResolver(), "LogLevel", 0);
            //SystemProperties.set("persist.log.level","1");
            //tmp = SystemProperties.getInt("persist.log.level",INFO_INT);
            tmp = SystemProperties.getInt("persist.log.level",0);
            Log.i("LogCtrlActivity", "wanlihua debug press 1 : " + tmp);
            /*if (tmp >= INFO_INT)*/ {
                //Toast.makeText(this, "press i,tmp : " +tmp, Toast.LENGTH_SHORT).show();
                Log.i("LogCtrlActivity", "wanlihua debug press i");
            }
        }else if (v == btnW){
            //Settings.Global.putInt(getContentResolver(), "LogLevel", WARN);
            //tmp = Settings.Global.getInt(getContentResolver(), "LogLevel", 0);
            //SystemProperties.set("persist.log.level",WARN);
            tmp = SystemProperties.getInt("persist.log.level",0);
            Log.w("LogCtrlActivity", "wanlihua debug press w : " + tmp);
            /*if (tmp >= WARN_INT)*/ {
                Toast.makeText(this, "press w,tmp " + tmp, Toast.LENGTH_SHORT).show();
                Log.w("LogCtrlActivity", "wanlihua debug press w");
            }
        }else if (v == btnE){
            //Settings.Global.putInt(getContentResolver(), "LogLevel", ERROR);
            //tmp = Settings.Global.getInt(getContentResolver(), "LogLevel", 0);
            //SystemProperties.set("persist.log.level",ERROR);
           // tmp = SystemProperties.getInt("persist.log.level",ERROR_INT);
          /*  if (tmp >= ERROR_INT)*/ {
                Toast.makeText(this, "press e,tmp : " +tmp, Toast.LENGTH_SHORT).show();
                Log.e("LogCtrlActivity", "wanlihua debug press e");
            }
        }
    }
}
