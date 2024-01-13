package movieComm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movieComm.dto.QandADto;
import movieComm.mybatis.mapper.QandAMapper;

@Service
public class QandAService {
    @Autowired private QandAMapper m;
	
    public List<QandADto> getQandA(){
        return m.getQandADto();
    }
    
    public boolean addQandA(QandADto q) {
        return m.addQandA(q);
    }
    
	public QandADto getQandAOne(int qaID) {
        return m.getQandAOne(qaID);
        
    }
}