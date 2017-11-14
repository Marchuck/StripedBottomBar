package pl.marchuck.stripedbottombar;

/**
 * Settings specific for a shy BottomBar.
 */
public class ShySettings {
    private StripedBottomBar stripedBottomBar;
    private Boolean pendingIsVisibleInShyMode;

    ShySettings(StripedBottomBar stripedBottomBar) {
        this.stripedBottomBar = stripedBottomBar;
    }

    void shyHeightCalculated() {
        updatePendingShyVisibility();
    }

    /**
     * Shows the BottomBar if it was hidden, with a translate animation.
     */
    public void showBar() {
        toggleIsVisibleInShyMode(true);
    }

    /**
     * Hides the BottomBar in if it was visible, with a translate animation.
     */
    public void hideBar() {
        toggleIsVisibleInShyMode(false);
    }

    private void toggleIsVisibleInShyMode(boolean visible) {
        if (!stripedBottomBar.isShy()) {
            return;
        }

        if (stripedBottomBar.isShyHeightAlreadyCalculated()) {
            BottomNavigationBehavior<StripedBottomBar> behavior = BottomNavigationBehavior.from(stripedBottomBar);

            if (behavior != null) {
                boolean isHidden = !visible;
                behavior.setHidden(stripedBottomBar, isHidden);
            }
        } else {
            pendingIsVisibleInShyMode = true;
        }
    }

    private void updatePendingShyVisibility() {
        if (pendingIsVisibleInShyMode != null) {
            toggleIsVisibleInShyMode(pendingIsVisibleInShyMode);
            pendingIsVisibleInShyMode = null;
        }
    }
}
