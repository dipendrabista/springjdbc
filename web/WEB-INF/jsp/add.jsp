<%-- 
    Document   : add
    Created on : Dec 6, 2016, 6:10:18 PM
    Author     : punoj123
--%>

<%@include file="../../header.jsp" %>

<form action="${SITE_URL}/student/add" method="post">
    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" class="form-control"/>
    </div>
    <input type="submit" value="add"  class="btn btn-success"/>
</form>

<%@include file="../../footer.jsp" %>