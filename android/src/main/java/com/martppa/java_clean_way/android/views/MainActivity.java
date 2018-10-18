/*
 * Copyright 2018 Humberto Martín Dieppa, Open source project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.martppa.java_clean_way.android.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.martppa.java_clean_way.android.R;
import com.martppa.java_clean_way.android.di.component.DaggerMainComponent;
import com.martppa.java_clean_way.android.di.component.MainComponent;
import com.martppa.java_clean_way.android.di.module.MainModule;
import com.martppa.java_clean_way.android.views.adapter.CountryListAdapter;
import com.martppa.java_clean_way.ui.models.CountryModel;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenter;
import com.martppa.java_clean_way.ui.view.CountryListView;

import java.util.ArrayList;
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
        ((ListView) findViewById(R.id.countryListView))
                .setAdapter(new CountryListAdapter(this, new ArrayList<>(countries)));
    }

    @Override
    public void showInfoMessage(String message) {
        showToast(message);
    }

    @Override
    public void showWarningMessage(String message) {
        showToast(message);
    }

    @Override
    public void showErrorMessage(String message) {
        showToast(message);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
