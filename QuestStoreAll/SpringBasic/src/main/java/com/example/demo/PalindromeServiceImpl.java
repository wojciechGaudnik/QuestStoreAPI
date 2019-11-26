package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

	private PalindromeChecker pc;

	@Autowired
	public PalindromeServiceImpl(PalindromeChecker pc) {
		this.pc = pc;
	}

	@Override
	public String getResult(String s) {
		return pc.isPalindrome(s) ? s + " is a palindrome." : s + " is not a palindrome.";
	}
}
