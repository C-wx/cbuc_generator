package cbuc.life.controller;

import cbuc.life.entity.QueryDTO;
import cbuc.life.entity.Result;
import cbuc.life.service.GeneratorService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author: Caiwx
 * @Date: Create in 10:35 2020-06-18
 * @Description:
 */
@Controller
@RequestMapping("/generator")
public class GeneratorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneratorController.class);

    @Autowired
    private GeneratorService generatorService;

    /**
     * 获取数据库表列表
     */
    @ResponseBody
    @RequestMapping("/list")
    public Result list(@RequestParam Map<String, Object> params) {
        QueryDTO queryDTO = QueryDTO.getQueryDTO(params);
        LOGGER.info("***** QueryDTO:[{}] *****", queryDTO);
        Result result = new Result();
        PageInfo pageInfo = generatorService.queryList(queryDTO);
        return result.sendOk(pageInfo);
    }

    /**
     * 生成代码
     */
    @RequestMapping("/code")
    public void code(String tables, HttpServletResponse response) throws IOException {
        byte[] data = generatorService.generatorCode(tables.split(","));

        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"renren.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }

}
