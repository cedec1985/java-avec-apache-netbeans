<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : calculatrice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <link href="https://unpkg.com/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet" />
    
    <body>
        <div class="container">
            <br/>
            <div class="row">            
                <form>  <!-- name="myForm" action="Calcul" method="POST">   -->
                    <div class="col-sp-8">
                        <div class="form-group"> 
                            <td>Nombre 1</td>
                            <input type="text" class="form-control" maxlength="3" name="nombre1" id="nombre1" value="" /> <br/>
                        </div>
                        
                        <div class="form-group">                    
                            <td>Nombre 2</td>
                            <input type="text" class="form-control" name="nombre2" id="nombre2" value="" /> <br/>
                        </div>
                    </div>
                    
                    <div class="col-sp-4">
                        <input type="submit" class="btn btn-primary" value="Addition" name="addition" onclick="additionner()" /> 
                        <input type="submit" class="btn btn-primary" value="Multiplication" name="multiplication" onclick="multiplier()"/>
                        <input type="reset" class="btn btn-primary" value="CE" name="clear" />
                    </div>
                </form>            
            </div>
        </div>
            
        <script type="text/javascript">
            function additionner()
            {
               var nb1 = parseInt(document.getElementById("nombre1").value);
               var nb2 = parseInt(document.getElementById("nombre2").value);
               var resulat = nb1 + nb2;
               alert(resulat);
            }
            function multiplier()
            {
               var nb1 = parseInt(document.getElementById("nombre1").value);
               var nb2 = parseInt(document.getElementById("nombre2").value);
               var resulat = nb1 * nb2;
               alert(resulat);
            }    
        </script>
    </body>
</html>

<jsp:useBean id="prs" scope="page" class="entities.Personne" />
<jsp:setProperty name="prs" property="prenom" value="Pierre" />
<jsp:getProperty name="prs" property="prenom" />