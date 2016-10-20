/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapper1;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author welcome
 */
public class program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("enter keyword you want to search");
            String keyword = in.next();
            try {
                Grabber grabber = new Grabber();
                String content = grabber.grab("http://www.merojob.com/search-new/index.php?search=" + keyword + "&category=0", ("search=" + keyword));

                String regPattern = "<a\\shref='(.*?)//(.*?)/(.*?)/(.*?)_";
                Pattern pattern = Pattern.compile(regPattern);
                Matcher matcher = pattern.matcher(content.toString());
                while (matcher.find()) {
                    System.out.print(matcher.group(4) + "\r\n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
