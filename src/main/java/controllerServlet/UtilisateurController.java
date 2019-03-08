package controllerServlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.SondageDate;
import entity.SondageDateLieu;
import entity.SondageLieu;

@WebServlet("/userDoodleController")
public class UtilisateurController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String emailUtilisateur = req.getParameter("emailUtilisateur");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
	    String motPasse  = req.getParameter("motPasse");
		/*int employeeSalary = Integer.parseInt(req.getParameter("salary"));

		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.createEmployee(employeeName, employeeSurname, employeeSalary);

		List<Employee> allEmployees = employeeService.findAllEmployees();
		req.setAttribute("allEmployees", allEmployees);//olusturulan instance request edilir.
		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");//jsp sayfasina dispatch ve forward edilir.
		dispatcher.forward(req, resp);
		
		private String motPasse;
    private Collection<SondageDate> sondageDates;
    private Collection<SondageLieu> sondageLieux;
    private Collection<SondageDateLieu> sondageDateLieux;
		
		*/

	}
	
}
