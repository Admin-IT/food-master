package edu.nf.food.user.web;

import edu.nf.food.exception.UserException;
import edu.nf.food.label.service.exception.LabelException;
import edu.nf.food.user.entity.User;
import edu.nf.food.user.service.UserService;
import edu.nf.food.util.BaseController;
import edu.nf.food.util.CommconsEmail;
import edu.nf.food.util.MyFileUtils;
import edu.nf.food.vo.ResponseVO;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import org.json.JSONException;

/**
 * @author ljf
 * @date 2020/4/2
 * 用户
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @GetMapping("/login_user")
    public ResponseVO login(User user, HttpServletRequest request) {
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPass());
        User us = service.loginUser(user);
        request.getServletContext().setAttribute("user", us);
        return success("登录成功");
    }


    /**
     * 获取用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("/get_user_info")
    public ResponseVO getUser(HttpServletRequest request) {
        User user1 = (User) request.getServletContext().getAttribute("user");
        System.out.println(user1.getUserId());
        return success(user1);

    }


    @GetMapping("/add_user")
    public ResponseVO addUser(User user, String yzm, HttpServletRequest request) {
        //随机生成名字
        int len = 123;
        String name = getRandomJianHan(len) + getStringRandom(len);

        String yzms = (String) request.getServletContext().getAttribute("email");
        System.out.println(yzm);
        System.out.println(yzms + "session");
        if (!yzm.equals(yzms)) {
            throw new LabelException("验证码不正确");
        }
        User us = new User();
        us.setUserPass(user.getUserPass());
        user.setUserName(name);
        us.setUserEmail(user.getUserEmail());
        us.setUserFans("0");
        us.setUserFollow("0");

        System.out.println("邮箱" + user.getUserEmail());
        System.out.println("密码" + user.getUserPass());
        System.out.println("昵称" + user.getUserName());
        service.addUser(user);
        return success("注册成功");

    }

    // 发送邮件
    @GetMapping("/send_email")
    public ResponseVO sendemail(String email, HttpServletRequest request) throws Exception {

        System.out.println(email);
        int pass = (int) ((Math.random() * 9 + 1) * 100000);//随机生成验证码
        String strText = "【有谱】您的验证码是 " + pass + ",用于有谱网站验证，请勿将验证码透露给他人，如非本人操作，请立即访问www.youpu.shop 查询";
        CommconsEmail.sendTextMail(email, "有谱网站邮件认证", strText);
        request.getServletContext().setAttribute("email", String.valueOf(pass));
        return success("发送成功");
    }

    /**
     * 发送手机验证码
     *
     * @param phone
     * @param request
     * @return
     */
    @GetMapping("/send_phone")
    public ResponseVO sendphone(String phone, HttpServletRequest request) {
        //获取电话号码
        System.out.println(phone);
        //配置腾讯云数据
        int appid = 1400190009;
        String appkey = "485bc79b9e94aee3c82b575adecede48";
        //验证码生成
        String yanzhengma = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        System.out.println(yanzhengma);
        try {
            //实例化单发信息类（腾讯云提供）
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            //调用方法进行发送
            SmsSingleSenderResult result = ssender.send(0, "86", phone,
                    "【有谱美食】 您正在申请手机注册，验证码为：" + yanzhengma + "，3分钟内有效！", "", "");
            //保存验证码到session
            //session.setAttribute("code", yanzhengma);
            request.getServletContext().setAttribute("phone", yanzhengma);
            System.out.println(result.fee);
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.github.qcloudsms.httpclient.HTTPException e) {
            e.printStackTrace();
        }
        return success("发送成功！");
    }

    //用于退出页面
    @GetMapping("/tologout")
    public String tologout(HttpSession session, HttpServletResponse response) throws IOException {

        session.setAttribute("user", null);
        response.sendRedirect("index.html");
        return "退出成功";
    }

    //用于查询登录用户的个人信息
    @GetMapping("/all_userMess")
    public ResponseVO selectUserMess(Integer userId) {
        System.out.println("我进来显示用户信息了");
        System.out.println(userId);
//        System.out.println(user.getUserId());
        User user = service.allUserMess(userId);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.format(user.getUserBirthday());
        System.out.println(user);
//        System.out.println(user.getUserName());
//        User user = service.allUserMess(userId);
        return success(user);
    }

    /**
     * 随机生成汉字
     *
     * @param len
     * @return
     */
    public static String getRandomJianHan(int len) {
        String ret = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }
        ret = ret.substring(1, 3);
        return ret;
    }

    //生成随机用户名，数字和字母组成,
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        val = val.substring(1, 4);
        return val;
    }

    /**
     * 修改用户密码
     *
     * @param user
     * @param request
     */
    @GetMapping("/upPassWord")
    public void upPass(User user, HttpServletRequest request) {

        String pass2 = request.getParameter("newpass");
        String pass3 = request.getParameter("newpwd");
        String user1 = request.getParameter("userId");
        int userId = Integer.parseInt(request.getParameter("userId"));

        if ("".equals(pass2) && "".equals(pass3)) {
            throw new UserException("未输入密码!");
        } else if (!pass2.equals(pass3)) {
            throw new UserException("密码不一致，请重新输入");
        } else {
            user.setUserPass(pass2);
            user.setUserId(userId);
            service.upPass(user);
        }
    }

    /**
     * 修改个人基本信息
     *
     * @param user
     * @param request
     */
    @GetMapping("/upUser")
    public void upUser(User user, HttpServletRequest request) throws ParseException {
        System.out.println("开始修改信息");
        //获取用户的所以基础信息
        String userName = request.getParameter("user_name");
        int sex = Integer.parseInt(request.getParameter("gender"));
        String provinceFirst = request.getParameter("province");
        String provinceCity = request.getParameter("city");

        String local_province = request.getParameter("local_province");
        String local_city = request.getParameter("local_city");

        String user1 = request.getParameter("userId");
        int userId = Integer.parseInt(request.getParameter("userId"));

        String year = request.getParameter("birthday_year");
        String month = request.getParameter("birthday_month");
        String day = request.getParameter("birthday_day");
        String birthday = year + "-" + month + "-" + day;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birthday);

        String profession = request.getParameter("profession");
        String intro = request.getParameter("intro");

        System.out.println(userName + " " + sex + " " + birthday + " " + provinceFirst + provinceCity);
        System.out.println(local_province + local_city + " " + profession + " " + intro);
        try {
            user.setUserName(userName);
            user.setUserSex(sex);
            user.setUserBirthday(date);
            user.setUserHometown(provinceFirst + provinceCity);
            user.setUserLocation(local_province + local_city);
            user.setUserOccupation(profession);
            user.setUserAutograph(intro);
            user.setUserId(userId);
            service.upUser(user);
        } catch (Exception e) {
            throw new UserException("修改用户信息异常！");
        }

    }

    @PostMapping("/upImage")
    public String upImage(User user, HttpServletRequest request, MultipartFile[] files, Model model) throws IOException {
        System.out.println("开始修改图片");
        int userId = Integer.parseInt(request.getParameter("userId"));

        //下载地址
        String uploadPath = request.getServletContext().getRealPath(File.separator + "static/img");
        System.out.println(uploadPath);
        return null;
//        List<String> fileNames = new ArrayList<>();
//        MyFileUtils.createUploadDir(uploadPath);
//        for (MultipartFile file : files) {
//            //获取上传文件的文件名
//            String fileName = file.getOriginalFilename();
//            fileName = MyFileUtils.newFileName(fileName);
//            File uploadFile = MyFileUtils.createUploadFile(uploadPath, fileName);
//            //执行上传
//            file.transferTo(uploadFile);
//            //保存文件名
//            fileNames.add(fileName);
//        }
//        model.addAttribute("fileNames",fileNames);
//        for (String fileName : fileNames) {
//            System.out.println(fileName);
////            user.setUserImage(fileName);
//        }
//        user.setUserId(userId);
    }

    @GetMapping("/phone_login")
    public ResponseVO phonrLogin(User user, HttpServletRequest request, String phoneEmail) {
        //随机生成name
        int len = 234;
        String name = getRandomJianHan(len) + getStringRandom(len);

        String phoneNum = request.getParameter("phoneNum");
        String yzms = (String) request.getServletContext().getAttribute("phone");
        System.out.println("验证码: " + phoneEmail);
        System.out.println("验证码: " + yzms);
        if (!phoneEmail.equals(yzms)) {
            throw new LabelException("验证码不正确");
        }
        User user1 = service.phoneLogin(phoneNum);
        System.out.println(user1);
        if (user1 == null) {
            user.setUserTel(phoneNum);
            user.setUserName(name);
            user.setUserImage("img/png/tx2_7.png");
            user.setUserFans("0");
            user.setUserFollow("0");
            System.out.println(user);
            request.getServletContext().setAttribute("user", user);
            service.addPhone(user);
        } else {
            request.getServletContext().setAttribute("user", user1);
            return success(user1);
        }
        return success(user);
    }

}