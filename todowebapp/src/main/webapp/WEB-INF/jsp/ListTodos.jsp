<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
    <head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
        <title> List Todos Page</title>
    </head>
    <body>
    <%@ include file="common/navigation.jspf" %>
    <div class="container">
            <div> <h2>Your Todos are :</h2></div>
            <table class="table">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Target DATE</th>
                    <th>Is Done?</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                     <c:forEach items="${todos}" var="todo">
                         <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning"> Delete </a> </td>
                            <td> <a href="update-todo?id=${todo.id}" class="btn btn-success"> Update </a> </td>
                         </tr>
                     </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success"> Add Todo</a>
            </div>
            <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
            <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>
</html>