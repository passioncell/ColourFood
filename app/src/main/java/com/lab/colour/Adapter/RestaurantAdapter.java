package com.lab.colour.Adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lab.colour.Model.Restaurant;
import com.lab.colour.R;

import java.util.Vector;

/**
 * Created by SeoHyeonBae on 2016-09-19.
 */
public class RestaurantAdapter extends BaseAdapter {

    private Context mContext = null;
    private Vector<Restaurant> restaurants = new Vector<>();
    CustomHolder holder;
    int nowPosition;

    public RestaurantAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurants.get(position);
    }

    @Override
    public long getItemId(int position) {
        return restaurants.get(position).getPrimaryKey();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        holder  = null;

        // 캐시된 뷰가 없을 경우 새로 생성하고 뷰홀더를 생성한다
        if ( convertView == null ) {
            // view가 null일 경우 커스텀 레이아웃을 얻어 옴
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listitem_rec, null);

            holder = new CustomHolder();
            holder.holder_image = (ImageView) convertView.findViewById(R.id.iv_list_image);
            holder.holder_rating_bar =(AppCompatRatingBar) convertView.findViewById(R.id.rb_list);
            holder.holder_rating = (TextView) convertView.findViewById(R.id.tv_list_rating);
            holder.holder_restaurant_name = (TextView) convertView.findViewById(R.id.tv_list_restaurant_name);
            holder.holder_address = (TextView) convertView.findViewById(R.id.tv_list_address);
            holder.holder_review_cnt = (TextView) convertView.findViewById(R.id.tv_list_review_cnt);
            holder.holder_distance = (TextView) convertView.findViewById(R.id.tv_list_distance);

            //like
            holder.holder_like = (ImageButton) convertView.findViewById(R.id.ib_list_like);
            holder.holder_like.setBackground(mContext.getDrawable(R.drawable.icon_heart_off));
            holder.holder_like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    restaurants.get(position).setLike(true);
                    notifyDataSetChanged();
                }
            });

            holder.holder_rating_bar.setStepSize((float) 0.5);        //별 색깔이 1칸씩줄어들고 늘어남 0.5로하면 반칸씩 들어감
            holder.holder_rating_bar.setRating((float) 2.5);      // 처음보여줄때(색깔이 한개도없음) default 값이 0  이다
            holder.holder_rating_bar.setIsIndicator(true);           //true - 별점만 표시 사용자가 변경 불가 , false - 사용자가 변경가능


            convertView.setTag(holder);

        }else{  // 캐시된 뷰가 있을 경우 저장된 뷰홀더를 사용한다
            holder = (CustomHolder) convertView.getTag();
        }

        //이제 데이터 씌우는 작업.
        //이미지
        String url = restaurants.get(position).getImageURL();
        Glide.with(mContext).load(url).centerCrop().placeholder(R.drawable.sample_food_3).crossFade().into(holder.holder_image);
        holder.holder_rating_bar.setRating(restaurants.get(position).getRating());
        holder.holder_rating.setText(String.valueOf(restaurants.get(position).getRating()));
        holder.holder_restaurant_name.setText(restaurants.get(position).getRestaurantName());
        holder.holder_address.setText(restaurants.get(position).getAddress());
        holder.holder_review_cnt.setText(String.valueOf(restaurants.get(position).getReviewCnt()));
        holder.holder_distance.setText(String.valueOf(restaurants.get(position).getDistance())+"km");

        if(restaurants.get(position).isLike){
            holder.holder_like.setBackground(mContext.getDrawable(R.drawable.icon_heart_on));
        }

        nowPosition = position;


        return convertView;
    }



    //View Model Holder
    private class CustomHolder {
        ImageView holder_image;
        AppCompatRatingBar holder_rating_bar;
        TextView holder_rating;
        TextView holder_restaurant_name;
        TextView holder_address;
        TextView holder_review_cnt;
        TextView holder_distance;
        ImageButton holder_like;
    }

    // 외부에서 아이템 추가 요청 시 사용
    public void addItem(Restaurant restaurant){
        restaurants.add(restaurant);
    }

}
