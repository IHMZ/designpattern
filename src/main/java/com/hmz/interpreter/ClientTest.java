package com.hmz.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//TODO 解释器模式
public class ClientTest {

	public static void main(String[] args) throws IOException {
		String expStr = getExpStr(); // a+b
		HashMap<String, Integer> var = getValue(expStr);// var {a=10, b=20}
		Calculator calculator = new Calculator(expStr);
		System.out.println("��������" + expStr + "=" + calculator.run(var));
	}

	// ��ñ��ʽ
	public static String getExpStr() throws IOException {
		return (new BufferedReader(new InputStreamReader(System.in))).readLine();
	}

	public static HashMap<String, Integer> getValue(String expStr) throws IOException {
		HashMap<String, Integer> map = new HashMap<>();

		for (char ch : expStr.toCharArray()) {
			if (ch != '+' && ch != '-') {
				if (!map.containsKey(String.valueOf(ch))) {
					System.out.print("������" + String.valueOf(ch) + "��ֵ��");
					String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
					map.put(String.valueOf(ch), Integer.valueOf(in));
				}
			}
		}

		return map;
	}
}
