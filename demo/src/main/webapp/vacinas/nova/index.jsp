<!--
  Created by IntelliJ IDEA.
  User: matheuscoqueiro
  Date: 04/08/2022
  Time: 23:15
  To change this template use File | Settings | File Templates.
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" xmlns="http://www.w3.org/1999/xhtml" version="2.0">
    <html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Vacinas</h1>
        <ul>
            <c:forEach items="${vacinas}" var="vacinas">
                <li> ${vacinas.getNome()} </li>
            </c:forEach>
        </ul>
    </body>
    </html>
</jsp:root>