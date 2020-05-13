# 影评网站后台API接口及数据库文档

## 1.API说明

### 1.1接口信息

* 服务端**未开启** 跨域支持 ，开发时用本地服务器。
* 接口基准地址：http://localhost:8080/FilmReviewWeb/
* 数据返回格式统一使用 JSON

### 1.2请求方法

* GET ：向特定资源发出请求（请求指定页面信息，并返回实体主体）；无消息体，只能携带少量数据，且不安全；提交的数据最多只能有1024字节。
* POST ：向指定资源提交数据进行处理请求（提交表单、上传文件），又可能导致新的资源的建立或原有资源的修改；有消息体，可以携带大量数据，且安全；提交的数据大小无限制；



## 2.API细节

### 2.1首页





### 2.2登录注册

#### 2.2.1登录

* 请求路径：login

* 请求方法：post

* 请求参数：

  | 参数名   | 参数说明 | 类型|  默认值 | 必填      | 备注 |
  | -------- | ------ | ------ | ---- | -------------- | ---- |
  | user     | 用户名或用户id |       string |    |是 |      |
  | password | 密码 |  string      |    |         是       |      |

* 响应

  * 成功：页面跳转

  * 失败：返回数据

    | 响应参数 | 说明           | 备注 |
    | -------- | -------------- | ---- |
    | user     | 请求的user参数 |      |
  
* 响应数据

  ```
  {
  	data:{
  		user:"xxx"
  	},
  	message:"用户不存在或密码错误"
  }
  ```

  

### 2.3电影库展列

#### 2.3.1搜索

* 请求路径：search

* 请求方法：get

* 请求参数：

  | 参数名   | 参数说明 | 类型|  默认值 | 必填      | 备注 |
| -------- | ------ | ------ | ---- | -------------- | ---- |
  | word | 搜索的关键词 |       string | all |否 |      |

* 请求响应

  | 响应参数      | 说明             | 备注 |
  | ------------- | ---------------- | ---- |
  | number        | 电影集合元素数量 |      |
  | list.filmName | 电影名字         |      |
  | list.filmYear | 电影上映年份     |      |
  | list.filmArea | 电影地区         |      |

* 响应数据

  ```
  {
  	data:{
  		number:2,
  		list:{
  			{
  				fileName:"乱世佳人",
  				fileYear："1968",
  				fileArea:"美国"
  			},
  			{
       			fileName:"长城",
  				fileYear："2017",
  				fileArea:"中国"
  			}
  		}
  	},
  	message:"搜索成功"
  }
  ```

  

### 2.4特定电影页面

#### 2.4.1获取电影数据

* 请求路径：filmpage/getData

* 请求方法：get

* 请求参数：

  | 参数名   | 参数说明 | 类型   | 默认值 | 必填 | 备注 |
| -------- | -------- | ------ | ------ | ---- | ---- |
  | filmName | 电影名称 | string |        | 是   |      |

* 请求响应

  | 响应参数  | 说明     | 备注     |
  | --------- | -------- | -------- |
  | filmId    | 电影id   |          |
  | filmName  | 电影名字 |          |
  | rating    | 评分     | 0.0-10.0 |
  | area      | 电影地区 |          |
  | director  | 导演     |          |
  | writer    | 编剧     |          |
  | performer | 演员     |          |
  | genre     | 题材     |          |
  | language  | 语言     |          |
  | duration  | 片长     |          |
  | synopsis  | 梗概     |          |

* 响应数据

  ```
  {
  	message:"搜索成功",
  	data:{
  			{
  				filmId:"0001",
  				idfilmName:"xxx",
  				rating:5.6,
  				area:"中国",
  				director:"胡可",
  				writer:"许可",
  				performer:"赵薇、黄晓明",
  				genre:"历史",
  				language:"中文",
  				duration:"123min",
  				synopsis:"东汉末年....."
  			},
  			{
  				filmId:"0002",
  				idfilmName:"xxx",
  				rating:5.6,
  				area:"中国",
  				director:"胡可",
  				writer:"许可",
  				performer:"赵薇、黄晓明",
  				genre:"历史",
  				language:"中文",
  				duration:"123min",
  				synopsis:"东汉末年....."
  			}
  		}
  	},
  	dataCount:2,
  	pageCount:1	
  }
  ```

### 2.5用户个人中心





### 2.6管理员个人中心





## 3.数据库