package id.indrasudirman.belajarbahasainggris.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.model.EnglishList;

public class EnglishListAdapter extends RecyclerView.Adapter <EnglishListAdapter.MyViewHolder> {

    private Context context;
    private List<EnglishList> englishLists;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public AppCompatTextView title, count;
        public AppCompatImageView thumbnail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            count = itemView.findViewById(R.id.count);
            thumbnail = itemView.findViewById(R.id.thumbnail);
        }
    }

    public EnglishListAdapter (Context context, List <EnglishList> englishLists) {
        this.context = context;
        this.englishLists = englishLists;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.english_card, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        EnglishList englishList = englishLists.get(position);
        holder.title.setText(englishList.getName());
        holder.count.setText(englishList.getNumOfPages() + " pages");

        //Loading EnglishList cover using Glide library
        Glide.with(context).load(englishList.getThumbnail()).into(holder.thumbnail);

    }



    @Override
    public int getItemCount() {
        return englishLists.size();
    }
}
