public abstract class User {
    private final String name;
    private final int id;
    private String username;
    private String password;
    private String department;
    private final String type;
    private String email;
    private String phoneNum;


    public User(String name, int id, String username, String password, String department, String email, String type, String phoneNum) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.department = department;
        this.email = email;
        this.type = type;
        this.phoneNum = phoneNum;

    }

    public String getName() {
        return name;
    }

    public String getDepartment() {

        return department;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
