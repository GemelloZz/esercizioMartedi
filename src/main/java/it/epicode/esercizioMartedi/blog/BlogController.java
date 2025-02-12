package it.epicode.esercizioMartedi.blog;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getBlog() {
        return blogService.getAllBlog();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog getBlog(@PathVariable Long id) {
        if (Blog.isEmpty()) {
            throw new EntityNotFoundException("Blog con ID " + id + " non trovato.");
        }
        return blogService.getBlog(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setCategoria(blogRequest.getCategoria());
        blog.setTitolo(blogRequest.getTitolo());
        blog.setContenuto(blogRequest.getContenuto());
        blog.setTempoDiLettura(blogRequest.getTempoDiLettura());
        blog.setCover(blogRequest.getCover());
        return blogService.createBlog(blog);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blog updateBlog(@PathVariable Long id, @RequestBody BlogRequest blogRequest) {
        Blog blog = new Blog();
        blog.setCategoria(blogRequest.getCategoria());
        blog.setTitolo(blogRequest.getTitolo());
        blog.setContenuto(blogRequest.getContenuto());
        blog.setTempoDiLettura(blogRequest.getTempoDiLettura());
        blog.setCover(blogRequest.getCover());
        return blogService.updateBlog(id, blog);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
    }

}
