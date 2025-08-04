package com.sujata.controller;

import com.sujata.entity.Share;
import com.sujata.exception.ErrorResponse;
import com.sujata.exception.NoSuchShareExistException;
import com.sujata.exception.ShareAlreadyExistException;
import com.sujata.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShareResource {

    @Autowired
    private ShareService shareService;

    @GetMapping(path = "/shares",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public List<Share> getAllDetails(){

        return shareService.getAllShares();
    }

    @PostMapping("/shares")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public String saveRecord(@RequestBody Share share){
        if(shareService.insertShare(share))
            return "Record Added!";
        return "Insersion Failed";
    }

    @GetMapping(path = "/shares/{eid}",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Share getRecordById(@PathVariable("eid") int id){
        return shareService.getShareById(id);
    }


    @DeleteMapping("/shares/{eId}")
    @CrossOrigin
    public String deleteRecord(@PathVariable("eId") int id){
        if(shareService.deleteShare(id))
            return "Deleted!";
        return "Deletion Failed";
    }

    @PutMapping("/shares/{id}/{mp}")
    @CrossOrigin
    public String updateRecord(@PathVariable("id") int id,@PathVariable("mp") int marketPrice){
        if(shareService.updateMarketPrice(id,marketPrice))
            return "Updated";
        return "Updation Failed";
    }

    @ExceptionHandler(value = NoSuchShareExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchCustomerExistsException(NoSuchShareExistException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(value = ShareAlreadyExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(ShareAlreadyExistException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
