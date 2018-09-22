package com.martppa.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.martppa.di.Injector;
import com.martppa.ui.models.CountryModel;
import com.martppa.ui.presenter.country.CountryListPresenter;
import com.martppa.ui.view.CountryListView;

import java.util.Collection;

public class MainActivity extends AppCompatActivity implements CountryListView {
    private CountryListPresenter countryListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectPresenter();
        initPresenter();
        requestCountries();
    }

    private void injectPresenter() {
        countryListPresenter = Injector.getInstance().inject(countryListPresenter.getClass());
    }

    private void initPresenter() {
        countryListPresenter.setView(this);
        countryListPresenter.init();
    }

    private void requestCountries() {
        countryListPresenter.requestCountries();
    }

    @Override
    public void renderCountries(Collection<CountryModel> countries) {
        System.out.print("pepe");
    }

    @Override
    public void showInfoMessage(String message) {

    }

    @Override
    public void showWarningMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }
}
