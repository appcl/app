package com.mt.cardletter.view.exchange;


import android.content.Context;

import com.mt.cardletter.entity.food.CommentBean;
import com.mt.cardletter.entity.food.FoodBean;
import com.mt.cardletter.entity.food.TypeBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseUtils {
	public static List<TypeBean> getTypes() {
		ArrayList<TypeBean> tList = new ArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			TypeBean typeBean = new TypeBean();
//			typeBean.setName("话费" + i);
//			tList.add(typeBean);
//		}
		TypeBean typeBean1 = new TypeBean();
		typeBean1.setName("话费");
		tList.add(typeBean1);
		TypeBean typeBean2 = new TypeBean();
		typeBean2.setName("加油卡");
		tList.add(typeBean2);
		return tList;
	}

	public static List<FoodBean> getDatas(Context context) {
		ArrayList<FoodBean> fList = new ArrayList<>();
		FoodBean foodBean = new FoodBean();
		foodBean.setId(0);
		foodBean.setName("10元话费");
		foodBean.setPrice(BigDecimal.valueOf(100));
		foodBean.setJf(100);
		foodBean.setSale("月售" + new Random().nextInt(100));
		foodBean.setType("话费");
		int resID = context.getResources().getIdentifier("phone_10", "drawable", "com.mt.cardletter");
		foodBean.setIcon(resID);
		fList.add(foodBean);

		FoodBean foodBean1 = new FoodBean();
		foodBean1.setId(1);
		foodBean1.setName("50元话费");
		foodBean1.setPrice(BigDecimal.valueOf(500));
		foodBean1.setJf(500);
		foodBean1.setSale("月售" + new Random().nextInt(100));
		foodBean1.setType("话费");
		int res1ID = context.getResources().getIdentifier("phone_50", "drawable", "com.mt.cardletter");
		foodBean1.setIcon(res1ID);
		fList.add(foodBean1);

		FoodBean foodBean10 = new FoodBean();
		foodBean10.setId(2);
		foodBean10.setName("100元话费");
		foodBean10.setPrice(BigDecimal.valueOf(1000));
		foodBean10.setJf(1000);
		foodBean10.setSale("月售" + new Random().nextInt(100));
		foodBean10.setType("话费");
		int res10ID = context.getResources().getIdentifier("phone_100", "drawable", "com.mt.cardletter");
		foodBean10.setIcon(res10ID);
		fList.add(foodBean10);

		FoodBean foodBean100 = new FoodBean();
		foodBean100.setId(3);
		foodBean100.setName("100元加油卡");
		foodBean100.setPrice(BigDecimal.valueOf(1000));
		foodBean100.setJf(1000);
		foodBean100.setSale("月售" + new Random().nextInt(100));
		foodBean100.setType("加油卡");
		int res100ID = context.getResources().getIdentifier("oil_100", "drawable", "com.mt.cardletter");
		foodBean100.setIcon(res100ID);
		fList.add(foodBean100);

		FoodBean foodBean200 = new FoodBean();
		foodBean200.setId(4);
		foodBean200.setName("200元加油卡");
		foodBean200.setPrice(BigDecimal.valueOf(2000));
		foodBean200.setJf(2000);
		foodBean200.setSale("月售" + new Random().nextInt(100));
		foodBean200.setType("加油卡");
		int res200ID = context.getResources().getIdentifier("oil_200", "drawable", "com.mt.cardletter");
		foodBean200.setIcon(res200ID);
		fList.add(foodBean200);
//		for (int i = 0; i < 91; i++) {
//			FoodBean foodBean = new FoodBean();
//			foodBean.setId(i);
//			foodBean.setName("食品--" + i + 1);
//			foodBean.setPrice(BigDecimal.valueOf((new Random().nextDouble() * 100)).setScale(1, BigDecimal.ROUND_HALF_DOWN));
//			foodBean.setSale("月售" + new Random().nextInt(100));
//			foodBean.setType("话费" + i / 10);
//			int resID = context.getResources().getIdentifier("food" + new Random().nextInt(8), "drawable", "com.k.neleme");
//			foodBean.setIcon(resID);
//			fList.add(foodBean);
//		}
		return fList;
	}

	public static List<FoodBean> getDetails(List<FoodBean> fList) {
		ArrayList<FoodBean> flist = new ArrayList<>();
		for (int i = 1; i < 5; i++) {
			if (fList.size() > i * 10) {
				flist.add(fList.get(i * 10 - 1));
				flist.add(fList.get(i * 10));
			} else {
				break;
			}
		}
		return flist;
	}

	public static List<CommentBean> getComment() {
		ArrayList<CommentBean> cList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			cList.add(new CommentBean());
		}
		return cList;
	}
}
