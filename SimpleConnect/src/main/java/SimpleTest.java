import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

			HostnameVerifier allHostsValid = (hostname, session) -> true;
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);


			url = new URL("https://localhost:8443/login");
			url = new URL("https://localhost:8443/api/userData");

			httpsURLConnection = (HttpsURLConnection) url.openConnection();
//			httpsURLConnection.setRequestMethod("POST");
			httpsURLConnection.setRequestMethod("GET");
			httpsURLConnection.setRequestProperty("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyb290IiwiZXhwIjoxNTcxMTI2NjgyfQ.GXQfRn9-1fL1drDvbXXyurRSWr46SJqb7Yn8MLudIXYE4lwnIqPT3M7TXf0Yi7Hxevo8cjHkh5aNAnikxiNmRw");
			httpsURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
			httpsURLConnection.setRequestProperty("Accept", "application/json");
			httpsURLConnection.setDoOutput(true);
			loginViewModel = new LoginViewModel();
			loginViewModel.setNick("root");
			loginViewModel.setPass("root");
			mapper = new ObjectMapper();
			loginViewModelJSON = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(loginViewModel);

			httpsURLConnection.getOutputStream().write(loginViewModelJSON.getBytes(StandardCharsets.UTF_8));
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));

			//todo headers !!! print !!!
			bufferedReader.lines().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
