package org.opentutorials.javatutorials.eclipse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class java10591_3 {

	static ArrayList<Long> nums;
	static ArrayList<Character> chars;
	static long start, finish;
	static int starti, finishi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		nums = new ArrayList<Long>();
		chars = new ArrayList<Character>();
		String s = br.readLine();
		long value = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '-' || s.charAt(i) == '+' ||
                s.charAt(i) == '*' ||s.charAt(i) == '/') {
				nums.add(value);
				chars.add(s.charAt(i));
				value = 0;
			} else {
				if (value == 0 && s.charAt(i) != '0') {
					value = (s.charAt(i) - '0');
				} else if (value != 0) {
					value *= 10;
					value += (s.charAt(i) - '0');
				}
			}
		}
		nums.add(value);
		if (nums.get(0) == 0&&!chars.isEmpty()) {
			starti = 1;
			start = nums.get(1) * -1;
		} else {
			start = nums.get(0);
		}
		finishi = chars.size() - 1;
		finish = nums.get(nums.size() - 1);
		long result = 0;
		if (chars.size() == 0 || chars.size() == 1 && nums.get(0) == 0) {
			result = start;
		} else {
			while (starti != finishi) {
				char first = chars.get(starti);
				char last = chars.get(finishi);
				if ((first == '-' || first == '+') && (last == '*' || last == '/')) {
					long next = nums.get(finishi);
					finish = cal( next, finish, chars.get(finishi));
					finishi--;
				} else if ((first == '*' || first == '/') && (last == '-' || last == '+')) {
					long next = nums.get(starti + 1);
					start = cal(start,  next, chars.get(starti));
					starti++;
				} else {
					long next1 = nums.get(starti + 1);
					long start2 = cal(start, next1,chars.get(starti));
					long next2 = nums.get(finishi);
					long finish2 = cal(next2,finish,chars.get(finishi));
					if (start2 >= finish2) {
						start = start2;
						starti++;
					} else {
						finish = finish2;
						finishi--;
					}
				}
			}
			result = cal(start, finish, chars.get(starti));
		}
		System.out.println(result);
	}

	private static long cal(long next, long finish2, char character) {
		// TODO Auto-generated method stub
		if (character == '-') {
			return next - finish2;
		} else if (character == '+') {
			return next + finish2;
		} else if (character == '*') {
			return next * finish2;
		} else {
			return next / finish2;
		}
	}

}