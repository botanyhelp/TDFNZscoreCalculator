/**Copyright (C) 2015 Seth Weinberg
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.jimsuplee.tdfnzscorecalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;

import java.util.HashMap;
//import java.util.Map;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
//import android.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.widget.Toast;
import android.database.Cursor;
import android.widget.EditText;

import java.util.List;
import java.util.ArrayList;
//import com.jimsuplee.scottishdistilleries.R;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
//import android.R;
import android.net.Uri;




public class TDFNZscoreCalculator extends ActionBarActivity {
    static final String TAG = "TDFN";
    static String measurementChoice = "";
    static String ageChoice = "";
    static String sexChoice = "";
    //static String measurementChoice = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tdfnzscore_calculator);
        Log.w(TAG, "In TDFNZscoreCalculator_ActionBarActivity_onCreate()");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tdfnzscore_calculator, menu);
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
    public void onClickZscore(View view) {
        Intent iZscore = new Intent("com.jimsuplee.tdfnzscorecalculator.Zscore");
        startActivityForResult(iZscore,0);
    }
    public void onClickMeasurements(View view) {
        Intent iMeasurements = new Intent("com.jimsuplee.tdfnzscorecalculator.Measurements");
        startActivity(iMeasurements);
    }
    public void onClickNotes(View view) {
        Intent iNotes = new Intent("com.jimsuplee.tdfnzscorecalculator.Notes");
        startActivity(iNotes);
    }
    public void onClickHelp(View view) {
        //Intent iZscore = new Intent("com.jimsuplee.tdfnzscorecalculator.Zscore");
        //startActivityForResult(iZscore,0);
        //TextView tv = (TextView) findViewById(R.string.help);
        TextView tv = (TextView) findViewById(R.id.txt_InfoAndHelp);
        tv.setText(R.string.help);
        tv.setVisibility(View.VISIBLE);
    }
    public void onClickInfo(View view) {
        //Intent iZscore = new Intent("com.jimsuplee.tdfnzscorecalculator.Zscore");
        //startActivityForResult(iZscore,0);
        //TextView tv = (TextView) findViewById(R.string.info);
        TextView tv = (TextView) findViewById(R.id.txt_InfoAndHelp);
        tv.setText(R.string.info);
        tv.setVisibility(View.VISIBLE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // ---check if the request code is 0 1 2 3 4 5---
        Log.w(TAG, "In TDFNZscoreCalculator.onActivityResult(), checking reqCod");
        if (requestCode == 0) {
            Log.w(TAG, "In TDFNZscoreCalculator.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
            if (resultCode == RESULT_OK) {
                String measurement = data.getData().toString();
                Intent iCalculator = new Intent("com.jimsuplee.tdfnzscorecalculator.Calculator");
                iCalculator.putExtra("measurement", measurement);
                startActivityForResult(iCalculator,1);
            }
        }
    }
}
