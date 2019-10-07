package com.provider.web.controller;

import com.provider.web.entity.Provider;
import com.provider.web.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @GetMapping
    public String msg(){
        return "PROVIDERS AVAIABLE";
    }
    @GetMapping("/provider/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable(value = "id") String id){
        Provider prov = providerService.getProvider(id);
        if (!prov.equals(null)){
            return ResponseEntity.ok(prov);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path ="/insertProvider", consumes = "application/json")
    public ResponseEntity<Long> createProvider(@RequestBody Provider provider) {
            Provider prov = providerService.getProvider(provider.getProviderId() );
            if (prov.equals(null)){
                providerService.createProvider(provider);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping(path ="/insertProvider", consumes = "application/json")
    public ResponseEntity<Long> updateProvider(@RequestBody Provider provider) {
        Provider prov = providerService.getProvider(provider.getProviderId() );
        if (!prov.equals(null) && prov.getId()==provider.getId()){
            providerService.updateProvider(provider);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
