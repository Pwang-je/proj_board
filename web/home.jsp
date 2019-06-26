<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>

<%@include file="WEB-INF/views/include/head.jsp"%>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <%@include file="WEB-INF/views/include/main_header.jsp"%>

    <!-- Left side column. contains the logo and sidebar -->
    <%@include file="WEB-INF/views/include/left_column.jsp"%>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <%@include file="WEB-INF/views/include/main_footer.jsp"%>
</div>
<!-- ./wrapper -->

<%--<%@include file="WEB-INF/views/include/plugin_js.jsp"%>--%>
<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="resources/dist/js/adminlte.min.js"></script>
</body>
</html>