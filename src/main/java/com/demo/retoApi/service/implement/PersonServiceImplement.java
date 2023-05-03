package com.demo.retoApi.service.implement;

import com.demo.retoApi.model.Person;
import com.demo.retoApi.repository.PersonRepository;
import com.demo.retoApi.service.PersonService;
import com.demo.retoApi.view.PersonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.lang.invoke.MethodHandles;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImplement implements PersonService {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${serpApi.apiKey}")
    private String serpApiKey;
    @Value("${serpApi.url}")
    private String authorServiceUrl;

    private static final String HTTP_STATUS_MESSAGE = "HttpStatus: {}";

    @Autowired
    private PersonRepository personRepository;

    @Retryable(backoff = @Backoff(1000), maxAttempts = 2)
    public Person getPersonView(String id){
        @SuppressWarnings("ReassignedVariable") Person person = null;
        try{
            RestTemplate restTemplate = new RestTemplate();
            authorServiceUrl = MessageFormat.format(authorServiceUrl,id,serpApiKey);

            ResponseEntity<String> response
                    = restTemplate.getForEntity(authorServiceUrl , String.class);

            HttpStatus statusCode = (HttpStatus) response.getStatusCode();
            if(statusCode==HttpStatus.OK){
                person = new Person();
                person.setId(id);

                try{
                    ObjectMapper mapper = new ObjectMapper();
                    PersonView personView = new PersonView();
                    JsonNode jsonNode = mapper.readTree(response.getBody());
                    personView.setUrl(jsonNode.get("search_metadata").get("google_scholar_author_url").asText());
                    personView.setId(jsonNode.get("search_metadata").get("id").asText());
                    personView.setAffiliationName(jsonNode.get("author").get("affiliations").asText());
                    personView.setResults(jsonNode.get("articles").size());

                    BeanUtils.copyProperties(person, personView);

                    this.personRepository.save(personView);

                }catch(JsonProcessingException jsonProcessingException){
                    logger.error(jsonProcessingException.getMessage());
                }
            }
            return person;
        }catch(HttpClientErrorException exception){
            logger.info(HTTP_STATUS_MESSAGE, exception.getStatusCode().value());
            logger.error(exception.getResponseBodyAsString());
        }
        return person;
    }

    public ArrayList<Person> getPersonViewList(){

        ArrayList<Person> personList = null;
        List<PersonView> personViewList = this.personRepository.findAll();

        if(!personViewList.isEmpty()){
            personList = new ArrayList<>();

            for(PersonView personView :personViewList){
                Person person = new Person();
                BeanUtils.copyProperties(personView, person);
                personList.add(person);
            }
        }
        return personList;
    }
}
