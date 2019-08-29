<!DOCTYPE html>
<html>
<c:import url="WEB-INF/includes/header.jsp?title=index" />
    <body>
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


    </body>
</html>
