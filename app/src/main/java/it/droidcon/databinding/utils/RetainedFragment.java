package it.droidcon.databinding.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class RetainedFragment<T> extends Fragment {

    public static final String TAG = "retained";
    private T obj;

    public RetainedFragment() {
        setRetainInstance(true);
    }

    public static <T> T get(FragmentManager fragmentManager) {
        RetainedFragment<T> retained = getFragment(fragmentManager);
        if (retained != null) {
            return retained.obj;
        } else {
            return null;
        }
    }

    public static <T> void save(FragmentManager fragmentManager, T obj) {
        RetainedFragment<T> fragment = new RetainedFragment<>();
        fragment.obj = obj;
        fragmentManager.beginTransaction().add(fragment, TAG).commit();
    }

    private static <T> RetainedFragment<T> getFragment(FragmentManager fragmentManager) {
        return (RetainedFragment<T>) fragmentManager.findFragmentByTag(TAG);
    }
}
