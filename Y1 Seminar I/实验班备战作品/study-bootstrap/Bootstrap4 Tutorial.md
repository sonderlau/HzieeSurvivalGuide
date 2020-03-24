# Bootstrap4 Tutorial

---

## Font

`display-*` 能够输出更大更粗得字体样式

`small` 创建字号更小 颜色更浅得样式

`<mark>` 黄色背景 有一定内边距的高亮

`<abbr>` 底部虚线边框

 `<blockquote>`  blockquote-footer 等

| 类名                  | 描述                                                         |
| --------------------- | ------------------------------------------------------------ |
| `.font-weight-bold`   | 加粗                                                         |
| `.font-weight-normal` | 普通                                                         |
| `.font-weight-light`  | 更细                                                         |
| `.font-italic`        | 斜体                                                         |
| `.lead`               | 段落突出                                                     |
| `.small`              | 指定更小文本 85%                                             |
| `.text-left`          | 左对齐                                                       |
| `.text-center`        | 居中                                                         |
| `.test-right`         | 右对齐                                                       |
| `.text-justify`       | 超出屏幕的自动对齐 换行                                      |
| `.text-nowrap`        | 超出屏幕部分 不换行                                          |
| `.text-lowercase`     | 文本小写                                                     |
| `.text-uppercase`     | 文本大写                                                     |
| `.text-cpatilize`     | 首字母大写                                                   |
| `.initialism`         | `<abbr> ` 标签字体稍微小一点 全大写                          |
| `.list-unstyled`      | 移除了默认的 `list-style` 样式和左侧外边距的一组元素**这是针对直接子元素的**， |
| `.list-inline`        | 列表放在同一行                                               |
| `.pre-scrollable`     | `<pre>`元素可滚动                                            |

---

## Bootsrap Color

| ColorName         | Description                              |
| ----------------- | ---------------------------------------- |
| `.text-mited`     | <font color="#6c757d" >柔和的颜色</font> |
| `.text-primary`   | <font color="#007BEF">主要链接</font>    |
| `.text-success`   | <font color="#19692C">成功链接</font>    |
| `.text-info`      | <font color="#17A2BB">信息文本</font>    |
| `.text-warning`   | <font color="BA8B00">警告链接</font>     |
| `.text-danger`    | <font color="#DC3545"> 危险链接</font>   |
| `.text-secondary` | <font color="#6C757D">副标题</font>      |
| `.text-dark`      | <font color="#343A40">深灰色链接</font>  |
| `.text-light`     | 浅色的                                   |
| `.text-white`     | 白色的                                   |

**以上text换成bg可得到背景颜色**

**以上text换成table可得到表格颜色**

---

## Bootsrap Table

==`.table`==

- `.table-striped` 条纹表格
- `.table-bordered` 表格添加边框
- `.table-hover` 鼠标悬停效果
- `.table-dark` 黑色背景

==`.thead.`==

- `.thead-dark` 可用于给表头添加黑色背景
- `.thead-light` 可用途给表头添加灰色背景

`.table-sm` 创建内边距较小的表格

==`.table-responsive`==

可设置指定屏幕宽度下显示滚动条

- `.table-responsive-sm`  <579px
- `.table-responsive-md`  <768px
- `.table-responsive-lg`  <992px
- `table-responsive-xl`  <1200px

---

## Bootstrap Image Shape

- `.rounderd` 图片圆角效果
- `.rounded-circle` 设置椭圆图片
- `img-thumbnail` 图片缩略图 带边框
- `.float-left / float-right` 设置左/右对齐
- `.img-fluid` 自适应图片

---

## Bootsrap Jumbotron

Jumbotron

> 超大屏幕
>
> 创建一个大的灰色背景框 可以放Html标签 也可以是Bootsrap元素

- `.jumbotron` 在div中加入此类可创建
- `.jumbotron-fluid` 没有圆角的全屏幕 即扩展到两边

