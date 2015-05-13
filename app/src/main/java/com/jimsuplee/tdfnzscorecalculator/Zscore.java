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

import android.app.ListActivity;
//import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.net.Uri;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;

//import android.util.Log;

/**
 * Created on 3/19/15.
 */
public class Zscore extends ListActivity {
    static final String TAG = "TDFN";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displayListView();
    }

    private void displayListView() {
        List<String> measurementsList = new ArrayList<String>();
        measurementsList.add("Cranial Base Width");
        measurementsList.add("Cutaneous Lower Lip Height");
        measurementsList.add("Intercanthal Width");
        measurementsList.add("Labial Fissure Width");
        measurementsList.add("Lower Facial Depth Left");
        measurementsList.add("Lower Facial Depth Right");
        measurementsList.add("Lower Facial Height");
        measurementsList.add("Lower Lip Height");
        measurementsList.add("Lower Vermilion Height");
        measurementsList.add("Mandibular Width");
        measurementsList.add("Maximum Cranial Length");
        measurementsList.add("Maximum Cranial Width");
        measurementsList.add("Maximum Facial Width");
        measurementsList.add("Middle Facial Depth Left");
        measurementsList.add("Middle Facial Depth Right");
        measurementsList.add("Minimum Frontal Width");
        measurementsList.add("Morphological Facial Height");
        measurementsList.add("Nasal Ala Length Left");
        measurementsList.add("Nasal Ala Length Right");
        measurementsList.add("Nasal Bridge Length");
        measurementsList.add("Nasal Height");
        measurementsList.add("Nasal Protrusion");
        measurementsList.add("Nasal Width");
        measurementsList.add("Outercanthal Width");
        measurementsList.add("Palpebral Fissure Length Left");
        measurementsList.add("Palpebral Fissure Length Right");
        measurementsList.add("Philtrum Length");
        measurementsList.add("Philtrum Width");
        measurementsList.add("Subnasal Width");
        measurementsList.add("Upper Facial Depth Left");
        measurementsList.add("Upper Facial Depth Right");
        measurementsList.add("Upper Facial Height");
        measurementsList.add("Upper Lip Height");
        measurementsList.add("Upper Vermilion Height");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.measurementtextview, measurementsList);
        setListAdapter(dataAdapter);
        ListView listView = getListView();
        listView.setTextFilterEnabled(true);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //ScottishDistilleries.distillerySearchList.clear();
                Intent i = new Intent("");
                String measurementChoice = ((TextView) view).getText().toString();
                TDFNZscoreCalculator.measurementChoice = measurementChoice;
                i.setData(Uri.parse(measurementChoice));
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}





