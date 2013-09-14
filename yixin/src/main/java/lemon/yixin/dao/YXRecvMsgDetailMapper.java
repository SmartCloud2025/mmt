package lemon.yixin.dao;

import lemon.yixin.bean.message.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


/**
 * YiXin receive message repository
 * 
 * @author lemon
 * @version 1.0
 * 
 */
@Repository
public interface YXRecvMsgDetailMapper {
	/**
	 * save message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_detail(cust_id,toUserName,fromUserName,createTime,msgType,msgId) SELECT #{cust_id}, #{toUserName}, #{fromUserName}, #{createTime}, #{msgType}, #{msgId}")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	void saveMsgDetail(YiXinMessage msg);

	/**
	 * save text message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_text(detail_id,content) SELECT #{id}, #{content}")
	void saveTextMsgDetail(TextMessage msg);

	/**
	 * save image message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_image(detail_id,picUrl) SELECT #{id}, #{picUrl}")
	void saveImageMsgDetail(ImageMessage msg);

	/**
	 * save location message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_location(detail_id,location_X,location_Y,scale,label) SELECT #{id}, #{location_X}, #{location_Y},#{scale},#{label}")
	void saveLocationMsgDetail(LocationMessage msg);

	/**
	 * save event message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_event(detail_id,eventType,eventKey) SELECT #{id}, #{eventType}, #{eventKey}")
	void saveEventMsgDetail(EventMessage msg);

	/**
	 * save link message detail(暂时无用)
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_link(detail_id,title,description,url) SELECT #{id}, #{title}, #{description},#{url}")
	void saveLinkMsgDetail(LinkMessage msg);
	/**
	 *save voice message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_voice(detail_id,mediaId,format,recognition) SELECT #{id}, #{mediaId}, #{format},#{recognition}")
	void saveVoiceMsgDetail(VoiceMessage msg);
	/**
	 * save video message detail
	 * 
	 * @param msg
	 */
	@Insert("INSERT INTO yixin_recvmsg_video(detail_id,mediaId,thumbMediaId) SELECT #{id}, #{mediaId}, #{thumbMediaId}")
	void saveVideoMessageDetail(VideoMessage msg);
	
	/**
	 * get text message
	 * @param id
	 * @return
	 */
	@Select("SELECT A.id,A.cust_id,A.toUserName,A.fromUserName,A.createTime,A.msgType,A.msgId, B.content FROM yixin_recvmsg_detail A, yixin_recvmsg_text B WHERE A.id=B.detail_id AND A.msgType='text' AND A.id=#{id}")
	TextMessage getTextMsg(int id);
}