---

## Bootstrap Alter

具体颜色参考 ==Bootstrap Color==

- `.alter` 代表是提示标签 用到div中
- `alter-***` **代表了颜色 参考上面
- `alter-link` 插入a标签中 提供跳转链接
- `.alter-dismissible` div中插入此类
  - ` class= "close" data-dismiss="alter" ` button中加入此来设置关闭标签
- `.fade .show` 设置提示框在关闭时的淡入淡出效果

---

## Bootstrap Button

- `btn` 按钮样式标准

- `btn-***` **填入color 参考上面

- `.btn-link` 链接按钮

- 按钮可用于`<a> <button> <input> `标签

  ```html
  <a href="#" class="btn btn-info" role="button">链接按钮</a>
    <button type="button" class="btn btn-info">按钮</button>
    <input type="button" class="btn btn-info" value="输入框按钮">
    <input type="submit" class="btn btn-info" value="提交按钮"> 
  ```

- `btn btn-outline-***` 边框按钮

- `.btn-lg` `btn-sm` 大 小 

- `.btn-block` 块级按钮

- `.active` 点击后的按钮

- `disabled` 禁止点击的按钮 也可用在a中 参考上面

---

## Bootstrap Button Group

==可内嵌按钮组==

- `.btn-group` div标签创建按钮组
- `.btn-group-lg / btn-group-sm` 按钮组大小
- `.btn-group-vertial` 创建垂直的按钮组
- `.dropdown-toggle` `data-toggle = "dropdown"` 下拉按钮
- `.dropdown-toggle-spilt` 拆分标签
  - `.caret` span标签使用该类用来增加下拉菜单
- `.dropdown-menu`  `.dropdown-item` div中使用menu代表列表开始 a标签使用item用于跳转

---

## Bootstrap Badges

span标签

- `.badge`  新建一个Badges
- `.badge-***` 颜色 参考color
- `.badge-pill` 药丸形状徽章
- 可嵌套到按钮内

---

## Bootstrap Progress Bar

TBD

---

## Bootstrap Pagination

- `.pagination` ul 标签 
- `.page-item` li 元素
- `.active` 标签代表当前页
- `.disabled` 分页链接不可点击
- `.pagination-lg`  `.pagination-sm` 大小字体

---

## Bootstrap 面包屑导航

- `.breadcrumb` ul 
- `.breadcrumb-item` li 标签  

---

## Bootstrap 列表组

- `.list-group` ul
- `.list-group-item` li 
- `.active` 激活
- `.disabled` 禁用
- `.list-group-item-***` ***为color 参考上面 li / a 标签
- `.list-item-action` 悬停显示灰色背景

---

## Bootstrap 卡片组件

- `.card` 创建卡片组件 div
- `.card-body`  div
- `.card-header` 卡片头部
- `.card-footer` 卡片底部
- `.bg-color .text-color`  字体 背景颜色
- `.card-title` 标题
- `.card-text` 正文
- `.card-link` 链接
- `.card-img-top / bottom` img标签  创建卡片的图片
- `.card-img-overlay` 代替 `card-body` 图片作为背景

---

## Bootstrap 下拉菜单

```html
<div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Java
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">JSP</a>
      <a class="dropdown-item" href="#">Servlet</a>
    </div>
</div>
```

下拉标准格式

- `.dropdown` 用div

- `.dropdown-divider` 水平分割线
-  `.dropdown-header` 添加标签
- `.active / .disabled` 可用与禁用
- `.dropdown-menu-right` 下拉标签右对齐
- `.dropup` 向上弹出

---

## Bootstrap 折叠组件

```html
<button data-toggle="collapse" data-target="#demo">折叠的标题</button>
<div id="demo" class="collapse">
要折叠的内容
</div>
```

==id一致==

- 可以用a标签代替button标签
- `.show` 可以让默认内容显示

---

