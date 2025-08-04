package com.sujata.service;

import com.sujata.entity.Blog;

import com.sujata.entity.Share;
import com.sujata.exception.NoSuchBlogExistException;
import com.sujata.exception.NoSuchShareExistException;
import com.sujata.exception.ShareAlreadyExistException;
import com.sujata.persistence.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public boolean insertBlog(Blog blog) {

        if(blogDao.existsById(blog.getId())){
            throw new ShareAlreadyExistException("Blog with ID "+blog.getId()+" already exist");
        }
        else
            blogDao.save(blog);
        return true;
    }

    @Override
    public boolean deleteBlog(int id) {
        if(!blogDao.existsById(id)){
            throw new NoSuchShareExistException("No Blog Exist with ID "+id);
        }
        else
            blogDao.deleteById(id);
        return true;
    }
    @Override
    public Blog getBlogById(int id) {
        Optional<Blog> opShare= blogDao.findById(id);
        Blog blog=null;
        if(opShare.isPresent()) {
            blog = opShare.get();return blog;
        }
        throw new NoSuchBlogExistException("No Blog Exist with ID "+id);
    }

}
