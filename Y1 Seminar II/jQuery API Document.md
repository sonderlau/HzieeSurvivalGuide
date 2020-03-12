# jQuery API Document

---

虽说官网啥都有 但是不自己整理下还是记不住的

于是乎 遇到啥我就记录下啥

以备查阅

参考: [jQuery API Document](https://api.jquery123.com/) [w3school](https://www.w3schools.com/jquery/default.asp)



---

## 知识要点

DOM

> When a web page is loaded, the browser creates a **D**ocument **O**bject **M**odel of the page
>
> The **HTML DOM** model is constructed as a tree of **Objects**
>
> Refer : w3school [What is HTML DOM](https://www.w3schools.com/whatis/whatis_htmldom.asp)

----

## 文档摘要

### .html()

返回选中元素的HTML内容 采用`innerHtml`

**对XML文档无效**

#### html()

> `return String`
>
> 获取集合中第一个匹配元素的HTML内容

#### html(String)

> `return jQuery`
>
> 设置每个匹配元素的HTML字符串

#### html( function(index, currentContent))

> `return jQuery`
>
> `params: index Integer` 当前元素在选中元素集中的位置
>
> `params: currentContent String` 当前选中元素的HTML内容

---

### jQuery.trim(str)

删除字符串开始和结尾处的换行符 空格(包括连续的空格) 和制表符(Tab)

> `params: str String`

---

### .click()

#### .click()

`.trigger("click")`的便捷方式

触发该事件

#### .click(handler(eventObject))

> `param: handler(eventObject) Function`
>
> 每次事件触发执行的函数

---

### .find(selector)

后代元素选择器

#### .find( selector)

> `param: selector Selector` 用于匹配元素的选择器字符串

#### .find( jQuery_object)

> `param: jQuery_object Object` 匹配元素集合的jQuery对象

#### .find( element)

> `param: element Element` 匹配元素集合的元素

---

### .eq()

减少匹配元素的集合为制定的索引的哪一个元素

#### .eq( index)

> `param: index Integer` 指示元素的位置

#### .eq( -index)

> `param: -index Integer` 元素倒数的位置

---

### .get()

#### .get( [index] )

> `param: index Numebr` 获取哪个元素

---

### .text()

`XML HTML`中均可使用

不能作用在`input`或`script`元素

该两个元素需要使用`.val()`获取

#### .text()

> `return String`
>
> 得到匹配元素集合中每个元素的合并文本 包括后代

#### .text( textString )

设置匹配元素集合中每个元素的文本内容为指定的文本内容

**Note: 特殊字符会被转码**

> `param: textString String` 设置匹配元素内容的文本

#### .text( function(index, currentContent) )

> `param function(index, currentContent) Function` 返回设置文本内容的一个函数 接受元素的位置和文本值作为参数

### val()

#### val()

> `param : None`
>
> 获取匹配元素的第一个元素的值

#### val(value)

> `param : value String\Array` 设定每个匹配的元素的值
>
> `param : function(index, value) Function` 设置返回值的函数 `this` 指向当前元素

此方法通常用于设置表单字段的值

---

### Selector

#### :hidden

选取所有隐藏的元素

> 可被认为是隐藏的几个情况
>
> - 他们的CSS `display`值是`none`
> - 他们是`type="hidden"`的表单元素
> - 它们的宽度和高度都显式设置为0
> - 一个祖先元素是隐藏的，因此该元素是不会在页面上显示

**Additional Notes（其他注意事项）:**

> 因为 `:hidden()` 是一个 jQuery 延伸出来的一个选择器。 并且不是的CSS规范的一部分, 使用`:hidden()`查询不能充分利用原生DOM提供的`querySelectorAll()` 方法来提高性能。为了在现代浏览器上获得更佳的性能，请使用[`.filter(":hidden")`](https://www.jquery123.com/filter)代替

#### :visible

选择所有可见的元素

> `visibility: hidden` or `opacity: 0` 被认为是可见的
>
> 可见元素的宽度或高度，是大于零的
>
> 隐藏元素上做动画 元素被认为是可见的 直到动画结束
>
> 显示元素上做动画 在动画的开始处该元素被认为是可见的

同 :hidden 的注意事项

#### :contains()

选择所有包含指定文本的元素

> `params : text String` 用来查找的字符串 区分大小写

#### :empty

择所有没有子元素的元素 (包括文本节点)



#### :has()

选择元素其中至少包含指定选择器匹配的一个种元素

> `param : selector` 任何选择器

同 :hidden 的注意事项

#### :parent

选择所有含有子元素或者文本的父级元素

> 这个正好和 `:empty`相反
>
> 需要注意的一件重要的事情是`:parent` (和 `:empty`)所涉及的子元素 包括文本节点

同 :hidden 的注意事项

---

### Attributes Series

#### [attribute$=value]

选择指定属性是以给定值结尾的元素 这个比较是区分大小写的

> `param : attribute `属性名
>
> `param :value` 属性值

#### [attribute*=value]

选择指定属性具有包含一个给定的子字符串的元素 (选择给定的属性是以包含某些值的元素)

> `param : attribute `属性名
>
> `param :value` 属性值



#### [selector]\[selectorN]

将每一个选择器匹配到的元素合并后一起返回

> `param : selecotrN` N个有效的选择器



### .css()

获取匹配元素集合中的第一个元素的样式属性的值

#### .css( propertyName )
#### .css( propertyNames)

> `param :propertyName String`
>
> `param : propertyNames Array`





#### .css( propertyName, value)
#### .css(propertyName, function(index, value) )

设置每个匹配元素的一个或多个CSS属性
> `param : propertyName String` CSS属性名
> `param : value` 值
>
>  
>
> `param : propertyName String` CSS属性名
>
> `param : function(index, value)` 一个返回设置值的函数

---

### Manipulate classes

#### addClass()

为每个匹配的元素添加指定的样式类名

> `param : className String` 类名
>
> `param :function(index, currentClass) 　` 这个函数返回一个或更多用空格隔开的要增加的样式名

#### removeClass()

> `param : className String` 类名
>
> `param :function(index, currentClass) 　` 这个函数返回一个或更多用空格隔开的要删除的样式名

#### toggleClass()

> `param : className String` 每个匹配元素移除的一个或多个用空格隔开的样式名
>
> `param :function(index, currentClass) 　` 一个函数 返回一个或多个将要被移除的样式名 index 参数表示在所有匹配元素的集合中当前元素的索引位置class 参数表示原有的样式名

#### hasClass()

确定任何一个匹配元素是否有被分配给定的 (样式) 类

> `param : className String` 要查询的样式名



---

### Manipulate size

#### width()

#### height()

#### innerWidth()

#### innerHeight()

#### outerWidth()

#### outerHeight

---

### Manipulate localtion

#### offset()

#### offsetParent()

#### position()

#### scrollLeft()

#### scrollTop()

### .attr()













