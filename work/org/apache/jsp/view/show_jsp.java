/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2023-12-08 00:15:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import bean.*;
import java.time.format.DateTimeFormatter;

public final class show_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/view/../common/head.jsp", Long.valueOf(1701390492539L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("bean");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.time.format.DateTimeFormatter");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	//リクエストスコープからのデータの取得
	ArrayList<Reply> list = (ArrayList<Reply>) request.getAttribute("list");

	Inquiry inquiry = (Inquiry) request.getAttribute("inquiry");

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String dateTimeString = inquiry.getSentAt().format(formatter);

	int categoryId = inquiry.getCategory();
	String subject = null;

	switch(categoryId) {
	case 1:
		subject = "料金・お支払いについて";
		break;
	case 2:
		subject = "講座・コース・教材について";
		break;
	case 3:
		subject = "学習の進め方について";
		break;
	case 4:
		subject = "受講期限について";
		break;
	case 5:
		subject = "受講終了後のサポートについて";
		break;
	case 6:
		subject = "その他";
		break;
	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v6.1.2/css/all.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>");
      out.write("\r\n");
      out.write("<title>お問い合わせ詳細：#");
      out.print( inquiry.getInquiryId() );
      out.write(' ');
      out.write('|');
      out.write(' ');
      out.print( subject );
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("\t\t\t<h3 class=\"my-3\">#");
      out.print( inquiry.getInquiryId() );
      out.write(' ');
      out.print( subject );
      out.write("</h3>\r\n");
      out.write("\t\t\t<div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/list\" method=\"POST\" class=\"mx-3\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">一覧へ <i class=\"fa-solid fa-list\"></i></button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/logout\" method=\"POST\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">ログアウト <i class=\"fa-solid fa-arrow-right-from-bracket\"></i></button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card border-secondary mb-3\">\r\n");
      out.write("\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t<span class=\"fw-bold\"><i class=\"fa-regular fa-user\"></i> ");
      out.print( inquiry.getName() );
      out.write("</span>&emsp;\r\n");
      out.write("\t\t\t\t<span>");
      out.print( inquiry.getEmail() );
      out.write("</span>&emsp;\r\n");
      out.write("\t\t\t\t<span>");
      out.print( dateTimeString );
      out.write("</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t");
      out.print( inquiry.getContents() );
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t");
 if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Reply reply = (Reply) list.get(i);
				String repliedAt = reply.getRepliedAt().format(formatter);
				String contents = reply.getContents();
				contents = contents.replace("\n", "<br>");
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"card border-secondary mb-3\">\r\n");
      out.write("\t\t\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t\t\t<span class=\"fw-bold\"><i class=\"fa-regular fa-comments\"></i> 担当者</span>&emsp;\r\n");
      out.write("\t\t\t\t\t\t<span>");
      out.print( repliedAt );
      out.write("</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( contents );
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t<div class=\"card border-secondary\">\r\n");
      out.write("\t\t\t<div class=\"card-header\">\r\n");
      out.write("\t\t\t\t<span class=\"fw-bold\"><i class=\"fa-solid fa-reply\"></i> 返信欄</span>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/reply\" method=\"GET\">\r\n");
      out.write("\t\t\t\t\t<div class=\"mb-3\">\r\n");
      out.write("\t\t\t\t\t\t<textarea required class=\"form-control\" name=\"contents\" rows=\"8\"></textarea>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"email\" value=\"");
      out.print( inquiry.getEmail() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print( inquiry.getInquiryId() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"subject\" value=\"");
      out.print( subject );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">送信 <i class=\"fa-regular fa-paper-plane\"></i></button>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
