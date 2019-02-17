package com.sell.sellkaro.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.sell.sellkaro.activity.SearchForCategoryActivity;
import com.sell.sellkaro.activity.SearchForSingaporeChina;
import com.sell.sellkaro.model.CategoriesModel;
import com.sell.sellkaro.R;
import com.sell.sellkaro.views.CustomTextViewSbold;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by jianghejie on 15/11/26.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<CategoriesModel> alForCategory;
    Context context;

    public void setClickCallBack(ItemClickCallBack clickCallBack) {
        this.clickCallBack = clickCallBack;
    }

    public interface ItemClickCallBack{
        void onItemClick(int pos);
    }

    private ItemClickCallBack clickCallBack;
    Activity activity;
    public CategoryAdapter(Activity activity, Context context, List<CategoriesModel> alForCategory) {
        this.activity = activity;
        this.alForCategory = alForCategory;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_category_list_item,viewGroup,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int position) {

        viewHolder.catName.setText(alForCategory.get(position).getCategory());
//      Picasso.with(activity.getApplicationContext()).load(alForCategory.get(position).getIcon()).into(viewHolder.iv_img);
        Picasso.with(context).load(alForCategory.get(position).getIcon())
                .error(R.drawable.ic_error_loading)
                .placeholder(R.drawable.camera_with_bg)
                .into(viewHolder.iv_img);

        viewHolder.rl_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(alForCategory.get(position).getId().compareTo("4")==0||alForCategory.get(position).getId().compareTo("10")==0) {
                    Intent intent = new Intent(activity, SearchForSingaporeChina.class);
                    intent.putExtra("category_id", alForCategory.get(position).getId());
                    activity.startActivity(intent);
                }else {
                    Intent intent = new Intent(activity, SearchForCategoryActivity.class);
                    intent.putExtra("category_id", alForCategory.get(position).getId());
                    activity.startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return alForCategory.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv_img;
        CustomTextViewSbold catName;
        RelativeLayout rl_main;
        public ViewHolder(View view){
            super(view);
            iv_img = view.findViewById(R.id.imgView);
            catName = view.findViewById(R.id.catName);
            rl_main = view.findViewById(R.id.rl_main);
        }
    }

}





















