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
package com.martppa.java_clean_way.core.interactors;

import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;
import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Use-case base abstract.
 *
 * @param <T> Generic returning value type
 * @param <Params> Generic parameter type used in order to
 *                complete the task.
 */
public abstract class ObservableUseCase<T, Params> extends UseCase {

    public ObservableUseCase(SubscribedThreadExecutor executionThread, ObserverThreadExecutor uiExecutionThread) {
        super(executionThread, uiExecutionThread);
    }

    /**
     * Builds an {@link Observable} which will be used when executing the current {@link ObservableUseCase}.
     */
    protected abstract Observable buildUseCaseObservable(Params params);

    /**
     * Executes the current use case.
     *
     * @param observer {@link DisposableObserver} which will be listening to the observable build
     * by {@link #buildUseCaseObservable(Params)} ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    @SuppressWarnings("unchecked")
    public void execute(DisposableObserver<T> observer, Params params) {
        final Observable<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(uiExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }
}
