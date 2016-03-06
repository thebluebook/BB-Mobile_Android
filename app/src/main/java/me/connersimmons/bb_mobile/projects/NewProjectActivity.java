package me.connersimmons.bb_mobile.projects;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TimePicker;

import me.connersimmons.bb_mobile.R;


public class NewProjectActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_project);
        if (savedInstanceState == null) {
            createFullScreenDialog();
        }
    }

    private void createFullScreenDialog() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        NewProjectFragment newFragment = new NewProjectFragment();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, newFragment, "FullScreenFragment")
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        NewProjectFragment fragment = (NewProjectFragment) getSupportFragmentManager().findFragmentByTag("FullScreenFragment");
        if (fragment != null) {
            fragment.setDateView(year, monthOfYear, dayOfMonth);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        NewProjectFragment fragment = (NewProjectFragment) getSupportFragmentManager().findFragmentByTag("FullScreenFragment");
        if (fragment != null) {
            fragment.setTimeView(hourOfDay, minute);
        }
    }
}
