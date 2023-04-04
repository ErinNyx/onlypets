package com.csc340sp23.OnlyPets.past;

import com.csc340sp23.OnlyPets.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    public Post getPostById(int postId) {
        return repo.getReferenceById(postId);
    }

    public Post getPostByAuthorId(int userId) {
        List<Post> posts = getAllPosts();
        return posts.stream().filter(post -> post.getAuthor() == userId)
                .findFirst().orElse(null);
    }

    public void save(Post post) {
        repo.save(post);
    }
}