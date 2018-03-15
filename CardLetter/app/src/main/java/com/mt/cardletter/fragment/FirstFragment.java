package com.mt.cardletter.fragment;


import android.os.Bundle;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.GoodActivity;
import com.mt.cardletter.view.exchange.FoodAdapter;
import com.mt.cardletter.view.exchange.ListContainer;
import com.mt.cardletter.view.exchange.TypeAdapter;
import com.shizhefei.fragment.LazyFragment;


public class FirstFragment extends LazyFragment {

	private ListContainer listContainer;

	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_first);
		listContainer = (ListContainer) findViewById(R.id.listcontainer);
		listContainer.setAddClick((GoodActivity) getActivity());
	}

	public FoodAdapter getFoodAdapter() {
		return listContainer.foodAdapter;
	}

	public TypeAdapter getTypeAdapter() {
		return listContainer.typeAdapter;
	}

}
