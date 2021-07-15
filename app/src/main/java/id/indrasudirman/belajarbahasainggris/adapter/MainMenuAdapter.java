package id.indrasudirman.belajarbahasainggris.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import id.indrasudirman.belajarbahasainggris.R;
import id.indrasudirman.belajarbahasainggris.model.EnglishList;



public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MyViewHolder> {

    private Context mContext;
    private List<EnglishList> english;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            count = view.findViewById(R.id.count);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }


    public MainMenuAdapter(Context mContext, List<EnglishList> english) {
        this.mContext = mContext;
        this.english = english;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_card_test, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        EnglishList englishList = english.get(position);
        holder.title.setText(englishList.getName());
        holder.count.setText(englishList.getNumOfPages() + " hal");

        // loading englishList cover using Glide library
        Glide.with(mContext).load(englishList.getThumbnail()).into(holder.thumbnail);


    }




    @Override
    public int getItemCount() {
        return english.size();
    }
}
