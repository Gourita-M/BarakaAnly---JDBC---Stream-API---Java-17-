package src.entity;

public class Client {
    private int id;
    private String name;
    private String email;
    private boolean banned = false;

    public Client(int id, String name, String email, boolean banned) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.banned = banned;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