## Bootstrap 手风琴

TBD

---

## Bootstrap 导航组件

- `.nav``.nav-item .nav-link` 

-  ```html
  <ul class="nav">
    <li class="nav-item">
      <a class="nav-link" href="#">首页</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Python</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">PHP</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Perl</a>
    </li>
  </ul>
  ```

- `.disabled` 加入`.nav-link` 中 禁用一个导航

- `.justify-content-center` 居中

- `.justify-content-end` 右对齐

- `.flex-column` 创建垂直导航

- `.nav-justified` 齐行等宽显示

---

## Bootstrap 导航栏

- ```html
  <nav class="navbar navbar-expand-sm bg-light">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">首页</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Python</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">PHP</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Perl</a>
      </li>
    </ul>
  </nav>
  ```

- `.navbar-expand- xl / lg / md / sm` 响应式的导航栏

- `.bg-color` 背景颜色

- `.active` / `.disabled` 在 `.nav-link` 加入

- `.navbar-brand` 品牌Logo 可用图片 建议加入响应式

### 折叠导航栏

- ```html
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
  ```

### 下拉菜单

```html
 <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Java
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Servlet</a>
        <a class="dropdown-item" href="#">JSP</a>
        <a class="dropdown-item" href="#">Spring</a>
      </div>
    </li>
```

### 表单 按钮

- `.form-inline` form标签加入 排版输入框与按钮
- `.navbar-text` span标签加入非链接文本
- `.fixed-top` 固定在顶部
- `.fixed-bottom` 固定在页面底部

---

## 选项卡组件

- `.nav-tabs` 创建一个选项卡

- ```html
   <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Java</a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">JSP</a>
        <a class="dropdown-item" href="#">Servlet</a>
        <a class="dropdown-item" href="#">Spring</a>
      </div>
    </li>
  ```

  - 下拉菜单

- `.nav-justified` 齐行等宽显示

### 动态选项卡

```html
<!-- 选项卡 -->
<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" data-toggle="tab" href="#home">Python</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#menu1">PHP</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" data-toggle="tab" href="#menu2">Perl</a>
  </li>
</ul>

<!-- 选项卡对应内容 -->
<div class="tab-content">
  <div class="tab-pane active container" id="home">Python AAA</div>
  <div class="tab-pane container" id="menu1">PHP BBBB</div>
  <div class="tab-pane container" id="menu2">PerlCCCC</div>
</div>
```

- `.fade` 淡入淡出效果

---

## Bootstrap 表单控件

- `<input>` 
  - <kbd>text, password, datetime, datetime-local, date, month, time, week, number, 
    email, url, search, tel, color </kbd>

---

## Bootstrap 轮播组件

```html
<div id="demo" class="carousel slide" data-ride="carousel">

  <!-- 指示符 -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>

  <!-- 轮播图片 -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <div class="carousel-caption">
          <p>描述</p>
        </div>
      <img src="/static/i/img2.jpg">
    </div>
    <div class="carousel-item">
      <img src="/static/i/img3.jpg">
    </div>
    <div class="carousel-item">
      <img src="/static/i/img4.jpg">
    </div>
  </div>

  <!-- 左右切换按钮 -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>

</div>
```

---

## 模态框

```html
<!-- 按钮：用于打开模态框 -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
  打开模态框
</button>

<!-- 模态框 -->
<div class="modal fade" id="myModal">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <!-- 模态框头部 -->
      <div class="modal-header">
        <h4 class="modal-title">模态框头部</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <!-- 模态框主体 -->
      <div class="modal-body">
        模态框内容..
      </div>

      <!-- 模态框底部 -->
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
      </div>

    </div>
  </div>
</div>
```

---

## 提示框

```html
<a href="#" data-toggle="tooltip" title="我只是一个提示框">鼠标移动到我这里显示提示框</a>
```

==`data-placement="top/left/bottom/rihgt"==

