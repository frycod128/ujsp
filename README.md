## 在 Spring Boot 中使用 JSP

在**JspController.java**中配置return来访问对应的JSP

项目中存在示例用于参考

在 **src/main/webapp/WEB-INF/jsp** 路径创建 **jsp** 项目

后在 **src/main/java/fry/ujsp/controller/JspController.java** 文件

内 **public class JspController** 类内写入如

（以 **1.jsp** 为例）
```bash
    @GetMapping("/1.jsp")
    # 处理根路径"/1"的GET请求
    public String index(Model model) {
      # model 用于向视图传递数据
      return "1";
      # 返回视图名称"1"
    }
```
以视图方式来运行 **jsp** 文件