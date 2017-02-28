package com.capgemini.chess.ranking.service.impl;

import java.util.Comparator;

import com.capgemini.chess.dataaccess.entities.UserEntity;

public class UserComparator  implements Comparator<UserEntity>{

	@Override
	public int compare(UserEntity u1, UserEntity u2) {
		int result=0;
		if(u1.getPoints()>u2.getPoints()){
			result=1;
		}else if(u1.getPoints()<u2.getPoints()){
			result=-1;
		}
		return  result;
	}

}
