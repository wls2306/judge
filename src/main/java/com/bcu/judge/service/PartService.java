package com.bcu.judge.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bcu.judge.pojo.Part;
import com.bcu.judge.mapper.PartMapper;
@Service
public class PartService{

    @Resource
    private PartMapper partMapper;

    
    public int deleteByPrimaryKey(Integer id) {
        return partMapper.deleteByPrimaryKey(id);
    }

    
    public int insert(Part record) {
        return partMapper.insert(record);
    }

    
    public int insertSelective(Part record) {
        return partMapper.insertSelective(record);
    }

    
    public Part selectByPrimaryKey(Integer id) {
        return partMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(Part record) {
        return partMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Part record) {
        return partMapper.updateByPrimaryKey(record);
    }


    public String selectPartNameByPartId(String partId){ return partMapper.selectPartNameByPartId(partId); }

}
