package com.timmyg.librariesproject.Presenter;

import com.timmyg.librariesproject.IViewHolder;

public interface RecyclerPresenter {
    void bindView(IViewHolder viewHolder);
    int getItemCount();
}
