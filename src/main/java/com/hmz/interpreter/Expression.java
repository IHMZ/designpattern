package com.hmz.interpreter;

import java.util.HashMap;

/**
 * 
 * @author Administrator
 *
 */
public abstract class Expression {
	// a + b - c
	// HashMap {a=10, b=20}
	public abstract int interpreter(HashMap<String, Integer> var);
}
