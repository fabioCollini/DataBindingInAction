package it.droidcon.databinding;

import android.databinding.Observable;
import android.databinding.Observable.OnPropertyChangedCallback;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import java.util.List;
import rx.AsyncEmitter;

public class RxDataBinding {
    public static rx.Observable<Boolean> toRx(ObservableBoolean observableBoolean) {
        return rx.Observable.fromEmitter(emitter -> {
            emitter.onNext(observableBoolean.get());
            OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    emitter.onNext(((ObservableBoolean) observable).get());
                }
            };
            observableBoolean.addOnPropertyChangedCallback(callback);
            emitter.setCancellation(() -> observableBoolean.removeOnPropertyChangedCallback(callback));
        }, AsyncEmitter.BackpressureMode.BUFFER);
    }

    public static rx.Observable<Integer> toRx(ObservableInt observableInt) {
        return rx.Observable.fromEmitter(emitter -> {
            emitter.onNext(observableInt.get());
            OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    emitter.onNext(((ObservableInt) observable).get());
                }
            };
            observableInt.addOnPropertyChangedCallback(callback);
            emitter.setCancellation(() -> observableInt.removeOnPropertyChangedCallback(callback));
        }, AsyncEmitter.BackpressureMode.BUFFER);
    }

    public static <T> rx.Observable<T> toRx(ObservableField<T> observableField) {
        return rx.Observable.fromEmitter(emitter -> {
            emitter.onNext(observableField.get());
            OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
                @Override
                public void onPropertyChanged(Observable observable, int i) {
                    emitter.onNext(((ObservableField<T>) observable).get());
                }
            };
            observableField.addOnPropertyChangedCallback(callback);
            emitter.setCancellation(() -> observableField.removeOnPropertyChangedCallback(callback));
        }, AsyncEmitter.BackpressureMode.BUFFER);
    }

    public static <T> rx.Observable<List<T>> toRx(ObservableArrayList<T> observableField) {
        return rx.Observable.fromEmitter(emitter -> {
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
    }
}
