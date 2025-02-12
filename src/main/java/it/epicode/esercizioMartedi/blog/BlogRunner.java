package it.epicode.esercizioMartedi.blog;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BlogRunner implements CommandLineRunner {

    private final BlogRepository blogRepository;
    private final Faker faker;



    @Override
    public void run(String... args) throws Exception {
        for(int i = 0 ; i < 10 ; i++) {
            Blog blog = new Blog();
            blog.setCategoria(faker.lorem().sentence());
            blog.setTitolo(faker.book().title());
            blog.setContenuto(faker.lorem().sentence());
            blog.setTempoDiLettura(faker.number().numberBetween(1, 100));
            blog.setCover(faker.lorem().sentence());
            blogRepository.save(blog);
        }
    }



}
