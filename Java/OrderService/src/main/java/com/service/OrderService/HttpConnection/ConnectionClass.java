package com.service.OrderService.HttpConnection;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class ConnectionClass {

    public void getHttppConnection() {
        HttpURLConnection httpURLConnection = null;
        String uri = "http://localhost:8081/ProductService/product";
        try {
            URL obj = new URL(uri);
            httpURLConnection = (HttpURLConnection) obj.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setConnectTimeout(100);
            httpURLConnection.setReadTimeout(500);

            BufferedReader input = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = input.readLine()) != null) {
                response.append(responseLine);
            }
            input.close();
            System.out.println(response);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null)
                httpURLConnection.disconnect();
        }
    }
}
