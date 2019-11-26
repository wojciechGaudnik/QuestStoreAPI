package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FastPalindromeChecker implements PalindromeChecker {

	public FastPalindromeChecker() {

	}


	@Override
	public boolean isPalindrome(String s) {
		System.out.println("Fast test");
		for (int i = 0, j = s.length() - 1; i != j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}
		return false;
	}
}
