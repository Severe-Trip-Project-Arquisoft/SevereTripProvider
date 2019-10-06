package com.provider.web.repository;

import com.provider.web.entity.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends MongoRepository<Provider, String> {
    Provider findProviderByProvider_id(String provider_id);
}
