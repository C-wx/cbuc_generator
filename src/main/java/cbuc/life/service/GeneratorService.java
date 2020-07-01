package cbuc.life.service;

import cbuc.life.controller.GeneratorController;
import cbuc.life.entity.QueryDTO;
import cbuc.life.mapper.GeneratorMapper;
import cbuc.life.mapper.MySQLGeneratorMapper;
import cbuc.life.utils.GenUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * @Author: Caiwx
 * @Date: Create in 10:53 2020-06-18
 * @Description: 生成器 Service
 */
@Service
public class GeneratorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorService.class);

    @Autowired
    private GeneratorMapper generatorMapper;

    @Autowired
    private GenUtils genUtils;

    /**
     * 返回数据库中表字段
     *
     * @param queryDTO 查询条件
     */
    public PageInfo<Map<String, Object>> queryList(QueryDTO queryDTO) {
        if (queryDTO.getPage() != null && queryDTO.getRows() != null) {
            PageHelper.startPage(queryDTO.getPage(), queryDTO.getRows());
        }
        List<Map<String, Object>> dataList = generatorMapper.queryList(queryDTO);
        return new PageInfo(dataList);
    }

    /**
     * 查询表信息
     *
     * @param tableName 表名称
     */
    public Map<String, String> queryTable(String tableName) {
        return generatorMapper.queryTable(tableName);
    }

    /**
     * 获取表的列表信息
     *
     * @param tableName 表名称
     */
    public List<Map<String, String>> queryColumns(String tableName) {
        return generatorMapper.queryColumns(tableName);
    }

    public byte[] generatorCode(String[] tableNames) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (String tableName : tableNames) {
            //查询表信息
            Map<String, String> table = queryTable(tableName);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(tableName);
            //生成代码
            genUtils.generatorCode(table, columns, zip);
        }
        IOUtils.closeQuietly(zip);
        return outputStream.toByteArray();
    }
}
