package com.sell.karo.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.curioustechizen.ago.RelativeTimeTextView;

import com.sell.karo.activity.ProductDetailActivity;
import com.sell.karo.model.ProductData;
import com.sell.karo.R;
import com.sell.karo.views.CustomTextViewMregular;
import com.sell.karo.views.CustomTextViewSbold;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jianghejie on 15/11/26.
 */
public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {

    List<ProductData> alForMyPost;
    public Context context;
    Activity activity;
    Typeface face;
    String myuserid;

    public DealsAdapter(Activity activity, Context context, List<ProductData> alForMyPost) {
        this.activity = activity;
        this.context = context;
        this.alForMyPost = alForMyPost;
        face = Typeface.createFromAsset(context.getAssets(),"fonts/ProximaNovaRegular.otf");
        /*SharedPrefrenceManager sharedPrefrenceManager=new SharedPrefrenceManager(context);
        myuserid=sharedPrefrenceManager.getStringData(SharedPrefrenceManager.USER_ID);*/
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_product,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        System.out.println("here 2");

        Picasso.with(context).load(alForMyPost.get(position).getItem_pic_1())
                 .resize(300,300)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(viewHolder.iv_product_img);

        viewHolder.txtPostTime.setTypeface(face);

        viewHolder.txtItemName.setText(alForMyPost.get(position).getTitle());
        viewHolder.txtName.setText(alForMyPost.get(position).getUser_name());
        viewHolder.txtItemCondition.setText(alForMyPost.get(position).getItem_condition());
        viewHolder.txtdescription.setText(alForMyPost.get(position).getDescription());
        viewHolder.txtLikecount.setText(""+alForMyPost.get(position).getTotal_likes());
        DateFormat formatter;
        Date date = null;
        formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            date = (Date) formatter.parse(alForMyPost.get(position).getCreated_at());
        } catch (ParseException e) {
            e.printStackTrace();
        }
      //  viewHolder.txtPostTime.setReferenceTime(date.getTime());
        viewHolder.txtItemPrice.setText("₹ "+alForMyPost.get(position).getPrice());
        viewHolder.txtViewcount.setText("Views "+alForMyPost.get(position).getTotalviews());
        Picasso.with(context).load(alForMyPost.get(position).getProfile_pic())
               // .resize(100,get)
                .error(R.drawable.ic_default_avatar)
                .into(viewHolder.imageview);


        if(!alForMyPost.get(position).isIs_liked()){
            viewHolder.iv_like.setImageResource(R.drawable.ic_grey_heart_outline);
        }else{
            viewHolder.iv_like.setImageResource(R.drawable.ic_red_heart_fill01);
        }
        viewHolder.likelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!alForMyPost.get(position).isIs_liked()){
                   // likePost(alForMyPost.get(position).getProductid(),myuserid,true,"",viewHolder,position);
                }
            }
        });

        viewHolder.layoutShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //share
                share();
            }
        });

        viewHolder.txtLikecount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!alForMyPost.get(position).isIs_liked()){
                    //likePost("1","1",true,"",viewHolder,position);
                }
            }
        });


        viewHolder.itemdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ProductDetailActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("type",6);
                activity.startActivity(intent);
            }
        });

        viewHolder.toplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ProductDetailActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("type",6);
                activity.startActivity(intent);
            }
        });

        viewHolder.iv_product_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ProductDetailActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("type",6);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return alForMyPost.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView iv_product_img,iv_like;
        CustomTextViewSbold txtName,txtItemName;
        CustomTextViewMregular txtLikecount,txtItemPrice
                ,txtItemCondition,txtViewcount,txtdescription;
        RelativeTimeTextView txtPostTime;
        RelativeLayout cv_main;
        CircleImageView imageview;
        LinearLayout likelayout;
        RelativeLayout layoutShare;
        LinearLayout toplayout,itemdetails;

        public ViewHolder(View view){
            super(view);
            iv_product_img = view.findViewById(R.id.imgView);
            iv_like = view.findViewById(R.id.likeicon);
            txtItemName = view.findViewById(R.id.itemname);
            txtItemPrice = view.findViewById(R.id.price);
            txtItemCondition = view.findViewById(R.id.condition);
            txtName = view.findViewById(R.id.username);
            txtPostTime = view.findViewById(R.id.posteddate);
            txtdescription = view.findViewById(R.id.description);
            txtLikecount = view.findViewById(R.id.likeCount);
            cv_main = view.findViewById(R.id.mainlayout);
            imageview = view.findViewById(R.id.image);
            txtViewcount = view.findViewById(R.id.viewCount);
            likelayout = view.findViewById(R.id.likelayout);
            layoutShare = view.findViewById(R.id.layoutShare);
            toplayout = view.findViewById(R.id.toplayout);
            itemdetails = view.findViewById(R.id.itemdetails);


        }
    }

   /* public void likePost(String productId, String user_id, boolean like, String comment, final ViewHolder viewHolder, final int pos){
        try {

            JSONObject parameters = new JSONObject();
            parameters.put("product_id",productId);
            parameters.put("user_id",user_id);
            parameters.put("like",like);
            parameters.put("comment",comment);

            JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, StaticValues.LIKE_COMMENT , parameters,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                                if(response.getBoolean("status")){
                                   int count = alForMyPost.get(pos).getTotal_likes();
                                    viewHolder.txtLikecount.setText(String.valueOf(count+1));
                                    notifyDataSetChanged();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println("sign up res- 111--" +error.getMessage());
                    Toast.makeText(activity, "", Toast.LENGTH_SHORT).show();

                }
            })
            {
//                @Override
//                public Map<String, String> getHeaders() throws AuthFailureError {
//                    HashMap<String, String> headers = new HashMap<String, String>();
//                    headers.put("Authorization", getString(R.string.restapi_key));
//                    headers.put("Content-Type", "application/json");
//                    return headers;
//                }
            };
            ApplicationClass.getInstance().addToRequestQueue(req);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public void share(){
        int applicationNameId = activity.getApplicationInfo().labelRes;
        final String appPackageName = activity.getApplicationContext().getPackageName();
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, activity.getString(applicationNameId));
        String text = "Download Sellkaro";
        String link = "https://play.google.com/store/apps/details?id=" + appPackageName;
        i.putExtra(Intent.EXTRA_TEXT, text + " " + link);
        activity.startActivity(Intent.createChooser(i, "Share"));
    }


}

