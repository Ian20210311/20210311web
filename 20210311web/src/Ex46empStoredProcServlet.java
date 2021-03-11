

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import beans.Ex46simpleEmp;

/**
 * Servlet implementation class Ex46empStoredProcServlet
 */
@WebServlet("/Ex46empStoredProcServlet")
public class Ex46empStoredProcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex46empStoredProcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String URL="jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&characterEncoding=utf-8";
		String URL="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=CST";
		String user="root";
		String password="1234";
		String SQL="call GetEmpInOffice(?)";
		
		PrintWriter out = response.getWriter();
		String city = request.getParameter("city");
		//city = "Tokyo";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(URL,user,password);
			CallableStatement cs =conn.prepareCall(SQL);
			cs.setString(1, city);
			ResultSet rs=cs.executeQuery();
			ArrayList<Ex46simpleEmp> list=new ArrayList<>();
			fillList(rs, list);
			request.getSession().setAttribute("emps", list);
			request.getRequestDispatcher("Ex46showEmpInCity.jsp").forward(request, response);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void fillList(ResultSet rs, ArrayList<Ex46simpleEmp> list) {
		try {
			while (rs.next()) {
				Ex46simpleEmp emp = new Ex46simpleEmp(
						rs.getInt("employeeNumber"),
						rs.getString("firstname"),
						rs.getString("lastname"),
						rs.getString("email")
						);
				list.add(emp);
				
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public void print(PrintWriter out, ResultSet rs) {
		try {
			out.println("<table border='1'>");
			while(rs.next()) {
				String no=rs.getString("employeeNumber");
				String fn=rs.getString("firstname");
				String ln=rs.getString("lastname");
				String em=rs.getString("email");
				
				out.println("<tr><td>");
				out.println(""+no);
				out.println("</td><td>");
				out.println(""+fn);
				out.println("</td><td>");
				out.println(""+ln);
				out.println("</td><td>");
				out.println(""+em);
				out.println("</td></tr>");
				
				out.println("");
			}
			out.println("</table>");
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
