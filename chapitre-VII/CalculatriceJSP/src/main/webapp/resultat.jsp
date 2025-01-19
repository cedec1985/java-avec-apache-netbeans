<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : resultat
--%>

<%
    int nbr1 = Integer.parseInt(request.getParameter("nombre1"));
    int nbr2 = Integer.parseInt(request.getParameter("nombre2"));
    
    if (request.getParameter("addition") != null) {
        int addition = nbr1 + nbr2;
        out.println(String.valueOf(addition));

    } else if (request.getParameter("multiplication") != null) {
        int multiplication = nbr1 * nbr2;
        out.println(String.valueOf(multiplication));
    }
%>
