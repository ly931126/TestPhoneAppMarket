package com.android.tv.settings.testphoneappmarket;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tv.settings.testphoneappmarket.fragment.FruitFoodFragment;
import com.android.tv.settings.testphoneappmarket.fragment.SeaFoodFragment;
import com.android.tv.settings.testphoneappmarket.fragment.SoupFoodFeagment;
import com.android.tv.settings.testphoneappmarket.fragment.SweetFoodFeagment;
import com.android.tv.settings.testphoneappmarket.fragment.VegetablesFragment;
import com.android.tv.settings.testphoneappmarket.util.ImageLoaderHelper;
import com.jorge.circlelibrary.ImageCycleView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {
	private static final String	TAG	= MainActivity.class.getSimpleName();
	@BindView(R.id.cycleView)
	ImageCycleView				mCycleView;
	@BindView(R.id.sea_food_icon)
	ImageView					mSeaFoodIcon;
	@BindView(R.id.sea_food_kind)
	TextView					mSeaFoodKind;
	@BindView(R.id.sea_food_tab)
	RelativeLayout				mSeaFoodTab;
	@BindView(R.id.fruit_food_icon)
	ImageView					mFruitFoodIcon;
	@BindView(R.id.fruit_food_kind)
	TextView					mFruitFoodKind;
	@BindView(R.id.fruit_food_tab)
	RelativeLayout				mFruitFoodTab;
	@BindView(R.id.vegetables_food_icon)
	ImageView					mVegetablesFoodIcon;
	@BindView(R.id.veges_food_kind)
	TextView					mVegesFoodKind;
	@BindView(R.id.vegetables_food_tab)
	RelativeLayout				mVegetablesFoodTab;
	@BindView(R.id.sweet_food_icon)
	ImageView					mSweetFoodIcon;
	@BindView(R.id.sweet_food_kind)
	TextView					mSweetFoodKind;
	@BindView(R.id.sweet_food_tab)
	RelativeLayout				mSweetFoodTab;
	@BindView(R.id.soup_food_icon)
	ImageView					mSoupFoodIcon;
	@BindView(R.id.soup_food_kind)
	TextView					mSoupFoodKind;
	@BindView(R.id.soup_food_tab)
	RelativeLayout				mSoupFoodTab;
	
	private ImageLoader			mImageLoader;
	
	// 底部标签切换的Fragment
	private Fragment			mSeaFoodFragment, mFruitFragment, mVegetablesFragment, mSweetFragment, mSoupFragment, currentFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		initData();
		initTab();
	}
	
	private void initData() {
		mCycleView.setCycle_T(ImageCycleView.CYCLE_T.CYCLE_VIEW_NORMAL);
		/** 装在数据的集合 文字描述 */
		ArrayList<String> imageDescList = new ArrayList<>();
		/** 装在数据的集合 图片地址 */
		ArrayList<String> urlList = new ArrayList<>();
		
		/** 添加数据 */
		urlList.add("http://pic.sc.chinaz.com/files/pic/pic9/201703/bpic685.jpg");
		urlList.add(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489054326&di=a0048b47c63a386e2820bc7ed2083000&imgtype=0&src=http%3A%2F%2Fimg01.taopic.com%2F141120%2F235109-1411200RZ118.jpg");
		urlList.add(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489112002&di=950d9f7d59bbb54161e8d53d1b9bc3f4&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F1%2Fd%2F160.jpg");
		urlList.add(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489172386&di=de8b3e47b52377fa5b5eae40c69e4996&imgtype=0&src=http%3A%2F%2Fimg1.qunarzz.com%2Ftravel%2Fd2%2F1508%2F20%2Ffe351ebdb1b464.jpg");
		urlList.add(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1491489426822&di=d4441b33d08b4bc3317437cb7d908b39&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fnuomi%2Fwh%3D470%2C285%2Fsign%3Db0665bcf09d162d985bb6a1826ef85de%2F7c1ed21b0ef41bd51f00fdff52da81cb39db3d6d.jpg");
		
		imageDescList.add("野果");
		imageDescList.add("排骨");
		imageDescList.add("冰淇淋");
		imageDescList.add("甜品");
		imageDescList.add("牛肉面");
		initCarsuelView(imageDescList, urlList);
	}
	
	/**
	 * 初始化轮播图
	 */
	public void initCarsuelView(ArrayList<String> imageDescList, ArrayList<String> urlList) {
		ImageCycleView.ImageCycleViewListener mAdCycleViewListener = new ImageCycleView.ImageCycleViewListener() {
			@Override
			public void onImageClick(int position, View imageView) {
				/** 实现点击事件 */
				Toast.makeText(MainActivity.this, "position=" + position, Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void displayImage(String imageURL, ImageView imageView) {
				/** 在此方法中，显示图片，可以用自己的图片加载库，也可以用本demo中的（Imageloader） */
				mImageLoader = ImageLoader.getInstance();
				mImageLoader.init(ImageLoaderConfiguration.createDefault(MainActivity.this));
				ImageLoaderHelper.getInstance().loadImage(imageURL, imageView);
				
			}
		};
		mCycleView.pushImageCycle();
		/** 设置数据 */
		mCycleView.setImageResources(imageDescList, urlList, mAdCycleViewListener);
		// 是否隐藏底部
		mCycleView.hideBottom(false);
		mCycleView.startImageCycle();
	}
	
	/**
	 * 初始化底部标签
	 */
	private void initTab() {
		if (mSeaFoodFragment == null) {
			mSeaFoodFragment = new SeaFoodFragment();
		}
		//
		if (!mSeaFoodFragment.isAdded()) {
			// 提交事务
			getSupportFragmentManager().beginTransaction().add(R.id.content_layout, mSeaFoodFragment).commit();
			
			// 记录当前Fragment
			currentFragment = mSeaFoodFragment;
			// 设置图片文本的变化
			mSeaFoodKind.setTextColor(getResources().getColor(R.color.red));
			mFruitFoodKind.setTextColor(getResources().getColor(R.color.blue));
			mVegesFoodKind.setTextColor(getResources().getColor(R.color.blue));
			mSweetFoodKind.setTextColor(getResources().getColor(R.color.blue));
			mSoupFoodKind.setTextColor(getResources().getColor(R.color.blue));
		}
		
	}
	
	/**
	 * 点击第一个tab
	 */
	private void clickTab1Layout() {
		if (mSeaFoodFragment == null) {
			mSeaFoodFragment = new SeaFoodFragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mSeaFoodFragment);
		
		// 设置底部tab变化
		mSeaFoodKind.setTextColor(getResources().getColor(R.color.red));
		mFruitFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mVegesFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSweetFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSoupFoodKind.setTextColor(getResources().getColor(R.color.blue));
	}
	
	/**
	 * 点击第二个tab
	 */
	private void clickTab2Layout() {
		if (mFruitFragment == null) {
			mFruitFragment = new FruitFoodFragment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mFruitFragment);
		
		mSeaFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mFruitFoodKind.setTextColor(getResources().getColor(R.color.red));
		mVegesFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSweetFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSoupFoodKind.setTextColor(getResources().getColor(R.color.blue));
		
	}
	
	/**
	 * 点击第三个tab
	 */
	private void clickTab3Layout() {
		if (mVegetablesFragment == null) {
			mVegetablesFragment = new VegetablesFragment();
		}
		
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mVegetablesFragment);
		mSeaFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mFruitFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mVegesFoodKind.setTextColor(getResources().getColor(R.color.red));
		mSweetFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSoupFoodKind.setTextColor(getResources().getColor(R.color.blue));
		
	}
	
	private void clickTab4Layout() {
		if (mSweetFragment == null) {
			mSweetFragment = new SweetFoodFeagment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mSweetFragment);
		mSeaFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mFruitFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mVegesFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSweetFoodKind.setTextColor(getResources().getColor(R.color.red));
		mSoupFoodKind.setTextColor(getResources().getColor(R.color.blue));
	}
	
	private void clickTab5Layout() {
		if (mSoupFragment == null) {
			mSoupFragment = new SoupFoodFeagment();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), mSoupFragment);
		mSeaFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mFruitFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mVegesFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSweetFoodKind.setTextColor(getResources().getColor(R.color.blue));
		mSoupFoodKind.setTextColor(getResources().getColor(R.color.red));
	}
	/**
	 * 添加或者显示碎片
	 *
	 * @param transaction
	 * @param fragment
	 */
	private void addOrShowFragment(FragmentTransaction transaction, Fragment fragment) {
		if (currentFragment == fragment)
			return;
		
		if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
			transaction.hide(currentFragment).add(R.id.content_layout, fragment).commit();
		} else {
			transaction.hide(currentFragment).show(fragment).commit();
		}
		
		currentFragment = fragment;
	}
	
	@OnClick({R.id.sea_food_tab, R.id.fruit_food_tab, R.id.vegetables_food_tab, R.id.sweet_food_tab, R.id.soup_food_tab})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.sea_food_tab : // 知道
				clickTab1Layout();
				break;
			case R.id.fruit_food_tab : // 我想知道
				clickTab2Layout();
				break;
			case R.id.vegetables_food_tab : // 我的
				clickTab3Layout();
				break;
			case R.id.sweet_food_tab :// 甜品
				clickTab4Layout();
				break;
			case R.id.soup_food_tab :// 汤
				clickTab5Layout();
				break;
			default :
				break;
		}
	}
	
	public interface MyTouchListener {
		public void onTouchEvent(MotionEvent event);
	}
	
	// 保存MyTouchListener接口的列表
	private ArrayList<MyTouchListener> myTouchListeners = new ArrayList<MyTouchListener>();
	
	/**
	 * 提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法
	 * 
	 * @param listener
	 */
	public void registerMyTouchListener(MyTouchListener listener) {
		myTouchListeners.add(listener);
	}
	
	/**
	 * 提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法
	 * 
	 * @param listener
	 */
	public void unRegisterMyTouchListener(MyTouchListener listener) {
		myTouchListeners.remove(listener);
	}
	
	/**
	 * 分发触摸事件给所有注册了MyTouchListener的接口
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		for (MyTouchListener listener : myTouchListeners) {
			listener.onTouchEvent(ev);
		}
		return super.dispatchTouchEvent(ev);
	}
}
