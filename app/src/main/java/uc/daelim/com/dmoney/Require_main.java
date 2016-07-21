package uc.daelim.com.dmoney;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import uc.daelim.com.dmoney.R;
import uc.daelim.com.dmoney.common.ErrorUtils;

public class Require_main extends AppCompatActivity {
    ImageView RightButton;
    TextView date;

    static final int DATE_DIALOG_ID = 0;

    public int year, month, day;
    private int mYear, mMonth, mDay;

    public Require_main() {
        final java.util.Calendar c = java.util.Calendar.getInstance();
        mYear = c.get(java.util.Calendar.YEAR);
        mMonth = c.get(java.util.Calendar.MONTH);
        mDay = c.get(java.util.Calendar.DAY_OF_MONTH);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_require_main);

        RightButton = (ImageView) findViewById(R.id.iv_RightButton);
        date = (TextView) findViewById(R.id.requiredate);

        date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        RightButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Toast.makeText(Require_main.this, "저장", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Require_main.this, detailView.class);
                startActivity(intent);
            }
        });

        try {

            addToolBar();

        } catch (Exception e) {
            ErrorUtils.AlertException(this, getString(R.string.error_msg_default_with_activity), e);
        }
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(DatePicker view, int yearSelected,
                              int monthOfYear, int dayOfMonth) {
            year = yearSelected;
            month = monthOfYear;
            day = dayOfMonth;
            Toast.makeText(getApplicationContext(), "날짜: "+year+"-"+month+"-"+day,
                    Toast.LENGTH_SHORT).show();
            date.setText(year + " - " + month + " - " + day);
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch(id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);
        }
        return null;
    }

    private void addToolBar() throws Exception {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(R.string.require);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
