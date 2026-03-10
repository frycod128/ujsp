package fry.ujsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.awt.Desktop;
import java.net.URI;

/**
 * Spring Boot应用程序主入口类
 * 标注了@SpringBootApplication注解，表明这是一个Spring Boot应用
 */
@SpringBootApplication
public class UjspApplication extends SpringBootServletInitializer {

    /**
     * 重写configure方法，用于配置SpringApplicationBuilder
     * 这个方法使得应用可以打包成WAR文件并在外部Servlet容器中运行
     * @param application SpringApplicationBuilder实例
     * @return 配置好的SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UjspApplication.class);
    }

    /**
     * 应用程序主方法，Spring Boot应用的入口点
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 启动Spring Boot应用
        SpringApplication.run(UjspApplication.class, args);

        // 启动后自动打开浏览器
        openBrowserAfterStart();
    }

    /**
     * 应用启动后自动打开浏览器访问指定URL的方法
     * 该方法会根据操作系统类型选择合适的浏览器打开命令
     */
    private static void openBrowserAfterStart() {
        try {
            // 延迟0.2秒，等待应用完全启动
            Thread.sleep(200);

            // 设置要访问的URL地址
            String url = "http://localhost:8080";
            // 获取当前操作系统名称并转换为小写，便于后续判断
            String os = System.getProperty("os.name").toLowerCase();

            // 首先尝试使用Desktop类打开浏览器（支持Java 6+）
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                // 如果不支持Desktop类，则使用Runtime执行系统命令打开浏览器
                Runtime runtime = Runtime.getRuntime();
                // 判断操作系统类型并执行相应的打开命令
                if (os.contains("win")) {
                    // Windows系统使用rundll32命令
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    // Mac系统使用open命令
                    runtime.exec("open " + url);
                } else if (os.contains("nix") || os.contains("nux")) {
                    // Linux/Unix系统使用xdg-open命令
                    runtime.exec("xdg-open " + url);
                }
            }
        } catch (Exception e) {
            // 捕获并打印所有可能的异常
            e.printStackTrace();
        }
    }
}