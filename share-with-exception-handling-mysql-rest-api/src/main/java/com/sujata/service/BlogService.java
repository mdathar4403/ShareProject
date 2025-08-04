package com.sujata.service;

import com.sujata.entity.Blog;
import com.sujata.entity.Share;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();

    boolean insertBlog(Blog blog);

    boolean deleteBlog(int id);

    Blog getBlogById(int id);


}
