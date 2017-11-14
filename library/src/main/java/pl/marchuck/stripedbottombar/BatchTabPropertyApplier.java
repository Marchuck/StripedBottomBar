package pl.marchuck.stripedbottombar;

import android.support.annotation.NonNull;

class BatchTabPropertyApplier {
    private final StripedBottomBar stripedBottomBar;

    interface TabPropertyUpdater {
        void update(StripedBottomBarTab tab);
    }

    BatchTabPropertyApplier(@NonNull StripedBottomBar stripedBottomBar) {
        this.stripedBottomBar = stripedBottomBar;
    }

    void applyToAllTabs(@NonNull TabPropertyUpdater propertyUpdater) {
        int tabCount = stripedBottomBar.getTabCount();

        if (tabCount > 0) {
            for (int i = 0; i < tabCount; i++) {
                StripedBottomBarTab tab = stripedBottomBar.getTabAtPosition(i);
                propertyUpdater.update(tab);
            }
        }
    }
}
