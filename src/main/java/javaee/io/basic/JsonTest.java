package javaee.io.basic;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.hsf.HSFJSONUtils;


import java.io.*;
import java.util.List;


public class JsonTest {

    //读取json文件
    public static String readJsonFile(String fileName) {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void write(String line) {
        try {
            FileWriter fw = new FileWriter("test.csv", true);
            String c = line + "\r\n";
            fw.write(c);
            fw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            System.out.println("写入失败");
            System.exit(-1);
        }
    }

    public static boolean writeFile(String filePath, String sets) {
        FileWriter fw;
        try {
            fw = new FileWriter(filePath);
            PrintWriter out = new PrintWriter(fw);
            out.write(sets);
            out.println();
            fw.close();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public static void main(String[] args) {
        String path = JsonTest.class.getClassLoader().getResource("send.json").getPath();
        String s = readJsonFile(path);
        JSONObject jObj1 = JSON.parseObject(s);
        JSONObject jObj2 = jObj1.getJSONObject("project");
        JSONArray jsonArray1 = jObj2.getJSONArray("_iot_gateway");
        JSONObject jObj3 = jsonArray1.getJSONObject(0);
        JSONArray jsonArray2 = jObj3.getJSONArray("mqtt_clients");
        write("name,type,is gateway,MQTT client ID,MQTT user name,MQTT password");
        for (int i = 0; i < jsonArray2.size(); i++) {
            JSONObject key = (JSONObject) jsonArray2.get(i);
            String name = (String) key.get("common.ALLTYPES_NAME");
            key.remove("iot_gateway.MQTT_CLIENT_CLIENT_ID");
            key.put("iot_gateway.MQTT_CLIENT_CLIENT_ID", Integer.toString((301 + i)));
            StringBuilder stringBuilder = new StringBuilder(name);
            stringBuilder.append(",default,TRUE,").append(301 + i).append(",123,123");
            name = stringBuilder.toString();
            System.out.println(name);
            write(name);
        }
        writeFile("send.json", jObj1.toJSONString());
    }
}