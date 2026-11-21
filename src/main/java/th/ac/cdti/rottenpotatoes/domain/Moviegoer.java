package th.ac.cdti.rottenpotatoes.domain;

public record Moviegoer(String name, String email) {
    public Moviegoer {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must not be blank");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("email must contain @");
        }
    }
}