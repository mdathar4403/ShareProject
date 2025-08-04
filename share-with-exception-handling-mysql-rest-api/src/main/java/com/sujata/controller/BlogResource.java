package com.sujata.controller;

import com.sujata.entity.Blog;
import com.sujata.entity.Share;
import com.sujata.exception.*;
import com.sujata.service.BlogService;
import com.sujata.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogResource {

    @Autowired
    private BlogService blogService;
//@CrossOrigin enable SpringBoot Cross-Origin Resourse Sharing (CORS)
    @GetMapping(path = "/blogs",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public List<Blog> getAllDetails(){

        return blogService.getAllBlogs();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/blogs")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveRecord(@RequestBody Blog blog){
        if(blogService.insertBlog(blog))
            return "Record Added!";
        return "Insersion Failed";
    }


    @DeleteMapping("/blogs/{bId}")
    @CrossOrigin
    public String deleteRecord(@PathVariable("bId") int id){
        if(blogService.deleteBlog(id))
            return "Deleted!";
        return "Deletion Failed";
    }


    @GetMapping(path = "/blogs/{eid}",produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public Blog getRecordById(@PathVariable("eid") int id){
        return blogService.getBlogById(id);
    }

    @CrossOrigin
    @ExceptionHandler(value = NoSuchBlogExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchCustomerExistsException(NoSuchBlogExistException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @CrossOrigin
    @ExceptionHandler(value = BlogAlreadyExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchElementException(BlogAlreadyExistException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
