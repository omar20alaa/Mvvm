package com.mvvm.mvvm.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mvvm.mvvm.Model.MainModel;
import com.mvvm.mvvm.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    // vars
    private Context context;
    private List<MainModel> mainModels ;


    public MainAdapter(Context context, List<MainModel> mainModels) {
        this.context = context;
        this.mainModels = mainModels;
    } // constructor


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_android);
        requestOptions.error(R.drawable.ic_android);


        holder.tv_title.setText(mainModels.get(position).getTitle());


        Glide.with(context)
                .setDefaultRequestOptions(requestOptions)
                .load(mainModels.get(position).getImageUrl())
                .into(holder.imageProfile);

    }

    @Override
    public int getItemCount() {

        Log.e("QP", "arraysize : " + mainModels.size());
        return mainModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imageProfile;

        TextView tv_title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            imageProfile = itemView.findViewById(R.id.imageProfile);
            ButterKnife.bind(context, itemView);
        }
    }
}
