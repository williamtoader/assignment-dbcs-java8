import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //create a list of 3 users
        List<User> users = new ArrayList<>();
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());
        users.add(User.createUser());

        System.out.println(users);

        List<User> filteredUsersUnder18 = users.stream()
                .filter(user -> user.getAge() < 18)
                .map(user -> {
                    user.setAge(user.getAge() * 2);
                    return user;
                })
                .collect(Collectors.toList());
        if(filteredUsersUnder18.size() > 0)
            System.out.println(filteredUsersUnder18.get(filteredUsersUnder18.size() - 1));
        System.out.println(filteredUsersUnder18.stream().max(User::compareTo).orElse(null));
        System.out.println(filteredUsersUnder18.stream().min(User::compareTo).orElse(null));
        System.out.println(filteredUsersUnder18.stream().distinct().collect(Collectors.toList()));

        List<User> filteredUsersOver30 = users.stream()
                .filter(user -> user.getAge() > 30)
                .map(user -> {  user.setName(user.getName().toUpperCase(Locale.ROOT)); return user; })
                .sorted(User::descCompareTo)
                .collect(Collectors.toList());

        System.out.println(filteredUsersOver30);

    }
}
