package com.example.p03_ps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModuleInfoAdapter extends ArrayAdapter<ModuleInfo> {
    private ArrayList<ModuleInfo> moduleinfo;
    private Context context;
    private TextView tvWeek , tvDG , tvGrade;
    private ImageView ivModuleIcon;


    public ModuleInfoAdapter(Context context, int resource, ArrayList<ModuleInfo> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        moduleinfo = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.rowinfo, parent, false);

        // Get the TextView object
        tvWeek = rowView.findViewById(R.id.textViewWeek);
        tvDG = rowView.findViewById(R.id.textViewDG);
        tvGrade = rowView.findViewById(R.id.textViewGrade);
        ivModuleIcon = rowView.findViewById(R.id.imageViewModuleIcon);
        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        ModuleInfo currentModule = moduleinfo.get(position);
        // Set the TextView to show the food

        tvGrade.setText(currentModule.getGrade());
        tvWeek.setText("week " + currentModule.getWeek());
        ivModuleIcon.setImageResource(R.drawable.dg);
        tvDG.setText(currentModule.getCode());
                // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
