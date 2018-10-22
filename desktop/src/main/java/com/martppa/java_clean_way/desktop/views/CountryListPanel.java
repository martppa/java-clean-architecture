/*
 *   Copyright (c) 2018 Humberto Martín Dieppa, Open source project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.martppa.java_clean_way.desktop.views;

import com.martppa.java_clean_way.desktop.di.component.DaggerMainComponent;
import com.martppa.java_clean_way.desktop.di.component.MainComponent;
import com.martppa.java_clean_way.desktop.di.module.MainModule;
import com.martppa.java_clean_way.ui.models.CountryModel;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenter;
import com.martppa.java_clean_way.ui.view.CountryListView;

import java.awt.BorderLayout;
import java.util.Collection;

import javax.inject.Inject;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CountryListPanel extends JPanel implements CountryListView {
    private MainComponent mainComponent;
    private JTable countryTable;

    @Inject
    CountryListPresenter countryListPresenter;

    public CountryListPanel() {
        this.setLayout(new BorderLayout());
        countryTable = new JTable();
        this.add(new JScrollPane(countryTable), BorderLayout.CENTER);
    }

    public void viewDisplayed() {
        createInjector();
        injectDependencies();
        initPresenter();
        requestCountries();
    }

    private void createInjector() {
        mainComponent = DaggerMainComponent.builder().mainModule(new MainModule()).build();
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
        DefaultTableModel defaultTableModel = (DefaultTableModel) countryTable.getModel();
        defaultTableModel.addColumn("Flag");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Ico Code");
        for (CountryModel countryModel : countries) {
            Object[] row = new Object[3];
            row[0] = countryModel.getFlagImageUrl();
            row[1] = countryModel.getName();
            row[2] = countryModel.getIsoCode();
            defaultTableModel.addRow(row);
        }
    }

    @Override
    public void showInfoMessage(String message) {

    }

    @Override
    public void showWarningMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {
        System.err.println(message);
    }
}
