package Controller;

import DAO.RouteDAO;
import Model.RouteModel;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

@WebServlet("/test")
public class test extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        String t1 = req.getParameter("t1");
        String t2 = req.getParameter("t2");

        try {
            DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
            Date d1 = dateFormat.parse(t1);
            Date d2 = dateFormat.parse(t2);

            if (d1.compareTo(d2) > 0) {
                // d1 > d2
                System.out.println(t1);
                System.out.println(d1);
            } else {
                // d1 < d2
                System.out.println(t2);
                System.out.println(d2);
            }


            long differenceInMilliSeconds = Math.abs(d1.getTime() - d2.getTime());

            long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
            long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
            long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60;

            // Printing the answer
            String time = "Difference is " + differenceInHours + " hours " + differenceInMinutes + " minutes " + differenceInSeconds + " Seconds. ";


            res.setStatus(HttpServletResponse.SC_OK);
            out.write("{\"size\": " + time + "}");


        } catch (
                Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            out.close();


        }

    }
}
