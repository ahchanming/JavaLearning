package com.opq.fund;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2017/3/24.
 */
public class FundSpider {
    public String doGet(String codeId){
        String url = "http://fund.eastmoney.com/f10/F10DataApi.aspx?type=lsjz&code=163117&page=1&per=365&sdate=&edate=&rt=0.7916265109088272";
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        try{
            HttpResponse response = client.execute(get);
            System.out.println(response.getStatusLine().getStatusCode());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            int total = 0;
            while ((line = bufferedReader.readLine()) != null){
                total += 1;
                //System.out.println(line);
                //String lines[] = line.split("<td class='tor bold'>");
                String lines[] = line.split("<tr>");
                for (int i = 0; i < 10; ++i){
                    System.out.println(lines[i]);
                }
            }
            System.out.println(total);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]){
        new FundSpider().doGet("");
    }
}
