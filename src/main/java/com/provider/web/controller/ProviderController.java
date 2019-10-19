package com.provider.web.controller;

import com.provider.web.entity.Provider;
import com.provider.web.service.ProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value="Provider Controller", description="Operations pertaining to Provider in Severe Trip System")
@RestController
@RequiredArgsConstructor
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;


    @ApiOperation(value = "Get all providers", response = List.class)
    @GetMapping("/allProviders")
    public List<Provider> getAllClients(){
        return providerService.getAllProvider();
    }

    @ApiOperation(value = "Get a provider by generated id", response = Provider.class)
    @GetMapping("/provider/{generatedId}")
    public ResponseEntity<Provider> getProvider(@PathVariable(value = "generatedId") String generatedId){
        Provider prov = providerService.getProvider(generatedId);
        if (prov!=null){
            return ResponseEntity.ok(prov);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Insert a provider", response = String.class)
    @PostMapping(path ="/insertProvider", consumes = "application/json")
    public ResponseEntity<String> createProvider(@RequestBody Provider provider) {
            Provider prov = providerService.getProviderByCustId(provider.getProviderId() );
            if (prov==null){
                Provider created = providerService.createProvider(provider);
                return new ResponseEntity<>(created.getId(),HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>("Username not available",HttpStatus.BAD_REQUEST);
            }
    }

    @ApiOperation(value = "Get provider by username",response = Provider.class)
    @GetMapping("/provider/username/{id}")
    public ResponseEntity<Provider> getClientByClientId(@PathVariable(value = "id") String id){
        Provider cli = providerService.getProviderByCustId(id);
        if (cli!= null){
            return ResponseEntity.ok(cli);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Get availability of Username",response = Boolean.class)
    @GetMapping("/provider/available/{userName}")
    public ResponseEntity<Boolean> checkAvailability(@PathVariable(value = "userName") String userName){
        return ResponseEntity.ok(providerService.isAvailable(userName));
    }

    @ApiOperation(value = "Update a provider")
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


    @ApiOperation(value = "Delete a provider")
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
