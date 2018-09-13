package com.martppa.core.interactors;

import com.martppa.core.threading.ExecutionThread;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

public abstract class ObservableUseCase<T, Params> extends UseCase {

    public ObservableUseCase(ExecutionThread executionThread, ExecutionThread uiExecutionThread) {
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
