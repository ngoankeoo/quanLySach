package ngoan_7C4;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/** * Servlet implementation class StudentControllerServlet */
@WebServlet("/sinhvienControllerServlet")

public class sinhvienControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private sinhvienDbUtil sinhvienDbUtil;
	@Resource(name = "jdbc/sinhvien")
	private DataSource dataSource;

	@Override
	public void init() throws ServletException {
		super.init();

		try {
			sinhvienDbUtil = new sinhvienDbUtil(dataSource);
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String theCommand = request.getParameter("command");

			if (theCommand == null) {
				theCommand = "LIST";
			}

			switch (theCommand) {
			case "LIST":
				listsinhvien(request, response);
				break;
			case "ADD":
				addsinhvien(request, response);
				break;
			case "LOAD":
				loadsinhvien(request, response);
				break;
			case "UPDATE":
				updatesinhvien(request, response);
				break;
			case "DELETE":
				deletesinhvien(request, response);
				break;

			default:
				listsinhvien(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	private void deletesinhvien(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String themasv = request.getParameter("masv");

		sinhvienDbUtil.deletesinhvien(themasv);

		listsinhvien(request, response);
	}

	private void updatesinhvien(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int masv = Integer.parseInt(request.getParameter("masv"));
		String hoten = request.getParameter("hoten");
		String tenkhoa = request.getParameter("tenkhoa");
		
		String gioitinh= request.getParameter("gioitinh");
		int diemtin = Integer.parseInt(request.getParameter("diemtin"));
		sinhvien thesinhvien = new sinhvien(masv, hoten, tenkhoa, gioitinh, diemtin);

		sinhvienDbUtil.updatesinhvien(thesinhvien);

		listsinhvien(request, response);
	}

	private void loadsinhvien(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String themasv = request.getParameter("masv");

		sinhvien thesinhvien = sinhvienDbUtil.getsinhvien(themasv);

		request.setAttribute("THE_SINHVIEN", thesinhvien);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
		dispatcher.forward(request, response);
	}

	private void addsinhvien(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int masv = Integer.parseInt(request.getParameter("masv"));
		String hoten = request.getParameter("hoten");
		String tenkhoa = request.getParameter("tenkhoa");
		String gioitinh = request.getParameter("gioitinh");
		int diemtin = Integer.parseInt(request.getParameter("diemtin"));
		sinhvien thesinhvien = new sinhvien(masv, hoten, tenkhoa, gioitinh, diemtin);

		sinhvienDbUtil.addsinhvien(thesinhvien);

		listsinhvien(request, response);
	}

	private void listsinhvien(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<sinhvien> sinhvien = sinhvienDbUtil.getsinhviens();
		request.setAttribute("LIST_SINHVIEN", sinhvien);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}

}