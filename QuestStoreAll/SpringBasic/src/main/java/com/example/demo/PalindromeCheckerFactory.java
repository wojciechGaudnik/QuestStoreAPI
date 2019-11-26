package com.example.demo;


import org.springframework.stereotype.Component;

public class PalindromeCheckerFactory {
	PalindromeChecker getPalindromeChecker(String version){
		if (version.equals("Fast")) {
			return new FastPalindromeChecker();
		}
		return new StringBuilderPalindromeChecker();
		//todo asl mentor return (version.equals("Fast")) ? () ->  new FastPalindromeChecker() : (PalindromeChecker) null;
//		todo ask mentor ----------->return (version.equals("Fast")) ? (FastPalindromeChecker::new) : (PalindromeChecker) null;
		//todo ask mentor can I say "dependence inversion prepare our program tu use dependence injection ?"
	}

}
