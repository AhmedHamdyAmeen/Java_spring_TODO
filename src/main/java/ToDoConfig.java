import com.ameen.ToDo.Model.ToDo;
import com.ameen.ToDo.Repository.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToDoConfig {

    @Bean
    CommandLineRunner commandLineRunner (ToDoRepository repository) {
        return args -> {
            ToDo todo1 = new ToDo(1,"Stydy Angular", "description");
            ToDo todo2 = new ToDo(2,"Stydy Spring Boot", "description");
            ToDo todo3 = new ToDo(3,"Stydy Postgres", "description");

            repository.saveAll(List.of(todo1, todo2, todo3));
        };
    }

}
