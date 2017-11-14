package pl.marchuck.stripedbottombar;

import android.view.View;

public interface ToggleVisibilityCallback {

    void onVisibleStart(View stripeView);

    void onVisibleEnd(View stripeView);
}
