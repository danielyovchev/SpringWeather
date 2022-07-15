package com.example.springexample.Domain.Service;

//import com.example.springexample.Old.Domain.interfaces.RestTemplateProvider;
import com.example.springexample.Domain.Service.Interface.RestTemplateProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Lazy
@Service
public class RestTemplateProviderImpl implements RestTemplateProvider {
    public RestTemplateProviderImpl() {
        System.out.println("Created Rest template provider");
    }

    @Override
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
