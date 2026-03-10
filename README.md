## 在 Spring Boot 中使用 JSP

项目中存在示例用于参考

在 `src/main/webapp/WEB-INF/jsp` 路径创建 **jsp** 项目

后在 `src/main/java/fry/ujsp/controller/JspController.java` 文件

内 `public class JspController` 类内写入如

（以 **1.jsp** 为例）
```jsp
    @GetMapping("/1.jsp")
    # 处理根路径"/1"的GET请求
    public String index(Model model) {
      # model 用于向视图传递数据
      return "1";
      # 返回视图名称"1"
    }
```
以视图方式来运行 **jsp** 文件

在上文函数的传参中写形如：
```jsp
    @RequestParam(name = "name", defaultValue = "访客") String name,
    @RequestParam(name = "n", defaultValue = "2") int n,
    ......
```
来传递GET方法参数 （参考 **index.jsp** 与 **Hello.jsp**）

变更 `@GetMapping("")`为 `@PostMapping("")` 字样

则接受POST方法参数，内参数名传递如上 （参考 **2.jsp** 与 **2-1.jsp**）

同时接受多种参数较为复杂,具体参考 `markdown/多参数.md`