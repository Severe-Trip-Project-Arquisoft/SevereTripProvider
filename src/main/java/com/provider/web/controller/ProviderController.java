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
        return ResponseEntity.ok(providerService.getProvider(id));
    }

    @PostMapping(path ="/insertProvider", consumes = "application/json")
    public ResponseEntity<Long> createProvider(@RequestBody Provider provider) {
        try{
            Provider prov = providerService.getProvider(provider.getProvider_id() );
            if (prov.equals(null)){
                providerService.createProvider(provider);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>((long) -1,HttpStatus.FORBIDDEN);
        }

    }

}
