package uc.daelim.com.dmoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class SetView extends AppCompatActivity {
    TextView setid;
    TextView setpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        Intent intent = getIntent();
        String idd = intent.getExtras().getString("id");
        String pwdd = intent.getExtras().getString("pwd");

        setid = (TextView)findViewById(R.id.setid);
        setpwd = (TextView)findViewById(R.id.setpwd);

        setid.setText(idd);
        setpwd.setText(pwdd);


    }
}