package be.vdab.servlets;

import be.vdab.entities.SterrenBeeld;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.htm")
public class SterrenBeeldenServlet extends HttpServlet {
    private final static long serialVersionUID = 1L;
    private static final String VIEW = "WEB-INF/JSP/sterrenbeelden.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("datum") != null) {
            final String datumAlsString = request.getParameter("datum").replace("-", "/");
            final Locale locale = new Locale("nl", "BE");
            final DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, locale);
            format.setLenient(false);
            try {
                final Calendar calendar = Calendar.getInstance();
                final Date geboorteDatum = format.parse(datumAlsString.indexOf('/') == datumAlsString.lastIndexOf('/')
                        ? datumAlsString + "/" + calendar.get(Calendar.YEAR)
                        : datumAlsString);
                request.setAttribute("beeld", new SterrenBeeld(geboorteDatum).getNaam());

            } catch (ParseException ex) {
                request.setAttribute("fout", "Tik een correcte datum");
            }
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }
}
