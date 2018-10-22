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

package com.martppa.java_clean_way.desktop;

import com.martppa.java_clean_way.desktop.views.CountryListPanel;

import javax.swing.*;

public class Main {
    private JFrame mainFrame;
    private CountryListPanel countryListPanel;

    private Main() {
        countryListPanel = new CountryListPanel();
        mainFrame = new JFrame("Java Clean Way");
        mainFrame.setSize(800, 600);
        mainFrame.setContentPane(countryListPanel);
        showWindow();
    }

    private void showWindow() {
        mainFrame.setVisible(true);
        countryListPanel.viewDisplayed();
    }

    public static void main(String[] args) {
        new Main();
    }
}
