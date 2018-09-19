$(function(){
    switch (window.location.pathname.split('/')[2]) {
        case 'user':
            $("#main").append(
                "<table id=\"table\" class=\"layui-table\" style=\"table-layout:fixed\">\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th>序号</th>\n" +
                "            <th>用户名</th>\n" +
                "            <th>密码</th>\n" +
                "            <th>操作</th>\n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "    <tbody></tbody>\n" +
                "</table>");
            $("#main").prepend(
                "<div style=\"margin: 10px; float: left\">\n" +
                "  <span class=\"layui-breadcrumb\" lay-separator='/' style=\"visibility: visible;\">\n" +
                "    <a href=\"\">实体管理</a>\n" +
                "    <a><cite>用户管理</cite></a>\n" +
                "  </span>\n" +
                "</div>"
            );
            break;
        case 'article':
            $("#main").append(
                "<table id=\"table\" class=\"layui-table\" style=\"table-layout:fixed\">\n" +
                "    <thead>\n" +
                "        <tr>\n" +
                "            <th>序号</th>\n" +
                "            <th>标题</th>\n" +
                "            <th>作者</th>\n" +
                "            <th>内容</th>\n" +
                "            <th>日期</th>\n" +
                "            <th>操作</th>\n" +
                "        </tr>\n" +
                "    </thead>\n" +
                "    <tbody></tbody>\n" +
                "</table>");
            $("#main").prepend(
                "<div style=\"margin: 10px; float: left\">\n" +
                "  <span class=\"layui-breadcrumb\" lay-separator='/' style=\"visibility: visible;\">\n" +
                "    <a href=\"\">实体管理</a>\n" +
                "    <a><cite>文章管理</cite></a>\n" +
                "  </span>\n" +
                "</div>"
            );
            break;
    }
    $.getJSON("getData", function(data){
        console.log(data);
        var tbody = $("table").find("tbody");
        $.each(data, function(i, iEl){
                var tr = $("<tr></tr>");
                $.each(iEl, function(j, jEl){
                    var td = $("<td></td>");
                    if (j==="date"){
                        var date = new Date(jEl);
                        td.text(date.getFullYear()+"-"
                            +date.getMonth()+"-"
                            +date.getDate()+" "
                            +date.getHours()+":"
                            +date.getMinutes()+":"
                            +date.getSeconds())
                    }
                    else
                        td.text(jEl);
                    tr.append(td);
                });
                var td = $(
                    "<td>\n" +
                    "    <button id=\""+(i+1)+"\" onclick='updateClick(this.id)' type='button' class='layui-btn layui-btn-sm'>修改</button>\n" +
                    "    <button onclick=\"deleteClick("+tr.children()[0].innerText+")\" type='button' class='layui-btn layui-btn-sm'>删除</button>\n" +
                    "</td>"
                );
                tr.append(td);
                tbody.append(tr);
            });
    });
});

var updateClick = function (id) {
    $("table").wrap("<form action=\"update\" method=\"GET\" class='layui-form'></form>")
    var tr = $("#" + id).parents("tr");
    switch (window.location.pathname.split('/')[2]) {
        case 'user':
            tr.after(
                "    <tr>\n" +
                "        <td>" + tr.children()[0].innerText + "</td>\n" +
                "        <td>\n" +
                "            <input name=\"userName\" placeholder=\"" + tr.children()[1].innerText + "\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input name=\"password\" placeholder=\"" + tr.children()[2].innerText + "\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input type=\"hidden\" name=\"id\" value=\"" + tr.children()[0].innerText + "\">\n" +
                "            <input type=\"submit\" class=\"layui-btn layui-btn-sm\" value=\"提交\">" +
                "            <input type='button' onclick=\"$(this).parents('tr').prev().show();$(this).parents('tr').remove()\" class='layui-btn layui-btn-sm' value='取消'>\n" +
                "        </td>\n" +
                "    </tr>"
            );
            break;
        case 'article':
            tr.after(
                "    <tr>\n" +
                "        <td>" + tr.children()[0].innerText + "</td>\n" +
                "        <td>\n" +
                "            <input name=\"title\" placeholder=\"" + tr.children()[1].innerText + "\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input name=\"author\" placeholder=\"" + tr.children()[2].innerText + "\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input name=\"content\" placeholder=\"" + tr.children()[3].innerText + "\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>" + tr.children()[4].innerText + "</td>\n" +
                "        <td>\n" +
                "            <input type=\"hidden\" name=\"id\" value=\"" + tr.children()[0].innerText + "\">\n" +
                "            <input type=\"submit\" class=\"layui-btn layui-btn-sm\" value=\"提交\">" +
                "            <input type='button' onclick=\"$(this).parents('tr').prev().show();$(this).parents('tr').remove()\" class='layui-btn layui-btn-sm' value='取消'>\n" +
                "        </td>\n" +
                "    </tr>"
            );
            break;
    }
    tr.hide();
};

var insertClick = function () {
    switch (window.location.pathname.split('/')[2]) {
        case 'user':
            $("tbody").prepend(
                "    <tr>\n" +
                "        <td></td>\n" +
                "        <td>\n" +
                "            <input name=\"userName\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input name=\"password\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input type=\"submit\" class=\"layui-btn\" value=\"提交\">\n" +
                "        </td>\n" +
                "    </tr>"
            );
            break;
        case 'article':
            $("tbody").prepend(
                "    <tr>\n" +
                "        <td></td>\n" +
                "        <td>\n" +
                "            <input name=\"title\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input name=\"author\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td>\n" +
                "            <input name=\"content\" class=\"layui-input\">\n" +
                "        </td>\n" +
                "        <td></td>\n" +
                "        <td>\n" +
                "            <input type=\"submit\" class=\"layui-btn\" value=\"提交\">\n" +
                "        </td>\n" +
                "    </tr>"
            );
            break;
    }
    $("table").wrap("<form action=\"insert\" method=\"GET\"></form>");
};

var deleteClick = function (id) {
    window.location.replace("delete?id="+id);
}
