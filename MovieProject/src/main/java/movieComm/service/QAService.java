package movieComm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.dao.QADao;
import movieComm.dto.QADto;
import movieComm.mybatis.mapper.QandAMapper;

@Service
public class QAService {
    @Autowired QADao dao;
    
    public int total() {
    	return dao.total();
    }
    
    public List<QADto> QAList(int start){
    	Map<String, Object> m = new HashMap<String, Object>();
    	m.put("start", start);
    	m.put("count", 10);
    	return dao.QAList(m);
    }
    
    public int insert(QADto dto) {
    	return dao.insert(dto);
    }
    
    public QADto QAContent(int qaID) {
    	dao.addReadCount(qaID);
    	return dao.QAContent(qaID);
    }
    
    public int updateQA(QADto dto) {
    	return dao.updateQA(dto);
    }
    
    public int deleteQA(int no) {
    	return dao.deleteQA(no);
    }
    
    public List<QADto> QAListSearch(int searchn, String search, int start){
    	Map<String, Object> m = new HashMap<String, Object>();
    	m.put("searchn", searchn);
    	m.put("search", search);
    	m.put("start", start);
    	m.put("count", 10);
    	return dao.QAListSearch(m);
    }
    
    public int countSearch(int searchn, String search) {
    	Map<String, Object> m = new HashMap<String, Object>();
    	m.put("searchn", searchn);
    	m.put("searchn", searchn);
    	m.put("search", search);
    	return dao.countSearch(m);
    }
}