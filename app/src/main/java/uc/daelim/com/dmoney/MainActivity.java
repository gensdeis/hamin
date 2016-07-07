package uc.daelim.com.dmoney;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText id;
    EditText pwd;
    TextView setid;
    TextView setpwd;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login);
        setid = (TextView)findViewById(R.id.setid);
        setpwd = (TextView)findViewById(R.id.setpwd);

        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                id = (EditText)findViewById(R.id.id);
                pwd = (EditText)findViewById(R.id.pwd);
                String str = id.getText().toString();
                String str2 = pwd.getText().toString();
                Toast.makeText(MainActivity.this, "ID : " + str, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "PWD : " + str2, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, SetView.class);
                intent.putExtra("id", str);
                intent.putExtra("pwd", str2);
                startActivity(intent);


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
}
