package com.android.tv.settings.testphoneappmarket.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.tv.settings.testphoneappmarket.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liye on 2017/4/7.
 */

public class VegetablesFragment extends Fragment {
	private static final String	TAG		= VegetablesFragment.class.getSimpleName();
	@BindView(R.id.vegetables_picture)
	ImageView					mVegetablesPicture;
	
	private View				mView	= null;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.layout_fragment_vegetables_food, container, false);
		ButterKnife.bind(this, mView);
		initView();
		return mView;
	}

	private void initView() {
		//设置ImageView的背景为帧动画布局文件
		mVegetablesPicture.setBackgroundResource(R.drawable.frame_animator);
		AnimationDrawable frameAnimation = (AnimationDrawable) mVegetablesPicture.getBackground();
//开启帧动画
		frameAnimation.start();
	}
}
