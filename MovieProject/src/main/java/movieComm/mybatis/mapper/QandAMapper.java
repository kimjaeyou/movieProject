package movieComm.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import movieComm.dto.QADto;

@Repository("QandAMapper")
@Mapper
public interface QandAMapper {
    public boolean addQandA(QADto QA);
    public List<QADto> getQandADto();
    public QADto getQandAOne(int qaID);

}
