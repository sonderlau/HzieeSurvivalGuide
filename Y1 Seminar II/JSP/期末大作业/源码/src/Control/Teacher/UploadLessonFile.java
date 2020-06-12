package Control.Teacher;

import Model.Lesson;
import Model.User_Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class UploadLessonFile extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");

        User_Teacher teacher = (User_Teacher) req.getSession().getAttribute("teacher");
        Lesson lesson = (Lesson) req.getSession().getAttribute("lesson");

//        //? 测试用
//        Lesson lesson = null;
//        try {
//            lesson = utils.Database.query.lesson.getLessonInfoById("0582ceb8-4725-49db-ba68-0d64786cb953");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //? ---------------------------

        DiskFileItemFactory factory = new DiskFileItemFactory();

        File f = new File("V:\\JSPFinal\\FileDisk");

        // 如果文件夹不存在 就新建一个
        if (!f.exists()) {
            f.mkdirs();
        }

        factory.setRepository(f);

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");


        List<FileItem> items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
            //! 获取上传的文件失败
        }

        for (FileItem fileItem : items) {
            // 判断是否为普通字段
            if (fileItem.isFormField()){
                //* 不是file类型的表单项
            }else {
                String fileName = fileItem.getName();
                // 处理上传文件
                if (fileName != null && !fileName.equals("")) {
                    fileName = fileName.substring(fileName.lastIndexOf("/") + 1) ;
                    // 文件名唯一


                    fileName = UUID.randomUUID().toString() + "_" + fileName;
                    // 服务器创建同名文件
                    String webPath = "/upload/";
                    // 组合完整的服务器路径
                    String filePath = getServletContext().getRealPath(webPath + fileName);

                    // 存储上传的文件
                    JSONArray jsonArray = null;
                    if (lesson != null) {
                        jsonArray = JSON.parseArray(lesson.getFile());
                        jsonArray.add(filePath);
                    }


                    String latestJSON = jsonArray.toJSONString();
                    try {
                        utils.Database.ModelData.lesson.updateLessonFileById(latestJSON,lesson.getID());
                    } catch (Exception e) {
                        e.printStackTrace();
                        //! 数据库 更新失败
                    }

                    System.out.println("新建的文件路径是 : " + filePath);
                    System.out.println("JSON Array : "+ latestJSON);


                    // 创建文件
                    File file = new File(filePath);
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                    // 文件上传流
                    InputStream in = fileItem.getInputStream();
                    // 打开服务器 上传文件
                    FileOutputStream out = new FileOutputStream(file);
                    // 流的对拷
                        // 逐个字节的读取
                    byte[] buffer = new byte[1024];
                    int len;
                    // 读取字节 并上传
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer,0,len);
                    }

                    in.close();
                    out.close();

                    // 删除临时文件
                    fileItem.delete();

                    // todo: 将成功的消息传递到前端

                }
            }

        }



    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
