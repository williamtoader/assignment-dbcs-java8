import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    Long id;
    String name;
    Integer age;

    static Long idCounter = 1L;
    static User createUser() {
        User user = User.builder()
                .id(idCounter)
                .name(Faker.instance().funnyName().name())
                .age((int) (Math.random() * 100))
                .build();
        idCounter++;
        return user;
    }

}
