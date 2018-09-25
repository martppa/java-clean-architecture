package com.martppa.android.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.martppa.android.R;
import com.martppa.android.di.component.DaggerMainComponent;
import com.martppa.android.di.component.MainComponent;
import com.martppa.android.di.module.MainModule;
import com.martppa.ui.models.CountryModel;
import com.martppa.ui.presenter.country.CountryListPresenter;
import com.martppa.ui.view.CountryListView;

import java.util.Collection;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements CountryListView {
    @Inject CountryListPresenter countryListPresenter;

    private MainComponent mainComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createInjector();
        injectDependencies();
        initPresenter();
        requestCountries();
    }

    private void createInjector() {
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
    }

    private void injectDependencies() {
        mainComponent.inject(this);
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
