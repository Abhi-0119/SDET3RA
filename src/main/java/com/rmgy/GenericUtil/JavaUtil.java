package com.rmgy.GenericUtil;

import java.util.Random;

public class JavaUtil
{
	/**
	 * this method is used to generate the random number 
	 * @return
	 */
	public int rmdNum()
	{
		Random r = new Random();
		int rnum = r.nextInt(2000);
		return rnum;		
	}

}
