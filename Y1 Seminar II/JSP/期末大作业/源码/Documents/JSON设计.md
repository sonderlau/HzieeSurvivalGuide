student 表内 

affiliation

```json
{
    "Lessons": {
        "LessonID": "ClassID",
        "LessonID2": "ClassID",
        "LessonID3": "ClassID"
    }
}
```

例子

```json
{
    "Lessons": {
        "0582ceb8-4725-49db-ba68-0d64786cb953": "d34ca632-90d5-43de-88b9-3facc7a0ae14"
    }
}
```

Question 表内

文件上传题目的 File_Type

```json
zip/doc/exe
```











Lesson 表

file

```json
{
    "File": [
        "Path1",
        "Path2",
        "Path3"
    ]
}
```



Homework 表

questionlist

```json
{
    "QuestionList": [
        "QuestionID",
        "QuestionID",
        "QuestionID"
    ]
}
```



Question 表

Answer

```json
AB/BCD/A

1/0

这才是正确答案呢
```

----

前端

新建一个公告

```json
{
    "addLesson": {
        "LessonID": "ClassID",
        "LessonID2": "ClassID",
        "LessonID3": "ClassID"
    }
}
```





