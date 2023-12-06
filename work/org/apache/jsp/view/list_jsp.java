/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2023-12-06 02:18:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import bean.Inquiry;
import java.time.format.DateTimeFormatter;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("bean.Inquiry");
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

	ArrayList<Inquiry> list = (ArrayList<Inquiry>) request.getAttribute("list");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
      out.write("<title>お問い合わせ一覧</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t\t<div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("\t\t\t<h3 class=\"my-3\">お問い合わせ一覧</h3>\r\n");
      out.write("\t\t\t<form action=\"");
      out.print( request.getContextPath() );
      out.write("/logout\" method=\"POST\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn btn-primary\">ログアウト <i class=\"fa-solid fa-arrow-right-from-bracket\"></i></button>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<table class=\"table table-striped table-hover\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">#</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">名前</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">種類</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">お問い合わせ日時</th>\r\n");
      out.write("\t\t\t\t\t<th scope=\"col\">お問い合わせ内容</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody class=\"table-group-divider\">\r\n");
      out.write("\t\t\t\t");

				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Inquiry inquiry = (Inquiry) list.get(i);
						String dateTimeString = inquiry.getSentAt().format(formatter);

						String title = inquiry.getContents();

						if (title.length() > 45) {
							title = inquiry.getContents().substring(0, 46) + "...";
						}

						int categoryId = inquiry.getCategory();
						String categoryBadge = null;

						switch(categoryId) {
						case 1:
							categoryBadge = "<span class='badge rounded-pill text-bg-warning'>料金・お支払い</span>";
							break;
						case 2:
							categoryBadge = "<span class='badge rounded-pill text-bg-primary'>講座・コース・教材</span>";
							break;
						case 3:
							categoryBadge = "<span class='badge rounded-pill text-bg-secondary'>学習の進め方</span>";
							break;
						case 4:
							categoryBadge = "<span class='badge rounded-pill text-bg-info'>受講期限</span>";
							break;
						case 5:
							categoryBadge = "<span class='badge rounded-pill text-bg-dark'>受講終了後のサポート</span>";
							break;
						case 6:
							categoryBadge = "<span class='badge rounded-pill text-bg-light'>その他</span>";
							break;
						}

						int isReplied = inquiry.getIsReplied();
						String repliedBadge = null;

						switch(isReplied) {
						case 0:
							repliedBadge = "<span class='badge rounded-pill text-bg-danger'>未返信 <i class='fa-regular fa-envelope-open'></i></span>";
							break;
						case 1:
							repliedBadge = "<span class='badge rounded-pill text-bg-success'>返信済 <i class='fa-regular fa-envelope'></i></span>";
							break;
						}
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr style=\"cursor: pointer;\" onclick=\"document.location = '");
      out.print( request.getContextPath() );
      out.write("/show?id=");
      out.print( inquiry.getInquiryId() );
      out.write("';\">\r\n");
      out.write("\t\t\t\t\t<th scope=\"row\">");
      out.print( inquiry.getInquiryId() );
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( inquiry.getName() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( categoryBadge );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( dateTimeString );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( title );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print( repliedBadge );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
 	} 
      out.write("\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
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
