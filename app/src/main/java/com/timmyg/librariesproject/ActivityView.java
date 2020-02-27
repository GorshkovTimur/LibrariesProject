package com.timmyg.librariesproject;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface ActivityView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void onRecyclerItemClick(int position);

    @StateStrategyType(value = SkipStrategy.class)
    void updateRecyclerView();

    void setFirstLaunchFalse();

}
