<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<c:import url="WEB-INF/includes/head.jsp?title=index" />
    <body>
    <c:import url="WEB-INF/includes/header.jsp" />

    <div class="container">
        <h2>Hello World!</h2>

        <p>headers:</p>


            <c:forEach items="${header}" var="item">
                <p>
                    <c:out value="${item.key} -> ${item.value}" />
                </p>
            </c:forEach>

        <hr />

        request: <c:out value="${pageContext.request}" /> <br />
        uri    : <c:out value="${pageContext.request.requestURI}" /> <br />
        url    : <c:out value="${pageContext.request.requestURL}" /> <br />
    </div>

    <c:import url="WEB-INF/includes/footer.jsp" />
    </body>
</html>
