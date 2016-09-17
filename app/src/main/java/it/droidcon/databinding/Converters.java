package it.droidcon.databinding;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import it.droidcon.databinding.data.TeamScore;

public class Converters {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url)
                .placeholder(R.drawable.loading).into(view);
    }

    @BindingAdapter({"imageUrl", "placeholder"})
    public static void loadImage(ImageView view, String url, Drawable placeholder) {
        Glide.with(view.getContext()).load(url)
                .placeholder(placeholder).into(view);
    }

    @BindingAdapter("visibleOrGone")
    public static void bindVisibleOrGone(View view, boolean b) {
        view.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("visible")
    public static void bindVisible(View view, boolean b) {
        view.setVisibility(b ? View.VISIBLE : View.INVISIBLE);
    }

    @BindingAdapter("android:onClick")
    public static void bindOnClick(View view, final Runnable listener) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.run();
            }
        });
    }

    @BindingConversion
    public static String convertTeamScoreToString(TeamScore score) {
        convertBooleanToVisibility(false);
        return Integer.toString(score.getGoals());
    }

    @BindingConversion
    public static int convertBooleanToVisibility(boolean b) {
        return b ? View.VISIBLE : View.GONE;
    }

    @BindingAdapter("goals")
    public static void bindGoals(TextView view, int goals) {
        view.setText(Integer.toString(goals));
    }
}