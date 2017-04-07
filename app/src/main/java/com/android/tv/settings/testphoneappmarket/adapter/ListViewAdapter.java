package com.android.tv.settings.testphoneappmarket.adapter;

import com.android.tv.settings.testphoneappmarket.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by liye on 2017/4/6.
 */

public class ListViewAdapter extends BaseAdapter {
	private static final String	TAG			= ListViewAdapter.class.getSimpleName();
	private Context				mContext	= null;
	private String mStringList[]	= new String[]{"红焖大虾", "红烧鳗鱼", "海鲜拼盘", "海底世界" };
	private int  mSeaFoodIcon[]={R.drawable.sea_food_one,R.drawable.sea_food_two,R.drawable.sea_food_three,R.drawable.sea_food_four};
	private String mPrice[]={"100$","120$","200$","80$"};
	public ListViewAdapter(Context context) {
		this.mContext = context;
	}
	@Override
	public int getCount() {
		return mStringList==null?0:mStringList.length;
	}
	
	@Override
	public Object getItem(int position) {
		return mStringList==null?null:mStringList[position];
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			holder=new ViewHolder();
			convertView= LayoutInflater.from(mContext).inflate(R.layout.item_listview,null);
			holder.mFoodIcon= (ImageView) convertView.findViewById(R.id.food_icon);
			holder.mFoodStar= (RatingBar) convertView.findViewById(R.id.food_star);
			holder.mFoodName= (TextView) convertView.findViewById(R.id.food_name);
			holder.mFoodPrice= (TextView) convertView.findViewById(R.id.food_price);
			convertView.setTag(holder);
		}else{
			holder= (ViewHolder) convertView.getTag();
		}
		holder.mFoodIcon.setImageResource(mSeaFoodIcon[position]);
		holder.mFoodName.setText(mStringList[position]);
		holder.mFoodStar.setRating(5);
		holder.mFoodPrice.setText(mPrice[position]);
		return convertView;
	}
	static class ViewHolder {
		public ImageView	mFoodIcon	= null;
		public RatingBar	mFoodStar	= null;
		public TextView		mFoodName	= null;
		public TextView		mFoodPrice	= null;
	}
}
