package mate.controller.car;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mate.lib.Injector;
import mate.model.Car;
import mate.service.CarService;

public class GetMyCurrentCarsController extends HttpServlet {
    private static final String SESSION_ATTRIBUTE_ID = "driver_id";
    private static final Injector injector = Injector.getInstance("mate");
    private final CarService carService = (CarService) injector
            .getInstance(CarService.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        Long driverId = (Long) session.getAttribute(SESSION_ATTRIBUTE_ID);
        List<Car> allCarsByDriver = carService.getAllByDriver(driverId);
        req.setAttribute("cars", allCarsByDriver);
        req.getRequestDispatcher("/WEB-INF/views/drivers/cars/myCars.jsp").forward(req, resp);
    }
}
