package cn.edu.bistu.cs.se.component;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btno = (Button)findViewById(R.id.btn_ok);
        Button btnc = (Button)findViewById(R.id.btn_cancl);
        final EditText btnslct= (EditText)findViewById(R.id.select_Txt);
        btno.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                btnslct.setText("您选择了按钮OK");
            }
        });
        btnc.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View v){
                btnslct.setText("您选择了按钮CANCEL");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onCheckboxClicked(View view) { //身份选择检查
        boolean checked = ((CheckBox)view).isChecked();
        TextView check_idnty= (TextView)findViewById(R.id.select_identity);

        switch (view.getId()){
            case R.id.checkS:
                if(checked){
                    check_idnty.setText("学生");
                }
                else{
                    Toast.makeText(this,"取消选择学生身份", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkT:
                if(checked){
                    check_idnty.setText("老师");
                }
                else{
                    Toast.makeText(this,"取消选择老师身份", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkV:
                if(checked){
                    check_idnty.setText("访客");
                }
                else{
                    Toast.makeText(this,"取消选择访客身份", Toast.LENGTH_SHORT).show();
                }
            }
        }
    public void onRadioButtonClicked(View view) { //退出选择检查
        boolean checked = ((RadioButton) view).isChecked();
        TextView quitcheck=(TextView)findViewById(R.id.select_quit);

        // 检查哪个radio button被选中
        switch(view.getId()) {
            case R.id.yesButton:
                if (checked)
                    quitcheck.setText("您选择退出");
                break;
            case R.id.NoButton:
                if (checked)
                    quitcheck.setText("您选择不退出");
                break;
        }
    }
    }
