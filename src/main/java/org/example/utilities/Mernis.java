package org.example.utilities;

import com.squareup.okhttp.*;
import org.example.entities.Customer;

import java.io.IOException;

public class Mernis implements CustomerCheckService {
    @Override
    public boolean isValid(Customer customer) throws IOException {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/soap+xml; charset=utf-8");
        RequestBody body = RequestBody.create(mediaType, "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <TCKimlikNoDogrula xmlns=\"http://tckimlik.nvi.gov.tr/WS\">\n" +
                "      <TCKimlikNo>13344077943</TCKimlikNo>\n" +
                "      <Ad>Salih Remzi</Ad>\n" +
                "      <Soyad>Güler</Soyad>\n" +
                "      <DogumYili>2002</DogumYili>\n" +
                "    </TCKimlikNoDogrula>\n" +
                "  </soap12:Body>\n" +
                "</soap12:Envelope>");
        Request request = new Request.Builder()
                .url("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx")
                .method("POST", body)
                .addHeader("Content-Type", "application/soap+xml; charset=utf-8")
                .build();
        Response response = client.newCall(request).execute();

        String responseBody = response.body().string();
        String result = responseBody.substring(responseBody.indexOf("<TCKimlikNoDogrulaResult>") + "<TCKimlikNoDogrulaResult>".length(), responseBody.indexOf("</TCKimlikNoDogrulaResult>"));
        response.body().close();



        if(result.equals("true"))
        {

            return true;
        }
        else {

            return false;
        }

    }
}
