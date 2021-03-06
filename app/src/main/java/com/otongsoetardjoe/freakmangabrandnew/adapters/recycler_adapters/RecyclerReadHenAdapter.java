package com.otongsoetardjoe.freakmangabrandnew.adapters.recycler_adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otongsoetardjoe.freakmangabrandnew.R;
import com.otongsoetardjoe.freakmangabrandnew.databinding.ItemListMangaContentBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerReadHenAdapter extends RecyclerView.Adapter<RecyclerReadHenAdapter.ViewHolder> {
    private Context context;
    private List<String> imageContent;

    public RecyclerReadHenAdapter(Context context, List<String> imageContent) {
        this.context = context;
        this.imageContent = imageContent;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemListMangaContentBinding itemListBinding = ItemListMangaContentBinding.inflate(layoutInflater);
        return new ViewHolder(itemListBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get()
                .load(imageContent.get(position))
                .placeholder(context.getResources().getDrawable(R.drawable.imageplaceholder))
                .error(context.getResources().getDrawable(R.drawable.error))
                .into(holder.itemListBinding.imageMangaContentItem);
    }

    @Override
    public int getItemCount() {
        return imageContent.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemListMangaContentBinding itemListBinding;

        public ViewHolder(final ItemListMangaContentBinding itemView) {
            super(itemView.getRoot());
            this.itemListBinding = itemView;
        }

    }
}
