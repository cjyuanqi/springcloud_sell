package com.essa.bootpre.service;

import com.essa.bootpre.domain.Girl;
import com.essa.bootpre.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Optional<Girl> girl = girlRepository.findById(id);
        Integer age = girl.get().getAge();

        if (age < 10) {
            //返回"你还在上小学吧" code=100
            throw new Exception("你还在上小学吧");
        }else if (age > 10 && age < 16) {
            //返回"你可能在上初中" code=101
            throw new Exception("你可能在上初中");
        }

        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findById(id).get();
    }

}
