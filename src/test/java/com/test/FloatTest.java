package com.test;

import java.math.BigDecimal;

import org.junit.Test;

public class FloatTest {

	@Test
	public void test() {
		BigDecimal bigDecimal = new BigDecimal("12.80");
		int i = (int)(bigDecimal.floatValue() * 100);
		System.out.println(i);
	}
}
