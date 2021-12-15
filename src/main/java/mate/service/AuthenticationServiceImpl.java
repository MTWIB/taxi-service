package mate.service;

import java.util.Optional;
import javax.naming.AuthenticationException;
import mate.lib.Inject;
import mate.lib.Service;
import mate.model.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Inject
    private DriverService driverService;
    private static final Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);


    @Override
    public Driver login(String login, String password) throws AuthenticationException {
        Optional<Driver> driver = driverService.findByLogin(login);
        if (driver.isEmpty() || !driver.get().getPassword().equals(password)) {
            logger.info("Authentication failed. Login - {}, password - {}", login, password);
            throw new AuthenticationException("Login or password was incorrect.");
        }
        logger.info("Successfull authentication. Login - {}", login);
        return driver.get();
    }
}
