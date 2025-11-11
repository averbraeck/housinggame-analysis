package nl.tudelft.simulation.housinggame.analysis;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/analysis")
public class AnalysisServlet extends HttpServlet
{

    /** */
    private static final long serialVersionUID = 1L;

    /** button that has been pressed. */
    private String button = "";

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();

        AnalysisData data = SessionUtils.getData(session);
        if (data == null || data.getScenario() == null)
        {
            response.sendRedirect("/housinggame-analysis/login");
            return;
        }

        // If showModalWindow has value 2, it means: refresh (once) INCLUDING modal window.
        if (data.getShowModalWindow() == 2)
        {
            data.setShowModalWindow(1); // wipe next time!
        }
        else
        {
            data.setShowModalWindow(0);
            data.setModalWindowHtml("");
        }

        if (request.getParameter("menu") != null)
            data.setMenuState(request.getParameter("menu"));

        if (request.getParameter("button") != null)
            this.button = request.getParameter("button");
        else
            this.button = "";

        data.readDynamicData();
        handlePressedButton(data, this.button, request);
        prepareAccordionButtons(data, request); // dependent on NEW state
        handleTopMenu(data); // dependent on NEW state

        response.sendRedirect("jsp/analysis/analysis.jsp");
    }

    public void handleTopMenu(final AnalysisData data)
    {
        // TBD
    }

    public void handlePressedButton(final AnalysisData data, final String button, final HttpServletRequest request)
    {
        // TBD
    }

    public void prepareAccordionButtons(final AnalysisData data, final HttpServletRequest request)
    {
        // TBD
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

}
