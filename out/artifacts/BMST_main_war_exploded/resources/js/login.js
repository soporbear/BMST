layui.use(['element', 'form'], function(){
    var layer = layui.layer
        ,form = layui.form;

    form.on('submit(login)', function(data){
        $.post('login/check', data.field, function(flag) {
            if(flag==='true') {
                layer.msg('登录成功：'+data.field['userName']+'，欢迎', {offset: '410px'});
                setTimeout(function () {
                    window.location.href='/manage/article/';
                }, 500);
            }
            else if(flag==='false') {
                layer.msg('登录失败：用户名或密码错误', {offset: '410px'});
            }
        });

        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
});

