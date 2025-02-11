package it.epicode.esercizioMartedi.blog;

import it.epicode.esercizioMartedi.autore.Autore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Blog getBlog(Long id) {
        Optional<Blog> autore = blogRepository.findById(id);
        return Blog.orElse(null);
    }


    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Long id, Blog blog) {
        Blog blogToUpdate = getBlog(id);
        blogToUpdate.setCategoria(blog.getCategoria());
        blogToUpdate.setTitolo(blog.getTitolo());
        blogToUpdate.setContenuto(blog.getContenuto());
        blogToUpdate.setTempoDiLettura(blog.getTempoDiLettura());
        blogToUpdate.setCover(blog.getCover());
        return blogRepository.save(blogToUpdate);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }
}
