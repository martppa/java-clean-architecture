package com.martppa.core.interactors;

import com.martppa.core.threading.ExecutionThread;
import com.martppa.core.threading.ObserverThreadExecutor;
import com.martppa.core.threading.SubscribedThreadExecutor;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class UseCase {

    protected final ExecutionThread executionThread;
    protected final ExecutionThread uiExecutionThread;
    protected final CompositeDisposable disposables;

    public UseCase(SubscribedThreadExecutor executionThread, ObserverThreadExecutor uiExecutionThread) {
        this.executionThread = executionThread;
        this.uiExecutionThread = uiExecutionThread;
        this.disposables = new CompositeDisposable();
    }
    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    protected void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
