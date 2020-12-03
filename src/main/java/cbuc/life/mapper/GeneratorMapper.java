package cbuc.life.mapper;

import cbuc.life.entity.QueryDTO;

import java.util.List;
import java.util.Map;

/**
 * 数据库Mapper
 */
public interface GeneratorMapper {
    List<Map<String, Object>> queryList(QueryDTO queryDTO);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
