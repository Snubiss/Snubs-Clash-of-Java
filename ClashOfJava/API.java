/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClashOfJava;

import Exceptions.AuthenticationException;
import Exceptions.BadRequestException;
import Exceptions.ClashException;
import Exceptions.NotFoundException;
import Exceptions.RateLimitExceededException;
import Exceptions.UnknownErrorException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import org.json.JSONObject;

/**
 *
 * @author SchoolBox
 */
public abstract class API {
    
    static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6ImJlZmIzMmI4LWFmNzgtNDhhNS05NjljLTFjNDdjMDJmOGY2ZCIsImlhdCI6MTU1NDM2Njg1Niwic3ViIjoiZGV2ZWxvcGVyL2IyMDMwMjE5LWUzNzgtZjg3Ny03NjZiLTM5NGUwZTUyMDZjOCIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjY3LjE4Ny44Ni41NSJdLCJ0eXBlIjoiY2xpZW50In1dfQ.qMrDYnoc09iRrGdFtzBnSIqSpiO1mMJRebxDD5webFxXSIaEUbt0Ouxa8MhRn9nl2lJEfczhPyoYbHTH181WoQ";
    private static final String API_BASE = "https://api.clashofclans.com/";
    private static final String API_VERSION = "v1";
    
    private static String inputStreamToString(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.close();
        in.close();
        return new String(out.toByteArray());
    }
    public static JSONObject performAPIRequest(String format, String... arguments) throws IOException, ClashException {
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = URLEncoder.encode(arguments[0], "UTF-8");
        }
        String suffix = String.format(format, arguments);
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(API_BASE + API_VERSION + "/" + suffix).openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("authorization", "Bearer " + token);

            InputStream input = null;
            int statusCode = connection.getResponseCode();
            if (statusCode >= 200 && statusCode < 400) {
                input = connection.getInputStream();
            } else {
                input = connection.getErrorStream();
            }

            String response = null;
            try {
                response = inputStreamToString(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject json = null;
            if (response != null && !response.isEmpty()) {
                try {
                    json = new JSONObject(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response = response.replace("\n", "");
            }

            switch (statusCode) {
                case 400:
                    throw new BadRequestException(response);
                case 403:
                    throw new AuthenticationException(response);
                case 404:
                    throw new NotFoundException(response);
                case 429:
                    throw new RateLimitExceededException(response);
                case 200:
                    return json;
                default:
                    throw new UnknownErrorException(statusCode + ": " + response);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        catch (UnknownHostException ex){
           System.out.println("No connection available");
           return null;
        }
    }
    
    public static void setToken(String temp){
        token = temp;
    }
}
