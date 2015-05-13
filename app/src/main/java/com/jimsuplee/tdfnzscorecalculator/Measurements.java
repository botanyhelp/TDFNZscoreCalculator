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
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import java.util.HashMap;
//import java.util.Map;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
//import android.util.Log;
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

/**
 * Created on 4/15/15.
 */
public class Measurements extends Activity {
    //
    //We want an Integer array here, with hope for no new measurements, but
    // the commented out Hashmap and its also-commented-out populating remain
    // in case that becomes more convenient.
    //HashMap<String,Integer> measurementMap = new HashMap<String,Integer>();
    //HashMap<String,Integer> photoMap = new HashMap<String,Integer>();
    //Integer[] imageIDs = [R.drawable.minimumfrontalwidth,R.drawable.mandibularwidth,R.drawable.maximumcranialwidth,R.drawable.maximumcraniallength,R.drawable.maximumfacialwidth,R.drawable.cranialbasewidth,R.drawable.upperfacialdepthright,R.drawable.upperfacialdepthleft,R.drawable.middlefacialdepthright,R.drawable.middlefacialdepthleft,R.drawable.lowerfacialdepthright,R.drawable.lowerfacialdepthleft,R.drawable.morphologicalfacialheight,R.drawable.upperfacialheight,R.drawable.lowerfacialheight,R.drawable.intercanthalwidth,R.drawable.outercanthalwidth,R.drawable.palpebralfissurelengthright,R.drawable.palpebralfissurelengthleft,R.drawable.nasalwidth,R.drawable.subnasalwidth,R.drawable.nasalprotrusion,R.drawable.nasalalalengthright,R.drawable.nasalalalengthleft,R.drawable.nasalheight,R.drawable.nasalbridgelength,R.drawable.labialfissurewidth,R.drawable.philtrumwidth,R.drawable.philtrumlength,R.drawable.upperlipheight,R.drawable.lowerlipheight,R.drawable.uppervermilionheight,R.drawable.lowervermilionheight,R.drawable.cutaneouslowerlipheight];
    //Integer[] measurementIDs = [R.string.minimumfrontalwidth,R.string.mandibularwidth,R.string.maximumcranialwidth,R.string.maximumcraniallength,R.string.maximumfacialwidth,R.string.cranialbasewidth,R.string.upperfacialdepthright,R.string.upperfacialdepthleft,R.string.middlefacialdepthright,R.string.middlefacialdepthleft,R.string.lowerfacialdepthright,R.string.lowerfacialdepthleft,R.string.morphologicalfacialheight,R.string.upperfacialheight,R.string.lowerfacialheight,R.string.intercanthalwidth,R.string.outercanthalwidth,R.string.palpebralfissurelengthright,R.string.palpebralfissurelengthleft,R.string.nasalwidth,R.string.subnasalwidth,R.string.nasalprotrusion,R.string.nasalalalengthright,R.string.nasalalalengthleft,R.string.nasalheight,R.string.nasalbridgelength,R.string.labialfissurewidth,R.string.philtrumwidth,R.string.philtrumlength,R.string.upperlipheight,R.string.lowerlipheight,R.string.uppervermilionheight,R.string.lowervermilionheight,R.string.cutaneouslowerlipheight];
    Integer[] imageIDs = {R.drawable.cranialbasewidth,R.drawable.cutaneouslowerlipheight,R.drawable.intercanthalwidth,R.drawable.labialfissurewidth,R.drawable.lowerfacialdepthleft,R.drawable.lowerfacialdepthright,R.drawable.lowerfacialheight,R.drawable.lowerlipheight,R.drawable.lowervermilionheight,R.drawable.mandibularwidth,R.drawable.maximumcraniallength,R.drawable.maximumcranialwidth,R.drawable.maximumfacialwidth,R.drawable.middlefacialdepthleft,R.drawable.middlefacialdepthright,R.drawable.minimumfrontalwidth,R.drawable.morphologicalfacialheight,R.drawable.nasalalalengthleft,R.drawable.nasalalalengthright,R.drawable.nasalbridgelength,R.drawable.nasalheight,R.drawable.nasalprotrusion,R.drawable.nasalwidth,R.drawable.outercanthalwidth,R.drawable.palpebralfissurelengthleft,R.drawable.palpebralfissurelengthright,R.drawable.philtrumlength,R.drawable.philtrumwidth,R.drawable.subnasalwidth,R.drawable.upperfacialdepthleft,R.drawable.upperfacialdepthright,R.drawable.upperfacialheight,R.drawable.upperlipheight,R.drawable.uppervermilionheight};
    Integer[] measurementIDs = {R.string.cranialbasewidth,R.string.cutaneouslowerlipheight,R.string.intercanthalwidth,R.string.labialfissurewidth,R.string.lowerfacialdepthleft,R.string.lowerfacialdepthright,R.string.lowerfacialheight,R.string.lowerlipheight,R.string.lowervermilionheight,R.string.mandibularwidth,R.string.maximumcraniallength,R.string.maximumcranialwidth,R.string.maximumfacialwidth,R.string.middlefacialdepthleft,R.string.middlefacialdepthright,R.string.minimumfrontalwidth,R.string.morphologicalfacialheight,R.string.nasalalalengthleft,R.string.nasalalalengthright,R.string.nasalbridgelength,R.string.nasalheight,R.string.nasalprotrusion,R.string.nasalwidth,R.string.outercanthalwidth,R.string.palpebralfissurelengthleft,R.string.palpebralfissurelengthright,R.string.philtrumlength,R.string.philtrumwidth,R.string.subnasalwidth,R.string.upperfacialdepthleft,R.string.upperfacialdepthright,R.string.upperfacialheight,R.string.upperlipheight,R.string.uppervermilionheight};
    static int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);
        Measurements.index = 0;
        displayTextAndImage();
        /*photoMap.put("minimumfrontalwidth", R.drawable.minimumfrontalwidth);
        photoMap.put("mandibularwidth", R.drawable.mandibularwidth);
        photoMap.put("maximumcranialwidth", R.drawable.maximumcranialwidth);
        photoMap.put("maximumcraniallength", R.drawable.maximumcraniallength);
        photoMap.put("maximumfacialwidth", R.drawable.maximumfacialwidth);
        photoMap.put("cranialbasewidth", R.drawable.cranialbasewidth);
        photoMap.put("upperfacialdepthright", R.drawable.upperfacialdepthright);
        photoMap.put("upperfacialdepthleft", R.drawable.upperfacialdepthleft);
        photoMap.put("middlefacialdepthright", R.drawable.middlefacialdepthright);
        photoMap.put("middlefacialdepthleft", R.drawable.middlefacialdepthleft);
        photoMap.put("lowerfacialdepthright", R.drawable.lowerfacialdepthright);
        photoMap.put("lowerfacialdepthleft", R.drawable.lowerfacialdepthleft);
        photoMap.put("morphologicalfacialheight", R.drawable.morphologicalfacialheight);
        photoMap.put("upperfacialheight", R.drawable.upperfacialheight);
        photoMap.put("lowerfacialheight", R.drawable.lowerfacialheight);
        photoMap.put("intercanthalwidth", R.drawable.intercanthalwidth);
        photoMap.put("outercanthalwidth", R.drawable.outercanthalwidth);
        photoMap.put("palpebralfissurelengthright", R.drawable.palpebralfissurelengthright);
        photoMap.put("palpebralfissurelengthleft", R.drawable.palpebralfissurelengthleft);
        photoMap.put("nasalwidth", R.drawable.nasalwidth);
        photoMap.put("subnasalwidth", R.drawable.subnasalwidth);
        photoMap.put("nasalprotrusion", R.drawable.nasalprotrusion);
        photoMap.put("nasalalalengthright", R.drawable.nasalalalengthright);
        photoMap.put("nasalalalengthleft", R.drawable.nasalalalengthleft);
        photoMap.put("nasalheight", R.drawable.nasalheight);
        photoMap.put("nasalbridgelength", R.drawable.nasalbridgelength);
        photoMap.put("labialfissurewidth", R.drawable.labialfissurewidth);
        photoMap.put("philtrumwidth", R.drawable.philtrumwidth);
        photoMap.put("philtrumlength", R.drawable.philtrumlength);
        photoMap.put("upperlipheight", R.drawable.upperlipheight);
        photoMap.put("lowerlipheight", R.drawable.lowerlipheight);
        photoMap.put("uppervermilionheight", R.drawable.uppervermilionheight);
        photoMap.put("lowervermilionheight", R.drawable.lowervermilionheight);
        photoMap.put("cutaneouslowerlipheight", R.drawable.cutaneouslowerlipheight);

        measurementMap.put("minimumfrontalwidth",R.string.minimumfrontalwidth);
        measurementMap.put("mandibularwidth",R.string.mandibularwidth);
        measurementMap.put("maximumcranialwidth",R.string.maximumcranialwidth);
        measurementMap.put("maximumcraniallength",R.string.maximumcraniallength);
        measurementMap.put("maximumfacialwidth",R.string.maximumfacialwidth);
        measurementMap.put("cranialbasewidth",R.string.cranialbasewidth);
        measurementMap.put("upperfacialdepthright",R.string.upperfacialdepthright);
        measurementMap.put("upperfacialdepthleft",R.string.upperfacialdepthleft);
        measurementMap.put("middlefacialdepthright",R.string.middlefacialdepthright);
        measurementMap.put("middlefacialdepthleft",R.string.middlefacialdepthleft);
        measurementMap.put("lowerfacialdepthright",R.string.lowerfacialdepthright);
        measurementMap.put("lowerfacialdepthleft",R.string.lowerfacialdepthleft);
        measurementMap.put("morphologicalfacialheight",R.string.morphologicalfacialheight);
        measurementMap.put("upperfacialheight",R.string.upperfacialheight);
        measurementMap.put("lowerfacialheight",R.string.lowerfacialheight);
        measurementMap.put("intercanthalwidth",R.string.intercanthalwidth);
        measurementMap.put("outercanthalwidth",R.string.outercanthalwidth);
        measurementMap.put("palpebralfissurelengthright",R.string.palpebralfissurelengthright);
        measurementMap.put("palpebralfissurelengthleft",R.string.palpebralfissurelengthleft);
        measurementMap.put("nasalwidth",R.string.nasalwidth);
        measurementMap.put("subnasalwidth",R.string.subnasalwidth);
        measurementMap.put("nasalprotrusion",R.string.nasalprotrusion);
        measurementMap.put("nasalalalengthright",R.string.nasalalalengthright);
        measurementMap.put("nasalalalengthleft",R.string.nasalalalengthleft);
        measurementMap.put("nasalheight",R.string.nasalheight);
        measurementMap.put("nasalbridgelength",R.string.nasalbridgelength);
        measurementMap.put("labialfissurewidth",R.string.labialfissurewidth);
        measurementMap.put("philtrumwidth",R.string.philtrumwidth);
        measurementMap.put("philtrumlength",R.string.philtrumlength);
        measurementMap.put("upperlipheight",R.string.upperlipheight);
        measurementMap.put("lowerlipheight",R.string.lowerlipheight);
        measurementMap.put("uppervermilionheight",R.string.uppervermilionheight);
        measurementMap.put("lowervermilionheight",R.string.lowervermilionheight);
        measurementMap.put("cutaneouslowerlipheight",R.string.cutaneouslowerlipheight);*/
    }
    public void displayTextAndImage() {
        ImageView iv = (ImageView) findViewById(R.id.image1);
        iv.setImageResource(imageIDs[Measurements.index]);
        TextView tv = (TextView) findViewById(R.id.txt_picture);
        //String measurementText = measurementIDs[Measurements.index] + " (" + Integer.toString(Measurements.index) + " of 34)";
        tv.setText(measurementIDs[Measurements.index]);
    }

    public void onClickPicture(View view) {
		if(index<33) {
		    index+=1;
		}
		displayTextAndImage();
	}
	public void onClickPictureback(View view) {
		if(index>0) {
			index-=1;
		}
		displayTextAndImage();
	}
    public void onClickHome(View view) {
		finish();
	}
}
