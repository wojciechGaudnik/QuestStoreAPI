package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class StringBuilderPalindromeChecker implements PalindromeChecker{

	@Override
	public boolean isPalindrome(String s) {
		System.out.println("Slow test");
		if (new StringBuilder(s).reverse().toString().equals(s)) {
			return true;
		}
		return false;

	}
}
