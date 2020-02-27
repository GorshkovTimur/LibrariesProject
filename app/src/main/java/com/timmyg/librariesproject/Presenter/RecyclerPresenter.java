package com.timmyg.librariesproject.presenter;

import com.timmyg.librariesproject.IViewHolder;

public interface RecyclerPresenter {
    void bindView(IViewHolder viewHolder);
    int getItemCount();
}
