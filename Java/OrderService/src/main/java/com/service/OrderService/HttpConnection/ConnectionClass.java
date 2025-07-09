package com.service.OrderService.HttpConnection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.OrderService.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

@Component
public class ConnectionClass {

    public void getData() {
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

    public ResponseEntity<String> postData(Product product){
        String url = "http://localhost:8081/ProductService/product";
        HttpURLConnection httpURLConnection = null;
        try{
            URL obj = new URL(url);
            httpURLConnection = (HttpURLConnection) obj.openConnection(Proxy.NO_PROXY);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            httpURLConnection.setReadTimeout(100);
            httpURLConnection.setConnectTimeout(500);
            httpURLConnection.setDoOutput(true);

            try(OutputStream os = httpURLConnection.getOutputStream()){
                ObjectMapper mapper = new ObjectMapper();
                String objectString = mapper.writeValueAsString(product);
                byte[] input = objectString.getBytes("utf-8");
                os.write(input,0, input.length);
                System.out.println("______"+ httpURLConnection.getResponseCode());
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (httpURLConnection != null)
                httpURLConnection.disconnect();
        }
        return new ResponseEntity<>("Product added successfully", HttpStatus.CREATED);
    }
}
