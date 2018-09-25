package com.martppa.core.interactors;

import com.martppa.core.threading.ObserverThreadExecutor;
import com.martppa.core.threading.SubscribedThreadExecutor;

import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;

public abstract class CompletableUseCase<Params> extends UseCase {

    public CompletableUseCase(SubscribedThreadExecutor executionThread, ObserverThreadExecutor uiExecutionThread) {
        super(executionThread, uiExecutionThread);
    }

    /**
     * Builds an {@link Completable} which will be used when executing the current {@link CompletableUseCase}.
     */
    protected abstract Completable buildUseCaseCompletable(Params params);

    /**
     * Executes the current use case.
     *
     * @param observer {@link DisposableCompletableObserver} which will be listening to the observable build
     * by {@link #buildUseCaseCompletable(Params)} ()} method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    @SuppressWarnings("unchecked")
    public void execute(DisposableCompletableObserver observer, Params params) {
        final Completable observable = this.buildUseCaseCompletable(params)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(uiExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(observer));
    }
}
