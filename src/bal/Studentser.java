package bal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dal.Student;



/**
 * Servlet implementation class Studentser
 */
@WebServlet("/Studentser")
public class Studentser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		Student stu = new Student();
		stu.setRno(Integer.parseInt(request.getParameter("txtrno")));
		stu.setSname(request.getParameter("txtsname"));
		stu.setBranch(request.getParameter("txtbranch"));
		stu.setFees(Integer.parseInt(request.getParameter("txtfees")));
		s.save(stu);
		tx.commit();
		out.print("Data Inserted Successfully");
		
		
		
		
		
	}

}
