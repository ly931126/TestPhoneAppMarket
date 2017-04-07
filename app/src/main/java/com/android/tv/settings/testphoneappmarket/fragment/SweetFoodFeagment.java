package com.android.tv.settings.testphoneappmarket.fragment;

import com.android.tv.settings.testphoneappmarket.adapter.SweetRecyclerViewAdapter;
import com.android.tv.settings.testphoneappmarket.util.SimpleItemsTouchHelper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by liye on 2017/4/7.
 */

public class SweetFoodFeagment extends Fragment  implements SweetRecyclerViewAdapter.onStartDragListener{
    private static final String TAG=SeaFoodFragment.class.getSimpleName();
    ItemTouchHelper mItemTouchHelper;

    public SweetFoodFeagment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SweetRecyclerViewAdapter adapter=new SweetRecyclerViewAdapter(getActivity(),   this);

        RecyclerView recyclerView= (RecyclerView) view;
        //固定recyclerview的大小
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter( adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        //关联ItemTouchHelper和RecyclerView
        ItemTouchHelper.Callback callback = new SimpleItemsTouchHelper(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
