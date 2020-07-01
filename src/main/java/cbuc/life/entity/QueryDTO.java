package cbuc.life.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author: Caiwx
 * @Date: Create in 10:45 2020-06-18
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {

    /**
     * 页码
     */
    private Integer page;

    /**
     * 页大小
     */
    private Integer rows;

    /**
     * 表名
     */
    private String tableName;

    public static QueryDTO getQueryDTO(Map<String, Object> map) {
        return QueryDTO.builder().page(Integer.valueOf(map.get("page").toString())).
                rows(Integer.valueOf(map.get("limit").toString())).
                tableName(map.getOrDefault("tableName","").toString()).build();
    }
}
