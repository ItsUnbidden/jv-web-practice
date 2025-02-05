package mate.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.lib.Injector;
import mate.model.Manufacturer;
import mate.service.ManufacturerService;

public class CreateManufacturerController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("mate");
    private ManufacturerService manufacturerService;

    @Override
    public void init() throws ServletException {
        manufacturerService = 
                (ManufacturerService) injector.getInstance(ManufacturerService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/manufacturers/create.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        Manufacturer newManufacturer = new Manufacturer();
        newManufacturer.setName(name);
        newManufacturer.setCountry(country);
        System.out.println(manufacturerService.create(newManufacturer)); 
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
