package nl.tudelft.simulation.housinggame.analysis;

import jakarta.servlet.http.HttpSession;

public final class SessionUtils
{

    private SessionUtils()
    {
        // utility class
    }

    public static AnalysisData getData(final HttpSession session)
    {
        AnalysisData data = (AnalysisData) session.getAttribute("analysisData");
        if (data == null)
        {
            data = new AnalysisData();
            session.setAttribute("analysisData", data);
            data.getDataSource();
        }
        return data;
    }

    public static String stripQuotes(final String s)
    {
        String ret = s.strip();
        if (ret.startsWith("\""))
            ret = ret.substring(1);
        if (ret.endsWith("\""))
            ret = ret.substring(0, ret.length() - 1);
        return ret.strip();
    }

}
