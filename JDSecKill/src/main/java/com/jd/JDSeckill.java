package com.jd;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.Properties;

public class JDSeckill {

    public static void main(String[] args) {
        //gogogo();
        jiexi();
    }

    public static void jiexi(){

        try {
            InputStream is = new JDSeckill().getClass().getClassLoader().getResourceAsStream("jd.properties");
            Properties properties = new Properties();
            Reader bufferedReader = new BufferedReader(new InputStreamReader(is,"utf-8"));
            properties.load(bufferedReader);
            String message = new String(properties.getProperty("message"));
            char[] chars = message.toCharArray();
            int startIndex = 0;
            int endIndex = 0 ;
            int count = 0 ;
            for (int i = 0; i < chars.length; i++) {

                if("\"".equals(chars[i])){
                    count++;
                }
                if(count == 7){
                    startIndex = i;
                }else if(count == 8){
                    endIndex = i;
                }

            }
            System.out.println(startIndex);
            System.out.println(endIndex);
            System.out.println(message);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void gogogo() {
        try {
            //javautil包下的配置文件工具
            Properties properties = new Properties();
            //类加载器读取配置文件
            InputStream is = new JDSeckill().getClass().getClassLoader().getResourceAsStream("jd.properties");
            //工具载入配置文件流对象
            properties.load(is);
            //根据属性名获取属性
            String url = (String)properties.get("url");
            //获取属性cookie
            String cookie = (String)properties.get("cookie");
            //获取属性userAgent
            String userAgent = (String)properties.get("User-Agent");
            //替换指定位置的字符串为当前时间戳
            url = url.replace("12345678", String.valueOf(System.currentTimeMillis()));
            //打印当前时间
            System.err.println(String.valueOf(System.currentTimeMillis()));
            //创建一个默认的httpclient客户端
            CloseableHttpClient aDefault = HttpClients.createDefault();
            //get请求
            HttpGet httpGet = new HttpGet(url);
            //设置请求头
            httpGet.setHeader("Cookie", cookie);
            httpGet.setHeader("userAgent", userAgent);
            //System.err.println(EntityUtils.toString(entity, "UTF-8"));
            //执行请求 获取响应
            CloseableHttpResponse response = aDefault.execute(httpGet);
            //获取响应内容
            HttpEntity entity = response.getEntity();
            //转成字符串
            String htmlResponse = EntityUtils.toString(entity);
            //解析
            Document doucument = Jsoup.parse(htmlResponse);
            String body = doucument.body().toString();
            System.out.println(body);
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
