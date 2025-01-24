<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
           <div class="container">
           <h1>Enter Todo Details:</h1>
           <form:form method="post" modelAttribute="toDo">

                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" name="description" required="required"/>
                    <form:errors path="description" cssClass="text-w"/>
                </fieldset>

                <fieldset class="mb-3">
                     <form:label path="targetDate">Target Date</form:label>
                     <form:input type="text" path="targetDate" name="description" required="required"/>
                     <form:errors path="targetDate" cssClass="text-w"/>
                </fieldset>

                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="done" />
                <input type="submit" class="btn btn-success"/>

           </form:form>
          </div>
            <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
            <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
            <script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
            <script type="text/javascript">
            	$('#targetDate').datepicker({
            	    format: 'yyyy-mm-dd'
            	});
            </script>
    </body>
</html>

