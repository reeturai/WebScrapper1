/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapper1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;;
import java.net.URL;

/**
 *
 * @author welcome
 */
public class Grabber {
    
    public String grab(String link,String keyword)throws IOException{
       
         URL url = new URL(link);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getOutputStream().write(keyword.getBytes());
              
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder content = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\r\n");
            }
            reader.close();
            return content.toString();
    }
}
