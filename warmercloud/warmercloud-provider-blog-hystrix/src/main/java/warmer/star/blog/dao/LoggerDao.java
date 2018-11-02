package warmer.star.blog.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import warmer.star.dto.LoggerQueryItem;
import warmer.star.entity.Logger;
@Mapper
public interface LoggerDao {
    List<Logger> getList(LoggerQueryItem queryItem);

    Logger getById(@Param("logId" ) int logId);

    boolean savelogger(Logger submitItem);
}
