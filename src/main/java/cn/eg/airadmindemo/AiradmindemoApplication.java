package cn.eg.airadmindemo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@MapperScan("cn.eg.airadmindemo.mapper")
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class AiradmindemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiradmindemoApplication.class, args);
    }
}
