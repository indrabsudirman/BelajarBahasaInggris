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
    private List<EnglishList> albumList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, count;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }


    public MainMenuAdapter(Context mContext, List<EnglishList> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        EnglishList album = albumList.get(position);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfPages() + " hal");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);


    }




    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
