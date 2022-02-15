package com.oes.service.impl;

import com.oes.mapper.ExaminationMapper;
import com.oes.mapper.FspQuestionsMapper;
import com.oes.mapper.SmdOptionsMapper;
import com.oes.mapper.SmdQuestionsMapper;
import com.oes.model.Examination;
import com.oes.model.FspQuestions;
import com.oes.model.SmdOptions;
import com.oes.model.SmdQuestions;
import com.oes.service.ExaminationSerivce;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

/**
 * @author: He Changjie  on  2018-10-04
 * @description:
 */
@Service("examinationSerivce")
public class ExaminationSerivceImpl implements ExaminationSerivce {

    @Resource
    ExaminationMapper mapper;

    @Resource
    SmdOptionsMapper smdOptionsMapper;

    @Resource
    SmdQuestionsMapper smdQuestionsMapper;

    @Resource
    FspQuestionsMapper fspQuestionsMapper;

    /**
     * 公共方法，非请求处理方法
     * 为试卷的某个题型添加一条题目（已判断是否重复添加相同题型）
     * @param str 所含的所有题目字符串
     * @param topicId 将要添加的字符串
     * @return
     */
    public String addtopic(String str,String topicId){
        if(str != null && str.length()>0){
            Set<String> set=new HashSet<>();
            String[] split = str.split("[,，]");
            for (String s : split) {
                set.add(s);
            }
            String[] strings = topicId.split("[,，]");
            for (String s : strings) {
                set.add(s);
            }
            str="";
            for (String s : set) {
                str+=s+",";
            }
            return StringUtils.substringBeforeLast(str,",");
        }else{
            return str;
        }
    }

