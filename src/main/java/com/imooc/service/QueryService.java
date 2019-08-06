package com.imooc.service;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;
import com.imooc.entity.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询相关的业务功能
 */
public class QueryService {
    public List<Message> queryMessageList(String command, String description, Page page) {
        // 组织消息对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        MessageDao messageDao = new MessageDao();
        // 根据条件查询条数
        int totalCount = messageDao.count(message);
        // 组织分页查询参数
        page.setTotalCount(totalCount);
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("message", message);
        parameter.put("page", page);
        // 分页查询并返回结果
        return messageDao.queryMessageList(parameter);
    }

    /**
     * 根据查询条件分页查询消息列表(拦截器分页)
     */
    public List<Message> queryMessageListByPage(String command, String description, Page page) {
        Map<String, Object> parameter = new HashMap<String, Object>();
        // 组织消息对象
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        parameter.put("message", message);
        parameter.put("page", page);
        MessageDao messageDao = new MessageDao();
        // 分页查询并返回结果
        return messageDao.queryMessageListByPage(parameter);
    }
}
