package com.sell.sellkaro.model;

import java.util.Date;

public class ProductData {
    String productid,user_id,title,description,item_condition,created_at,timestramp_create,
            item_pic_1;
    int price,totalviews,total_likes;
    boolean is_liked,is_viewed;
    Date date;


    String postedbyuser_id,first_name,last_name,user_name,profile_url,profile_pic,mobile_no,city;
    boolean email_verified;
    boolean mobile_verified;
    int rating,city_id,review_count;

    public ProductData(String productid, String user_id, String title, String description, String item_condition, String created_at, String timestramp_create, String item_pic_1, int price, int totalviews, int total_likes, boolean is_liked, boolean is_viewed, String postedbyuser_id, String first_name, String last_name, String user_name, String profile_url, String profile_pic, String mobile_no, String city, boolean email_verified, boolean mobile_verified, int rating, int city_id, int review_count) {
        this.productid = productid;
        this.user_id = user_id;
        this.title = title;
        this.description = description;
        this.item_condition = item_condition;
        this.created_at = created_at;
        this.timestramp_create = timestramp_create;
        this.item_pic_1 = item_pic_1;
        this.price = price;
        this.totalviews = totalviews;
        this.total_likes = total_likes;
        this.is_liked = is_liked;
        this.is_viewed = is_viewed;
        this.postedbyuser_id = postedbyuser_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.profile_url = profile_url;
        this.profile_pic = profile_pic;
        this.mobile_no = mobile_no;
        this.city = city;
        this.email_verified = email_verified;
        this.mobile_verified = mobile_verified;
        this.rating = rating;
        this.city_id = city_id;
        this.review_count = review_count;

    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem_condition() {
        return item_condition;
    }

    public void setItem_condition(String item_condition) {
        this.item_condition = item_condition;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTimestramp_create() {
        return timestramp_create;
    }

    public void setTimestramp_create(String timestramp_create) {
        this.timestramp_create = timestramp_create;
    }

    public String getItem_pic_1() {
        return item_pic_1;
    }

    public void setItem_pic_1(String item_pic_1) {
        this.item_pic_1 = item_pic_1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalviews() {
        return totalviews;
    }

    public void setTotalviews(int totalviews) {
        this.totalviews = totalviews;
    }

    public int getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(int total_likes) {
        this.total_likes = total_likes;
    }

    public boolean isIs_liked() {
        return is_liked;
    }

    public void setIs_liked(boolean is_liked) {
        this.is_liked = is_liked;
    }

    public boolean isIs_viewed() {
        return is_viewed;
    }

    public void setIs_viewed(boolean is_viewed) {
        this.is_viewed = is_viewed;
    }

    public String getPostedbyuser_id() {
        return postedbyuser_id;
    }

    public void setPostedbyuser_id(String postedbyuser_id) {
        this.postedbyuser_id = postedbyuser_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(boolean email_verified) {
        this.email_verified = email_verified;
    }

    public boolean isMobile_verified() {
        return mobile_verified;
    }

    public void setMobile_verified(boolean mobile_verified) {
        this.mobile_verified = mobile_verified;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getReview_count() {
        return review_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }
}
