package mate.service;

import javax.naming.AuthenticationException;
import mate.model.Driver;

public interface AuthenticationService {
    Driver login(String login, String password) throws AuthenticationException;
}
