# bootstrap系统

Bootstrap网站优选：http://www.youzhan.org/

# 一、bootstrap了解

## 1.1 模板

### 1.1.1 下载

> 用于生产环境的 Bootstrap，编译并压缩后的 CSS、JavaScript 和字体文件。不包含文档和源码文件。

### 1.1.2 CDN 加速服务

> [Bootstrap 中文网](http://www.bootcss.com/) 联合 [又拍云](https://www.upyun.com/) 共同为 Bootstrap 专门构建了免费的 CDN 加速服务，访问速度更快、加速效果更明显、没有速度和带宽限制、永久免费。BootCDN 还对大量的前端开源工具库提供了 CDN 加速服务
>
> BootCDN官网：http://www.bootcdn.cn/

```javascript
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
```

### 1.1.3 jquery引入

> 请注意，Bootstrap 的所有 JavaScript 插件都依赖 jQuery，因此 jQuery 必须在 Bootstrap 之前引入，就像在基本模版中所展示的一样。在 bower.json 文件中 列出了 Bootstrap 所支持的 jQuery 版本。

### 1.1.4 最终模板

```javascript
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"> <!--告诉IE浏览器用最新的引擎去渲染页面-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1 class="page-header">Hello Bootstrap !</h1>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>
```

## 1.2 预编译版目录

> 下载压缩包之后，将其解压缩到任意目录即可看到以下（压缩版的）目录结构：

```javascript
bootstrap/
            ├── css/
            │   ├── bootstrap.css
            │   ├── bootstrap.css.map
            │   ├── bootstrap.min.css
            │   ├── bootstrap.min.css.map
            │   ├── bootstrap-theme.css
            │   ├── bootstrap-theme.css.map
            │   ├── bootstrap-theme.min.css
            │   └── bootstrap-theme.min.css.map
            ├── js/
            │   ├── bootstrap.js
            │   └── bootstrap.min.js
            └── fonts/
                ├── glyphicons-halflings-regular.eot
                ├── glyphicons-halflings-regular.svg
                ├── glyphicons-halflings-regular.ttf
                ├── glyphicons-halflings-regular.woff
                └── glyphicons-halflings-regular.woff2
```

> 上面展示的就是 Bootstrap 的基本文件结构：预编译文件可以直接使用到任何 web 项目中。我们提供了编译好的 CSS 和 JS (bootstrap.*) 文件，还有经过压缩的 CSS 和 JS (bootstrap.min.*) 文件。同时还提供了 CSS 源码映射表 (bootstrap.*.map) ，可以在某些浏览器的开发工具中使用。同时还包含了来自 Glyphicons 的图标字体，在附带的 Bootstrap 主题中使用到了这些图标。



# 二、媒体查询

## 1.1 link标签

```javascript
<link rel="stylesheet" href="mobile.css" media="(max-width:480px)">//当页面宽度小于480px的时候就会应用mobile.css里面的样式 适用于所有的
 <link rel="stylesheet" href="mobile.css" media="print">//适用于打印机
```

## 1.2 浏览器窗口和设备宽高

> 浏览器的宽高是页面的宽高，而设备的宽高是指手机，电脑等设备的宽高

### 1.2.1 max-width max-device-width

> 可视窗口的宽度  @media(max-width:480px){ ...}
>
> 设备的宽度      @media(max-device-width:480px){ ...}

### 1.2.2 max-height max-device-height

> 可视窗口的高度  @media(max-height:480px){ ...}
>
> 设备的高度      @media(max-device-height:480px){ ...}

### 1.2.3 宽高比

> 可视窗口    @media(aspect-radio: 3/2 ){ ... }       	页面的宽高比为3:2的时候
>
> 设备的      @media(device-aspect-radio: 3/2 ){ ... }   	当设备的宽高比为3/2的时候  设备是指电脑或手机等设备的屏幕

### 1.2.4 设备方向

> landscape   水平  media(orientation: landscape){...}  当设备方向是水平的时候
>
> portrait    垂直  media(orientation: portrait){...}   	当设备方向是垂直的时候

## 1.3 操作符

### 1.3.1 and（表示与）

> @media screen and (max-width: 480px){...}   表示在屏幕和可视窗口小于480px设备上显示
>
> @media screen and (max-width: 767px) and (min-width: 480px){...}    表示在屏幕且最小宽度480最大宽度767像素

### 1.3.2 or(,)表示或

> @media screen and (min-width: 767px) ,screen and (orientation: portrait){...} 表示都为屏幕且最小宽度为767或者屏幕方向为垂直

### 1.3.3 not(否定)

> @media not screen and (min-width: 767px) 在屏幕小于767px的时候
>
> @media not screen and (min-width: 767px),screen and (min-width: 480px){...} 如果有逗号的时候not否定逗号后面的
>
> 注意：在使用not的时候一定要给屏幕类型 如果不给永远返回一个假的值，因为默认是所有屏幕都可以使用的

# 三、栅格系统

> Bootstrap 提供了一套响应式、移动设备优先的流式栅格系统，随着屏幕或视口（viewport）尺寸的增加，系统会自动分为最多12列。它包含了易于使用的预定义类，还有强大的mixin 用于生成更具语义的布局。

## 1.1 辅助类

### 1.1.1 页头

```html
<h1 class="page-header">Hello Bootstrap!</h1> <!--.page-header页头-->
```

### 1.1.2 alert

> class="alert alert-info"    bootstrap设置好的样式

```html
<p class="alert alert-info">
     This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
 </p>
```



### 1.1.3 容器

> .container 类用于固定宽度并支持响应式布局的容器
>
> .container-fluid	100% 宽度   左右内补15px

```html
<div class="container"></div>
<div class="container-fluid"></div>
```

#### container容器详情：

​		

| 页面宽度   | 左右内补            | container实际宽度 |
| ------ | --------------- | ------------- |
| 1200px | padding: 0 15px | 1170px        |
| 992px  | padding: 0 11px | 970px         |
| 768px  | padding: 0 9px  | 750px         |
| <768px | padding: 0 15px | 100%          |
|        |                 |               |

### 1.1.4 情景色

#### 1. 情景文本

>  通过颜色来展示意图，Bootstrap 提供了一组工具类。这些类可以应用于链接，并且在鼠标经过时颜色可以还可以加深，就像默认的链接一样。

```html
<p class="text-muted">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-primary">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-success">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-info">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-warning">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="text-danger">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
```



#### 2. 情境背景色

> 和情境文本颜色类一样，使用任意情境背景色类就可以设置元素的背景。链接组件在鼠标经过时颜色会加深，就像上面所讲的情境文本颜色类一样。

```html
<p class="bg-primary">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-success">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-info">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-warning">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
<p class="bg-danger">Fusce dapibus, tellus ac cursus commodo, tortor mauris nibh.</p>
```

### 1.1.5 关闭按钮  三角符号    快速浮动

> 1. 关闭按钮    通过使用一个象征关闭的图标，可以让模态框和警告框消失。
> 2. 三角符号    通过使用三角符号可以指示某个元素具有下拉菜单的功能。注意，向上弹出式菜单中的三角符号是反方向的。
> 3. 快速浮动    通过添加一个类，可以将任意元素向左或向右浮动。!important 被用来明确 CSS 样式的优先级。这些类还可以作为 mixin（参见 less 文档） 使用。不能用于导航条组件中 排列导航条中的组件时可以使用这些工具类：.navbar-left 或 .navbar-right

#### 1. 关闭按钮

```html
<button type="button" class="close" aria-label="Close">
	<span aria-hidden="true">&times;</span>
</button>
```

#### 2. 三角符号

```html
<span class="caret"></span>
```

#### 3. 快速浮动

```html
<div class="pull-left">...</div>
<div class="pull-right">...</div>
```

#### 4. 清除浮动

> 通过为父元素添加 .clearfix 类可以很容易地清除浮动（float）

```html
<div class="clearfix">
	<div class="pull-left">...</div>
	<div class="pull-right">...</div>
</div>
```



## 1.2 栅格系统

### 1.2.1 简介

> 栅格系统用于通过一系列的行（row）与列（column）的组合来创建页面布局，你的内容就可以放入这些创建好的布局中。工作原理：

> 1. “行（row）”必须包含在 .container （固定宽度）或 .container-fluid （100% 宽度）中，以便为其赋予合适的排列（aligment）和内补（padding）。
> 2. 栅格系统中的列是通过指定1到12的值来表示其跨越的范围。例如，三个等宽的列可以使用三个 .col-md-4 来创建。
> 3. 如果一“行（row）”中包含了的“列（column）”大于 12，多余的“列（column）”所在的元素将被作为一个整体另起一行排列。
> 4. 栅格类适用于与屏幕宽度大于或等于分界点大小的设备 ， 并且针对小屏幕设备覆盖栅格类。 因此，在元素上应用任何 .col-md-* 栅格类适用于与屏幕宽度大于或等于分界点大小的设备 ， 并且针对小屏幕设备覆盖栅格类。 因此，在元素上应用任何 .col-lg-* 不存在， 也影响大屏幕设备。（也就是说通常我们以col-md-*来设定所占栅格）

### 1.2.2 尺寸

| 代码      | 屏幕            | 使用范围        | container最大宽度 |
| ------- | ------------- | ----------- | ------------- |
| col-xs- | 特小尺寸为手机准备     | 小于768px时使用  | 自动            |
| col-sm- | 小尺寸为平板电脑准备    | 大于768px时使用  | 750px         |
| col-md- | 中等尺寸为普通电脑屏幕准备 | 大于992px时使用  | 970px         |
| col-lg- | 中等尺寸为大电脑屏幕准备  | 大于1200px时使用 | 1170px        |
|         |               |             |               |

### 1.2.3 列排序和偏移

#### 1. 列排序 col-md-push- 和 col-md-pull

```java
col-md-push-    在中等尺寸下向右推...网格
col-md-pull-    在中等尺寸下向左拉...网格

<div class="col-md-6 col-md-push-4"></div>
<div class="col-md-6 col-md-pull-8"></div>
```

##### 代码案例：

```javascript
<div class="container">
        <h2 class="page-header">栅格系统基础</h2>
        <div class="row"
            <div class="col-md-8 col-md-push-4 "> <!--向右推4个网格-->
                <h3>主体</h3>
                <p class="alert alert-info">
                This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
        <div class="col-md-4 col-md-pull-8 "> <!--向左拉8个网格-->
                <h3>边栏</h3>
                <p class="alert alert-info">
                This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
        </div>
    </div>
```

#### 2. col-md-offset- 偏移

> col-md-offset-      向右偏移...个网格

##### 代码：

```javascript
<div class="container">
        <h2 class="page-header">栅格系统偏移空间</h2>
        <div class="row">
            <div class="col-md-6 col-md-offset-2 ">
                <h3>主体</h3>
                <p class="alert alert-info">
                    This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
            <div class="col-md-4"> <!--向右偏移2个网格-->
                <h3>边栏</h3>
                <p class="alert alert-info">
                    This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
        </div>
    </div>
```

#### 3. 区别：

> 实现方式的区别：col-md-offset-*，是利用margin-left实现的，col-md-push-*/col-md-pull-*是利用相对定位实现的。
>
> 效果的区别：
>
> ​	1、col-md-offset-*只能向右偏移，因为实现方式就是margin-left，而push/pull因为是相对定位，既可以左偏移也可以右偏移
>
>    	2、如果一行的偏移量+实际的宽度综合超过12，col-md-offset会换行显示，也是因为margin。而定位的pull和push则不会影响其他元素
>
> ​	3、从功能上来看：push和pull可以用来给元素换位置，比较灵活。

## 1.3 嵌套

> 栅格系统之间可以进行嵌套
>
> 注意：当本栅格列占满以后会换行显示，同浮动类似，如果被卡住，需要清除浮动

#### 清除浮动的方法: 被卡住的元素前加一个空盒子并添加clearfix类

```javascript
 <div class="clearfix"></div>   <!--清除浮动-->
```



```javascript
<div class="container">
        <h2 class="page-header">栅格系统嵌套</h2>
        <div class="row">
            <div class="col-md-8 ">
                <h3>主体</h3>
                <div class="row">
                    <div class="col-md-4">
                        <h4>区块一</h4>
                        <p class="alert alert-info">
                            This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                            This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                        </p>
                    </div>
                    <div class="col-md-4">
                        <h4>区块二</h4>
                        <p class="alert alert-info">
                        This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                        </p>
                    </div>
                    <!--当一行占满以后就会换行-->
                    <div class="col-md-4">
                        <h4>区块三</h4>
                        <p class="alert alert-info">
                            This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                        </p>
                    </div>
                    <div class="clearfix"></div>   <!--清除浮动-->
                    <div class="col-md-6">
                        <h4>区块四</h4>
                        <p class="alert alert-info">
                            This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                        </p>
                    </div>
                    <div class="col-md-6">
                        <h4>区块五</h4>
                        <p class="alert alert-info">
                            This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                        </p>
                    </div>

                </div>
            </div>
            <div class="col-md-4 ">
                <h3>边栏</h3>
                <p class="alert alert-info">
                    This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
        </div>
    </div>
```

## 1.4 显示与隐藏

> visible-sm  只有在小尺寸上才会显示     其他尺寸上隐藏
>
> hidden-sm   只有在小尺寸上隐藏   其他尺寸上显示

#### 代码展示：

```javascript
<div class="container">
        <h2 class="page-header">显示与隐藏</h2>
        <div class="row">
            <div class="col-md-6">
                <h3>主体</h3>
                <h4 class="visible-sm alert alert-info">在小尺寸上显示</h4>
                <p>
                    This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
            <div class="col-md-6"> 
                <h3>边栏</h3>
                <h4 class="hidden-sm alert alert-info">在小尺寸上隐藏</h4>
                <p>
                    This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.
                </p>
            </div>
        </div>
    </div>
```

# 四、bootstrap组件

## 1.1 排版

> HTML 中的所有标题标签，<h1> 到 <h6> 均可使用
>
> 在标题内还可以包含 <small> 标签或赋予 .small 类的元素，可以用来标记副标题。
>
> jumbotron  添加一些样式

### 1.1.1 h标题和small副标题

```javascript
<div class="container" >
        <h2 class="page-header">h标题</h2>
        <h1 class="h1">h1. Bootstrap heading <small>Secondary text</small></h1>
        <h2>h2. Bootstrap heading <small>Secondary text</small></h2>
        <h3>h3. Bootstrap heading <small>Secondary text</small></h3>
        <h4>h4. Bootstrap heading <small>Secondary text</small></h4>
        <h5>h5. Bootstrap heading <small>Secondary text</small></h5>
        <h6>h6. Bootstrap heading <small>Secondary text</small></h6>
    </div>
```

### 1.1.2 jumbotron

> 和alert类似添加一些内补和样式

```javascript
<div class="container">
        <div class="jumbotron">
            <h1>Theme example</h1>
            <p>This is a template showcasing the optional theme stylesheet included in Bootstrap. Use it as a starting point to create something more unique by building on or modifying it.</p>
        </div>
    </div>
```

### 1.1.3 对齐

> 通过文本对齐类，可以简单方便的将文字重新对齐。

```javascript
<div class="container">
        <h2 class="page-header">对齐</h2>
        <p class="text-left">Left aligned text.</p>
        <p class="text-center">Center aligned text.</p>
        <p class="text-right">Right aligned text.</p>
        <p class="text-justify">Justified text.</p>
        <p class="text-nowrap">No wrap text.</p>
    </div>
```

## 1.2 内联列表

> 通过设置 display: inline-block; 并添加少量的内补（padding），将所有元素放置于同一行。

```javascript
<div class="container">
        <h2 class="alert alert-info">内联列表</h2>
        <ul class="list-inline">
            <li>Lorem ipsum</li>
            <li>Phasellus</li>
            <li>iaculis Nulla</li>
            <li>volutpat</li>
        </ul>
    </div>
```

## 1.3 表格

### 1.3.1 条纹状表格

> 通过 .table-striped 类可以给 <tbody> 之内的每一行增加斑马条纹样式。条纹状表格是依赖 :nth-child CSS 选择器实现的，而这一功能不被 Internet Explorer 8 支持

```javascript
<table class="table table-striped"></table>
```

### 1.3.2 带边框表格

> 添加 .table-bordered 类为表格和其中的每个单元格增加边框。

```javascript
<table class="table table-bordered"></table>
```

### 1.3.3  鼠标悬停

> 通过添加 .table-hover 类可以让 <tbody> 中的每一行对鼠标悬停状态作出响应。

```javascript
<table class="table table-hover"></table>
```

### 1.3.4 状态类

> 通过这些状态类可以为行或单元格设置颜色。

| class    | 描述                 |
| -------- | ------------------ |
| .active  | 鼠标悬停在行或单元格上时所设置的颜色 |
| .success | 标识成功或积极的动作         |
| .info    | 标识普通的提示信息或动作       |
| .warning | 标识警告或需要用户注意        |
| .danger  | 标识危险或潜在的带来负面影响的动作  |
|          |                    |

```javascript
<table class="table">
            <tr>
                <th>我是标题</th>
                <th>我是标题</th>
                <th>我是标题</th>
                <th>我是标题</th>
            </tr>
            <tr class="active">
                <td>我是active</td>
                <td>我是active</td>
                <td>我是active</td>
                <td>我是active</td>
            </tr>
            <tr class="success">
                <td>我是success</td>
                <td>我是success</td>
                <td>我是success</td>
                <td>我是success</td>
            </tr>
            <tr class="info">
                <td>我是info</td>
                <td>我是info</td>
                <td>我是info</td>
                <td>我是info</td>
            </tr>
            <tr class="warning">
                <td>我是warning</td>
                <td>我是warning</td>
                <td>我是warning</td>
                <td>我是warning</td>
            </tr>
            <tr class="danger">
                <td>我是danger</td>
                <td>我是danger</td>
                <td>我是danger</td>
                <td>我是danger</td>
            </tr>
        </table>
```

## 1.4 表单

### 1.4.1 表单控件

> 单独的表单控件会被自动赋予一些全局样式。所有设置了 .form-control 类的 <input>、<textarea> 和 <select> 元素都将被默认设置宽度属性为 width: 100%;。 将 label 元素和前面提到的控件包裹在 .form-group 中可以获得最好的排列。Bootstrap默认情况下，control-label的文本采用右对齐方式。	.help-block 如果是输入用户名，用户如果输入不符合格式，下面的help-block会提示你输入的信息是不符合规范的
>
> form-group      包裹表单组
>
> form-control    给单个表单
>
> control-label	给label标签（使文字右对齐）
>
> .help-block	给表单下面的span
>
> 注意：只有正确设置了 type 属性的输入控件才能被赋予正确的样式。

```javascript
<form action="">
            <div class="form-group">
                <label for="email1">Email address: </label><input type="text" id="email1" class="form-control" placeholder="email">
            </div>
            <div class="form-group">
                <label for="password1">Password: </label><input type="text" id="password1" class="form-control"	placeholder="Password">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Check me out
                </label>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>

        </form>
```

### 1.4.2 内联表单

> form-inline     给form添加
>
> - 为 <form> 元素添加 .form-inline 类可使其内容左对齐并且表现为 inline-block 级别的控件。只适用于视口（viewport）至少在 768px 宽度时（视口宽度再小的话就会使表单折叠）。可能需要手动设置宽度
> - 在 Bootstrap 中，输入框和单选/多选框控件默认被设置为 width: 100% 宽度。在内联表单，我们将这些元素的宽度设置为 width: auto;，因此，多个控件可以排列在同一行。根据你的布局需求，可能需要一些额外的定制化组件。
> - 一定要添加 label 标签，如果你没有为每个输入控件设置 label 标签，屏幕阅读器将无法正确识别。

#### 代码展示：

```javascript
<form action=""  class="form-inline">
  <h2 class="alert alert-info">内联表单</h2>
  <div class="form-group">
    <label>Email address: <input type="text"  class="form-control" placeholder="Email" ></label>
  </div>
  <div class="form-group">
    <label>Password: <input type="text" class="form-control" placeholder="Password"></label>
  </div>
</form>
```

### 1.4.3 前后添加按钮

> form-inline     给form标签
>
> input-group     包裹表单组
>
> form-control    给input
>
> input-group-addon   给input前后的按钮

#### 代码展示：

```javascript
<form class="form-inline">
  <div class="input-group">
    <div class="input-group-addon">$</div>
    <input type="text" class="form-control" id="exampleInputAmount" placeholder="Amount">
    <div class="input-group-addon">.00</div>
  </div>
  <button type="submit" class="btn btn-primary">Transfer cash</button>
</form>
```

### 1.4.4 水平表单

> 通过为表单添加 .form-horizontal 类，并联合使用 Bootstrap 预置的栅格类，可以将 label 标签和控件组水平并排布局。这样做将改变 .form-group 的行为，使其表现为栅格系统中的行（row），因此就无需再额外添加 .row 了。
>
> 这时候我们就需要将label和input给分开了，因为可以设置栅格类

```javascript
<form action="" class="form-horizontal">
            <h2 class="alert alert-info">水平表单</h2>
            <div class="form-group">
                <label for="email3" class="control-label col-sm-2">Email address: </label>
                <div class="col-sm-10">
                    <input type="text" id="email3" class="form-control" placeholder="email">
                </div>
            </div>
</form>
```

### 1.4.5 单选多选框

#### 单选：

```javascript
<form action="">
            <h2 class="alert alert-info">单选框</h2>
            <div class="radio">
                <label>
                    <input type="radio" name="radio">radio 
                </label>
                <label>
                    <input type="radio" name="radio">radio 
                </label>
                <label>
                    <input type="radio" name="radio">radio 
                </label>
                <label>
                    <input type="radio" name="radio">radio 
                </label>
            </div>
        </form>
```

#### 复选框：

```javascript
<form action="">
            <h2 class="alert alert-info">复选框</h2>
            <div class="checkbox">
                <label>
                    <input type="checkbox">Option 
                </label>
                <label>
                    <input type="checkbox">Option 
                </label>
                <label>
                    <input type="checkbox">Option 
                </label>
            </div>
</form>
```

### 1.4.6 下拉列表

> 只需要给select一个form-control就可以了

```html
<form action="">
  <select class="form-control">
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
  </select>
</form>
```

> 对于标记了 multiple 属性的 select 控件来说，默认显示多选项。

```javascript
<form action="">
  	<select multiple class="form-control">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
	</select>
</form>
```

### 1.4.7 静态控件

> 如果需要在表单中将一行纯文本和 label 元素放置于同一行，为 <p> 元素添加 .form-control-static 类即可。

```javascript
<form action="" class="form-inline">
  	<p class="form-control-static">Hello Bootstrap！</p>
	<div class="form-group">
 		<input type="text" class="form-control" placeholder="Hello Bootstrap">
    	<button type="submit" class="btn btn-default">submit</button>
	</div>
</form>
```

### 1.4.8 校验状态

> Bootstrap 对表单控件的校验状态，如 error、warning 和 success 状态，都定义了样式。使用时，添加
>
> .has-warning    .has-error  .has-success    
>
> 类到这些控件的父元素即可。任何包含在此元素之内的 .control-label、.form-control 和 .help-block 元素都将接受这些校验状态的样式。

#### 代码展示：

```javascript
<form action="" class="form-inline">
            <div class="form-group has-success">
                <label>Input with success: <input type="text" class="form-control" placeholder="success"></label>
                <span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
            </div>

            <div class="form-group has-warning">
                <label>Input with warning: <input type="text" class="form-control" placeholder="warning"></label>
                <span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
            </div>
            <div class="form-group has-error">
                <label>Input with error: <input type="text" class="form-control" placeholder="error"></label>
                <span class="help-block">A block of help text that breaks onto a new line and may extend beyond one line.</span>
            </div>
        </form>
```

### 1.4.9 添加额外图标

你还可以针对校验状态为输入框添加额外的图标。只需设置相应的 .has-feedback 类并添加正确的图标即可。反馈图标（feedback icon）只能使用在文本输入框 <input class="form-control"> 元素上。

> 1. has-feedback    给包裹表单的外层div(反馈图标（feedback icon）只能使用在文本输入框 <input class="form-control"> 元素上。)
> 2. 最好加上label
>  3. aria-describedby=“”  使确保辅助技术正确传递图标含义
>  4. class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"  给定span设置相应图标
>  5. 不希望将 label 标签展示出来，可以通过添加 .sr-only 类来实现

```javascript
<form action="">
            <div class="form-group has-success has-feedback">
                <label class="control-label" for="inputSuccess2">Input with success</label>
                <input type="text" class="form-control" id="inputSuccess2" aria-describedby="inputSuccess2Status">
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputSuccess2Status" class="sr-only">(success)</span>  <!--额外的隐藏的文本应包含在 .sr-only 类中-->
            </div>
            <div class="form-group has-warning has-feedback">
                <label class="control-label" for="inputWarning2">Input with warning</label>
                <input type="text" class="form-control" id="inputWarning2" aria-describedby="inputWarning2Status">
                <span class="glyphicon glyphicon-warning-sign form-control-feedback" aria-hidden="true"></span>
                <span id="inputWarning2Status" class="sr-only">(warning)</span>
            </div>
            <div class="form-group has-error has-feedback">
                <label class="control-label" for="inputError2">Input with error</label>
                <input type="text" class="form-control" id="inputError2" aria-describedby="inputError2Status">
                <span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>
                <span id="inputError2Status" class="sr-only">(error)</span>
            </div>
            <div class="form-group has-success has-feedback">
                <label class="control-label" for="inputGroupSuccess1">Input group with success</label>
                <div class="input-group">
                    <span class="input-group-addon">@</span>
                    <input type="text" class="form-control" id="inputGroupSuccess1" aria-describedby="inputGroupSuccess1Status">
                </div>
                <span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
                <span id="inputGroupSuccess1Status" class="sr-only">(success)</span>
            </div>
        </form>
```

### 1.5.0 控件尺寸

#### 1. 普通控件尺寸

> 通过 .input-lg 类似的类可以为控件设置大小

```javascript
<form action="">
  <input  class="form-control input-lg" type="text" placeholder=".input-lg">
  <input class="form-control" type="text" placeholder="Default input">
  <input class="form-control input-sm" type="text" placeholder=".input-sm">
</form>
```

#### 2. 水平排列的表单组的尺寸

> 通过添加 .form-group-lg 或 .form-group-sm 类，为 .form-horizontal 包裹的 label 元素和表单控件快速设置尺寸。

```javascript
<form class="form-horizontal">
            <div class="form-group form-group-lg">
                <label class="col-sm-3 control-label" for="formGroupInputLarge">Large label</label>
                <div class="col-sm-9">
                    <input class="form-control" type="text" id="formGroupInputLarge" placeholder="Large input">
                </div>
            </div>
            <div class="form-group form-group-sm">
                <label class="col-sm-2 control-label" for="formGroupInputSmall">Small label</label>
                <div class="col-sm-10">
                    <input class="form-control" type="text" id="formGroupInputSmall" placeholder="Small input">
                </div>
            </div>
        </form>
```

#### 3. 调整列（column）尺寸

> 用栅格系统中的列（column）包裹输入框或其任何父元素，都可很容易的为其设置宽度。

```javascript
<form action="">
            <div class="row">
                <div class="col-xs-2">
                    <input type="text" class="form-control" placeholder=".col-xs-2">
                </div>
                <div class="col-xs-3">
                    <input type="text" class="form-control" placeholder=".col-xs-3">
                </div>
                <div class="col-xs-4">
                    <input type="text" class="form-control" placeholder=".col-xs-4">
                </div>
            </div>
 </form>
```

## 1.5 按钮

### 1.5.1 普通标签按钮

```javascript
<a class="btn btn-default" href="#" role="button">Link</a>
<button class="btn btn-default" type="submit">Button</button>
<input class="btn btn-default" type="button" value="Input">
<input class="btn btn-default" type="submit" value="Submit">
```

### 1.5.2 尺寸、不同样式的按钮

> 尺寸  需要让按钮具有不同尺寸吗？使用 .btn-lg、.btn-sm 或 .btn-xs 就可以获得不同尺寸的按钮

```javascript
<button type="button" class="btn btn-lg btn-default">Default（默认样式）</button>
<button type="button" class="btn btn-lg btn-primary">Primary（普通项）</button>
<button type="button" class="btn btn-lg btn-success">Success（成功）</button>
<button type="button" class="btn btn-lg btn-info">Info（一般信息）</button>
<button type="button" class="btn btn-lg btn-warning">Warning（警告）</button>
<button type="button" class="btn btn-lg btn-danger">Danger（危险）</button>
<button type="button" class="btn btn-lg btn-link">Link（链接）</button>
```

### 1.5.3 块级按钮

> 通过给按钮添加 .btn-block 类可以将其拉伸至父元素100%的宽度，而且按钮也变为了块级（block）元素

```javascript
<button type="button" class="btn btn-primary  btn-block">（块级元素）Block level button</button>
<button type="button" class="btn btn-default  btn-block">（块级元素）Block level button</button>
```

> 注意事项：
>
> 1. 针对组件的注意事项
>
>    虽然按钮类可以应用到 <a> 和 <button> 元素上，但是，导航和导航条组件只支持 <button> 元素。
>
> 2. 链接被作为按钮使用时的注意事项
>     如果 <a> 元素被作为按钮使用 -- 并用于在当前页面触发某些功能 -- 而不是用于链接其他页面或链接当前页面中的其他部分，那么，务必为其设置 role="button" 属性。

### 1.5.4 基本按钮组

```html
<div class="btn-group" role="group" aria-label="...">
        <button type="button" class="btn btn-default">Left</button>
        <button type="button" class="btn btn-default">Middle</button>
        <button type="button" class="btn btn-default">Right</button>
</div>
```

### 1.5.5 按钮工具栏

> 把一组 <div class="btn-group"> 组合进一个 <div class="btn-toolbar"> 中就可以做成更复杂的组件。

```html
<div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
        <div class="btn-group" role="group" aria-label="First group">
            <button type="button" class="btn btn-default">1</button>
            <button type="button" class="btn btn-default">2</button>
            <button type="button" class="btn btn-default">3</button>
            <button type="button" class="btn btn-default">4</button>
        </div>
        <div class="btn-group" role="group" aria-label="Second group">
            <button type="button" class="btn btn-default">5</button>
            <button type="button" class="btn btn-default">6</button>
            <button type="button" class="btn btn-default">7</button>
        </div>
        <div class="btn-group" role="group" aria-label="Third group">
            <button type="button" class="btn btn-default">8</button>
        </div>
</div>
```

### 1.5.6 尺寸

> 只要给 .btn-group 加上 .btn-group-* 类，就省去为按钮组中的每个按钮都赋予尺寸类了，如果包含了多个按钮组时也适用。

```html
<div class="bs-example" data-example-id="button-group-sizing">
        <div class="btn-group btn-group-lg" role="group" aria-label="Large button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
        </div>
        <br>
        <div class="btn-group" role="group" aria-label="Default button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
        </div>
        <br>
        <div class="btn-group btn-group-sm" role="group" aria-label="Small button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
        </div>
        <br>
        <div class="btn-group btn-group-xs" role="group" aria-label="Extra-small button group">
            <button type="button" class="btn btn-default">Left</button>
            <button type="button" class="btn btn-default">Middle</button>
            <button type="button" class="btn btn-default">Right</button>
        </div>
</div>
```

## 1.6 响应式图片

### 1.6.1 图片形状

> - 通过为 <img> 元素添加以下相应的类，可以让图片呈现不同的形状。给添加背景的盒子也可以
>
>   ​img-rounded
>
>   ​img-circle
>
>   ​img-thumbnail

```html
<img src="" class="img-rounded">
<img src="" class="img-circle">
<img src="" class="img-thumbnail">
```

### 1.6.2 响应式图片

> 在 Bootstrap 版本 3 中，通过为图片添加 .img-responsive 类可以让图片支持响应式布局。其实质是为图片设置了 max-width: 100%;、 height: auto; 和 display: block; 属性，从而让图片在其父元素中更好的缩放。

```html
<img src="../images/1366.jpg" alt="" class="img-responsive ">
```

### 1.6.3 响应式背景

#### 1. 在不知道元素高度的情况下想要根据图片大小设置背景

```css
.img{
      padding-top: 56%;  /*图片的高宽比例*/
      background: url("../images/1366.jpg") no-repeat center/cover;
     }
```

#### 2. 不同大小的页面不同大小的背景图片

```css
@media screen and (max-width: 976px) {
  .img{
    background-image: url("../images/960.jpg");
  }
}
@media screen and (max-width: 480px) {
  .img{
    background-image: url("../images/480.jpg");
  }
}
```

### 1.6.4 文字变图片

```html
<img  class="img-thumbnail" alt="A generic square placeholder image with a white border around it, making it resemble a photograph taken with an old instant camera">
```



## 1.7 Glyphicons 字体图标

> 出于性能的考虑，所有图标都需要一个基类和对应每个图标的类。把下面的代码放在任何地方都可以正常使用。注意，为了设置正确的内补（padding），务必在图标和文本之间添加一个空格。

> - 注意：
>
> 1. 不要和其他组件混合使用
>
>     图标类不能和其它组件直接联合使用。它们不能在同一个元素上与其他类共同存在。应该创建一个嵌套的 <span> 标签，并将图标类应用到这个 <span> 标签上。
>
>  2. 只对内容为空的元素起作用，图标类只能应用在不包含任何文本内容或子元素的元素上。

> 可以把它们应用到按钮、工具条中的按钮组、导航或输入框等地方。

```html
<button type="button" class="btn btn-default" aria-label="Left Align">
	<span class="glyphicon glyphicon-align-left" aria-hidden="true"></span>
</button>
<button type="button" class="btn btn-default">
	<span class="glyphicon glyphicon-star" aria-hidden="true"></span> Star
</button>
```

#### alert错误弹窗

> alert 组件中所包含的图标是用来表示这是一条错误消息的

```html
<div class="alert alert-danger" role="alert">
	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
	Enter a valid email address
</div>
```

## 1.9 下拉菜单

### 1.9.1 普通按钮下拉菜单

> 将下拉菜单触发器和下拉菜单都包裹在 .dropdown 里，或者另一个声明了 position: relative; 的元素。然后加入组成菜单的 HTML 代码。

> 1. <div class="dropdown">  给下拉菜单最外层盒子
> 2. 下拉按钮：
>      需要的类：dropdown-toggle
>      标签属性：data-toggle="dropdown"
>      图标：<span class="caret"></span>  注意：图标和字体之间最好有一个空格方便内补
>  3. 下拉菜单：由ul和li组成
>      需要的类：dropdown-menu
>  4. 对齐
>      默认情况下，下拉菜单自动沿着父元素的上沿和左侧被定位为 100% 宽度。 为 .dropdown-menu 添加 .dropdown-menu-right 类可以让菜单右对齐。
>  5. 标题
>      在任何下拉菜单中均可通过添加标题来标明一组动作。    class="dropdown-header"
>  6. 分割线
>      为下拉菜单添加一条分割线，用于将多个链接分组。 class="divider" role="separator"
>  7. 上拉菜单
>      通过为下拉菜单的父元素设置 .dropup 类，可以让菜单向上弹出（默认是向下弹出的）。

```html
<div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="true">
                Dropdown <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li class="dropdown-header">Action</li>
                <li  class="divider" role="separator"></li>
                <li><a href="#">Another action</a></li>
                <li  class="divider" role="separator"></li>
                <li><a href="#">Something else here</a></li>
                <li  class="divider" role="separator"></li>
                <li><a href="#">Separated link</a></li>
            </ul>
</div>
```

### 1.9.2 按钮组和下拉菜单嵌套

> 嵌套  想要把下拉菜单混合到一系列按钮中，只须把 .btn-group 放入另一个 .btn-group 中。

```html
<div class="btn-group" role="group" aria-label="Button group with nested dropdown">
        <button type="button" class="btn btn-default">1</button>
        <button type="button" class="btn btn-default">2</button>

        <div class="btn-group" role="group">
            <button id="btnGroupDrop1" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                <li><a href="#">Dropdown link</a></li>
                <li><a href="#">Dropdown link</a></li>
            </ul>
        </div>
</div>
```

## 2.0 按钮排列方式

### 2.0.1 按钮组垂直排列

> 通过添加btn-group-vertical类，让一组按钮垂直堆叠排列显示而不是水平排列。分列式按钮下拉菜单不支持这种方式。

```html
<div class="btn-group-vertical" role="group" aria-label="Vertical button group">
        <button type="button" class="btn btn-default">Button</button>
        <div class="btn-group" role="group">
            <button id="btnGroupVerticalDrop1" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="btnGroupVerticalDrop1">
                <li><a href="#">Dropdown link</a></li>
                <li><a href="#">Dropdown link</a></li>
            </ul>
        </div>
        <button type="button" class="btn btn-default">Button</button>
</div>
```

### 2.0.2 两端对齐排列的按钮组

> 通过添加btn-group-justified类，两端对齐排列的按钮组  让一组按钮拉长为相同的尺寸，填满父元素的宽度。对于按钮组中的按钮式下拉菜单也同样适用。

```html
<div class="btn-group-justified" role="group" aria-label="Justified button group">
        <a href="#" class="btn btn-default" role="button">Left</a>
        <a href="#" class="btn btn-default" role="button">Middle</a>
        <a href="#" class="btn btn-default" role="button">Right</a>
</div>
```

### 2.0.3 分列式下拉菜单

```html
<div class="btn-group">
    <button type="button" class="btn btn-primary">Primary</button>
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
      <li><a href="#">Action</a></li>
      <li><a href="#">Another action</a></li>
      <li><a href="#">Something else here</a></li>
      <li role="separator" class="divider"></li>
      <li><a href="#">Separated link</a></li>
    </ul>
</div>
```

## 2.1 分页按钮

> 为您的网站或应用提供带有展示页码的分页组件，或者可以使用简单的翻页组件。想要更小或更大的分页？.pagination-lg 或 .pagination-sm 类提供了额外可供选择的尺寸。

```html
<ul class="pagination">
  <li>
    <a href="#" aria-label="Previous">
      <span aria-hidden="true">&laquo;</span>
    </a>
  </li>
  <li class="active"><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li>
    <a href="#" aria-label="Next">
      <span aria-hidden="true">&raquo;</span>
    </a>
  </li>
</ul>

```

## 2.2 徽章

> 给链接、导航等元素嵌套 <span class="badge"> 元素，可以很醒目的展示新的或未读的信息条目。

```html
<a href="#">Inbox <span class="badge">42</span></a>

<button class="btn btn-primary" type="button">
	Messages <span class="badge">4</span>
</button>
<!--nav nav-pills 变成胶囊式导航栏-->
<ul class="nav nav-pills" role="tablist">
        <li role="presentation" class="active">
            <a href="#">Home <span class="badge">42</span></a>
        </li>
        <li role="presentation"><a href="#">Profile <span class="badge">10</span></a></li>
        <li role="presentation"><a href="#">Messages <span class="badge">3</span></a></li>
 </ul>
```

## 2.3 图片和文本的对齐方式

### 2.3.1 缩略图自定义内容

> 可以让图片标题文字按钮很好的排列

```html
<div class="thumbnail">
  <img src="1.jpg">
  <div class="caption">
    <h3>Thumbnail label</h3>
    <p>
      Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
    </p>
    <p>
      <a href="#" class="btn btn-primary" role="button">Button</a> 
      <a href="#" class="btn btn-default" role="button">Button</a>
    </p>
  </div>
</div>
```

### 2.3.2 媒体对象

> 左侧小图像和右侧文本对齐方式
>
> 对齐方式：给media-left类添加
>
> media-top (默认)
>
> media-middle
>
> media-bottom

```html
<div class="media">
            <div class="media-left">
                <a href="#">
                    <img class="media-object" src="1.jpg">
                </a>
            </div>
            <div class="media-body">
                <h4 class="media-heading">Bottom aligned media</h4>
                <p>Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.</p>
                <p>Donec sed odio dui. Nullam quis risus eget urna mollis ornare vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
            </div>
</div>
```





## 2.4 进度条

> - 在展示很低的百分比时，如果需要让文本提示能够清晰可见，可以为进度条设置 min-width 属性。
> - 情景变化效果进度条：progress-bar-success      progress-bar-info等等
> - 渐变效果：通过渐变可以为进度条创建条纹效果，IE9 及更低版本不支持。
> - 动画效果：为 .progress-bar-striped 添加 .active 类，使其呈现出由右向左运动的动画效果。IE9 及更低版本的浏览器不支持。
> - 堆叠效果：把多个进度条放入同一个 .progress 中，使它们呈现堆叠的效果。

### 2.4.1 普通进度条

```html
<div class="progress">
    <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
    60%
    </div>
</div>
```

### 2.4.2 情景变化效果进度条

> 情景变化效果进度条：progress-bar-success      progress-bar-info等等。

```html
<div class="progress">
        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">40%
            <span class="sr-only">40% Complete (success)</span>
        </div>
    </div>
    <div class="progress">
        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
            <span class="sr-only">20% Complete</span>
        </div>
    </div>
    <div class="progress">
        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
            <span class="sr-only">60% Complete (warning)</span>
        </div>
    </div>
    <div class="progress">
        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
            <span class="sr-only">80% Complete (danger)</span>
        </div>
    </div>
```

### 2.4.3 条纹效果

> 渐变效果：通过渐变可以为进度条创建条纹效果，IE9 及更低版本不支持。
>
> 动画效果：为 .progress-bar-striped 添加 .active 类，使其呈现出由右向左运动的动画效果。IE9 及更低版本的浏览器不支持。

```html
<div class="progress">
        <div class="progress-bar progress-bar-success progress-bar-striped active" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
            <span class="sr-only">40% Complete (success)</span>
        </div>
    </div>
```

### 2.5.4 堆叠效果

> 堆叠效果：把多个进度条放入同一个 .progress 中，使它们呈现堆叠的效果。

```html
<div class="progress">
	<div class="progress-bar progress-bar-success" style="width: 35%">35%
		<span class="sr-only">35% Complete (success)</span>
	</div>
	<div class="progress-bar progress-bar-warning progress-bar-striped" style="width: 20%">20%
		<span class="sr-only">20% Complete (warning)</span>
	</div>
	<div class="progress-bar progress-bar-danger" style="width: 10%">
		<span class="sr-only">10% Complete (danger)</span>10%
	</div>
</div>
```

## 2.6 列表组

### 2.6.1 普通列表组

```html
<ul class="list-group">
    <li class="list-group-item">Cras justo odio</li>
    <li class="list-group-item">Dapibus ac facilisis in</li>
    <li class="list-group-item">Morbi leo risus</li>
    <li class="list-group-item">Porta ac consectetur ac</li>
    <li class="list-group-item">Vestibulum at eros</li>
</ul>
```

### 2.6.2 徽章

```html
<ul class="list-group">
        <li class="list-group-item">
          	Cras justo odio
            <span class="badge">14</span>
        </li>
</ul>
```

### 2.6.3 链接

- 用 <a> 标签代替 <li> 标签可以组成一个全部是链接的列表组（还要注意的是，我们需要将 <ul> 标签替换为 <div> 标签）。没必要给列表组中的每个元素都加一个父元素。

  ```html
  <div class="list-group">
          <a href="#" class="list-group-item active">Cras justo odio<span class="badge">14</span></a>
          <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
          <a href="#" class="list-group-item">Morbi leo risus</a>
          <a href="#" class="list-group-item">Porta ac consectetur ac</a>
          <a href="#" class="list-group-item">Vestibulum at eros</a>
  </div>
  ```

  ### 2.6.4 按钮

  - 列表组中的元素也可以直接就是按钮（也同时意味着父元素必须是 <div> 而不能用 <ul> 了），并且无需为每个按钮单独包裹一个父元素。注意不要使用标准的 .btn 类！

  ```html
      <div class="list-group">
          <button type="button" class="list-group-item">Cras justo odio</button>
          <button type="button" class="list-group-item">Dapibus ac facilisis in</button>
          <button type="button" class="list-group-item">Morbi leo risus</button>
          <button type="button" class="list-group-item">Porta ac consectetur ac</button>
          <button type="button" class="list-group-item">Vestibulum at eros</button>
      </div>
  ```

  ### 2.6.5 定制内容

  ```html
  <div class="list-group">
          <a href="#" class="list-group-item active">
              <h4 class="list-group-item-heading">List group item heading</h4>
              <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
          </a>
          <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">List group item heading</h4>
              <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
          </a>
          <a href="#" class="list-group-item">
              <h4 class="list-group-item-heading">List group item heading</h4>
              <p class="list-group-item-text">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
          </a>
      </div>
  ```

  ### 2.6.6 带表格的面板

  - 为面板中不需要边框的表格添加 .table 类，是整个面板看上去更像是一个整体设计。如果是带有 .panel-body 的面板，我们为表格的上方添加一个边框，看上去有分隔效果。

  ```html
  <div class="panel panel-default">
              <!-- Default panel contents -->
              <div class="panel-heading">Panel heading</div>
              <div class="panel-body">
                  <p>Some default panel content here. Nulla vitae elit libero, a pharetra augue. Aenean lacinia bibendum nulla sed consectetur. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              </div>

              <!-- Table -->
              <table class="table">
                  <thead>
                  <tr>
                      <th>#</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Username</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                      <th scope="row">1</th>
                      <td>Mark</td>
                      <td>Otto</td>
                      <td>@mdo</td>
                  </tr>
                  <tr>
                      <th scope="row">2</th>
                      <td>Jacob</td>
                      <td>Thornton</td>
                      <td>@fat</td>
                  </tr>
                  <tr>
                      <th scope="row">3</th>
                      <td>Larry</td>
                      <td>the Bird</td>
                      <td>@twitter</td>
                  </tr>
                  </tbody>
              </table>
  </div>
  ```

  ​

## 2.7 对话框

> 1. <div class="modal"></div>    包裹整个对话框 在里面还需包裹一层<div class="modal-dialog"></div>
> 2. <div class="modal-content"></div>    里面包裹对话框内容
> 3. <div class="modal-header"></div>  对话框头部
> 4. <div class="modal-body"></div>   对话框主体
> 5. <div class="modal-footer"></div> 对话框底部
> 6. 在最大的modal标签里需要给一个id和登录按钮绑定
> 7. 在登录按钮上需要设置   data-toggle="modal" 表示可以点击弹出对话框 data-target="#login-modal" 与对话框绑定
> 8. 在对话框modal标签上设置fade会有过渡效果
> 9. 在关闭按钮上添加    data-dismiss="modal" 可以关闭对话框
> 10. data-backdrop="false"    给modal标签设置 可关掉遮罩
> 11. 远程表单(需要本地服务器才能运行)
>     - 给登录的a加上本地表单地址 <li><a href="login-form.html" data-toggle="modal" data-target="#login-modal">登录</a></li>

```html
<a href="login-form.html" data-toggle="modal" data-target="#login-modal">登录</a>
    <div class="modal fade" id="login-modal" tabindex="-1" data-backdrop="false">
        <div class="modal-dialog">
            <div class="modal-content">

            </div>
        </div>
    </div>
```

```html
<div class="modal-header">
    <button class="close" data-dismiss="modal">&times;</button>
    <h4>用户登录</h4>
</div>
<div class="modal-body">
    <form action="">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" placeholder="请输入用户名" id="user" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" placeholder="请输入用户名" id="password" class="form-control">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button class="btn btn-primary">登录</button>
</div>
```

# 五、Bootstrap导航栏

## 1.1 标签页

- 注意 .nav-tabs 类依赖 .nav 基类。

  ### 1.1.1 普通标签页

```html
<ul class="nav nav-tabs">
    <li role="presentation" class="active"><a href="#">Home</a></li>
    <li role="presentation"><a href="#">Profile</a></li>
    <li role="presentation"><a href="#">Messages</a></li>
</ul>
```

### 1.1.2 胶囊式标签页

```html
<ul class="nav nav-pills">
        <li role="presentation" class="active"><a href="#">Home</a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="#">Messages</a></li>
</ul>
```

### 1.1.3 垂直胶囊式标签页

```html
<ul class="nav nav-pills nav-stacked">
        <li role="presentation" class="active"><a href="#">Home</a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="#">Messages</a></li>
</ul>
```

### 1.1.4 两端对齐的标签页

```html
<ul class="nav nav-pills nav-stacked nav-justified">
        <li role="presentation" class="active"><a href="#">Home</a></li>
        <li role="presentation"><a href="#">Profile</a></li>
        <li role="presentation"><a href="#">Messages</a></li>
</ul>
```

## 1.2 导航栏

- 导航栏也是基于nav类	导航栏样式(给nav标签)：

    navbar-default  默认样式
    	navbar-inverse  黑色

### 1.2.1 品牌图标

- 品牌图标也可以添加多个

  > 将导航条内放置品牌标志的地方替换为 <img> 元素即可展示自己的品牌图标。由于 .navbar-brand 已经被设置了内补（padding）和高度（height），你需要根据自己的情况添加一些 CSS 代码从而覆盖默认设置。

```html
<a class="navbar-brand" href="#"><img alt="Brand" src="" ></a>
<a href="" class="navbar-brand"><strong>Logo</strong></a>
```

### 1.2.2 菜单栏

- 基于nav	 navbar-nav类