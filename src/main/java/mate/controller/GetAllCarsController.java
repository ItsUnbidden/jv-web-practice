package mate.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Car;
import mate.service.CarService;

public class GetAllCarsController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private CarService carService;

    @Override
    public void init() throws ServletException {
        carService = (CarService) injector.getInstance(CarService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        List<Car> cars = carService.getAll();
        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/views/cars/all.jsp").forward(req, resp);
    }
}
