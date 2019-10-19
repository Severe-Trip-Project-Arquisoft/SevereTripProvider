package com.provider.web.repository;

import com.provider.web.entity.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ProviderRepository extends MongoRepository<Provider, Serializable> {

    Provider findFirstByProviderId(String providerId);
    Provider getById(String id);
    Boolean existsByProviderId(String providerId);

}
