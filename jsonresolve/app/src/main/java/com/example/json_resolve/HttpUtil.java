package com.example.json_resolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpUtil {

    public static String sendHttpRequest(String address) {
        URL url = null;
        try {
            url = new URL(address);
        }catch (MalformedURLException e) {
            e.printStackTrace();
            return "Error, URL Exception!";
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        }catch (IOException e) {
            e.printStackTrace();
            return "Error, can not open connection!";
        }
        try {
            connection.setRequestMethod("GET");
        }catch (ProtocolException e) {
            e.printStackTrace();
            return "Error, method error!";
        }
        connection.setConnectTimeout(8000);
        connection.setReadTimeout(8000);

        InputStream in = null;
        try {
            in = connection.getInputStream();
        }catch (IOException e) {
            e.printStackTrace();
            return "Error, can not open input stream!";
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        StringBuilder response = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        connection.disconnect();
        return response.toString();
    }
}
