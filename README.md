# 项目进程





---

## 2020.12.23

### 已实现功能

管理员用户登陆界面与学生、教师用户登录界面不同（用户管理、角色管理、图书管理）
浏览所有图书
管理员浏览、添加用户
管理员浏览、新增、删除角色
登录、注销功能
注册功能

### 待实现功能

管理员新增、编辑、删除图书
编辑、删除用户
图书借阅
图书归还
我的借阅
搜索图书

### 待完善功能

添加用户时验证所填写表单
新增角色后，注册用户时用户属性实时更新
进入首页时自动进入图书列表

### 待解决问题

服务器长时间运行 Tomcat 出现错误：

```java
23-Dec-2020 10:39:47.643 信息 [http-nio-8080-exec-1] org.apache.coyote.http11.Http11Processor.service 解析 HTTP 请求 header 错误注意：HTTP请求解析错误的进一步发生将记录在DEBUG级别。
        java.lang.IllegalArgumentException: 请求头太大
        at org.apache.coyote.http11.Http11InputBuffer.parseHeaders(Http11InputBuffer.java:604)
        at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:283)
        at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)
        at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)
        at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1589)
        at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
        at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
        at java.lang.Thread.run(Unknown Source)
```

服务器长时间运行 mysqlId 警告：

```
201223 16:19:52 [Warning] IP address '***.***.***.***' could not be resolved: 不知道这样的主机。
```

### 新增功能

注册用户时验证用户名是否存在，验证密码长度
用户注册后自动登录，直接跳转至图书列表

