# FilmReviewWeb-TeamWork-

---

## 介绍

软件工程课程团队项目作业，这是一个用于课程学习的简单Javaweb影评网站项目

## 贡献者

---

- [@HTwo2O](<https://github.com/HTwo2O>)(项目负责人)
- [@smart6666](<https://github.com/smart6666>)
- [@Mazin-hub](<https://github.com/Mazin-hub>)
- [@QiuBin666](<https://github.com/QiuBin666>)
- [@DuoRouLongShu](<https://github.com/DuoRouLongShu>)

 Project FilmReviewWeb repository belonging to ❤空植发队

## 下载

---

- Clone or download here
- [@码云地址](<https://gitee.com/DuoRouLongShu/FilmReviewWeb-TeamWork>)

## 安装教程

---

- ### 运行环境要求

  - 操作系统：windows10
  - JDK：1.8及以上
  - 数据库：mysql 8.0.15以上
  - 服务器：tomcat 9.0.0以上；NPM 6.0.0及以上
  - 其它：Node.js 12.0.0及以上；Vue 2.0.0及以上
  - IDE：推荐IDEA

- ### 安装方法（无上述运行环境要求才需要看）

  - [JDK](<https://blog.csdn.net/konggu_youlan/article/details/79942800>)
  - [数据库](<https://blog.csdn.net/bobo553443/article/details/81383194>)
  - [Tomcat](<https://blog.csdn.net/qq_40881680/article/details/83582484>)
  - [NPM&Node.js](<https://blog.csdn.net/u011342720/article/details/81267908>)
  - [Vue项目运行](<https://blog.csdn.net/wwaenig521314/article/details/73469542/>)

## 使用说明

---

1. 通过tomcat运行javaweb项目“zhiying“所打包而成的“zhiying.war”包

2. 通过nodejs的npm运行Vue项目”admin“，Scripts为“serve”

3. 将sql文件“film_review_web”导入mysql数据库中。其中数据库用户名须为root，密码为123456

   ps若数据库不想改密码，可添加root 123456的账户，或通过zhiying源代码，在src包下找到数据库配置文件druid.properties，修改对应的数据库账号和密码

4. 桌面新建一个浏览器快捷方式，设置“属性”中“目标”一栏后添加字符串“--args --disable-web-security --user-data-dir=D:\temp”（以解决javaweb项目与vue项目的跨域问题）

5. 在浏览器地址库输入http://localhost:8081/zhiying/进入  知影  影评网

6. 网站默认管理员账号为7530，密码为123456（数据库中uesr表power列为1的用户）

## 版本记录

---

- v1.0.0
  - 实现基础功能
