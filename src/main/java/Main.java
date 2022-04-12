import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        for(int i = 0; i < 3; ++i)
            userList.add(User.createUser());
        Stream<User> userStream = userList.stream();
        Stream<User> stream1 = userStream
                .peek(user-> user.setName(
                        user.getName().toUpperCase(Locale.ROOT)
                ))
                .peek(user -> user.setAge(user.getAge() * 2));

        stream1.forEach(System.out::println);
    }
}
