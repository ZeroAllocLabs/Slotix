package org.example.api;
import okhttp3.*;

import java.util.Base64;

public class getSample {

    public void makeCall() {


        OkHttpClient client = new OkHttpClient();

        String url = "http://127.0.0.1:5100/static/sample5.jpg";

        Request request = new Request.Builder().get().url(url).build();

        try (Response resp = client.newCall(request).execute()) {
            if (resp.body() != null) {
                byte[] bytes = resp.body().bytes();
                for(byte b:bytes){
                    System.out.printf("%d ",b);
                }
            }
        } catch (Exception e) {
            System.out.println("error fetching bytes form server. may be --server offline");
        }
    }
}
