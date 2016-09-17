package it.droidcon.databinding;

import android.databinding.Observable.OnPropertyChangedCallback;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import java.util.List;
import rx.AsyncEmitter;
import rx.Observable;

public class RxDataBinding {
    public static Observable<Boolean> toRx(ObservableBoolean observableBoolean) {
        Observable<Boolean> objectObservable = Observable.fromEmitter(emitter -> {
            emitter.onNext(observableBoolean.get());
            OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(android.databinding.Observable observable, int i) {
                    emitter.onNext(((ObservableBoolean) observable).get());
                }
            };
            observableBoolean.addOnPropertyChangedCallback(callback);
            emitter.setCancellation(() -> observableBoolean.removeOnPropertyChangedCallback(callback));
        }, AsyncEmitter.BackpressureMode.BUFFER);
        return objectObservable.replay(1).refCount();
    }

    public static <T> Observable<T> toRx(ObservableField<T> observableField) {
        Observable<T> objectObservable = Observable.fromEmitter(emitter -> {
            emitter.onNext(observableField.get());
            OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(android.databinding.Observable observable, int i) {
                    emitter.onNext(((ObservableField<T>) observable).get());
                }
            };
            observableField.addOnPropertyChangedCallback(callback);
            emitter.setCancellation(() -> observableField.removeOnPropertyChangedCallback(callback));
        }, AsyncEmitter.BackpressureMode.BUFFER);
        return objectObservable.replay(1).refCount();
    }

    public static <T> Observable<List<T>> toRx(ObservableArrayList<T> observableField) {
        Observable<List<T>> objectObservable = Observable.fromEmitter(emitter -> {
            emitter.onNext(observableField);
            ObservableList.OnListChangedCallback<ObservableList<T>> listener = new ObservableList.OnListChangedCallback<ObservableList<T>>() {
                @Override public void onChanged(ObservableList<T> ts) {
                    emitter.onNext(ts);
                }

                @Override public void onItemRangeChanged(ObservableList<T> ts, int i, int i1) {
                    emitter.onNext(ts);
                }

                @Override public void onItemRangeInserted(ObservableList<T> ts, int i, int i1) {
                    emitter.onNext(ts);
                }

                @Override public void onItemRangeMoved(ObservableList<T> ts, int i, int i1, int i2) {
                    emitter.onNext(ts);
                }

                @Override public void onItemRangeRemoved(ObservableList<T> ts, int i, int i1) {
                    emitter.onNext(ts);
                }
            };
            observableField.addOnListChangedCallback(listener);
            emitter.setCancellation(() -> observableField.removeOnListChangedCallback(listener));
        }, AsyncEmitter.BackpressureMode.BUFFER);
        return objectObservable.replay(1).refCount();
    }
}
