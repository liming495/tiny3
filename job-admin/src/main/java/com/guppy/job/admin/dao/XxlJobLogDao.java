package com.guppy.job.admin.dao;

import com.guppy.job.admin.core.model.XxlJobLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * job log
 * @author xuxueli 2016-1-12 18:03:06
 */
@Mapper
public interface XxlJobLogDao {

	// exist jobId not use jobGroup, not exist use jobGroup
	public List<XxlJobLog> pageList(@Param("offset") int offset,
									@Param("pageSize") int pageSize,
									@Param("jobGroup") int jobGroup,
									@Param("jobId") int jobId,
									@Param("triggerTimeStart") Date triggerTimeStart,
									@Param("triggerTimeEnd") Date triggerTimeEnd,
									@Param("logStatus") int logStatus);
	public int pageListCount(@Param("offset") int offset,
							 @Param("pageSize") int pageSize,
							 @Param("jobGroup") int jobGroup,
							 @Param("jobId") int jobId,
							 @Param("triggerTimeStart") Date triggerTimeStart,
							 @Param("triggerTimeEnd") Date triggerTimeEnd,
							 @Param("logStatus") int logStatus);
	
	XxlJobLog load(@Param("id") long id);

	long save(XxlJobLog xxlJobLog);

	int updateTriggerInfo(XxlJobLog xxlJobLog);

	int updateHandleInfo(XxlJobLog xxlJobLog);
	
	int delete(@Param("jobId") int jobId);

	Map<String, Object> findLogReport(@Param("from") Date from,
											 @Param("to") Date to);

	List<Long> findClearLogIds(@Param("jobGroup") int jobGroup,
									  @Param("jobId") int jobId,
									  @Param("clearBeforeTime") Date clearBeforeTime,
									  @Param("clearBeforeNum") int clearBeforeNum,
									  @Param("pageSize") int pageSize);
	int clearLog(@Param("logIds") List<Long> logIds);

	List<Long> findFailJobLogIds(@Param("pageSize") int pageSize);

	int updateAlarmStatus(@Param("logId") long logId,
								 @Param("oldAlarmStatus") int oldAlarmStatus,
								 @Param("newAlarmStatus") int newAlarmStatus);

	List<Long> findLostJobIds(@Param("lostTime") Date lostTime);

}
