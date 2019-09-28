package com.kamprzewoj.queststore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class QuestStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestStoreApplication.class, args);
	}
}
//test 1
// todo --- how mount new end point without crash existing from REST ? <--- siadz na spotkojnie i
// todo przelec od gotowych end pontow, one musza być jakimś kontrolerem wystawiane !!! znajdz i NADPISZ A JAK TO NIE PUJDZIE
// todo TO MIKRO SERVIS 3 <

// todo --- I WTEDY TEZ ZOBACZY CZY ZŁAPANIE WYJĄTKU W NIM ROZWIĄZĘ PROBLEM Internal Server Error

//todo why lov hybernate or jpa exceptions aren't cath globally
//TODO 2019-09-19 01:33:58.726 ERROR 6187 --- [nio-8080-exec-7] o.s.d.r.w.---> RepositoryRestExceptionHandler <---: could not execute statement; SQL [n/a]; constraint [uk_lrjnw0jty1fs19q56u0us8d0n]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
//
//org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [uk_lrjnw0jty1fs19q56u0us8d0n]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement


