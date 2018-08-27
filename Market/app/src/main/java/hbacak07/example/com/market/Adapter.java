package hbacak07.example.com.market;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private Context context;
    private List<Item> item_list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView isim, fiyat;
        public ImageView resim;

        public MyViewHolder(View view) {
            super(view);
            isim = view.findViewById(R.id.title);
            fiyat = view.findViewById(R.id.price);
            resim = view.findViewById(R.id.thumbnail);
        }
    }


    public Adapter(Context context, List<Item> list) {
        this.context = context;
        this.item_list = list;
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder myViewHolder, int position) {
        final Item item = item_list.get(position);
        myViewHolder.isim.setText(item.getBaslik());
        myViewHolder.fiyat.setText(item.getFiyat());

        Glide.with(context)
                .load(item.getResim())
                .into(myViewHolder.resim);
    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }
}
