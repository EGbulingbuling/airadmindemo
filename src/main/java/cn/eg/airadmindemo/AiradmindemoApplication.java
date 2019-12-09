package cn.eg.airadmindemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("cn.eg.airadmindemo.mapper")
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
//@ComponentScan(basePackages = {"cn.eg.airadmindemo.*"})
public class AiradmindemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiradmindemoApplication.class, args);
    }
}
