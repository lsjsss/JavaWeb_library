# 项目进程







---

## 2021.01.02（项目预结束）

### 新增功能

- 修复了服务器中运行mysql时报错无法解析ip地址的问题
- 新增搜索图书功能
- 修复了访客非法删除管理员角色
- 增加了限制删除指定测试用户的功能
- 增加了后台可查看用户操作记录的功能



![avatar](https://img-blog.csdnimg.cn/20210102161623865.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDM0MDEyOQ==,size_16,color_FFFFFF,t_70)

![avatar](https://img-blog.csdnimg.cn/20210102161623858.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDM0MDEyOQ==,size_16,color_FFFFFF,t_70)

![avator](https://img-blog.csdnimg.cn/2021010216404451.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDM0MDEyOQ==,size_16,color_FFFFFF,t_70#pic_center)



### 已实现功能

图书借阅

管理员新增、删除图书

编辑、删除用户

图书归还

我的借阅

搜索图书



### 待实现功能

无新增待实现功能



### 待完善功能

无新增待完善功能



### 待解决问题

无新增待解决问题



---

## 2021.01.01

### 新增功能

- 编辑、删除用户

- 图书归还

- 我的借阅

- 解决了为登录访问管理员页面的问题

- 新增欢迎界面

- 优化页面UI

  ![avatar](http://p.ananas.chaoxing.com/star3/origin/c52d6ff584c72dfecd7e74aa8004b8f3.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/4c97ee604bdd7f26781cfba06653cf5b.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/5a2b0e4e1f9be1cb347ff79c1e38f628.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/751ea00f38f627626a8e0160ef5fa187.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/f4ceaf43d707228fa5c982a60ac2eaee.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/20364b84278f0840cfbe01d586719d1a.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/f805cf44a0e590b65358345cbed3b976.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/08e2c04e5dd70e531587e64d5fa04f24.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/fa7e2ac9f936c04acedd42bb889e3851.jpg)

![avatar](http://p.ananas.chaoxing.com/star3/origin/9bee15df462e08b7fcf98f817f9971bb.jpg)



### 已实现功能

图书借阅

管理员新增、删除图书

编辑、删除用户

图书归还

我的借阅



### 待实现功能

搜索图书



### 待完善功能

无待完善功能



### 待解决问题

登陆时验证用户输入的账号或密码不正确时没有提示



---

## 2020.12.28

### 新增功能

- 修复了借阅图书时无法验证数据合法性的问题



### 已实现功能

无新增已实现功能



### 待实现功能

无新增待实现功能



### 待完善功能

无新增待完善功能



### 待解决问题

借阅图书时 Servlet 中无法获取到用户 Id ，导致无法借阅图书



---

## 2020.12.27

### 新增功能

- 图书借阅
- 管理员新增、删除图书



### 已实现功能

图书借阅

管理员新增、删除图书



### 待实现功能

编辑、删除用户

图书归还

我的借阅

搜索图书



### 待完善功能

借阅图书时无法验证数据合法性

借阅图书时无法设定借阅时间



### 待解决问题

无待解决问题



---

## 2020.12.25

### 新增功能

- 修复了 jsp 页面中提交中文数据时数据库产生乱码的问题
- 修复了管理员修改图书数量提交时转至500错误页面的问题（验证图书数量列表项时先验证字符串数据是否为空，后转为整形数据）



### 已实现功能

无新增已实现功能



### 待实现功能

无新增待实现功能



### 待完善功能

无新增待完善功能



### 待解决问题

修改图书数量时未验证数据实际情况，可能造成剩余图书数量为负数的情况



---

## 2020.12.24

### 新增功能

管理员编辑图书



### 已实现功能

管理员用户登陆界面与学生、教师用户登录界面不同（用户管理、角色管理、图书管理）

浏览所有图书

管理员浏览、添加用户

管理员浏览、新增、删除角色

管理员及用户注册、登录、注销功能



### 待实现功能

新增、删除图书

编辑、删除用户

图书借阅

图书归还

我的借阅

搜索图书



### 待完善功能

编辑图书时验证所填写的 图书数量 项

编辑图书完成后跳转显示编辑完成页面

新增用户完成后跳转显示新增完成页面（新增完成页面无提示字样）

用户登录系统时后台记录登录数据（时间、登录用户）

需新增操作记录（个人中心）页面记录用户和管理员的借书记录、登录记录，管理员的操作记录（新增、编辑、删除用户，新增、编辑、删除角色，新增、编辑、删除图书）

登录界面应具有判断用户输入账号或密码是否正确的能力，用户输入错误时应显示错误提示

显示错误提示时字体颜色应为红色



### 待解决问题

编辑图书提交时，若图书数量为空，则无法判断并显示500错误：

```java
HTTP状态 500 - 内部服务器错误

类型 异常报告
消息 For input string: ""

描述 服务器遇到一个意外的情况，阻止它完成请求。

例外情况
java.lang.NumberFormatException: For input string: ""
   java.lang.NumberFormatException.forInputString(Unknown Source)
   java.lang.Integer.parseInt(Unknown Source)
   java.lang.Integer.valueOf(Unknown Source)
   com.bms.servlet.BookServlet.doGet(BookServlet.java:56)
   com.bms.servlet.BookServlet.doPost(BookServlet.java:127)
   javax.servlet.http.HttpServlet.service(HttpServlet.java:652)
   javax.servlet.http.HttpServlet.service(HttpServlet.java:733)
   org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)

):注意 主要问题的全部 stack 信息可以在 server logs 里查看
```



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

