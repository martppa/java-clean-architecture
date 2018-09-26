package com.martppa.java_clean_way.android.views.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.martppa.java_clean_way.android.R;
import com.martppa.java_clean_way.ui.models.CountryModel;

import java.util.List;

public class CountryListAdapter extends ArrayAdapter<CountryModel> {
    private List<CountryModel> countries;
    private Activity context;

    public CountryListAdapter(Activity context, List<CountryModel> countries)
    {
        super(context, R.layout.country_layout);
        this.context = context;
        this.countries = countries;
    }


    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public CountryModel getItem(int position) {
        return countries.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountryModel  countryModel = getItem(position);
        if (convertView == null)
            convertView = context.getLayoutInflater().inflate(R.layout.country_layout, parent, false);
        ((TextView) convertView.findViewById(R.id.countryNameTextView)).setText(countryModel.getName());
        ((TextView) convertView.findViewById(R.id.countryIsoTextView)).setText(countryModel.getIsoCode());
        return convertView;
    }
}
