package cn.tedu.blogsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 处理上传图片的业务
 */
@Slf4j
@RestController
public class UploadController {

    // 将图片路径声明成不可变的量
    private final String dirPath = "C:\\Users\\admin\\IdeaProjects\\blog-client\\public\\";

    @RequestMapping("/upload")
    //MultipartFile是Spring框架中的一个文件类型接口
    public String upload(MultipartFile pic) throws IOException {
        //pic代表客户端上传的文件参数
        System.out.println("pic = " + pic);

        //得到图片的原始文件名  a.jpg
        String fileName = pic.getOriginalFilename();
        System.out.println("图片原始文件名:" + fileName);
        //得到原始文件名的后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));//从图片原始文件名的最后一个"."开始截取
        //得到唯一文件名 UUID.randomUUID()获取唯一标识符[java定义的不含后缀]
        fileName = UUID.randomUUID() + suffix;
        System.out.println("唯一文件名:" + fileName);

        //准备保存图片的路径(本机磁盘中)
        File dirFile = new File(dirPath);//定义该目录中的文件夹
        if (!dirFile.exists()) {//如果没有files文件夹
            dirFile.mkdirs();//创建(mkdirs()方法可多级创建)
        }
        //结合创建的图片路径,拼接得到文件的完整路径   d:/files/xxx.jpg
        String filePath = dirPath + "/" + fileName;
        //调用transferTo(new File())方法把图片保存到上面的路径中,异常抛出
        pic.transferTo(new File(filePath));

        //最后把图片的url路径响应给客户端  /文件名(http://localHost:8080/文件名)
        return "/" + fileName;//这里的文件名是唯一文件名
    }

    /**
     * 处理Element组件上传图片后的删除功能(删除文件中的那张)
     *
     * @param url 图片的唯一路径
     */
    @RequestMapping("/remove")
    public void remove(String url) {
        log.debug("开始处理删除图片的请求...路径:{}",url);
        if (new File(dirPath + url).delete()) {//File对象的delete()方法,返回值boolean
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
    }
}
