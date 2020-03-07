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

### :hidden

### :visible

### :contains()

### :empty

### :has()

### :parent

### Attributes Series

#### [attribute$=value]

#### [attribute*=value]

#### [selector]\[selectorN]