    @Override
    public int addTopic(String examNo, String topicId, String type) {
        try {
            Examination examination = mapper.findById(examNo);
            switch (type){
                case "1":{
                    examination.setSingleId(addtopic(examination.getSingleId(),topicId));
                }break;
                case "2":{
                    examination.setMultipleId(addtopic(examination.getMultipleId(),topicId));
                }break;
                case "3":{
                    examination.setTrueFalseId(addtopic(examination.getTrueFalseId(),topicId));
                }break;
                case "4":{
                    examination.setSimpleAnwserId(addtopic(examination.getSimpleAnwserId(),topicId));
                }break;
                case "5":{
                    examination.setProgramId(addtopic(examination.getProgramId(),topicId));
                }break;
                default:break;
            }
            mapper.update(examination);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int removeTopic(String examNo, String topicId, String type) {
        try {
            Examination examination = mapper.findById(examNo);
            List<String> list=new ArrayList<>();
            switch (type){
                case "1":{
                    String singleId = examination.getSingleId();
                    if(!(singleId.contains(",") || singleId.contains("，"))){
                        examination.setSingleId("");
                    }else{
                        String[] strings = singleId.split("[,，]");
                        for (String s : strings) {
                            list.add(s);
                        }
                        list.remove(topicId);
                        singleId="";
                        for (String s : list) {
                            singleId+=s+",";
                        }
                        singleId=StringUtils.substringBeforeLast(singleId,",");
                        examination.setSingleId(singleId);
                    }
                }break;
                case "2":{
                    String multipleId = examination.getMultipleId();
                    if(!(multipleId.contains(",") || multipleId.contains("，"))){
                        examination.setSingleId("");
                    }else{
                        String[] strings = multipleId.split("[,，]");
                        for (String s : strings) {
                            list.add(s);
                        }
                        list.remove(topicId);
                        multipleId="";
                        for (String s : list) {
                            multipleId+=s+",";
                        }
                        multipleId=StringUtils.substringBeforeLast(multipleId,",");
                        examination.setMultipleId(multipleId);
                    }
                }break;
                case "3":{
                    String trueFalseId = examination.getTrueFalseId();
                    if(!(trueFalseId.contains(",") || trueFalseId.contains("，"))){
                        examination.setSingleId("");
                    }else{
                        String[] strings = trueFalseId.split("[,，]");
                        for (String s : strings) {
                            list.add(s);
                        }
                        list.remove(topicId);
                        trueFalseId="";
                        for (String s : list) {
                            trueFalseId+=s+",";
                        }
                        trueFalseId=StringUtils.substringBeforeLast(trueFalseId,",");
                        examination.setTrueFalseId(trueFalseId);
                    }
                }break;
                case "4":{
                    String simpleAnwserId = examination.getSimpleAnwserId();
                    if(!(simpleAnwserId.contains(",") || simpleAnwserId.contains("，"))){
                        examination.setSingleId("");
                    }else{
                        String[] strings = simpleAnwserId.split("[,，]");
                        for (String s : strings) {
                            list.add(s);
                        }
                        list.remove(topicId);
                        simpleAnwserId="";
                        for (String s : list) {
                            simpleAnwserId+=s+",";
                        }
                        simpleAnwserId=StringUtils.substringBeforeLast(simpleAnwserId,",");
                        examination.setSimpleAnwserId(simpleAnwserId);
                    }
                }break;
                case "5":{
                    String programId = examination.getProgramId();
                    if(!(programId.contains(",") || programId.contains("，"))){
                        examination.setSingleId("");
                    }else{
                        String[] strings = programId.split("[,，]");
                        for (String s : strings) {
                            list.add(s);
                        }
                        list.remove(topicId);
                        programId="";
                        for (String s : list) {
                            programId+=s+",";
                        }
                        programId=StringUtils.substringBeforeLast(programId,",");
                        examination.setProgramId(programId);
                    }
                }break;
                default:break;
            }
            mapper.update(examination);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public Examination findById(String id) {
        return mapper.findById(id);
    }

    @Override
    public Map<String, List<Object>> queryPaper(String id) {
        List<Object> singleList=new ArrayList<>();
        List<Object> multipleList=new ArrayList<>();
        List<Object> trueFalseList=new ArrayList<>();
        List<Object> simpleAnwserList=new ArrayList<>();
        List<Object> programList=new ArrayList<>();
        Map<String, List<Object>> map=new HashMap<>();
        Examination examination = mapper.findById(id);
        //单选题
        String singleId = examination.getSingleId();
        String[] singles = singleId.split("[,，]");
        for (String single : singles) {
            singleList.add(smdOptionsMapper.findBySmdId(single));
        }
        //多选题
        String multipleId = examination.getMultipleId();
        String[] multiples = multipleId.split("[,，]");
        for (String multiple : multiples) {
            multipleList.add(smdOptionsMapper.findBySmdId(multiple));
        }
        //判断题
        String trueFalseId = examination.getTrueFalseId();
        String[] trueFalses = trueFalseId.split("[,，]");
        for (String trueFalse : trueFalses) {
            trueFalseList.add(smdQuestionsMapper.findById(trueFalse));
        }
        //简答题
        String simpleAnwserId = examination.getSimpleAnwserId();
        String[] simpleAnwsers = simpleAnwserId.split("[,，]");
        for (String simpleAnwser : simpleAnwsers) {
            simpleAnwserList.add(fspQuestionsMapper.findById(simpleAnwser));
        }
        //编程题
        String programId = examination.getProgramId();
        String[] programs = programId.split("[,，]");
        for (String program : programs) {
            programList.add(fspQuestionsMapper.findById(program));
        }
        map.put("single",singleList);
        map.put("multiple",multipleList);
        map.put("trueFalse",trueFalseList);
        map.put("simpleAnwser",simpleAnwserList);
        map.put("program",programList);
        return map;
    }

    @Override
    public Map<String, List<FspQuestions>> querySubjectiveProblem(String id) {
        List<FspQuestions> simpleAnwserList=new ArrayList<>();
        List<FspQuestions> programList=new ArrayList<>();
        Map<String, List<FspQuestions>> map=new HashMap<>();
        Examination examination = mapper.findById(id);
        //简答题
        String simpleAnwserId = examination.getSimpleAnwserId();
        String[] simpleAnwsers = simpleAnwserId.split("[,，]");
        for (String simpleAnwser : simpleAnwsers) {
            simpleAnwserList.add(fspQuestionsMapper.findById(simpleAnwser));
        }
        //编程题
        String programId = examination.getProgramId();
        String[] programs = programId.split("[,，]");
        for (String program : programs) {
            programList.add(fspQuestionsMapper.findById(program));
        }
        map.put("simpleAnwser",simpleAnwserList);
        map.put("program",programList);
        return map;
    }

    @Override
    public int update(Examination examination) {
        return mapper.update(examination);
    }

    @Override
    public int save(Examination examination) {
        return mapper.save(examination);
    }

    @Override
    public List<Examination> findAllExamNo() {
        return mapper.findAllExamNo();
    }
}
