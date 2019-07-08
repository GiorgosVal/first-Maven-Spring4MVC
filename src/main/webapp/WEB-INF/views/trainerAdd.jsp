<%-- 
    Document   : trainerAdd
    Created on : Jul 7, 2019, 7:56:04 PM
    Author     : giorgos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Trainer</title>
        <link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
    </head>
    <body>
        <h1>${title}</h1>
        <f:form method="POST" action="${action}" modelAttribute="trainer" class="form-horizontal">
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="id">Id</label>
                    <div class="col-md-7">
                        <f:input type="hidden" path="id" id="id" class="form-control input-sm"  />
                        <div class="has-error">
                            <f:errors path="id" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="firstName">First Name</label>
                    <div class="col-md-7">
                        <f:input type="text" path="tfname" id="firstName" class="form-control input-sm" />
                        <div class="has-error">
                            <f:errors path="tfname" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                    <div class="col-md-7">
                        <f:input type="text" path="tlname" id="lastName" class="form-control input-sm" />
                        <div class="has-error">
                            <f:errors path="tlname" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="subj">Subject</label>
                    <div class="col-md-7">
                        <f:input type="text" path="tsubject" id="subj" class="form-control input-sm" />
                        <div class="has-error">
                            <f:errors path="tsubject" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="dob">Date of birth</label>
                    <div class="col-md-7">
                        <f:input type="date" path="tdob" id="dob" class="form-control input-sm" />
                        <div class="has-error">
                            <f:errors path="tdob" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-actions floatRight">
                    <input type="submit" value="Register" class="btn btn-primary btn-sm">
                </div>
            </div>
        </f:form>

    </body>
</html>
