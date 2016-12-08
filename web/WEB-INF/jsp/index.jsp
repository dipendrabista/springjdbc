<%@include file="../../header.jsp" %>


<div class="container">
    <div class="pull-right">
        <a href="${SITE_URL}/student/add" class="glyphicon glyphicon-plus" title="add"> </a>
    </div>
    <table class="table">
        <tr class="table-hover danger">
            <td>id</td>
            <td>name</td>
            <td>action</td>
        </tr>

        <c:forEach var="student" items="${students}">

            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>
                    <a href="${SITE_URL}/student/edit?id=${student.id}" class="glyphicon btn glyphicon-pencil" title="edit"></a>
                    <a href="${SITE_URL}/student/delete?id=${student.id}" class="glyphicon btn glyphicon-trash" title="delete" onclick="return confirm("Are you sure to delete?")"></a>
                </td>
            </tr>




        </c:forEach>
    </table>


</div>

<%@include file="../../footer.jsp" %>