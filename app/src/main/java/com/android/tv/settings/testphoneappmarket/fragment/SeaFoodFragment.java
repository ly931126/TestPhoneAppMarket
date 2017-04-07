package com.android.tv.settings.testphoneappmarket.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.tv.settings.testphoneappmarket.R;
import com.android.tv.settings.testphoneappmarket.adapter.ListViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liye on 2017/4/7.
 */

public class SeaFoodFragment extends Fragment {
	private static final String	TAG		= SeaFoodFragment.class.getSimpleName();
	@BindView(R.id.listView)
	ListView					mListView;
	private ListViewAdapter		mAdapter	= null;
	private View				mView	= null;
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mView = inflater.inflate(R.layout.layout_fragment_sea_food, container, false);
		ButterKnife.bind(this, mView);
		initListView();
		return mView;
	}
	private void initListView() {
		mAdapter = new ListViewAdapter(getActivity());
		mListView.setAdapter(mAdapter);
	}
}
