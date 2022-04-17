package s.m.tx.web;

import java.util.Optional;

public class RequestContext {
    private static ThreadLocal<Optional<String>> currentUser = new ThreadLocal<>();

    public static Optional<String> getCurrentUser() {
        return currentUser.get();
    }
    public static void setCurrentUser(String currentUser) {
        RequestContext.currentUser.set(Optional.of(currentUser));
    }
}
