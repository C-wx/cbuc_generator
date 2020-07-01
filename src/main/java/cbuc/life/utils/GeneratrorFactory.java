package cbuc.life.utils;

import cbuc.life.mapper.GeneratorMapper;
import cbuc.life.mapper.MySQLGeneratorMapper;
import cbuc.life.mapper.OracleGeneratorMapper;
import cbuc.life.mapper.SQLServerGeneratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author: Caiwx
 * @Date: Create in 11:49 2020-06-18
 * @Description:
 */
@Configuration
public class GeneratrorFactory {

    @Value("${dataBaseTypetype:mysql}")
    private String dataBaseType;

    @Autowired
    private MySQLGeneratorMapper mySQLGeneratorMapper;

    @Autowired
    private OracleGeneratorMapper oracleGeneratorMapper;

    @Autowired
    private SQLServerGeneratorMapper sqlServerGeneratorMapper;

    @Bean
    @Primary
    public GeneratorMapper getGeneratorDao() {
        switch (dataBaseType) {
            case "mysql":
                return mySQLGeneratorMapper;
            case "oracle":
                return oracleGeneratorMapper;
            case "sqlserver":
                return sqlServerGeneratorMapper;
            default:
                throw new RuntimeException("未知数据库驱动,请联系作者添加");
        }
    }

}
