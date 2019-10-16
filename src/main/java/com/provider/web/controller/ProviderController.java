package com.provider.web.controller;

import com.provider.web.entity.Provider;
import com.provider.web.service.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/allProviders")
    public List<Provider> getAllClients(){
        return providerService.getAllProvider();
    }

    @GetMapping("/provider/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable(value = "id") String id){
        Provider prov = providerService.getProvider(id);
        if (prov!=null){
            return ResponseEntity.ok(prov);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path ="/insertProvider", consumes = "application/json")
    public ResponseEntity<Long> createProvider(@RequestBody Provider provider) {
            Provider prov = providerService.getProvider(provider.getProviderId() );
            if (prov==null){
                providerService.createProvider(provider);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @PutMapping(path = "/updateProvider/{id}")
    public void updateClient(@RequestBody Provider provider, @PathVariable(value = "id") String id){
        Provider prov = providerService.getProvider(id);
        if (prov!= null){
            providerService.deleteProvider(prov);
            providerService.createProvider(provider);
        }else{
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Long> updateProvider(@RequestBody Provider provider) {
        Provider prov = providerService.getProvider(provider.getProviderId() );
        if (prov!=null && prov.getId()==provider.getId()){
            providerService.updateProvider(provider);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(path = "/deleteProvider/{id}")
    public void deleteClient(@PathVariable(value = "id") String id){
        Provider pro = providerService.getProvider(id);
        if (pro!= null){
            providerService.deleteProvider(pro);
        }else{
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
