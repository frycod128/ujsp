package fry.ujsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class UjspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UjspApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(UjspApplication.class, args);

        // 启动后自动打开浏览器
        openBrowserAfterStart();
    }

    private static void openBrowserAfterStart() {
        try {
            // 延迟0.2秒，等待应用完全启动
            Thread.sleep(200);

            String url = "http://localhost:8080";
            String os = System.getProperty("os.name").toLowerCase();

            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                Runtime runtime = Runtime.getRuntime();
                if (os.contains("win")) {
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    runtime.exec("open " + url);
                } else if (os.contains("nix") || os.contains("nux")) {
                    runtime.exec("xdg-open " + url);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}