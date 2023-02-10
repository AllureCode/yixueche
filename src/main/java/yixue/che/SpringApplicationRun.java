package yixue.che;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * @description 启动类
 * @date 2023/2/9 21:52
 * @return: null
 */
@SpringBootApplication(scanBasePackages = "yixue.che.*")
@MapperScan(basePackages = "yixue.che.mapper")
public class SpringApplicationRun {

    public static void main(String[] args) {

        SpringApplication.run(SpringApplicationRun.class, args);
    }
}
