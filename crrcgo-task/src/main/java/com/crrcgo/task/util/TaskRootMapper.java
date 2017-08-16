package com.crrcgo.task.util;

import java.util.List;

import com.crrcgo.task.model.Task;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * mybatis映射文件的批量处理，包括翻页等的处理
 *
 * @author jiapengfei
 * @since 2015-09-06 21:53
 */
public interface TaskRootMapper<T> extends Mapper<T>, MySqlMapper<T> {

	
	List<Task> likeName(String taskName);

    //FIXME 特别注意，该接口不能被扫描到，否则会出错
	
	
}
