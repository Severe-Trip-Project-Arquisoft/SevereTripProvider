package com.provider.web.service;

import com.provider.web.entity.Provider;
import com.provider.web.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> getAllProvider() {

        return providerRepository.findAll();
    }

    public Provider getProvider(String providerId){
        return providerRepository.getById(providerId);
    }

    public Provider getProviderByCustId(String providerId){

        return providerRepository.findFirstByProviderId(providerId);
    }

    public Provider createProvider(Provider newProvider){

        return providerRepository.save(newProvider);
    }

    public Provider updateProvider(Provider upProvider){

        return providerRepository.save(upProvider);
    }

    public void deleteProvider(Provider delProvider) {

        providerRepository.delete(delProvider);
    }
}
