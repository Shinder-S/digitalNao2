package com.demo.retoApi.model;

import jakarta.persistence.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Entity
@Table(schema = "Author")
public class Person {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private final long id;
        private final String apiKey;
        @Column
        private String title;
        @Column
        private int results;
        private final String paramsUrl;



        public Person(String id, String apiKey, String title, int results, String paramsUrl){
            this.id = Long.parseLong(id);
            this.apiKey = apiKey;
            this.title = title;
            this.results = results;
            this.paramsUrl = paramsUrl;
        }

        public long getId() {
            return id;
        }


        public String getApiKey(){
            return apiKey;
        }

        public String getTitle(){
            return title;
        }

        public int getResults(){
            return results;
        }

        public String getParamsUrl(){
            return paramsUrl;
        }

        public String requestSearch() throws URISyntaxException, IOException, InterruptedException{
            HttpClient client = HttpClient.newHttpClient();
            String getParams = paramsUrl + "&person_id" + id + "&title" + title + "%res=" + results + "&api_key" + apiKey;
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(getParams)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }

}
