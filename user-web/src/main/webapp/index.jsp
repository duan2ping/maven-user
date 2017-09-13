<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%><br>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<script type="application/javascript" src="js/jquery-2.2.3.js"></script>
<script>
    var click_cnt = 0;
    var x_max = $(document.body).width();
    var y_max = $(document.body).height();
    jQuery(document).ready(function($) {

        //setInterval(function(){alert(1)},1000);
        setInterval('show()',10);
    });
    function show() {
        var n = 18;
        var $i;
        click_cnt++;
        // 可动态切换内容
        $i = $("<b></b>").text("❤");
        n = Math.round(Math.random() * 14 + 6);
        var x = parseInt(Math.random()*x_max),
            y = parseInt(Math.random()*y_max);
        $i.css({
            "z-index": 9999,
            "top": y - 20,
            "left": x,
            "position": "absolute",
            "color": "#E94F06",
            "font-size": n,
            "-moz-user-select": "none",
            "-webkit-user-select": "none",
            "-ms-user-select": "none"
        });
        $("body").append($i);
        $i.animate({
            // 控制方向，y + number --->向下
            "top": y - 180,
            "opacity": 0
        // 控制消失时间
        }, 5000, function () {
            $i.remove();
        });
    }

</script>
<body>
<h2 align="center">用户列表</h2>
<table align="center" border="1" cellspacing="0">
    <tr>
        <th>用户名</th>
        <th>手机号</th>
    </tr>
    <c:forEach var="user" items="${ulist}" varStatus="vs">
        <tr ${vs.index%2==0?"bgcolor='gray'":''}>
            <td align="center" width="200px">${user.name}</td>
            <td align="center" width="200px">${user.phone}</td>
        </tr>
    </c:forEach>
  <%--  <%
        List<User> list = (List<User>)request.getAttribute("ulist");
        for(int i = 0 ; i < list.size() ; i++) {
    %>
            <tr ><td ><%=list.get(i).getName()%></td ><td><%=list.get(i).getPhone()%></td></tr >

   <%
        }
    %>--%>
</table>
</body>
</html>
