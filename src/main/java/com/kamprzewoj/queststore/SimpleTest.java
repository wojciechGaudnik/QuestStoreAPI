package com.kamprzewoj.queststore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamprzewoj.queststore.security.JWT.LoginViewModel;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;

public class SimpleTest {
	private static URL url;
	private static HttpsURLConnection httpsURLConnection;
	private static LoginViewModel loginViewModel;
	private static ObjectMapper mapper;
	private static String loginViewModelJSON;

	public static void main(String[] args) {
		try {
			TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}
				}
			};

			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			httpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			url = new URL("https://localhost:8443/login");
			httpsURLConnection = (HttpsURLConnection) url.openConnection();
			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
			httpsURLConnection.setRequestProperty("Accept", "application/json");
			httpsURLConnection.setDoOutput(true);
			loginViewModel = new LoginViewModel();
			loginViewModel.setUsername("root");
			loginViewModel.setPassword("root");
			mapper = new ObjectMapper();
			loginViewModelJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginViewModel);

			httpsURLConnection.getOutputStream().write(loginViewModelJSON.getBytes(StandardCharsets.UTF_8));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));

			String newLine = "";
			while ((newLine = bufferedReader.readLine()) != null) {
				System.out.println(newLine);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
