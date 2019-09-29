package com.kamprzewoj.queststore;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class QuestStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestStoreApplication.class, args);
	}

//	@Bean
//	public ServletWebServerFactory servletContainer() {
//		// Enable SSL Trafic
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				context.addConstraint(securityConstraint);
//			}
//		};
//
//		// Add HTTP to HTTPS redirect
//		tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
//
//		return tomcat;
//	}
//
//	/*
//	We need to redirect from HTTP to HTTPS. Without SSL, this application used
//	port 8082. With SSL it will use port 8443. So, any request for 8082 needs to be
//	redirected to HTTPS on 8443.
//	 */
//	private Connector httpToHttpsRedirectConnector() {
//		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
//		connector.setScheme("http");
//		connector.setPort(8082);
//		connector.setSecure(false);
//		connector.setRedirectPort(8443);
//		return connector;
//	}
}

// todo --- how mount new end point without crash existing from REST ? <--- siadz na spotkojnie i
// todo przelec od gotowych end pontow, one musza być jakimś kontrolerem wystawiane !!! znajdz i NADPISZ A JAK TO NIE PUJDZIE
// todo TO MIKRO SERVIS 3 <

// todo --- I WTEDY TEZ ZOBACZY CZY ZŁAPANIE WYJĄTKU W NIM ROZWIĄZĘ PROBLEM Internal Server Error

//todo why lov hybernate or jpa exceptions aren't cath globally
//TODO 2019-09-19 01:33:58.726 ERROR 6187 --- [nio-8080-exec-7] o.s.d.r.w.---> RepositoryRestExceptionHandler <---: could not execute statement; SQL [n/a]; constraint [uk_lrjnw0jty1fs19q56u0us8d0n]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement
//
//org.springframework.dao.DataIntegrityViolationException: could not execute statement; SQL [n/a]; constraint [uk_lrjnw0jty1fs19q56u0us8d0n]; nested exception is org.hibernate.exception.ConstraintViolationException: could not execute statement


