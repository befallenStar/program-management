package cn.edu.njnu.controller;

import cn.edu.njnu.pojo.MyFile;
import cn.edu.njnu.service.ResourceService;
import cn.edu.njnu.util.DownloadUtil;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @RequestMapping("/show")
    public String resource(Model model) {
        List<MyFile> myFiles = resourceService.showAllFile();
        model.addAttribute("files", myFiles);
        return "resource";
    }

    @RequestMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
        if (file == null || file.isEmpty()) return "resource";
        String realname = file.getOriginalFilename();
        String filename = UUID.randomUUID().toString() + realname.substring(realname.lastIndexOf("."));
        String path = "D://Git//SoftwareManage//spm//";
        try {
            file.transferTo(new File(path + filename));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            MyFile myFile = new MyFile(null, filename, realname, path, sdf.format(new Date()));
            resourceService.uploadFile(myFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("files", resourceService.showAllFile());
        return "resource";
    }

    @RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        MyFile myFile = resourceService.queryFileById(Integer.parseInt(id));
        File file = new File(myFile.getPath() + myFile.getFilename());
        ServletOutputStream os = null;
        FileInputStream is = null;
        try {
            String filename = DownloadUtil.getName(request.getHeader("user-agent"), myFile.getRealname());
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            response.setContentType("multipart/form-data");
            is = new FileInputStream(file);
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "resource";
    }

    @RequestMapping("/delete")
    public String deleteFile(Integer id, Model model) {
        MyFile myFile = resourceService.queryFileById(id);
        File file = new File(myFile.getPath() + myFile.getFilename());
        boolean isSuccess;
        isSuccess = file.delete();
        if (isSuccess)
            resourceService.deleteFileById(id);
        model.addAttribute("files", resourceService.showAllFile());
        return "resource";
    }

}
