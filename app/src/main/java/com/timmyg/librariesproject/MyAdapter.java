package com.timmyg.librariesproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.timmyg.librariesproject.model.picasso.PicassoLoader;
import com.timmyg.librariesproject.presenter.RecyclerPresenter;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private RecyclerPresenter recyclerPresenter;
    private onRecyclerItemClickListener onRecyclerItemClickListener;
    private PicassoLoader picassoLoader;

    public MyAdapter(RecyclerPresenter recyclerPresenter, onRecyclerItemClickListener onRecyclerItemClickListener) {
        this.recyclerPresenter = recyclerPresenter;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
        picassoLoader = new PicassoLoader();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v, onRecyclerItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.position = position;
    recyclerPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return recyclerPresenter.getItemCount();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder, View.OnClickListener {

        private ImageView imageView;
        private int position = 0;
        onRecyclerItemClickListener onRecyclerItemClickListener;


        public MyViewHolder(@NonNull View itemView, onRecyclerItemClickListener listener) {
            super(itemView);
            this.onRecyclerItemClickListener = listener;
            imageView = itemView.findViewById(R.id.item_image_view);
            itemView.setOnClickListener(this);

        }

        @Override
        public void setImage(String url) {
            picassoLoader.loadImage(url, imageView);
        }

        @Override
        public int getPos() {
            return position;
        }


        @Override
        public void onClick(View view) {
            onRecyclerItemClickListener.onRecyclerItemClick(getAdapterPosition());
        }
    }

    public interface onRecyclerItemClickListener{
        void onRecyclerItemClick(int position);
    }



}
