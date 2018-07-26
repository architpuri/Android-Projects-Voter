package com.example.architpuri.voter;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Login_Validator extends AsyncTask<String,Void,String> {

    Context context;
    String result;
    Login_Validator(Context ctx)
    {
        ctx = context;
    }

    @Override
    protected String doInBackground(String...params) {



        String login_url = "http://192.168.1.218/aadhar_login.php";
        try {

            URL url = new URL(login_url);
            String aadhar_no = params[0];
            String area_code = params[1];
            String mob_no = params[2];

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String post_Data = URLEncoder.encode("aadhar_no","UTF-8")+"="+URLEncoder.encode(aadhar_no,"UTF-8")+"&"+
                               URLEncoder.encode("area_code","UTF-8")+"="+URLEncoder.encode(area_code,"UTF-8")+"&"+
                               URLEncoder.encode("mob_no","UTF-8")+"="+URLEncoder.encode(mob_no,"UTF-8");
            bufferedWriter.write(post_Data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            //to get Response from Server
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            result = "";
            String line =" ";
            while ((line=bufferedReader.readLine())!=null)
            {
                result = result+line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();



            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    protected Boolean returner()
    {
        if(result=="Login Successful")
        {

            return true;//Allow Login
        }
        else
        {
            return false;
        }
    }
}
