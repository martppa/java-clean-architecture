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
package com.martppa.java_clean_way.iosapp.views;

import com.martppa.java_clean_way.iosapp.di.component.DaggerMainComponent;
import com.martppa.java_clean_way.iosapp.di.component.MainComponent;
import com.martppa.java_clean_way.iosapp.di.module.MainModule;
import com.martppa.java_clean_way.ui.models.CountryModel;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenter;
import com.martppa.java_clean_way.ui.view.CountryListView;

import apple.NSObject;
import apple.foundation.NSArray;
import apple.foundation.NSBundle;
import apple.foundation.NSCoder;
import apple.foundation.NSIndexPath;
import apple.foundation.NSMethodSignature;
import apple.foundation.NSSet;
import apple.uikit.UITableView;
import apple.uikit.UITableViewCell;
import apple.uikit.UITableViewController;
import apple.uikit.protocol.UITableViewDataSource;

import org.moe.natj.c.ann.FunctionPtr;
import org.moe.natj.general.NatJ;
import org.moe.natj.general.Pointer;
import org.moe.natj.general.ann.Generated;
import org.moe.natj.general.ann.Mapped;
import org.moe.natj.general.ann.MappedReturn;
import org.moe.natj.general.ann.NInt;
import org.moe.natj.general.ann.NUInt;
import org.moe.natj.general.ann.Owned;
import org.moe.natj.general.ann.RegisterOnStartup;
import org.moe.natj.general.ann.Runtime;
import org.moe.natj.general.ptr.VoidPtr;
import org.moe.natj.objc.Class;
import org.moe.natj.objc.ObjCRuntime;
import org.moe.natj.objc.SEL;
import org.moe.natj.objc.ann.ObjCClassBinding;
import org.moe.natj.objc.ann.ObjCClassName;
import org.moe.natj.objc.ann.Selector;
import org.moe.natj.objc.map.ObjCObjectMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

@Runtime(ObjCRuntime.class)
@ObjCClassName("CountryTableViewController")
@RegisterOnStartup
public class CountryTableViewController extends UITableViewController implements CountryListView {
	static {
		NatJ.register();
	}

	private MainComponent mainComponent;

	@Inject
	CountryListPresenter countryListPresenter;

	@Override
	public void viewDidLoad() {
		super.viewDidLoad();

		createInjector();
		injectDependencies();
		initPresenter();
		requestCountries();
	}

	@Generated
	protected CountryTableViewController(Pointer peer) {
		super(peer);
	}

	@Generated
	@Selector("accessInstanceVariablesDirectly")
	public static native boolean accessInstanceVariablesDirectly();

	@Generated
	@Owned
	@Selector("alloc")
	public static native CountryTableViewController alloc();

	@Generated
	@Selector("allocWithZone:")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object allocWithZone(VoidPtr zone);

	@Generated
	@Selector("attemptRotationToDeviceOrientation")
	public static native void attemptRotationToDeviceOrientation();

	@Generated
	@Selector("automaticallyNotifiesObserversForKey:")
	public static native boolean automaticallyNotifiesObserversForKey(String key);

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:")
	public static native void cancelPreviousPerformRequestsWithTarget(
			@Mapped(ObjCObjectMapper.class) Object aTarget);

	@Generated
	@Selector("cancelPreviousPerformRequestsWithTarget:selector:object:")
	public static native void cancelPreviousPerformRequestsWithTargetSelectorObject(
			@Mapped(ObjCObjectMapper.class) Object aTarget, SEL aSelector,
			@Mapped(ObjCObjectMapper.class) Object anArgument);

	@Generated
	@Selector("classFallbacksForKeyedArchiver")
	public static native NSArray<String> classFallbacksForKeyedArchiver();

	@Generated
	@Selector("classForKeyedUnarchiver")
	public static native Class classForKeyedUnarchiver();

	@Generated
	@Selector("clearTextInputContextIdentifier:")
	public static native void clearTextInputContextIdentifier(String identifier);

	@Generated
	@Selector("countryTableView")
	public native UITableView countryTableView();

	@Generated
	@Selector("debugDescription")
	public static native String debugDescription_static();

	@Generated
	@Selector("description")
	public static native String description_static();

	@Generated
	@Selector("hash")
	@NUInt
	public static native long hash_static();

	@Generated
	@Selector("init")
	public native CountryTableViewController init();

	@Generated
	@Selector("initWithCoder:")
	public native CountryTableViewController initWithCoder(NSCoder aDecoder);

	@Generated
	@Selector("initWithNibName:bundle:")
	public native CountryTableViewController initWithNibNameBundle(
			String nibNameOrNil, NSBundle nibBundleOrNil);

	@Generated
	@Selector("initWithStyle:")
	public native CountryTableViewController initWithStyle(@NInt long style);

	@Generated
	@Selector("instanceMethodForSelector:")
	@FunctionPtr(name = "call_instanceMethodForSelector_ret")
	public static native NSObject.Function_instanceMethodForSelector_ret instanceMethodForSelector(
			SEL aSelector);

	@Generated
	@Selector("instanceMethodSignatureForSelector:")
	public static native NSMethodSignature instanceMethodSignatureForSelector(
			SEL aSelector);

	@Generated
	@Selector("instancesRespondToSelector:")
	public static native boolean instancesRespondToSelector(SEL aSelector);

	@Generated
	@Selector("isSubclassOfClass:")
	public static native boolean isSubclassOfClass(Class aClass);

	@Generated
	@Selector("keyPathsForValuesAffectingValueForKey:")
	public static native NSSet<String> keyPathsForValuesAffectingValueForKey(
			String key);

	@Generated
	@Owned
	@Selector("new")
	@MappedReturn(ObjCObjectMapper.class)
	public static native Object new_objc();

	@Generated
	@Selector("resolveClassMethod:")
	public static native boolean resolveClassMethod(SEL sel);

	@Generated
	@Selector("resolveInstanceMethod:")
	public static native boolean resolveInstanceMethod(SEL sel);

	@Generated
	@Selector("setCountryTableView:")
	public native void setCountryTableView(UITableView value);

	@Generated
	@Selector("setVersion:")
	public static native void setVersion(@NInt long aVersion);

	@Generated
	@Selector("superclass")
	public static native Class superclass_static();

	@Generated
	@Selector("version")
	@NInt
	public static native long version_static();

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
		countryTableView().setDataSource(new CountryTableViewSource(new ArrayList<>(countries)));
		countryTableView().reloadData();
	}

	@Override
	public void showInfoMessage(String message) {

	}

	@Override
	public void showWarningMessage(String message) {

	}

	private void showMessage() {

	}

	@Override
	public void showErrorMessage(String message) {
		System.out.print("");
	}

	class CountryTableViewSource implements UITableViewDataSource {

		private List<CountryModel> countries;
		private String cellIdentifier = "countryItemCell";

		public CountryTableViewSource(List<CountryModel> countries) {
			this.countries = countries;
		}

		@Override
		public UITableViewCell tableViewCellForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
			UITableViewCell uiTableViewCell = tableView.dequeueReusableCellWithIdentifierForIndexPath(cellIdentifier, indexPath);
			CountryModel countryModel = countries.get((int) indexPath.row());
			String item = countryModel.getName() + " - " + countryModel.getIsoCode();
			uiTableViewCell.textLabel().setText(item);
			return uiTableViewCell;
		}

		@Override
		public long tableViewNumberOfRowsInSection(UITableView tableView, long section) {
			return countries.size();
		}
	}
}