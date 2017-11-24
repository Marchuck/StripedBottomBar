# StripedBottomBar

Inspired by 'BottomBar' fork with stripes feature:

<img src="https://github.com/Marchuck/StripedBottomBar/blob/master/images/bottom_bar_stripes.gif" width="30%" />


# setup 

```
final ToggleVisibilityCallback animation = new StripeAnimation(); //custom stripe start | end animation

final int tabCount = bottomBar.getTabCount();

for (int i = 0; i < tabCount; i++) {
  StripedBottomBarTab tab = bottomBar.getTabAtPosition(i);
  
  //determine stripe color. This also can be done via 'stripeColor' property via xml <tabs> definition
  tab.setStripeViewColor(getResources().getColor(R.color.colorPrimary));
  tab.setStripeViewEnabled(true); 
  tab.setCustomStripeAnimation(animation);
}
//basic 
bottomBar.setOnTabSelectListener(tabId -> { //your code here });
bottomBar.setOnTabReselectListener(tabId -> { //your code here });
bottomBar.setBadgesHideWhenActive(true);
bottomBar.setDefaultTab(R.id.tab_home);

...
class StripeAnimation implements ToggleVisibilityCallback {

    @Override
    public void onVisibleStart(View view) {
        view.setScaleX(0);
        ViewCompat.animate(view)
                .setDuration(200)
                .scaleX(1f)
                .setInterpolator(new AccelerateInterpolator())
                .start();
    }

    @Override
    public void onVisibleEnd(View stripeView) {

    }
}
```

# installation

add to your `build.gradle`

```implementation 'com.github.Marchuck:StripedBottomBar:v1.0'```


# license

```

StripedBottomBar library for Android
Copyright (c) 2017 Łukasz Marczak (http://github.com/Marchuck).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
