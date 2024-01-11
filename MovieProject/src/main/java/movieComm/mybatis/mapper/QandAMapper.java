package movieComm.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import movieComm.dto.QandADto;

@Repository("QandAMapper")
@Mapper
public interface QandAMapper {
    public boolean addQandA(QandADto QA);
    public List<QandADto> getQandADto();
    public QandADto getQandAOne(int qaID);

}
